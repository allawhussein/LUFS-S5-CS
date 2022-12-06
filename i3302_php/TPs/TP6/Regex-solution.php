<form method="post" action="regex.php">
Write the text here: <input type="text" name="text" ><br>
<input type="submit" name="Full_Name" value="Test Full Name">
<input type="submit" name="Phone_Number" value="Test Phone Number">
<input type="submit" name="Match_Dates" value="Test Dates">
<input type="submit" name="Match_Number" value="Test Numbers">
</form>

<?php
if(isset($_POST['Full_Name'])){
	$re='`\b[A-Z][a-z]+ [A-Z][a-z]+\b`';
	$str=$_POST['text'];
	preg_match_all($re, $str, $matches);
	print_r($matches);
}

if(isset($_POST['Phone_Number'])){
	$re='`\+961( )?[0-9]{1,2}[ \/]?(([0-9]{6})|([0-9]{3} [0-9]{3})|([0-9]{2} [0-9]{2} [0-9]{2}))\b`';
	//$re='`\b961`';
	$str=$_POST['text'];
	preg_match_all($re, $str, $matches);
	print_r($matches);
}

if(isset($_POST['Match_Dates'])){
	$re='`\b\d{2}[-.\/][A-Z][a-z]{2}[-.\/]\d{4}\b`';
	$str=$_POST['text'];
	preg_match_all($re, $str, $matches);
	print_r($matches);
}

if(isset($_POST['Match_Number'])){
	$re='`\b-?\d+(\.\d+)?\b`';
	$str=$_POST['text'];
	preg_match_all($re, $str, $matches);
	print_r($matches);
}

?>