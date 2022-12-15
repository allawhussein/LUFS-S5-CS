<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>From & String</title>
</head>
<body>
    <form action = "problem_2.php" method="POST">
        Username: <input type="text" name="user"><br>
        Password: <input type="password" name="pass"><br>
        <input type="submit" value="Send" name="submit">
        <input type="submit" value="Delete" name="submit">
    </form>
    <?php
        if (isset($_POST["user"]) && isset($_POST["pass"]) && isset($_POST["submit"]) && $_POST["submit"] != "Delete"){
            $user = $_POST["user"];
            $pass = $_POST["pass"];
            if ($user == "" || $pass == "") echo "Enter a valid username and/or password";
            else if (strlen($pass) < 6) echo "Your password is short, minimum is 6 characters";
            else if (strpos($pass, " ")) echo "Your password shouldn't contain spaces";
            else if (strpos($user, $pass)) echo "Your password shouldn't be a substring of your username";
            else echo "Welcome $user";
            
        }
    ?>
</body>
</html>