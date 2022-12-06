<?php
session_start();
require("functions.php");

if(isset($_SESSION["user"])){
	
	$user = $_SESSION["user"];
	echo "<h1>Welcome ".$user."</h1>";
	
	if(!isset($_SESSION["store"])){
		$store = StoreToArray("store.txt");
		$_SESSION["store"]=$store;
	}
	
	if(isset($_GET["item"])){
		$item = $_GET["item"];
		if($_GET["op"]=="a"){
			$_SESSION["store"][$item]["quantity"]++;
		}elseif($_GET["op"]=="d"){
			$_SESSION["store"][$item]["quantity"]--;
		}
	}
	
	$store = $_SESSION["store"];
	echo "<table border=2 align='center'>";
	echo "<tr><td>Item</td><td>Price</td><td>Quantity</td><td>Add</td><td>Delete</td></tr>";
	foreach($store as $item=>$info){
		echo "<tr><td>".$item."</td><td>".$info["price"]."</td><td>".$info["quantity"]."</td><td><a href='store.php?item=$item&op=a'>+</a></td><td><a href='store.php?item=$item&op=d'>-</a></td></tr>";
	}
	echo "</table>";
	print_r($_SESSION["store"]);
	
	echo "<h2><a href='invoice.php'>Invoice</a></h2>";
	echo "<h2><a href='signin.php?logout=1'>Logout</a></h2>";
}else{
	header("Location:signin.php");
}
?>