<?php
$servername = "localhost";
$username = "id16576897_madatabasesss";
$password = "BD_{KYK<~_eeQ5=D";
$database = "id16576897_madatabase";

$Fname = $_POST['Fname'];
$User = $_POST['User'];
$Pass = $_POST['Pass'];
$Num = $_POST['Num'];

$con = mysqli_connect($servername, $username, $password, $database);
$sql ="INSERT INTO User(fullname,Username,Password,number) VALUES ('$Fname','$User','$Pass','$Num')";
$result = mysqli_query( $con,$sql );

if($result){
echo "Register Succesfully";

}
else{
echo "Error Occured";
}

?>