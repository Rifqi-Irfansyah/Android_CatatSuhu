<?php
    $server     = "localhost";
    $user       = "root";
    $password   = "";
    $database   = "catatsuhu";

    $con = mysqli_connect($server, $user, $password, $database);
    if (mysqli_connect_errno()){
        echo "Gagal Terhubung ke Database".mysqli_connect_error();
    }
?>