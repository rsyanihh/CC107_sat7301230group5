<?php
$servername = "localhost";
$username = "id16576897_madatabasesss";
$password = "BD_{KYK<~_eeQ5=D";
$database = "id16576897_madatabase";


$User = $_POST['User'];
$Pass = $_POST['Pass'];

$con = mysqli_connect($servername, $username, $password, $database);
$sql ="SELECT * FROM `User` WHERE Username = '$User' AND Password ='$Pass'";
$result = mysqli_query( $con,$sql );

if($result->num_rows > 0){
echo "Login Succesfully";

}
else{
echo "User Not Found";
}

?>