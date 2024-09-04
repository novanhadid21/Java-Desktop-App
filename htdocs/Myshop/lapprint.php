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
    <title>LAPORAN PENJUALAN</title>
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
  		<div class="col-md-12"> <img src="img/icon.jpg" alt=""> <h1 class="text-center text-dark">ARTSHOP</h1> 
		  <hr> <h5 class="text-center text-secondary">Jl. Grogol Raya, RT 001/008 No. 35, Kelurahan Limo, Kecamatan Grogol, Depok</h5> 
		  <br> <h1 class="text-center text-dark">LAPORAN PENJUALAN</h1></div>
  	</div>
  	 <?php 
          if(isset($_POST['cek'])){
              $where = "SELECT * FROM tbl_beli WHERE tanggal BETWEEN '$_POST[dari]' AND '$_POST[sampai]'";
          }
    ?>
    <form method="post">
      <table>
        <tr>
          <td>Dari Tanggal <input type="date" value="<?php if(isset($_POST['dari'])){echo $_POST['dari'];} ?>" name="dari"></td>
          <td>   Sampai <input type="date" value="<?php if(isset($_POST['sampai'])){echo $_POST['sampai'];} ?>" name="sampai"></td>
          <td><input type="submit" name="cek" value="CEK"></td>
        </tr>
      </table>
    </form>
  	<br>
  	<div class="row">
  		<div class="col-md-12">
        <table class="table">
		        <thead class="thead-dark">
		            <tr>
                        <th>No Faktur</th>
                        <th>Kode Barang</th>
                        <th>Nama Barang</th>
                        <th>Harga Satuan</th>
                        <th>Jumlah Beli</th>
                        <th>Total</th>
                        <th>Tanggal</th>
		            </tr>
		        </thead>

		        <tbody>
		        	<?php 
						if(isset($_POST['cek'])){
                        $data = 0;
		        		$query = mysqli_query($con, $where);
		        		while($r= mysqli_fetch_array($query)){
                        $data+=$r['harga'];
		        	?>
		            <tr>
                        <td><?php echo $r['nofaktur'] ?></td>
                        <td><?php echo $r['kd_barang'] ?></td>
                        <td><?php echo $r['nama_barang'] ?></td>
                        <td><?php echo $r['hsatuan'] ?></td>
                        <td><?php echo $r['jumlah_beli'] ?></td>
                        <td><?php echo $r['harga'] ?></td>
                        <td><?php echo $r['tanggal'] ?></td>
		            </tr>
                     
		            <?php }?>
                    <tr class="table-dark">
                        <td colspan="5"><?php echo "TOTAL";?></td>
                        <td colspan="2"><?php echo $data;?></td>

                    </tr>
                    <?php } 
                    else{
						$sql = "SELECT * FROM tbl_beli";
		        		$query = mysqli_query($con, $sql);
		        		while($r= mysqli_fetch_array($query)){
					?>
					<tr>
                        <td><?php echo $r['nofaktur'] ?></td>
                        <td><?php echo $r['kd_barang'] ?></td>
                        <td><?php echo $r['nama_barang'] ?></td>
                        <td><?php echo $r['hsatuan'] ?></td>
                        <td><?php echo $r['jumlah_beli'] ?></td>
                        <td><?php echo $r['harga'] ?></td>
                        <td><?php echo $r['tanggal'] ?></td>
					</tr>
					<?php }} ?>

		        </tbody>
		    </table>

  		</div>
  	</div>
    <div class="static-bottom">
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
          </div>
  </div>
    <script src="js/bootstrap.min.js"></script>
  </body>

</html>