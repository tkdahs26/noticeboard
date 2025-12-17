
<?php
$connect=mysqli_connect("localhost","tidahk2","wiatnpfa*8","tidahk2");




$sql1 = "INSERT INTO writedb(title_db,content_db,writer)
VALUES('$_POST[writetitle_php]','$_POST[writecontent_php]','$_POST[writer]')";
$query1=mysqli_query($connect,$sql1);

/*
while($row=mysqli_fetch_array($query1)){
    $data =    array('index'=>$row[0],
        'title'=>$row[1],
        'content'=>$row[2],
        'joinname'=>$row[3]
    );
}
*/
    mysqli_close($connect);




?>
