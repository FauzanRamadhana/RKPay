-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2023 at 07:57 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rkpay`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id` int(11) NOT NULL,
  `transaksiId` int(11) NOT NULL,
  `menuId` int(11) NOT NULL,
  `jumlah` bigint(20) NOT NULL,
  `subTotal` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id`, `transaksiId`, `menuId`, `jumlah`, `subTotal`) VALUES
(1, 1, 9, 3, 15000),
(2, 1, 2, 3, 30000),
(3, 2, 3, 25, 500000),
(4, 3, 3, 25, 500000),
(5, 4, 3, 25, 500000),
(6, 5, 3, 25, 500000),
(7, 6, 3, 25, 500000),
(8, 7, 3, 25, 500000),
(9, 8, 3, 25, 500000),
(10, 9, 3, 25, 500000),
(11, 10, 2, 3, 30000),
(12, 11, 9, 2, 10000),
(13, 11, 3, 2, 40000),
(14, 12, 9, 5, 25000),
(15, 12, 1, 3, 21000),
(16, 13, 3, 2, 40000),
(17, 13, 9, 1, 5000),
(18, 13, 2, 1, 10000),
(19, 14, 10, 2, 8000),
(20, 14, 3, 3, 60000),
(21, 14, 1, 3, 21000),
(22, 15, 10, 2, 8000),
(23, 15, 2, 2, 20000),
(24, 16, 2, 3, 30000),
(25, 16, 3, 2, 40000),
(26, 17, 3, 2, 40000),
(27, 17, 10, 1, 4000),
(28, 18, 9, 1, 5000),
(29, 18, 3, 2, 40000),
(30, 19, 11, 5, 125000),
(31, 19, 12, 5, 50000),
(32, 20, 13, 7, 70000),
(33, 20, 14, 5, 250000);

-- --------------------------------------------------------

--
-- Table structure for table `meja`
--

CREATE TABLE `meja` (
  `id` int(11) NOT NULL,
  `status` enum('Kosong','Penuh') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `meja`
--

INSERT INTO `meja` (`id`, `status`) VALUES
(1, 'Kosong'),
(2, 'Kosong'),
(3, 'Kosong'),
(4, 'Kosong'),
(5, 'Kosong');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `harga` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `kategori` enum('Makanan','Minuman') NOT NULL,
  `showMenu` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `nama`, `harga`, `stok`, `kategori`, `showMenu`) VALUES
(1, 'Nasi Merah', 7000, 14, 'Makanan', 1),
(2, 'Ayam Goreng', 10000, 14, 'Makanan', 1),
(3, 'Ikan Goreng', 20000, 12, 'Makanan', 0),
(9, 'Es Teh', 5000, 11, 'Minuman', 1),
(10, 'Es Jeruk', 4000, 95, 'Minuman', 1),
(11, 'Sate Ayam', 25000, 95, 'Makanan', 1),
(12, 'Es Kelapa Muda', 10000, 15, 'Minuman', 1),
(13, 'Rendang', 10000, 43, 'Makanan', 1),
(14, 'Es Kelapa Sawit', 50000, 5, 'Minuman', 1),
(15, 'Nasi Goreng', 15000, 100, 'Makanan', 1),
(16, 'Teh Tawar', 3000, 1000, 'Minuman', 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `status` enum('Diproses','Selesai') NOT NULL,
  `mejaId` int(11) NOT NULL,
  `totalBayar` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `tgl_transaksi`, `userId`, `status`, `mejaId`, `totalBayar`) VALUES
(1, '2023-12-20', NULL, 'Diproses', 1, 45000),
(2, '2023-12-20', NULL, 'Diproses', 1, 500000),
(3, '2023-12-20', NULL, 'Diproses', 1, 500000),
(4, '2023-12-20', NULL, 'Diproses', 1, 500000),
(5, '2023-12-20', NULL, 'Diproses', 1, 500000),
(6, '2023-12-20', NULL, 'Diproses', 1, 500000),
(7, '2023-12-20', NULL, 'Diproses', 1, 500000),
(8, '2023-12-20', NULL, 'Diproses', 1, 500000),
(9, '2023-12-20', NULL, 'Diproses', 1, 500000),
(10, '2023-12-20', NULL, 'Diproses', 1, 30000),
(11, '2023-12-20', NULL, 'Diproses', 1, 50000),
(12, '2023-12-20', NULL, 'Diproses', 1, 46000),
(13, '2023-12-22', NULL, 'Diproses', 1, 55000),
(14, '2023-12-22', 7, 'Diproses', 2, 89000),
(15, '2023-12-22', 7, 'Selesai', 1, 28000),
(16, '2023-12-22', 7, 'Selesai', 1, 70000),
(17, '2023-12-22', 7, 'Selesai', 1, 44000),
(18, '2023-12-22', 7, 'Selesai', 1, 45000),
(19, '2023-12-27', 7, 'Selesai', 1, 175000),
(20, '2023-12-27', 7, 'Selesai', 3, 320000);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('Admin','Kasir') NOT NULL,
  `telepon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `nama`, `password`, `role`, `telepon`) VALUES
(1, 'Wandi', '12345', 'Admin', '12345'),
(2, 'a', 'a', 'Admin', 'a'),
(3, 'a', 'a', 'Admin', 'a'),
(4, 'a', 'a', 'Admin', 'a'),
(5, 'a', 'a', 'Admin', 'a'),
(6, 'aaa', 'asd', 'Admin', '876'),
(7, 'Asep', '123', 'Kasir', '08111'),
(8, 'Ojan', '11', 'Kasir', '12345'),
(9, 'Kasir1', '123', 'Kasir', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `detail_transaksi_menuid_foreign` (`menuId`),
  ADD KEY `detail_transaksi_transaksiid_foreign` (`transaksiId`);

--
-- Indexes for table `meja`
--
ALTER TABLE `meja`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `transaksi_mejaid_foreign` (`mejaId`),
  ADD KEY `transaksi_userid_foreign` (`userId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `meja`
--
ALTER TABLE `meja`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_menuid_foreign` FOREIGN KEY (`menuId`) REFERENCES `menu` (`id`),
  ADD CONSTRAINT `detail_transaksi_transaksiid_foreign` FOREIGN KEY (`transaksiId`) REFERENCES `transaksi` (`id`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_mejaid_foreign` FOREIGN KEY (`mejaId`) REFERENCES `meja` (`id`),
  ADD CONSTRAINT `transaksi_userid_foreign` FOREIGN KEY (`userId`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
