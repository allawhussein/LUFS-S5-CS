<?php
$server="localhost";
$username="root";
$pass="";
$db="info";

$mysqli_connect= new mysqli($server,$username,$pass,$db);

if($mysqli_connect->connect_error){
	exit('Error in connection');
}

$sql="SELECT * FROM t1";
$stmt=$mysqli_connect->prepare($sql);
$stmt->execute();
$arr=$stmt->get_result()->fetch_all(MYSQLI_ASSOC);
print_r($arr);

?>
<table border="2">
<tr><th>id</th><th>Fname</th><th>Lname</th><th>Grade</th></tr>
<?php foreach ($arr as $k => $v){
	echo "<tr>";
	foreach($v as $k1=>$v1){
		echo "<td> $v1 </td>";
	}
	echo "</tr>";
} ?>














</table>
<?php

$stmt->close();


?>