
<?php
$connect=mysqli_connect("localhost","tidahk","wiatnpfa*8","tidahk");



$sql1 = "SELECT * FROM joindb WHERE joinid='{$_POST['joinid_dup']}'";
$query1=mysqli_query($connect,$sql1);
$row=mysqli_fetch_array($query1);
  
if($row[1]==null){
    echo "중복아이디없다";
}else{
    echo "중복아이디있다";
}


    mysqli_close($connect);




?>
