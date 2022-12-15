<?php
if(isset($_GET['user'])){
$x=$_GET['user'];
echo "<h1 align='center'>Hello $x !</h1> 
<h1 align='center'>I3302 Grades </h1>";

$server="localhost";
$username="root";
$pass="";
$db="db_grades";

$mysqli_connect= new mysqli($server,$username,$pass,$db);

if($mysqli_connect->connect_error){
	exit('Error in connection');
}

$sql="SELECT description, grade, grade_on, date FROM users, grades, exam WHERE users.iduser=grades.iduser AND exam.idexam=grades.idexam AND users.name= ?";
$stmt=$mysqli_connect->prepare($sql);
$stmt->bind_param("s",$x);
$stmt->execute();
$arr=$stmt->get_result()->fetch_all(MYSQLI_ASSOC);
//print_r($arr);

echo "<table align='center' border='1'><tr><th>exam</th><th>grade</th><th>on</th><th>date</th></tr>";

foreach ($arr as $k => $v){
	echo "<tr>";
	foreach($v as $k1=>$v1){
		echo "<td> $v1 </td>";
	}
	echo "</tr>";
}
echo "</table>";

echo "<br><p align='center'><a href='Login.php'>logout</a></p>";
}
?>