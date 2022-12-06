<?php
// Creation du fichier photos.txt une seule fois
// a partir du dossier fourni

	$f=fopen("photos.txt","w");
	$im=scandir("flowers");
	foreach($im as $v){
		if($v!="." && $v!=".."){
			fwrite($f,$v."\n");
		}
	}
	fclose($f);


$images=file("photos.txt");
$nbi=count($images);

// Affichage du gallery
if(isset($_GET["id"])){
	$idc = $_GET["id"];
	if($idc==0){
		$idp=$nbi-1;
	}else{
		$idp=$idc-1;
	}
	if($idc==$nbi-1){
		$idn=0;
	}else{
		$idn=$idc+1;
	}
}else{
	$idc=0;
	$idp=$nbi-1;
	$idn=1;
}

echo "<a href='view.php?id=".$idp."'>Previous</a>";
echo "<img src='flowers/".$images[$idc]."' width=150 height=150>";
echo "<a href='view.php?id=".$idn."'>Next</a>";

echo "<h2><a href='upload.php'>Upload</a></h2>";
?>