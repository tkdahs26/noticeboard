<?php
$connect=mysqli_connect("localhost","root","","test");

$sql2 = "SELECT * FROM writedb WHERE title_db='{$_POST['title_php']}'";
    $query2=mysqli_query($connect,$sql2); 

    //var_dump($row);

    
    while($row=mysqli_fetch_array($query2)){
        $data = array('index'=>$row[0],
            'title'=>$row[1],
            'content'=>$row[2],
            'writer'=>$row[3]
    );
    }
            
            
    header('Content-Type: application/json; charset=utf8');
    $json = json_encode(array("result"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
    echo $json;
    mysqli_close($connect);


    ?>