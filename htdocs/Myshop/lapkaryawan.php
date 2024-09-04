<?php 
error_reporting(0);

  include "config/koneksi.php";
  
?>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>LAPORAN BARANG MASUK</title>
  </head>
  <body>
  	<a href="javascript:window.print()" target="_blank"><img src="img/print.jpg" alt="print" class="img-thumbnail" height="20" width="40" style="margin-top:5px"></a>

  	<?php
        $tanggal = date('Y-m-d');
        echo $tanggal;
		$tanggal12 = date("F j, Y");
        ?>
  <div class="container">
  	<div class="row">
  		<div class="col-md-12"><h1 class="text-center text-primary">LAPORAN DATA KARYAWAN</h1></div>
  	</div>
  	<br>
  	<div class="row">
  		<div class="col-md-12">
        <table class="table">
		        <thead class="thead-dark">
		            <tr>
		                <th>Nama</th>
		                <th>Username</th>
		                <th>Password</th>
		                <th>Jenis Kelamin</th>
		                <th>Email</th>
		                <th>No. Telp</th>
		                <th>Agama</th>
		                <th>Alamat</th>
		            </tr>
		        </thead>

		        <tbody>
		        	<?php 
		        		$sql = "SELECT * FROM tbl_login";
		        		$query = mysqli_query($con, $sql);
		        		while($r= mysqli_fetch_array($query)){
		        	?>
		            <tr>
		                <td><?php echo $r['nama'] ?></td>
		                <td><?php echo $r['username'] ?></td>
		                <td><?php echo $r['password'] ?></td>
		                <td><?php echo $r['jenis_kelamin'] ?></td>
		                <td><?php echo $r['email'] ?></td>
		                <td><?php echo $r['no_telp'] ?></td>
		                <td><?php echo $r['agama'] ?></td>
		                <td><?php echo $r['alamat'] ?></td>
		            </tr>
		            <?php } ?>

		        </tbody>
		    </table>

  		</div>
  	</div>

  </div>
    <script src="js/bootstrap.min.js"></script>
  </body>
  <footer class="fixed-bottom"> 
  <div class="align-left">
  <div class="d-flex justify-content-between col-md-10 col-md-offset-2 mb-3 mt-5">
                        <div class="align-left">
                        </div>
                        <div class="pull-right small">
                            Depok, </a><?php echo $tanggal12?>
                            <br> Pemilik
                            <br><br><br><br><br> M. Raihan Mahesa</a>
                        </div>
                </div>
</footer>
</html>