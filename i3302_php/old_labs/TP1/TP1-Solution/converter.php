<?php
if(isset($_POST["submit"])){
	if($_POST["submit"]=="To Livre"){
		$d = $_POST["dollar"];
		$l = $d * 1500;
		echo "The ammount is:".$l." LBP.";
	}else{
		$l = $_POST["livre"];
		$d = $l / 1500;
		echo "The ammount is:".$d." dollars.";
	}
}else{
	echo "You should go to the form! ";
	echo "<a href='converter.html'>Form</a>";
}
?>