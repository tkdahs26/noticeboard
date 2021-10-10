	
<?php
$connect=mysqli_connect("localhost","root","","test");




$sql1 =" DELETE FROM writedb WHERE id='{$_POST['json3_id_php']}'";
$query1=mysqli_query($connect,$sql1);
var_dump($query1);




?>