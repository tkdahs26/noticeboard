
<?php
$connect=mysqli_connect("localhost","root","","test");

$sql1 = "SELECT * FROM joindb WHERE joinid='{$_POST['pwdfindid']}'";
$query1=mysqli_query($connect,$sql1);//pwd찾기
while($row=mysqli_fetch_array($query1)){
    $data =    array('id'=>$row[0],
        'joinid'=>$row[1],
        'joinpassword'=>$row[2],
        'joinname'=>$row[3]
    );
}






    header('Content-Type: application/json; charset=utf8');
    $json = json_encode(array("result"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
    echo $json;
    mysqli_close($connect);



?>
