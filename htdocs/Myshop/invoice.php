<?php 
    include "config/koneksi.php";
    include "phpqrcode/qrlib.php";
    
?>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>FAKTUR PENJUALAN</title>
    
    <style>
    .invoice-box {
        max-width: 800px;
        margin: auto;
        padding: 30px;
        border: 1px solid #eee;
        box-shadow: 0 0 10px rgba(0, 0, 0, .15);
        font-size: 16px;
        line-height: 24px;
        font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
        color: #555;
    }
    
    .invoice-box table {
        width: 100%;
        line-height: inherit;
        text-align: left;
    }
    
    .invoice-box table td {
        padding: 5px;
        vertical-align: top;
    }
    
    .invoice-box table tr td:nth-child(2) {
        text-align: right;
    }
    
    .invoice-box table tr.top table td {
        padding-bottom: 20px;
    }
    
    .invoice-box table tr.top table td.title {
        font-size: 45px;
        line-height: 45px;
        color: #333;
    }
    
    .invoice-box table tr.information table td {
        padding-bottom: 40px;
    }
    
    .invoice-box table tr.heading td {
        background: #eee;
        border-bottom: 1px solid #ddd;
        font-weight: bold;
    }
    
    .invoice-box table tr.details td {
        padding-bottom: 20px;
    }
    
    .invoice-box table tr.item td{
        border-bottom: 1px solid #eee;
    }
    
    .invoice-box table tr.item.last td {
        border-bottom: none;
    }
    
    .invoice-box table tr.total td:nth-child(2) {
        border-top: 2px solid #eee;
        font-weight: bold;
    }
    
    @media only screen and (max-width: 600px) {
        .invoice-box table tr.top table td {
            width: 100%;
            display: block;
            text-align: center;
        }
        
        .invoice-box table tr.information table td {
            width: 100%;
            display: block;
            text-align: center;
        }
    }
    
    /** RTL **/
    .rtl {
        direction: rtl;
        font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
    }
    
    .rtl table {
        text-align: right;
    }
    
    .rtl table tr td:nth-child(2) {
        text-align: left;
    }
    </style>
</head>

<body onload="window.print()">


    <div class="invoice-box">
        <table cellpadding="0" cellspacing="0">
            <tr class="top">
                <td colspan="5">
                    <table>
                        <tr>
                            <td class="title">
                                <p style="font-size: 20px;">FAKTUR PEMBELIAN
                                </br>
                                <?php 
                                     $tempDir = "qrcodes/";
    
                                     $codeContents = "http://192.168.43.185$_SERVER[REQUEST_URI]";
                                     
                                     $fileName = '005_file_'.md5($codeContents).'.png';
                                     
                                     $pngAbsoluteFilePath = $tempDir.$fileName;
                                     $urlRelativeFilePath = $tempDir.$fileName;
                                     
                                     if (!file_exists($pngAbsoluteFilePath)) {
                                         QRcode::png($codeContents, $pngAbsoluteFilePath);
                                         echo '';
                                         echo '<hr />';
                                     } else {
                                         echo '';
                                         echo '<hr />';
                                     }
                                     
                                     
                                     echo '<img src="'.$urlRelativeFilePath.'" />';
                                ?>
                            </td>
                            
                            <td>
                               <?php
                               $tanggal=date('Y-m-d');
                               echo $tanggal;
                               $tanggal12 = date("F j, Y");
                               ?><br><img src="img/icon.jpg" alt="" srcset="">
                            </td>
                            
                            
                        </tr>
                    </table>
                </td>
            </tr>
            
            <tr class="information">
                <td colspan="5">
                    <table>
                        <tr>
                            <td>
                                Jl. Grogol Raya, RT 001/008 No. 35, Kelurahan Limo, Kecamatan Grogol<br>
                                Depok, Jawa Barat
                            </td>
                            
                            <td>
                                ArtShop<br>
                                https//:wwww.instagram.com/artshopid<br>
                                artshop_id21@gmail.com
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            
            <tr class="heading">
                <td>
                    NO FAKTUR
                </td>
                
                <td>
                    <?php echo $_GET['fk'] ?>
                </td>
            </tr>
            
            <tr class="details">
                <td></td>
                <td></td>
            </tr>
            
            <tr class="heading">
                <td>NO</td>
                <td>Nama Barang</td>
                <td>Harga Satuan</td>
                <td>Jumlah Beli</td>
                <td>Total Harga</td>
            </tr>
            <?php 
                $no=0;
                $a = mysqli_query($con,"SELECT * FROM tbl_beli WHERE nofaktur = '$_GET[fk]'");
                while($r=mysqli_fetch_array($a)){
                $no++
            ?>
            <tr class="item">
                <td><?php echo $no ?></td>
                <td><?php echo $r['nama_barang'] ?></td>
                <td><?php echo $r['hsatuan'] ?></td>
                <td><?php echo $r['jumlah_beli'] ?></td>
                <td><?php echo $r['harga'] ?></td>
            </tr>
            <?php } ?>
            
            <tr class="total">
                <td></td>
                <td></td>
                <td></td>
                <th align="right">Grand Total :</th>
                <?php
                $a = mysqli_query($con, "SELECT SUM(harga) as TOTAL FROM tbl_beli WHERE nofaktur='$_GET[fk]'");
                $total = mysqli_fetch_array($a);
                ?>
                <td><?php echo $total['TOTAL'] ?></td>
            </tr>
            <tr class="total">
                <td></td>
                <td></td>
                <td></td>
                <th align="right">Bayar :</th>
                <?php
                $b = mysqli_query($con, "SELECT bayar FROM tbl_beli WHERE nofaktur='$_GET[fk]'");
                $bayar = mysqli_fetch_array($b);
                ?>
                <td><?php echo $bayar['bayar'] ?></td>
            </tr>
            <tr class="total">
                <td></td>
                <td></td>
                <td></td>
                <th align="right">Kembalian :</th>
                <?php
                $c = mysqli_query($con, "SELECT kembalian FROM tbl_beli WHERE nofaktur='$_GET[fk]'");
                $kembalian = mysqli_fetch_array($c);
                ?>
                <td><?php echo $kembalian['kembalian'] ?></td>
            </tr>
        </table>
        <table><tr><td align="right">
        <footer class="fixed-bottom"> 
  <div class="align-left">
  <div class="d-flex justify-content-between col-md-8 col-md-offset-2 mb-3 mt-5">
                        <div class="align-left">
                        </div>
                        <div class="align-right small">
                            Depok, </a><?php echo $tanggal12?>
                            <br>Pemilik &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <br><br><br><br><br> M. Raihan Mahesa</a>
                        </div>
                </div>
</footer></td></tr>
</table>
    </div>
</body>

</html>
