<?php
define("DATABASE_HOST", "localhost");
define("DATABASE_USERNAME", "root");
define("DATABASE_PASSWORD", "");
define("DATABASE_NAME", "mainbase");

//------------------------------------------------

$db = new mysqli(DATABASE_HOST, DATABASE_USERNAME, DATABASE_PASSWORD, DATABASE_NAME);
if($db->connect_errno >0)
	die("<p>error connecting to database: ".mysql_error()."<p>");


//----------------------------------------------------
if(!@$_GET['id'])die("NO ID SELECTED!");

$query = $db->prepare("SELECT username FROM users WHERE id = ?");
$query->bind_param('s', $_GET['id']);
$query->execute();
$query->bind_result($returned_username);


$query->fetch();
$username = $returned_username;

$query->free_result();

echo $username;
