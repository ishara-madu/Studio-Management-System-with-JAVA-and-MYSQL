-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 16, 2024 at 12:36 PM
-- Server version: 8.0.31
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studio`
--
CREATE DATABASE IF NOT EXISTS `studio` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `studio`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pass` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `pass`) VALUES
(1, 'user', 'user'),
(13, 'bandara', '1234'),
(14, 'hasi', '2580'),
(15, 'Madu', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `ct_id` int NOT NULL,
  `ct_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ct_price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`ct_id`, `ct_name`, `ct_price`) VALUES
(1, 'A3', 900.00),
(2, '4R', 250.00),
(3, 'A4', 500.00);

-- --------------------------------------------------------

--
-- Table structure for table `main_admin`
--

CREATE TABLE `main_admin` (
  `id` int NOT NULL,
  `username` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(40) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `main_admin`
--

INSERT INTO `main_admin` (`id`, `username`, `password`) VALUES
(1, 'ishara', '1234'),
(19, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE `sale` (
  `s_id` int NOT NULL,
  `ct_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `s_date` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sold_out` int NOT NULL DEFAULT '1',
  `damage` int NOT NULL DEFAULT '0',
  `price` decimal(13,2) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `add_user` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_user` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nothing` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'empty'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`s_id`, `ct_name`, `s_date`, `sold_out`, `damage`, `price`, `date`, `add_user`, `update_user`, `nothing`) VALUES
(1, '4R', '2024 Jan 13  09:47:59 PM', 1, 0, 250.00, '2024-01-13', 'null', NULL, 'empty'),
(2, '4R', '2024 Jan 13  09:47:59 PM', 1, 0, 250.00, '2024-01-13', 'null', NULL, 'empty'),
(3, '4R', '2024 Jan 13  09:47:59 PM', 1, 0, 250.00, '2024-01-13', 'null', NULL, 'empty'),
(4, '4R', '2024 Jan 13  09:47:59 PM', 1, 0, 250.00, '2024-01-13', 'null', NULL, 'empty'),
(5, '4R', '2024 Jan 13  09:47:59 PM', 1, 0, 250.00, '2024-01-13', 'null', NULL, 'empty'),
(6, '4R', '2024 Jan 13  09:47:59 PM', 1, 0, 250.00, '2024-01-13', 'null', NULL, 'empty'),
(7, '4R', '2024 Jan 13  09:47:59 PM', 1, 0, 250.00, '2024-01-13', 'null', NULL, 'empty'),
(8, 'A3', '2024 Jan 13  10:01:49 PM', 1, 0, 900.00, '2024-01-13', 'null', NULL, 'empty'),
(9, '4R', '2024 Jan 14  03:01:12 AM', 1, 0, 250.00, '2024-01-14', 'null', NULL, 'empty'),
(10, '4R', '2024 Jan 14  03:01:12 AM', 1, 0, 250.00, '2024-01-14', 'null', NULL, 'empty'),
(11, '4R', '2024 Jan 14  03:01:12 AM', 1, 0, 250.00, '2024-01-14', 'null', NULL, 'empty'),
(13, '4R', '2024 Jan 14  03:01:12 AM', 1, 0, 250.00, '2024-01-14', 'null', NULL, 'empty'),
(14, '4R', '2024 Jan 14  03:01:12 AM', 1, 0, 250.00, '2024-01-14', 'null', NULL, 'empty'),
(15, '4R', '2024 Jan 14  03:01:12 AM', 1, 0, 250.00, '2024-01-14', 'null', NULL, 'empty'),
(16, 'A3', '2024 Jan 14  03:01:12 AM', 1, 0, 900.00, '2024-01-14', 'null', NULL, 'empty'),
(17, 'A3', '2024 Jan 14  03:01:12 AM', 1, 0, 900.00, '2024-01-14', 'null', NULL, 'empty'),
(18, 'A3', '2024 Jan 14  03:01:12 AM', 1, 0, 900.00, '2024-01-14', 'null', NULL, 'empty'),
(19, 'A3', '2024 Jan 14  03:01:12 AM', 1, 1, 900.00, '2024-01-14', 'null', 'admin', 'empty'),
(20, '4R', '2024 Jan 14  03:09:35 AM', 1, 0, 250.00, '2024-01-14', 'admin', NULL, 'empty'),
(21, '4R', '2024 Jan 14  03:09:35 AM', 1, 0, 250.00, '2024-01-14', 'admin', NULL, 'empty'),
(22, '4R', '2024 Jan 14  03:09:35 AM', 1, 0, 250.00, '2024-01-14', 'admin', NULL, 'empty'),
(23, '4R', '2024 Jan 14  05:53:43 PM', 1, 0, 250.00, '2024-01-14', 'admin', NULL, 'empty'),
(24, '4R', '2024 Jan 14  05:53:43 PM', 1, 0, 250.00, '2024-01-14', 'admin', NULL, 'empty'),
(25, '4R', '2024 Jan 14  05:53:43 PM', 1, 0, 250.00, '2024-01-14', 'admin', NULL, 'empty'),
(26, 'A3', '2024 Jan 14  05:53:43 PM', 1, 0, 900.00, '2024-01-14', 'admin', NULL, 'empty'),
(27, 'A3', '2024 Jan 14  05:53:43 PM', 1, 0, 900.00, '2024-01-14', 'admin', NULL, 'empty'),
(28, 'A3', '2024 Jan 14  05:53:43 PM', 1, 0, 900.00, '2024-01-14', 'admin', NULL, 'empty'),
(29, 'A4', '2024 Jan 14  05:53:43 PM', 1, 0, 500.00, '2024-01-14', 'admin', NULL, 'empty'),
(30, 'A4', '2024 Jan 14  05:53:43 PM', 1, 0, 500.00, '2024-01-14', 'admin', NULL, 'empty'),
(31, 'A4', '2024 Jan 14  05:53:43 PM', 1, 2, 500.00, '2024-01-14', 'admin', 'admin', 'empty'),
(32, '4R', '2024 Jan 14  08:26:51 PM', 1, 0, 250.00, '2024-01-14', 'ishara', NULL, 'empty'),
(33, '4R', '2024 Jan 14  08:26:51 PM', 1, 0, 250.00, '2024-01-14', 'ishara', NULL, 'empty'),
(34, '4R', '2024 Jan 14  08:26:51 PM', 1, 0, 250.00, '2024-01-14', 'ishara', NULL, 'empty'),
(35, '4R', '2024 Jan 14  08:26:51 PM', 1, 0, 250.00, '2024-01-14', 'ishara', NULL, 'empty'),
(36, '4R', '2024 Jan 14  08:26:51 PM', 1, 0, 250.00, '2024-01-14', 'ishara', NULL, 'empty'),
(37, '4R', '2024 Jan 14  08:26:51 PM', 1, 0, 250.00, '2024-01-14', 'ishara', NULL, 'empty'),
(38, '4R', '2024 Jan 14  08:26:51 PM', 10, 0, 2500.00, '2024-01-14', 'ishara', 'ishara', 'empty'),
(39, '4R', '2024 Jan 14  08:27:11 PM', 10, 0, 2500.00, '2024-01-14', 'ishara', NULL, 'empty'),
(40, '4R', '2024 Jan 15  01:21:33 PM', 1, 0, 250.00, '2024-01-15', 'user', NULL, 'empty'),
(41, '4R', '2024 Jan 15  01:21:33 PM', 1, 0, 250.00, '2024-01-15', 'user', NULL, 'empty'),
(42, '4R', '2024 Jan 15  01:21:33 PM', 1, 0, 250.00, '2024-01-15', 'user', NULL, 'empty'),
(43, '4R', '2024 Jan 15  01:21:33 PM', 1, 0, 250.00, '2024-01-15', 'user', NULL, 'empty'),
(44, '4R', '2024 Jan 15  01:21:33 PM', 1, 0, 250.00, '2024-01-15', 'user', NULL, 'empty'),
(45, '4R', '2024 Jan 15  01:21:33 PM', 1, 0, 250.00, '2024-01-15', 'user', NULL, 'empty'),
(46, '4R', '2024 Jan 15  01:21:33 PM', 10, 0, 2500.00, '2024-01-15', 'user', NULL, 'empty'),
(47, '4R', '2024 Jan 15  01:21:33 PM', 10, 0, 2500.00, '2024-01-15', 'user', NULL, 'empty'),
(48, '4R', '2024 Jan 15  01:21:48 PM', 1, 0, 250.00, '2024-01-15', 'user', NULL, 'empty'),
(49, '4R', '2024 Jan 15  01:21:48 PM', 1, 0, 250.00, '2024-01-15', 'user', NULL, 'empty'),
(50, '4R', '2024 Jan 15  01:21:48 PM', 1, 0, 250.00, '2024-01-15', 'user', NULL, 'empty'),
(51, '4R', '2024 Jan 15  01:21:48 PM', 19, 0, 4750.00, '2024-01-15', 'user', NULL, 'empty'),
(52, '4R', '2024 Jan 15  01:21:48 PM', 1, 0, 250.00, '2024-01-15', 'user', NULL, 'empty'),
(53, 'A3', '2024 Jan 15  06:44:29 PM', 1, 0, 900.00, '2024-01-15', 'admin', NULL, 'empty'),
(54, 'A3', '2024 Jan 15  06:44:29 PM', 1, 0, 900.00, '2024-01-15', 'admin', NULL, 'empty'),
(55, 'A3', '2024 Jan 15  06:44:29 PM', 1, 0, 900.00, '2024-01-15', 'admin', NULL, 'empty'),
(56, 'A3', '2024 Jan 15  06:44:29 PM', 1, 0, 900.00, '2024-01-15', 'admin', NULL, 'empty'),
(57, 'A4', '2024 Jan 15  06:44:29 PM', 1, 0, 500.00, '2024-01-15', 'admin', NULL, 'empty'),
(58, 'A4', '2024 Jan 15  06:44:29 PM', 1, 0, 500.00, '2024-01-15', 'admin', NULL, 'empty'),
(59, 'A4', '2024 Jan 15  06:44:29 PM', 1, 0, 500.00, '2024-01-15', 'admin', NULL, 'empty'),
(60, 'A4', '2024 Jan 15  06:44:29 PM', 1, 0, 500.00, '2024-01-15', 'admin', NULL, 'empty'),
(61, '4R', '2024 Jan 15  06:44:29 PM', 1, 0, 250.00, '2024-01-15', 'admin', NULL, 'empty'),
(62, '4R', '2024 Jan 15  06:44:29 PM', 1, 0, 250.00, '2024-01-15', 'admin', NULL, 'empty'),
(63, '4R', '2024 Jan 15  06:44:29 PM', 1, 0, 250.00, '2024-01-15', 'admin', NULL, 'empty'),
(64, '4R', '2024 Jan 15  06:44:59 PM', 1, 0, 250.00, '2024-01-15', 'admin', 'admin', 'empty'),
(65, '4R', '2024 Jan 16  05:06:07 PM', 1, 0, 250.00, '2024-01-16', 'admin', NULL, 'empty'),
(66, '4R', '2024 Jan 16  05:06:07 PM', 1, 0, 250.00, '2024-01-16', 'admin', NULL, 'empty'),
(67, '4R', '2024 Jan 16  05:06:07 PM', 11, 0, 2750.00, '2024-01-16', 'admin', 'admin', 'empty'),
(68, '4R', '2024 Jan 16  05:14:10 PM', 1, 0, 250.00, '2024-01-16', 'madu', NULL, 'empty'),
(69, '4R', '2024 Jan 16  05:14:10 PM', 1, 0, 250.00, '2024-01-16', 'madu', NULL, 'empty'),
(70, '4R', '2024 Jan 16  05:14:10 PM', 1, 0, 250.00, '2024-01-16', 'madu', NULL, 'empty'),
(71, '4R', '2024 Jan 16  05:14:10 PM', 1, 0, 250.00, '2024-01-16', 'madu', NULL, 'empty');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`ct_id`),
  ADD UNIQUE KEY `ct_name` (`ct_name`),
  ADD UNIQUE KEY `ct_id` (`ct_id`);

--
-- Indexes for table `main_admin`
--
ALTER TABLE `main_admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`s_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `ct_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `main_admin`
--
ALTER TABLE `main_admin`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `sale`
--
ALTER TABLE `sale`
  MODIFY `s_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
