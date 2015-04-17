<?php
require '../config.php';
//------------------------------------------------

$db = new mysqli($dbServer, $dbUser, $dbPassword, $dbName);
if($db->connect_errno >0)
	die("PHP ERROR: Error connecting to database: ".$db->connect_error."");


//----------------------------------------------------

$query = $db->prepare("SELECT id, title, opt1, opt2, photo1, photo2, end_time, user FROM questions");
$query->execute();
$query->bind_result($id, $title, $opt1, $opt2, $photo1, $photo2, $end_time, $user);
while($query->fetch()){
	echo "ID: $id; title: $title; opt1: $opt1; opt2: $opt2; photo1: $photo1; $photo2: $photo2; end_time: $end_time user: $user </br>";
}


$query->fetch();
$username = $returned_username;

$query->free_result();

echo $username;
