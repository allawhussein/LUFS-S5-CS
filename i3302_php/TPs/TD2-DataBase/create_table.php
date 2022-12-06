<?php
$server="localhost";
$username="root";
$pass="";
$db="info";

$mysqli_connect= new mysqli($server,$username,$pass,$db);

if($mysqli_connect->connect_error){
	exit('Error in connection');
}

$stmt=$mysqli_connect->prepare("DROP TABLE IF EXISTS t1");
$stmt->execute();
$stmt->close();
	
$sql="CREATE TABLE t1 (
	id INT(6) AUTO_INCREMENT PRIMARY KEY,
	firstName VARCHAR(30) NOT NULL,
	LastName VARCHAR(30) NOT NULL,
	Grade INT(3)
	)";
	
	$stmt=$mysqli_connect->prepare($sql);
	$stmt->execute();
	$stmt->close();

	echo "<h1>Table Created</h1>";
	
?>
<form method="post" action="insert_from_form.php">
<input type="submit" name="submit" value="click to insert values from form">
</form>