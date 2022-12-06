<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="main.css">
    <title>TP 1.2</title>
</head>
<body>
    <?php
        echo "<table class='mul-tbl'>";
        echo "<tbody>";
        for ($i = 1; $i <= 10; $i++){
            echo "<tr>";
            for ($j = 1; $j <= 10; $j++){
                echo "<td>", $i * $j, "</td>";
            }
            echo "</tr>";
        }
        echo "</tbody>";
        echo "</table>";
    ?>
</body>
</html>