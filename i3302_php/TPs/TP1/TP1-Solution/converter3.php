<?php
$d="";
$l="";

if(isset($_POST["submit"])){
	if($_POST["submit"]=="To Livre"){
		$d = $_POST["dollar"];
		$l = $d * 1500;
	}else{
		$l = $_POST["livre"];
		$d = $l / 1500;
	}
}
?>

<form method="post" action="converter3.php">
   Dollar : <input type="number" name="dollar" value="<?php echo $d; ?>">
   <input type="submit" name="submit" value="To Livre"><br>
   Livre : <input type="number" name="livre" value="<?php echo $l; ?>">
   <input type="submit" name="submit" value="To Dollar">
</form>

