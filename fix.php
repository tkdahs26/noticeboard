	
<?php
$connect=mysqli_connect("localhost","tidahk","wiatnpfa*8","tidahk");




$sql1 = "UPDATE writedb SET title_db ='{$_POST['fixtitle_php']}'
,content_db='{$_POST['fixcontent_php']}' WHERE count ='{$_POST['id_php']}';";
$query1=mysqli_query($connect,$sql1);
var_dump($query1)
/*

$data=array();
while($row=mysqli_fetch_array($query1)){
    array_push($data,array('index'=>$row[0],
        'title'=>$row[1],
        'content'=>$row[2],
        'writer'=>$row[3]
));
}

header('Content-Type: application/json; charset=utf8');
$json = json_encode(array("result"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
echo $json;
    mysqli_close($connect);


*/


?>
