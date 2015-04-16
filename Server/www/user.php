<?php
require '../config.php';
//------------------------------------------------

$db = new mysqli($dbServer, $dbUser, $dbPassword, $dbName);
if($db->connect_errno >0)
	die("PHP ERROR: Error connecting to database: ".$db->connect_error."");


//----------------------------------------------------
if(!@$_GET['action']) die("No action selected!");
if(!@$_POST['username'] || !@$_POST['password'])die("PHP ERROR: No username or password selected!");

if($_GET['action'] == "login"){
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
} else if($_GET['action'] == "create"){
	//password hashing
	$hash = password_hash($_POST['password'], CRYPT_BLOWFISH);
	
	
	$query = $db->prepare("INSERT INTO users (username, password) VALUES (?, ?)") or die("PHP ERROR: failed to prepare db statement! ". $db->error);
	$query->bind_param('ss', $_POST['username'], $hash) 
		or die("PHP ERROR: Params wouldn't bind!");
	$query->execute() or die("PHP ERROR: execution failed. ".$query->error);
	
	
	$query->free_result();
	
	echo 'SUCCESS';
} else die("PHP ERROR: Action not possible");
