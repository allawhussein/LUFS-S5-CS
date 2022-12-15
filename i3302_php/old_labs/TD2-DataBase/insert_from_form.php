<?php
session_start();
?>
<form method="post" action="insert_from_form.php">
Insert your first name<input type="text" name="fname"><br>Inse
Insert your last name<input type="text" name="lname"><br>
Insert the grade<input type="text" name="grade"><br>
<input type="submit" name="submit1" value="Insert"><br>
</form>

<?php
$mysqli_connect=$_SESSION['con'];
/*$server="localhost";
$username="root";
$pass="";
$db="info";

$mysqli_connect= new mysqli($server,$username,$pass,$db);
*/
if($mysqli_connect->connect_error){
	exit('Error in connection');
}

if(isset($_POST['submit1'])){
$sql="INSERT INTO t1 (firstName,LastName,Grade) 
VALUES(?,?,?)";
$stmt=$mysqli_connect->prepare($sql);
$stmt->bind_param("ssi",$_POST['fname'],$_POST['lname'],$_POST['grade']);
$stmt->execute();
$stmt->close();
echo "<h1>Data inserted</h1>";
}










?>