<?php
if(isset($_POST["submit"])){
	$username="sdep";
	$password="123";
	$user=$_POST["user"];
	$pass=$_POST["pass"];
	
	if($user!=$username || $pass!=$password){
		
	header("Location:index.php");
	
	}elseif($user==$username && $pass==$password){
		
		echo "<p align='center'>";

		//open the file of messages and display its contents
		$f = fopen("messages.txt","r");
		while($m=fgets($f)){
			echo "<span align='center' style='text-align:center; width: 400px;border-bottom: 2px solid red;background-color: lightgrey;border-radius: 5px;'>";
			echo $m;
			echo "</span><br/><br/>";
		}

		echo "</p>";
	}
}

?>

<p align="center"><img src="profile.jpg" width="75" height="75"></p>

<h2 align="center">Science Dep.</h2>

<h4 align="center"><a href="index.php">Send a message</a></h4>

<p>
<form action="<?php $_SERVER['PHP_SELF'] ?>" method="POST" align="center">
	<table align="center">
		<tr><th>Username:</th><td><input type="text" name="user"></td>
		<tr><th>Password: </th><td><input type="password" name="pass"></td>
		<tr><th colspan="2"><input type="submit" name="submit" value="Read"></th></tr>
	</table>
</form>
</p>
