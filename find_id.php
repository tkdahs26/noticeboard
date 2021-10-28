<?php
$connect=mysqli_connect("localhost","tidahk","wiatnpfa*8","tidahk");

$sql2 = "SELECT * FROM joindb WHERE joinemail='{$_POST['idfind_by_email_php']}'";
    $query2=mysqli_query($connect,$sql2); //id찾기
    while($row=mysqli_fetch_array($query2)){
        $data =    array('id'=>$row[0],
            'joinid'=>$row[1],
            'joinpassword'=>$row[2],
            'joinemail'=>$row[3]
    );
    }
            
            
    header('Content-Type: application/json; charset=utf8');
    $json = json_encode(array("result"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
    echo $json;
    mysqli_close($connect);


    ?>