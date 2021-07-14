-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th7 14, 2021 lúc 03:33 AM
-- Phiên bản máy phục vụ: 5.7.31
-- Phiên bản PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `fertilizerweb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `specifications` int(11) NOT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `discount` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `cart`
--

INSERT INTO `cart` (`id`, `phone`, `name`, `specifications`, `pic`, `price`, `amount`, `discount`) VALUES
(56, '098765432', 'Phân NPK Yuroka 16.16.16 (BM)', 50, '1.jpg', 750000, 50, 0.3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nameuser` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `nameproduct` varchar(225) COLLATE utf8_vietnamese_ci NOT NULL,
  `priceproduct` float NOT NULL,
  `amount` int(11) NOT NULL,
  `total` float NOT NULL,
  `day` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id`, `nameuser`, `phone`, `nameproduct`, `priceproduct`, `amount`, `total`, `day`) VALUES
(19, 'test 21', '012345', 'Harry Potter', 123000, 100, 253000, '2021-07-11'),
(20, 'test 21', '012345', 'Nha Lanh Dao Khong Chuc Danh', 130000, 100, 253000, '2021-07-11'),
(21, 'test 21', '012345', 'Harry Potter', 123000, 100, 253000, '2021-07-11'),
(22, 'test 21', '012345', 'Nha Lanh Dao Khong Chuc Danh', 130000, 100, 253000, '2021-07-11'),
(23, 'test 21', '012345', 'Harry Potter', 123000, 100, 253000, '2021-07-11'),
(24, 'test 21', '012345', 'Nha Lanh Dao Khong Chuc Danh', 130000, 100, 253000, '2021-07-11');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `specifications` int(11) DEFAULT NULL,
  `price` float NOT NULL,
  `pic` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `discount` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `name`, `specifications`, `price`, `pic`, `discount`) VALUES
(1, 'Phân NPK Yuroka 16.16.16 (BM)', 50, 750000, '1.jpg', 0.3),
(2, 'NPK JVF tím 16-6-18+12S+TE', 50, 600000, '2.jpg', 0.1),
(3, 'URÊ - Đạm Phú Mỹ', 50, 750000, '3.jpg', 0.3),
(4, 'Phân Bón NPK Spectrum Đức BM 20-20-15+TE', 50, 700000, '4.jpg', 0),
(5, 'NPK Đầu Trâu xanh 16-8-16-6S+TE', 50, 550000, '5.jpg', 0),
(6, 'NPK Đầu Trâu vàng 17-7-14-10S+TE', 50, 520000, '6.jpg', 0.2),
(7, 'Haifa Multi-K GG - KNO3 - Phân Bón Cao Cấp Chuyên Dùng Tưới Nhỏ Giọt', 25, 820000, '7.jpg', 0),
(8, 'Haifa Multi-K GG - KNO3 - Phân Bón Cao Cấp Chuyên Dùng Tưới Nhỏ Giọt', 1, 65000, '8.jpg', 0),
(9, 'Phân Bón Cao Cấp Yara Mila Winner', 25, 460000, '9.jpg', 0),
(10, 'Phân Bón Cao Cấp Yara Mila Winner', 1, 65000, '10.jpg', 0),
(78, 'URÊ - Đạm Phú Mỹ', 50, 750000, '3.jpg', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `phone` varchar(11) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `money` double DEFAULT NULL,
  `endow` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `phone`, `money`, `endow`) VALUES
(1, 'admin', '111', '01234557577', 0, 0),
(2, 'Nguyen Van A', '111', '0969435542', 0, 0.2),
(3, 'Le Duc Thanh', '121', '0333252212', 0, 0),
(4, 'thanhson', '123', '098765432', 1000000, 0.3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
