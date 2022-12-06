<?php
session_start();

if(isset($_SESSION["user"]) && isset($_SESSION["store"])){
	$store=$_SESSION["store"];
	$s=0;
	foreach($store as $item=>$info){
		if($info["quantity"]>0){
			$pt = $info["price"]*$info["quantity"];
			echo "$item: price(".$info["price"].") - quantity(".$info["quantity"].") - total price:".$pt."<br>";
			$s+=$pt;
		}
	}
	echo "------------------";
	if($s!=0){
		echo "<h3>Amount: $s LP</h3>";
	}else{
		echo "<h3>No items to display!</h3>";
	}
	echo "------------------";
	echo "<h2><a href='store.php'>Back to store</a></h2>";
	echo "<h2><a href='signin.php?logout=1'>Logout</a></h2>";
}else{
	header("Location:signin.php");
}
?>