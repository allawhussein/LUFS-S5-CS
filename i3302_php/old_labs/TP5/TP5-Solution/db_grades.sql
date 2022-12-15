-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 11, 2018 at 07:39 PM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_grades`
--

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
CREATE TABLE IF NOT EXISTS `exam` (
  `idexam` int(6) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf16_bin NOT NULL,
  `grade_on` int(3) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`idexam`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`idexam`, `description`, `grade_on`, `date`) VALUES
(1, 'Midterm', 22, '2018-12-05'),
(2, 'final', 53, '2018-12-06'),
(3, 'tp', 25, '2018-12-07');

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
CREATE TABLE IF NOT EXISTS `grades` (
  `idgrade` int(6) NOT NULL AUTO_INCREMENT,
  `iduser` int(6) NOT NULL,
  `idexam` int(6) NOT NULL,
  `grade` int(3) DEFAULT NULL,
  PRIMARY KEY (`idgrade`),
  KEY `I1` (`iduser`),
  KEY `I2` (`idexam`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`idgrade`, `iduser`, `idexam`, `grade`) VALUES
(1, 1, 1, 12),
(2, 1, 2, 34),
(3, 1, 3, 13),
(4, 2, 1, 9),
(5, 2, 2, 40),
(6, 2, 3, 12);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `iduser` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf16_bin NOT NULL,
  `pass` varchar(45) COLLATE utf16_bin NOT NULL DEFAULT '123456',
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`iduser`, `name`, `pass`) VALUES
(1, 'Shirihan', '123456'),
(2, 'Adel Imam', '123456'),
(3, 'Bassem Youssef', '123456'),
(4, 'Lady Gaga', '123456'),
(5, 'Ziad Rahbani', '123456'),
(6, 'Abou Adal', '123456');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `grades`
--
ALTER TABLE `grades`
  ADD CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `users` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `grades_ibfk_2` FOREIGN KEY (`idexam`) REFERENCES `exam` (`idexam`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
