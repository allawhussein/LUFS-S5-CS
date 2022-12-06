<html>
        <head>
            <title>Guess Number</title>
        </head>
    <body>
        <h1>Guess the number between 1 and 100 ?</h1>
        <form method="get" action="guess_a_number.php">
            <input type="text" name="usr_num">
            <input type="submit" name="guess" value="guess">
            <input type="hidden" name="rand_num" value="<?php 
                if (!isset($_GET["rand_num"])) {
                    echo mt_rand(0, 100);
                }
                else {
                    echo $_GET["rand_num"];
                }?>">
        </form>
        <h2><?php
            if (isset($_GET["usr_num"]) && isset($_GET["rand_num"])){
                $usr_num = $_GET["usr_num"];
                $guess = $_GET["guess"];
                $rand_num = $_GET["rand_num"];
            
                if ($usr_num == $rand_num) echo "YOU WIN!";
                else if ($usr_num > $rand_num) echo "Your number is higher";
                else echo "Your number is lower";
            }
        ?></h2>
    </body>
</html> 