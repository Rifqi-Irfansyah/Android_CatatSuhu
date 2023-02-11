-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Feb 2023 pada 16.30
-- Versi server: 10.4.20-MariaDB
-- Versi PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `catatsuhu`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `catat`
--

CREATE TABLE `catat` (
  `nis` varchar(10) NOT NULL,
  `suhu` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `catat`
--

INSERT INTO `catat` (`nis`, `suhu`) VALUES
('201114899', '37'),
('201114900', '36'),
('201114901', '36'),
('201114902', '34.9'),
('201114903', '37'),
('201114904', '37.6'),
('201114905', '35.3'),
('201114906', '36'),
('201114907', '37.2'),
('201114908', '37'),
('201114909', '35.9'),
('201114910', '37.1'),
('201114911', '36.5'),
('201114912', '35.5'),
('201114913', '35'),
('201114914', '36.5');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `catat`
--
ALTER TABLE `catat`
  ADD PRIMARY KEY (`nis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
