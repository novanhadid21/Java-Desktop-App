-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2021 at 01:00 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_barang`
--

CREATE TABLE `tbl_barang` (
  `kd_barang` varchar(11) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jumlah_barang` int(11) NOT NULL,
  `harga_beli` int(11) NOT NULL,
  `harga_jual` int(11) NOT NULL,
  `tanggal_masuk` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_barang`
--

INSERT INTO `tbl_barang` (`kd_barang`, `nama_barang`, `jumlah_barang`, `harga_beli`, `harga_jual`, `tanggal_masuk`) VALUES
('A0002', 'Kuas', 33, 2500, 3000, '2021-08-16'),
('B0001', 'Canvas', 34, 30000, 40000, '2021-08-16'),
('B0002', 'Pilox', 100, 20000, 32000, '2021-08-24');

--
-- Triggers `tbl_barang`
--
DELIMITER $$
CREATE TRIGGER `delete` AFTER INSERT ON `tbl_barang` FOR EACH ROW DELETE FROM tbl_supplier WHERE tbl_supplier.jumlah_barang = '0'
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_beli`
--

CREATE TABLE `tbl_beli` (
  `nofaktur` varchar(11) NOT NULL,
  `kd_barang` varchar(11) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `hsatuan` int(11) NOT NULL,
  `jumlah_beli` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_beli`
--

INSERT INTO `tbl_beli` (`nofaktur`, `kd_barang`, `nama_barang`, `hsatuan`, `jumlah_beli`, `harga`, `bayar`, `kembalian`, `tanggal`) VALUES
('F0001', 'B0002', 'pen', 6000, 1, 6000, 10000, 4000, '2021-07-30'),
('F0002', 'B0002', 'pen', 6000, 1, 6000, 10000, 4000, '2021-07-30'),
('F0003', 'B0002', 'pen', 6000, 2, 12000, 20000, 8000, '2021-07-30'),
('F0004', 'B0002', 'pen', 6000, 3, 18000, 20000, 2000, '2021-07-30'),
('F0005', 'B0002', 'pen', 6000, 3, 18000, 25000, 1000, '2021-07-30'),
('F0005', 'B0002', 'pen', 6000, 1, 6000, 25000, 1000, '2021-07-30'),
('F0006', 'B0002', 'pen', 6000, 1, 6000, 10000, 4000, '2021-07-30'),
('F0007', 'A0001', 'fountain pen', 150000, 2, 300000, 400000, 88000, '2021-07-30'),
('F0007', 'B0002', 'pen', 6000, 2, 12000, 400000, 88000, '2021-07-30'),
('F0008', 'A0003', 'asddf', 2000, 1, 2000, 5000, 3000, '2021-07-30'),
('F0009', 'B0002', 'pen', 6000, 1, 6000, 10000, 4000, '2021-08-05'),
('F0010', 'B0002', 'pen', 6000, 5, 30000, 30000, 0, '2021-08-05'),
('F0011', 'A0003', 'asddf', 2000, 2, 4000, 5000, 1000, '2021-08-05'),
('F0012', 'B0002', 'pen', 6000, 14, 84000, 100000, 16000, '2021-08-06'),
('F0013', 'A0003', 'pulpen faster', 3000, 60, 180000, 190000, 10000, '2021-08-08'),
('F0014', 'A0003', 'pulpen faster', 3000, 12, 36000, 40000, 4000, '2021-08-12'),
('F0015', 'A0001', 'fountain pen', 150000, 5, 750000, 750000, 0, '2021-08-12'),
('F0016', 'A0002', 'Kuas', 3000, 2, 6000, 10000, 4000, '2021-08-16'),
('F0017', 'A0002', 'Kuas', 3000, 4, 12000, 55000, 3000, '2021-08-18'),
('F0017', 'B0001', 'Canvas', 40000, 1, 40000, 55000, 3000, '2021-08-18'),
('F0018', 'A0002', 'Kuas', 3000, 1, 3000, 5000, 2000, '2021-08-20'),
('F0019', 'B0001', 'Canvas', 40000, 1, 40000, 50000, 10000, '2021-08-20'),
('F0020', 'B0001', 'Canvas', 40000, 1, 40000, 50000, 10000, '2021-08-20'),
('F0021', 'A0002', 'Kuas', 3000, 4, 12000, 55000, 3000, '2021-08-20'),
('F0021', 'B0001', 'Canvas', 40000, 1, 40000, 55000, 3000, '2021-08-20'),
('F0022', 'B0001', 'Canvas', 40000, 1, 40000, 50000, 10000, '2021-08-20'),
('F0023', 'A0002', 'Kuas', 3000, 5, 15000, 20000, 5000, '2021-08-21'),
('F0024', 'B0001', 'Canvas', 40000, 1, 40000, 60000, 20000, '2021-08-21'),
('F0025', 'B0001', 'Canvas', 40000, 10, 400000, 600000, 200000, '2021-08-22'),
('F0026', 'A0002', 'Kuas', 3000, 1, 3000, 5000, 2000, '2021-08-24');

--
-- Triggers `tbl_beli`
--
DELIMITER $$
CREATE TRIGGER `updatequantity` AFTER INSERT ON `tbl_beli` FOR EACH ROW update tbl_barang i set i.jumlah_barang = i.jumlah_barang - new.jumlah_beli
where i.kd_barang = new.kd_barang
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE `tbl_login` (
  `nama` varchar(25) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `no_telp` varchar(30) NOT NULL,
  `agama` varchar(30) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`nama`, `username`, `password`, `jenis_kelamin`, `email`, `no_telp`, `agama`, `alamat`) VALUES
('Pmilik Toko', 'admin', 'admin', 'Perempuan', 'admin@gmail.com', '123', 'Islam', 'Jakarta'),
('Oji Admin1', 'admin2', 'admin2', 'Laki-Laki', 'admin2@gmail.com', '124156157', 'Islam', 'Jakarta'),
('oki', 'kasir2', 'kasir2', 'Laki-Laki', 'kasir2@gmail.com', '+62123456789', 'Islam', 'Jakarta'),
('Leo gudang', 'kasir_gudang', 'kasir1', 'Laki-Laki', 'kasir_gudang@gmail.com', '+624128471249', 'Islam', 'Jakarta');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_supplier`
--

CREATE TABLE `tbl_supplier` (
  `kd_barang` varchar(10) CHARACTER SET latin1 NOT NULL,
  `nama_barang` varchar(50) CHARACTER SET latin1 NOT NULL,
  `jumlah_barang` int(11) NOT NULL,
  `harga_beli` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_supplier`
--

INSERT INTO `tbl_supplier` (`kd_barang`, `nama_barang`, `jumlah_barang`, `harga_beli`) VALUES
('A0002', 'Kuas', 50, 2500),
('A0003', 'Pilox (Biru Tua)', 100, 24000);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tmp_beli`
--

CREATE TABLE `tbl_tmp_beli` (
  `kd_barang` varchar(11) CHARACTER SET latin1 NOT NULL,
  `nama_barang` varchar(50) CHARACTER SET latin1 NOT NULL,
  `hsatuan` int(11) NOT NULL,
  `jumlah_beli` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_barang`
--
ALTER TABLE `tbl_barang`
  ADD PRIMARY KEY (`kd_barang`);

--
-- Indexes for table `tbl_login`
--
ALTER TABLE `tbl_login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tbl_supplier`
--
ALTER TABLE `tbl_supplier`
  ADD PRIMARY KEY (`kd_barang`);

--
-- Indexes for table `tbl_tmp_beli`
--
ALTER TABLE `tbl_tmp_beli`
  ADD PRIMARY KEY (`kd_barang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
