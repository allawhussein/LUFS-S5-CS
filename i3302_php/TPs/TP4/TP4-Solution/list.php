<?php
//load the session
session_start();

echo "<p align='center'>";
echo "<a href='cart.php'>See the shopping cart</a><br>";
echo "</p>";

$products = 'products';
$p = scandir($products);
//print_r($p);
?>
<table align="center" width="800" border="1">
<tr><th>Product</th><th>Price</th><th>Type</th></tr>
<?php
foreach($p as $r){
	if(is_dir($products."/".$r) && $r!='.' && $r!='..'){
		$equi = scandir($products."/".$r);
		//print_r($equi); echo "<br>"; //to see the array
		foreach($equi as $im){
			if($im!='.' && $im!='..'){
				$p1 = strpos($im,'#');
				$s1 = substr($im,$p1+1);
				$p2 = strrpos($s1,'.');
				$price = substr($s1,0,$p2);
				$name = substr($im,0,$p1);
				$nameprint = str_replace("-", " ", $name);
				$image = $products."/".$r."/".$im;
				echo "<tr><td><a href='view.php?c=".$r."&i=".urlencode($image)."&d=".urlencode($name)."&p=".$price."'>".$nameprint."</a></td><td>".$price."</td><td>".$r."</td></tr>";
			}
		}
	}
}
?>
</table>

<h2 align='center'>
<!-- if you click on this link, you send to this page the variable new=1 -->
<a href='list.php?new=1'>Empty the shopping cart</a>
</h2>

<?php
//if the above link is clicked, so destroy the session, so the shopping cart will be empty
if(isset($_GET["new"])){
	session_destroy();
}
?>