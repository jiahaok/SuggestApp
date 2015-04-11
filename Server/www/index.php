<?php
require '../config.php';
//------------------------------------------------

$db = new mysqli($dbServer, $dbUser, $dbPassword, $dbName);
if($db->connect_errno >0)
	die("PHP ERROR: Error connecting to database: ".$db->connect_error."");


//----------------------------------------------------
if(!@$_POST['id'])die("PHP ERROR: NO ID SELECTED!");

$query = $db->prepare("SELECT username FROM users WHERE id = ?");
$query->bind_param('s', $_POST['id']);
$query->execute();
$query->bind_result($returned_username);


$query->fetch();
$username = $returned_username;

$query->free_result();

echo $username;
