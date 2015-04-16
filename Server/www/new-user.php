<?php
require '../config.php';
//------------------------------------------------

$db = new mysqli($dbServer, $dbUser, $dbPassword, $dbName);
if($db->connect_errno >0)
	die("PHP ERROR: Error connecting to database: ".$db->connect_error."");


//----------------------------------------------------
if(!@$_POST['username'] || !@$_POST['password'])die("PHP ERROR: No username or password selected!");

//if(preg_match("/[]/", $subject))

//password hashing
$hash = password_hash($_POST['password'], CRYPT_BLOWFISH);


$query = $db->prepare("INSERT INTO users (username, password) VALUES (?, ?)") or die("PHP ERROR: failed to prepare db statement! ". $db->error);
$query->bind_param('ss', $_POST['username'], $hash) 
	or die("PHP ERROR: Params wouldn't bind!");
$query->execute() or die("PHP ERROR: execution failed. ".$query->error);


$query->free_result();

echo 'SUCCESS';
