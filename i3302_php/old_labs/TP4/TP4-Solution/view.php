<?php
//load of session
session_start();

echo "<p align='center'>";
echo "<a href='list.php'>List of products</a><br>";
echo "<a href='cart.php'>See the shopping cart</a><br>";
echo "</p>";

//if you click on Add
if(isset($_POST['add'])){
	//get information from the existing sessions (name, price and quantity)
	$currentimage = $_SESSION['name'];
	$currentprice = $_SESSION['price'];
	$quantity = $_POST['quantity'];
	//update the existing session cart
	$_SESSION['cart'][$currentimage]["price"] = $currentprice;
	$_SESSION['cart'][$currentimage]["cat"] = $_SESSION['cat'];
	if(isset($_SESSION['cart'][$currentimage]["quantity"])){
		$_SESSION['cart'][$currentimage]["quantity"] += $quantity;	
	}else{
		$_SESSION['cart'][$currentimage]["quantity"] = $quantity;
	}
	echo "<h3 align='center'>Product added to shopping cart.</h3>";
	//print_r($_SESSION['cart']); //to see the session
}

//if you visit this page
if(isset($_GET['i']) || isset($_SESSION['image'])){
	
	//you have clicked to a link in list.php to visit this page
	if(isset($_GET['i'])){
		$i = $_GET['i'];
		$d = $_GET['d'];
		$p = $_GET['p'];
		$c = $_GET['c'];
	
		//create the keys of session (image, name,....)
		$_SESSION['image'] = $i;
		$_SESSION['name'] = $d;
		$_SESSION['price'] = $p;
		$_SESSION['quantity'] = 0;
		$_SESSION['cat'] = $c;
		
		//if the sessions (image, name ...) are already created 
	}elseif(isset($_SESSION['image'])){
		$i = $_SESSION['image'];
		$d = $_SESSION['name'];
		$p = $_SESSION['price'];
	}
	
	//replace # character for image src
	$image = str_replace("#", "%23", $i);
	$name = str_replace("-", " ", $d);
	$price = $p;
	
	echo "<h1 align='center'>$name</h1>";
	echo "<h2 align='center'>".$price."$</h2>";
	echo "<p align='center'><img src='".$image."'></p>";
	?>
	<p align='center'>
	<form action='<?php echo $_SERVER['PHP_SELF']; ?>' method='post'>
	<p align='center'>
	<input type='number' name="quantity" value="1">
	<input type='submit' name='add' value='Add'>
	</p>
	</form>
	</p>
	<?php
}
?>