<?php
require '../config.php';
//------------------------------------------------

$db = new mysqli($dbServer, $dbUser, $dbPassword, $dbName);
if($db->connect_errno >0)
	die("PHP ERROR: Error connecting to database: ".$db->connect_error."");


//----------------------------------------------------
if(!@$_POST['session'] || !@$_POST['length'] ||
   !@$_POST['pic1']    || !@$_POST['pic2']     ||
   !@$_POST['opt1']    || !@$_POST['opt2']        )die("PHP ERROR: No username or password selected!");

//if(preg_match("/[]/", $subject))

//Android timestamp uses millis, php uses seconds
$endTime = ((float) $_POST['length'])/1000 + time();
$date = date("y-m-d h:i:s", $endTime);

$query = $db->prepare("INSERT INTO questions (title, opt1, opt2, photo1, photo2, user, end_time) VALUES (?, ?, ?, ?, ?, ?, ?)") or die("PHP ERROR: failed to prepare db statement! ". $db->error);
$query->bind_param('sssssis', $_POST['length'], $_POST['opt1'], $_POST['opt2'], $_POST['pic1'], 
							 $_POST['pic2'], 
							 $_POST['session'],
							 $date) or die("PHP ERROR: Params wouldn't bind!");
$query->execute() or die("PHP ERROR: execution failed. ".$query->error);


$query->free_result();

echo 'SUCCESS';
