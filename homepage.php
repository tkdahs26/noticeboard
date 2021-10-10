
<?php
$connect=mysqli_connect("localhost","root","","test");




$sql1 = "SELECT * FROM writedb";
$query1=mysqli_query($connect,$sql1);

/*
$sql2 = "SELECT * FROM joindb";
$query2=mysqli_query($connect,$sql2);
$row2=mysqli_fetch_array($query1);
 var_dump()
*/
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




?>
