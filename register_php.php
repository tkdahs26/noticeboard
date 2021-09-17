<!DOCTYPE html>
<html>
<body>
if($query==false){
    echo "에러=",mysqli_error($connect);
    }

<?php

$connect=mysqli_connect("localhost","root","","test");
$sql = "INSERT INTO joindb(joinid,joinpassword,joinemail)
VALUES('$_POST[joinid]','$_POST[joinpassword]','$_POST[joinemail]')";



$query=mysqli_query($connect,$sql); //여기까지db회원가입 아이디찾기

$str="";
while($row=mysqli_fetch_array($query)){
    $str=$str.$row['joinid'];
}




?>

</body>
</html>