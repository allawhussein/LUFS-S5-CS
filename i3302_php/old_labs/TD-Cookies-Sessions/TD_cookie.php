<?php
$cnom = "username";
$cvaleur = "ag02";

if(isset($_COOKIE[$cnom])){
	echo $_COOKIE[$cnom];
}else{
	echo "Cookie not found! create.";
	setcookie($cnom,$cvaleur);
	echo $_COOKIE[$cnom];
}

//to see details on cookie
var_dump($_COOKIE);
//to see the array of cookie
print_r($_COOKIE);

//to print the content of cookie (Username, PHP Session ID, ...)
foreach($_COOKIE as $k=>$v){
	echo $k."<br>";
}
?>