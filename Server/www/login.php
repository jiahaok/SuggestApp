<?php
define("DATABASE_HOST", "localhost");
define("DATABASE_USERNAME", "root");
define("DATABASE_PASSWORD", "");
define("DATABASE_NAME", "mainbase");

//------------------------------------------------

$db = new mysqli(DATABASE_HOST, DATABASE_USERNAME, DATABASE_PASSWORD, DATABASE_NAME);
if($db->connect_errno >0)
	die("PHP ERROR: Error connecting to database: ".mysql_error()."");


//----------------------------------------------------
if(!@$_GET['username'] || !@$_GET['password'])die("PHP ERROR: No username or password selected!");

$query = $db->prepare("SELECT username FROM users WHERE username = ? and password = ?");
$query->bind_param('ss', $_GET['username'], $_GET['password']);
$query->execute();
$query->bind_result($returned_username);


$query->fetch();
$username = $returned_username;

$query->free_result();

if($username)echo "Logged in!";
else echo "PHP ERROR: Incorrect username or password";
