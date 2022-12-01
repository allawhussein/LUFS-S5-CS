<html>
<head>
    <title>PHP Session 2</title>
</head>
<body>
    <?php
        $text = "Hello World";
        $string1 = 10;
        $string2 = 5;
        echo "$text";
        echo "<h1>Hi all</h1>".$text;
        echo $text,$text;
        $text = $string1.$string2;
        echo $text;
        echo "<br/>$text<br/>";
        echo $string2/$string1;
        $string1++;
        echo $string1;
    ?>
</body>
</html>