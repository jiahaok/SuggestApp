<?php
require '../config.php';
//------------------------------------------------

$db = new mysqli($dbServer, $dbUser, $dbPassword, $dbName);
if($db->connect_errno >0)
	die("PHP ERROR: Error connecting to database: ".$db->connect_error."");


//----------------------------------------------------
if(!@$_POST['username'] || !@$_POST['password'])die("PHP ERROR: No username or password selected!");

$query = $db->prepare("SELECT id FROM users WHERE username = ? and password = ?");
$query->bind_param('ss', $_POST['username'], $_POST['password']);
$query->execute();
$query->bind_result($returned_id);


$query->fetch();
$id = $returned_id;


$query->free_result();

if($id)echo $id;//TODO: make crypto safe way of generating a user session id
else echo "PHP ERROR: Incorrect username or password";
