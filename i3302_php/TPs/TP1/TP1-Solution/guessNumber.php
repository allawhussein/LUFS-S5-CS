<?php
if(!isset($_POST["guess"])){
	$r = mt_rand(1,100);
	$message = "PLAY!";
	$c = 0;
}else{
	$c = $_POST["counter"];
	$c = $c + 1;
	$r = $_POST["randnum"];
	$u = $_POST["usernum"];
	if($r>$u){
		$message = "Your number is smaler than mine! ($c)";
	}elseif($r<$u){
		$message = "Your number is greater than mine! ($c)";
	}else{
		$message = "You win ! ($c)";
	}
}
?>

<html>
<head>
<title>Guess Number</title>
</head>
<body>
<h1>Guess the number between 1 and 100 ?</h1>
<form method="post" action="guessNumber.php">
<input type="text" name="usernum">
<input type="submit" name="guess" value="Guess">
<input type="hidden" name="randnum" value="<?php echo $r; ?>">
<input type="hidden" name="counter" value="<?php echo $c; ?>">
</form>
<h2><?php echo $message; ?></h2>
</body>
</html>
