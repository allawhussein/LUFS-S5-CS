<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TP 1.1</title>
</head>
<body>
    <?php
        $sum = 0;
        $odd_nbr = 0;
        $i = 0;
        echo "<ul>";
        while ($i < 10){
            if (!($odd_nbr % 2)) {
                // even number
                $odd_nbr++;
                continue;
            }
            $i++;
            echo "<li>$odd_nbr</li>";
            $sum += $odd_nbr;
            $odd_nbr++;
        }
        echo "</ul>";
        echo "<h1>The Sum is $sum</h1>";
    ?>
</body>
</html>