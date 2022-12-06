<?php
$server="localhost";
$username="root";
$pass="";
$db="info";

$mysqli_connect= new mysqli($server,$username,$pass,$db);

if($mysqli_connect->connect_error){
	exit('Error in connection');
}

$sql="INSERT INTO t1 (firstName,LastName,Grade) 
VALUES(?,?,?)";
$stmt=$mysqli_connect->prepare($sql);
$stmt->bind_param("ssi",$fname,$lname,$grade);

$fname="x";
$lname="x";
$grade=3;
$stmt->execute();

$fname="y";
$lname="y";
$grade=4;
$stmt->execute();

$fname="z";
$lname="z";
$grade=5;
$stmt->execute();

$stmt->close();
echo "<h1>Data inserted</h1>";

?>