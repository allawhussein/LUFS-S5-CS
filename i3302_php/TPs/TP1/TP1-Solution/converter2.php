<form method="post" action="converter2.php">
   Dollar : <input type="number" name="dollar">
   <input type="submit" name="submit" value="To Livre"><br>
   Livre : <input type="number" name="livre">
   <input type="submit" name="submit" value="To Dollar">
</form>

<?php
if(isset($_POST["submit"])){
	if($_POST["submit"]=="To Livre"){
		$d = $_POST["dollar"];
		$l = $d * 1500;
		echo "lThe ammount is:".$l." LBP.";
	}else{
		$l = $_POST["livre"];
		$d = $l / 1500;
		echo "The ammount is:".$d." dollars.";
	}
}
?>