	
<?php
$connect=mysqli_connect("localhost","tidahk","wiatnpfa*8","tidahk");




$sql1 =" DELETE FROM writedb WHERE count='{$_POST['json3_id_php']}'";
$query1=mysqli_query($connect,$sql1);
var_dump($query1);




?>