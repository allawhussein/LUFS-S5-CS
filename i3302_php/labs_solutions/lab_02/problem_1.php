<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Associative Arrays & Strings</title>
</head>
<body>
    This application should get the number of occurences of email providers<br>
    <?php
        $email_providers = array();
        $emails = array(
            "ali@gmail.com",
            "aline.gh@ul.edu.lb",
            "samarlb@hotmail.com",
            "samir@gmail.com",
            "salim@hotmail.com",
            "yasmine_87@gmail.com");

        foreach($emails as $email){
            // get the array provider from the whole email
            $email_provider = "";
            preg_match("/(?<=@)[^.]+(?=\.).*/", $email, $email_provider); // https://stackoverflow.com/questions/39027204/regex-get-domain-name-from-email
            // add email provider to an associative array
            if (array_key_exists($email_provider[0], $email_providers))
                $email_providers[$email_provider[0]]++;
            else $email_providers[$email_provider[0]] = 1;
        }

        foreach($email_providers as $email_provider => $occurence_number)
            echo "$email_provider : $occurence_number<br>";

        /* Doctor's Solution
        foreach($emails as $email){
            $domain = substr($email, strpos($email, "@") + 1);
            $domains = $domain;
        }
        $count = array_count_values($domains);
        foreach($count as $domain=>occurences)
            echo "$domain:$occurences"
        */
    ?>

</body>
</html>