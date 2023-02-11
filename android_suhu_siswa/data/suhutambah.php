<?php
    if($_SERVER['REQUEST_METHOD']=='POST'){

        // Mendapatkan NIlai Variabel
        $nis    = $_POST['nis'];
        $suhu   = $_POST['suhu'];

        // Pembuatan Syntax SQL
        $sql = "INSERT INTO catat (nis,suhu) VALUES ('$nis', '$suhu')";

        // Import File Koneksi Database
        require_once('../koneksi.php');

        // Eksekusi Query Database
        if (mysqli_query($con,$sql)){
            echo "Berhasil Menambahkan Suhu";
        }
        else{
            echo "Gagal Menambahkan Suhu";
        }

        mysqli_close($con);
    }

?>