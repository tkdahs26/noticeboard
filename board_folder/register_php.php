<!DOCTYPE html>
<html>
<body>

<?php

$connect=mysqli_connect("localhost","root","","test");
$sql = "INSERT INTO joindb(joinid,joinpassword,joinemail)
VALUES('$_POST[joinid]','$_POST[joinpassword]','$_POST[joinemail]')";



$query=mysqli_query($connect,$sql); 

$str="";
while($row=mysqli_fetch_array($query)){
    $str=$str.$row['joinid'];  
}


echo ("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");

   $sql1 = "SELECT * FROM joindb WHERE id='{$_POST['id']}'";
   $query1=mysqli_query($connect,$sql1);
   $row1=mysqli_fetch_array($query1);

echo ("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");

print_r($row1);
$array=array('array1'=>$row1['joinid'],'array2'=>$row1['joinpassword']);
print_r($array);
echo ("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
print_r($str);
//echo '<li>'.$row['joinid'].'<li>';
//echo "id값=",$_POST['id'],"\n";
echo "joinid값=",$_POST['joinid'],"\n";
echo "joinpassword값=",$_POST['joinpassword'],"\n";
echo "joinpassword값=",$_POST['joinpassword2'],"\n";
echo "joinname값=",$_POST['joinname'],"\n";
echo ("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");



?>

</body>
</html>