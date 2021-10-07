
<?php
$connect=mysqli_connect("localhost","root","","test");




$sql1 = "SELECT * FROM joindb WHERE joinid='{$_POST['editid_php']}'";
$query1=mysqli_query($connect,$sql1);



$row=mysqli_fetch_array($query1);

if($row[1]==null){
    echo "아이디오류";
}elseif($_POST['editpassword_php']!=$row[2]){
    echo "비밀번호오류";
}else{
    $data =    array('id'=>$row[0],
        'joinid'=>$row[1],
        'joinpassword'=>$row[2],
        'joinname'=>$row[3]
    );
    header('Content-Type: application/json; charset=utf8');
    $json = json_encode(array("result"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
    echo $json;
}


    mysqli_close($connect);




?>
