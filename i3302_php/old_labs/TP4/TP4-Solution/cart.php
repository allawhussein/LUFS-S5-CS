<?php
//load the session
session_start();


// if you have clicked to UPDATE
if(isset($_POST['update'])){
	foreach($_SESSION['cart'] as $product=>$details){
		if(isset($_POST[$product])){
			// update the quantity of each product in his appropriate session
			$_SESSION['cart'][$product]['quantity'] = $_POST[$product];
		}
	}
}

echo "<p align='center'>";
echo "<a href='list.php'>List of products</a><br>";
echo "</p>";
?>
<form action="cart.php" method="post">
<table align="center" width="800" border="1">
<tr><th>Product</th><th>Price</th><th>Quantity</th><th>Total Price</th><th>Category</th></tr>
<?php
$sum = 0;
if(isset($_SESSION['cart'])){
foreach($_SESSION['cart'] as $product => $details){
	$name= str_replace("-", " ", $product);
	$price = $_SESSION['cart'][$product]['price'];
	$quantity = $_SESSION['cart'][$product]['quantity'];
	$sum += $price*$quantity;
	$cat= $_SESSION['cart'][$product]['cat'];
	echo "<tr><td>".$name."</td><td>".$price."$</td><td><input type='number' value='".$quantity."' name='".$product."'></td><td>".($price*$quantity)."$</td><td>".$cat."</td></tr>";
}}
?>
</table>
<h3 align='center'><input type='submit' name='update' value='UPDATE'></h3>
</form>

<?php
echo "<h3 align='center'>The total is : ".$sum."$</h3>";
//print_r($_SESSION['cart']); // to see the array of this session
?>