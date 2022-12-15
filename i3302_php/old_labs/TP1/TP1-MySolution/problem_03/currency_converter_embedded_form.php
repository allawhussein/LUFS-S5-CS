<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TP 1.3</title>
</head>
<body>
    <h1>PHP code is inside the HTML - simple reply</h1>
    
    <h1>PHP code is inside the HTML - form</h1>
    <form>
        Dollar: <input type="text" name="dollar">
        <input type="submit" name="submit" value="toLivre">
        <?php
            if(isset($_GET["submit"])){
                if ($_GET["submit"] == "toLivre") {
                    if ($_GET["dollar"]) echo $_GET["dollar"] * 40000, "L.L.";
                    else echo "You need to enter a value";
                }
            }
        ?>
        <br>
        Livre: <input type="text" name="livre">
        <input type="submit" name="submit" value="toDollar">
        <?php
            if(isset($_GET["submit"])){
                if ($_GET["submit"] == "toDollar") {
                    if ($_GET["livre"]) echo "$", $_GET["livre"] / 40000;
                    else echo "You need to enter a value";
                }
            }
        ?>
    </form>
</body>
</html>