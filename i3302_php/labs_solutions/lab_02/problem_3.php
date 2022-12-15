<?php
    function verify_pass($user, $pass){
        if ($user == "" || $pass == "") return false;
        else if (strlen($pass) < 6) return false;
        else if (strpos($pass, " ")) return false;
        else if (strpos($user, $pass)) return false;
        else return true;
    }
?>