<?php
define("DATABASE_HOST", "localhost");
define("DATABASE_USERNAME", "root");
define("DATABASE_PASSWORD", "");
define("DATABASE_NAME", "mainbase");
?>
<?php
$mysqli = mysqli_connect(DATABASE_HOST, DATABASE_USERNAME, DATABASE_PASSWORD) 
	or die("<p>error connecting to database: ".mysql_error()."<p>");

mysqli_select_db($mysqli, DATABASE_NAME)
	or die("<p>Error selecting the database ".DATABASE_NAME.mysql_error()."</p>");

?>

<?php
$result = $mysqli->query("SELECT * FROM users WHERE id = ".$_GET["id"]);

if(!$result) die("Error selecting user with id ".$_GET['id'].". ".mysql_error());
else{
	$row = mysqli_fetch_array($result);
	$username = $row['username'];
	$password = $row['password'];
	$id       = $row['id'];
}
?>
<!DOCTYPE html>
<html>
	<head>
		
	</head>
	<body>
		<h1><?php echo $username; ?></h1>
		<p>Password: <?php echo $password; ?></p>
		<p>ID: <?php echo $id; ?></p>
	</body>
</html>