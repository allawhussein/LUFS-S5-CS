<?php
session_start();
require("functions.php");

if(isset($_GET["logout"])){
	session_destroy();
}
?>

<h1>Sign in</h1>
<form action="signin.php" method="post">
user: <input type="text" name="user"><br>
pass: <input type="password" name="pass"><br>
<input type="submit" name="signin" value="Sign in">
</form>

<?php
if(isset($_POST["signin"])){
	if(userexist($_POST["user"],$_POST["pass"])){
		$_SESSION["user"]=$_POST["user"];
		header("Location:store.php");
	}else{
		echo "<h1>User not registered, please register!</h1>";
	}
}
?>

<h1>Sign up</h1>
<form action="signin.php" method="post">
user: <input type="text" name="user"><br>
pass: <input type="password" name="pass"><br>
<input type="submit" name="signup" value="Signup">
</form>

<?php
if(isset($_POST["signup"])){
	registeruser($_POST["user"],$_POST["pass"]);
	echo "<h1>User registered.</h1>";
	$_SESSION["user"]=$_POST["user"];
	header("Location:store.php");
}
?>