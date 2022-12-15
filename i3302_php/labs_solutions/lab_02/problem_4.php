<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>From & String & Function</title>
</head>
<body>
    <form action = "problem_4.php" method="POST">
        Username: <input type="text" name="user"><br>
        Password: <input type="password" name="pass"><br>
        <input type="submit" value="Send" name="submit">
        <input type="submit" value="Delete" name="submit">
    </form>
    <?php
        require 'problem_3.php';
        if (isset($_POST["user"]) && isset($_POST["pass"]) && isset($_POST["submit"]) && $_POST["submit"] != "Delete"){
            $user = $_POST["user"];
            $pass = $_POST["pass"];
            if (verify_pass($user, $pass)) echo "Welcome $user";
            else echo "Something went wrong";
        }
    ?>
</body>
</html>