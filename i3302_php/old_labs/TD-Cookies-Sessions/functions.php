<?php
// Check in the file of users if the user exist
function userexist($user,$pass){
	$f = "users.txt";
	$users = fileToArray($f);
	if(isset($users[$user]) && $users[$user]==$pass){
		return true;
	}else{
		return false;
	}	
}

// Save the username and password in the file of users
function registeruser($user,$pass){
	$f = "users.txt";
	$fo = fopen($f,"a");
	fwrite($fo, $user."\n".$pass."\n");
	fclose($fo);
}

// File to associative array
function fileToArray($f){
	$tab = file($f);
	$t2=array();
	for($i=0;$i<count($tab);$i+=2){
		$t2[trim($tab[$i])] = trim($tab[$i+1]);
	}
	return $t2;
}

// File store
function StoreToArray($f){
	$tab = file($f);
	$store=array();
	for($i=0;$i<count($tab);$i+=2){
		$store[trim($tab[$i])] = array("price"=>trim($tab[$i+1]),"quantity"=>0);
	}
	return $store;
}
?>