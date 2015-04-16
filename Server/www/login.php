<?php
require '../config.php';
//------------------------------------------------

$db = new mysqli($dbServer, $dbUser, $dbPassword, $dbName);
if($db->connect_errno >0)
	die("PHP ERROR: Error connecting to database: ".$db->connect_error."");


//----------------------------------------------------
if(!@$_POST['username'] || !@$_POST['password'])die("PHP ERROR: No username or password selected!");

$query = $db->prepare("SELECT id, password FROM users WHERE username = ?");
$query->bind_param('s', $_POST['username']);
$query->execute();
$query->bind_result($returned_id, $returned_hash);
$query->fetch();
$id   = $returned_id;
$hash = $returned_hash;

$query->free_result();

if(!password_verify($_POST['password'], $hash)) die("PHP ERROR: Incorrect username or password.");

echo $id;//TODO: make crypto safe way of generating a user session id
