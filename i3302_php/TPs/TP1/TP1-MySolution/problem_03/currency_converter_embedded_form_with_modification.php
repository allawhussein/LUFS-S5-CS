<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TP 1.3</title>
</head>
<body>
    <h1>PHP code is inside the HTML - form</h1>
    <?php
        $l = "";
        $d = "";
        if (isset($_GET["submit"])){
            if ($_GET["submit"] == "toLivre"){
                $d = $_GET["dollar"];
                $l = $d * 40000;
            }
            else if ($_GET["submit"] == "toDollar"){
                $l = $_GET["livre"];
                $d = $l / 40000;
            }
        }
    ?>
    <form method="GET" action="currency_converter_embedded_form_with_modification.php">
        Dollar: <input type="text" name="dollar" value=<?php echo "$d"; ?>>
        <input type="submit" name="submit" value="toLivre">
        <br>
        Livre: <input type="text" name="livre" value=<?php echo "$l"; ?>>
        <input type="submit" name="submit" value="toDollar">
    </form>
</body>
</html>