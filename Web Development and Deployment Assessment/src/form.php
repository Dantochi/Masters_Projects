<?php
$sql = "INSERT into customers ";
$username = $_REQUEST["username"];
$password = $_REQUEST["password"];
$DOB = $_REQUEST["DOB"];
$email = $_REQUEST["email"];
echo $username."<br>".$password."<br>".$email."<br>".$DOB;
?>

