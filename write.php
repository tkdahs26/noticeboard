
<?php
$connect=mysqli_connect("localhost","root","","test");




$sql1 = "INSERT INTO writedb(title_db,content_db,writer)
VALUES('$_POST[writetitle_php]','$_POST[writecontent_php]','$_POST[writer]')";
$query1=mysqli_query($connect,$sql1);


    mysqli_close($connect);




?>
