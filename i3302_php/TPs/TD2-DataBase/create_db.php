<?php
$server="localhost";
$username="root";
$pass="";
$mysqli_connect= new mysqli($server,$username,$pass);

if($mysqli_connect->connect_error){
	exit('Error in connection');
}
$sql="CREATE DATABASE info";

$stmt=$mysqli_connect->prepare($sql);
$stmt->execute();
$stmt->close();

echo "<h1>Data Base Created</h1>";
?>
<form method="post" action="create_table.php">
<input type="submit" name="submit" value="click to add tables">
</form>