

<?php
if(isset($_POST['username'])){
	$server="localhost";
$username="root";
$pass="";
$db="db_grades";

$mysqli_connect= new mysqli($server,$username,$pass,$db);

if($mysqli_connect->connect_error){
	exit('Error in connection');
}

$sql="SELECT name, pass FROM users WHERE name=? AND pass=?";
$stmt=$mysqli_connect->prepare($sql);
$stmt->bind_param("ss",$_POST['username'],$_POST['password']);
$stmt->execute();
$arr=$stmt->get_result()->fetch_all(MYSQLI_ASSOC);
//print_r($arr);echo "c=".count($arr);

if(count($arr)==1){
	$x=$_POST['username'];
	header("Location: View.php?user=$x");
	exit;
	}
else{
		echo "<h1 align='center'> Incorrect Username or Passord </h1>";
	}
}
?>

<form method="post" action="Login.php">
User: <input type="text" name="username" ><br><br>
Pass: <input type="password" name="password" ><br><br>
<input type="submit" name="submit" value="Connect">
</form>