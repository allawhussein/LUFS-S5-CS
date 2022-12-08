<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TP 1.3</title>
</head>
<body>
    <h1>PHP code is outside the HTML - simple reply</h1>
        <?php
            if(isset($_GET["submit"])){
                if ($_GET["submit"] == "toLivre") {
                    if ($_GET["dollar"]) echo "Your money is worth: ", $_GET["dollar"] * 40000, "L.L.";
                    else echo "You need to enter a value";
                }
                else if ($_GET["submit"] == "toDollar") {
                    if ($_GET["livre"]) echo "Your money is worth: $", $_GET["livre"] / 40000;
                    else echo "You need to enter a value";
                }
            }
        ?>
    </form>
    <br>
    return back to the converter at <a href="currency_converter_splited.html">here</a>
</body>
</html>    