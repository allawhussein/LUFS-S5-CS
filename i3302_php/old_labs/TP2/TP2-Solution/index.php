<!DOCTYPE html>
<html>
<head>
<title>Saraha for Science</title>
</head>
<body>

<p align="center"><img src="profile.jpg" width="75" height="75"></p>

<h2 align="center">Science Dep.</h2>

<h4 align="center"><a href="see.php">Read messages</a></h4>

<p align="center">Make your message fruitful!</p>

<p>
<form action="<?php $_SERVER['PHP_SELF'] ?>" method="POST" align="center">
	<textarea cols="40" rows="10" name="mess"></textarea><br>
	<input type="submit" name="submit" value="Send">
</form>
</p>

</body>
</html>

<?php
if(isset($_POST["submit"])){
	$message = $_POST["mess"]."\n";
	//Open the file messages.txt in append mode and insert the message
	$f = fopen("messages.txt","a");
	fwrite($f,$message);
	fclose($f);
}
?>