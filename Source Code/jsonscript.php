<?php

 // PHP variable to store the host address
 $db_host  = "YourDatabaseHost";
 // PHP variable to store the username
 $db_uid  = "userid";
 // PHP variable to store the password
 $db_pass = "password";
 // PHP variable to store the Database name  
 $db_name  = "databaseName"; 
        // PHP variable to store the result of the PHP function 'mysql_connect()' which establishes the PHP & MySQL connection  
 $db_con = mysql_connect($db_host,$db_uid,$db_pass) or die('could not connect');
 mysql_select_db($db_name);
 $sql = "SELECT * FROM people WHERE  birthyear > '". $_POST["birthyear"]."'";
 $result = mysql_query($sql);
 while($row=mysql_fetch_assoc($result))
  $output[]=$row;
 print(json_encode($output));
 mysql_close();   
?>

