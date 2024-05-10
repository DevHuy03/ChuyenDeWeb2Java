-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2024 at 08:36 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `example09`
--

-- --------------------------------------------------------

--
-- Table structure for table `attributes`
--

CREATE TABLE `attributes` (
  `id` binary(16) NOT NULL,
  `attribute_name` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` binary(16) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `attribute_values`
--

CREATE TABLE `attribute_values` (
  `id` binary(16) NOT NULL,
  `attribute_id` binary(16) DEFAULT NULL,
  `attribute_value` varchar(255) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cards`
--

CREATE TABLE `cards` (
  `id` binary(16) NOT NULL,
  `customer_id` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `card_items`
--

CREATE TABLE `card_items` (
  `id` binary(16) NOT NULL,
  `card_id` binary(16) DEFAULT NULL,
  `product_id` binary(16) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` binary(16) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `category_description` text DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` binary(16) DEFAULT NULL,
  `icon` text DEFAULT NULL,
  `image` text DEFAULT NULL,
  `parent_id` binary(16) DEFAULT NULL,
  `placeholder` text DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `active`, `category_description`, `category_name`, `created_at`, `created_by`, `icon`, `image`, `parent_id`, `placeholder`, `updated_at`, `updated_by`) VALUES
(0x0383c429ce954b6e99a3eb0b4605ec2c, b'1', '', 'Sunscreem', '2024-04-16 14:26:15.000000', NULL, '', '', 0xf25f5ceb6b814dcc8419e2658d575c2c, '', NULL, NULL),
(0x03f69a4daffe400bbc892ba182727423, b'1', '', 'Shampoo', '2024-04-16 14:26:07.000000', NULL, '', '', 0xf25f5ceb6b814dcc8419e2658d575c2c, '', NULL, NULL),
(0x20a2d83ececa4514911844e1addc0705, b'1', 'Sports', 'Sports', '2024-04-16 14:22:40.000000', NULL, '', 'Sports', 0xa9de794a380a457da0370b4fea1ee9d6, 'Sports', NULL, NULL),
(0x2dc6276c82cf42d7b63d9dc023b11e3f, b'1', '', 'Mens Fashion', '2024-04-16 14:32:27.000000', NULL, '', '', 0xa903614aacd5484c83e6099f0c7d36c3, '', NULL, NULL),
(0x3075f814cb184af28d3eee6bbc144d02, b'1', '', 'Winter Wear', '2024-04-16 14:32:47.000000', NULL, '', '', 0xa903614aacd5484c83e6099f0c7d36c3, '', NULL, NULL),
(0x34c51f45489b4397898a492a84724273, b'1', '', 'Makeup Kit', '2024-04-16 14:26:46.000000', NULL, '', '', 0xf25f5ceb6b814dcc8419e2658d575c2c, '', NULL, NULL),
(0x4099cba8ca864b1b9ad028b7b762c016, b'1', '', 'Safety Shoes', '2024-04-16 14:23:22.000000', NULL, '', '', 0xa9de794a380a457da0370b4fea1ee9d6, '', NULL, NULL),
(0x4926407f58904cda9466102f34fe0525, b'1', 'Perfume', 'Perfume', '2024-04-16 14:18:11.000000', NULL, 'perfume.svg', 'Perfume', NULL, 'Perfume', NULL, NULL),
(0x5018c6c347e048db8babdda4788b352f, b'1', '', 'Shopping Bag', '2024-04-16 14:29:26.000000', NULL, '', '', 0xeeb216d448f14e06a800f45c25de46ca, '', NULL, NULL),
(0x54e777bb654b48fcbb0ebe8893aa8ba0, b'1', '', 'Necklace', '2024-04-16 14:24:24.000000', NULL, '', '', 0xa2bc21d0fd9841eeb8f393b3a0b30d09, '', NULL, NULL),
(0x6f3284a690b84f14810a33e8e675e4d3, b'1', '', 'Wallet', '2024-04-16 14:29:52.000000', NULL, '', '', 0xeeb216d448f14e06a800f45c25de46ca, '', NULL, NULL),
(0x74a51b96b565430f87c0c6e7935445e1, b'1', '', 'Gym Backpack', '2024-04-16 14:29:34.000000', NULL, '', '', 0xeeb216d448f14e06a800f45c25de46ca, '', NULL, NULL),
(0x76e874aafa024a318b24997f52b8d684, b'1', '', 'Clothes Perfume', '2024-04-16 14:24:56.000000', NULL, '', '', 0x4926407f58904cda9466102f34fe0525, '', NULL, NULL),
(0x7d167491d9b04cc39fef3ea2ad23666d, b'1', '', 'Formal', '2024-04-16 14:23:06.000000', NULL, '', '', 0xa9de794a380a457da0370b4fea1ee9d6, '', NULL, NULL),
(0x8793cb2fa12948cfb5962742bf6d5005, b'1', '', 'Lenses', '2024-04-16 14:28:29.000000', NULL, '', '', 0xcffac0eb690a4833894367807443a440, '', NULL, NULL),
(0x8ed24bafc69945738c239e468f4a2305, b'1', 'Shorts & Jeans', 'Shorts & Jeans', '2024-04-16 14:20:46.000000', NULL, '', 'Shorts & Jeans', 0xa903614aacd5484c83e6099f0c7d36c3, 'Shorts & Jeans', NULL, NULL),
(0x983548047d384562bd4d272c22dfdf32, b'1', '', 'Body Wash', '2024-04-16 14:26:28.000000', NULL, '', '', 0xf25f5ceb6b814dcc8419e2658d575c2c, '', NULL, NULL),
(0x98e93de3af1c4a9d9780d94e7185b490, b'1', '', 'Casual', '2024-04-16 14:23:14.000000', NULL, '', '', 0xa9de794a380a457da0370b4fea1ee9d6, '', NULL, NULL),
(0xa130fa27c48c45749ef8d52e1ad3cf1a, b'1', 'Jacket', 'Jacket', '2024-04-16 14:21:19.000000', NULL, '', 'Jacket', 0xa903614aacd5484c83e6099f0c7d36c3, 'Jacket', NULL, NULL),
(0xa2bc21d0fd9841eeb8f393b3a0b30d09, b'1', 'Jewelry', 'Jewelry', '2024-04-16 14:17:46.000000', NULL, 'jewelry.svg', 'Jewelry', NULL, 'Jewelry', NULL, NULL),
(0xa903614aacd5484c83e6099f0c7d36c3, b'1', 'Clothes', 'Clothes', '2024-04-16 14:16:56.000000', NULL, 'dress.svg', 'Clothes', NULL, 'Clothes', NULL, NULL),
(0xa9bba1d3af7a4b86ac10144acf325ced, b'1', '', 'Jacket', '2024-04-16 14:25:13.000000', NULL, '', '', 0x4926407f58904cda9466102f34fe0525, '', NULL, NULL),
(0xa9de794a380a457da0370b4fea1ee9d6, b'1', 'Footwear', 'Footwear', '2024-04-16 14:17:23.000000', NULL, 'shoes.svg', 'Footwear', NULL, 'Footwear', NULL, NULL),
(0xb9c8c750d0cf40879494562933c72235, b'1', 'Dress & Frock', 'Dress & Frock', '2024-04-16 14:21:31.000000', NULL, '', 'Dress & Frock', 0xa903614aacd5484c83e6099f0c7d36c3, 'Dress & Frock', NULL, NULL),
(0xbabd807448094c09b000d69b7ab5ae94, b'1', '', 'Couple Rings', '2024-04-16 14:24:16.000000', NULL, '', '', 0xa2bc21d0fd9841eeb8f393b3a0b30d09, '', NULL, NULL),
(0xbb9c8a350690444795d0638c43d1a69e, b'1', '', 'Belt', '2024-04-16 14:28:38.000000', NULL, '', '', 0xcffac0eb690a4833894367807443a440, '', NULL, NULL),
(0xbf02e14cecd344d5a9121904c4e8871a, b'1', '', 'Watches', '2024-04-16 14:28:46.000000', NULL, '', '', 0xcffac0eb690a4833894367807443a440, '', NULL, NULL),
(0xc1e63cec68a54370bc3e623ed1191ed6, b'1', 'Shirt', 'Shirt', '2024-04-16 14:20:28.000000', NULL, '', 'Shirt', 0xa903614aacd5484c83e6099f0c7d36c3, 'Shirt', NULL, NULL),
(0xcffac0eb690a4833894367807443a440, b'1', 'Glasses', 'Glasses', '2024-04-16 14:18:56.000000', NULL, 'glasses.svg', 'Glasses', NULL, 'Glasses', NULL, NULL),
(0xdf7d4597896e467d9c0b1869a5485e93, b'1', '', 'Deodorant', '2024-04-16 14:25:05.000000', NULL, '', '', 0x4926407f58904cda9466102f34fe0525, '', NULL, NULL),
(0xeeb216d448f14e06a800f45c25de46ca, b'1', 'Bags', 'Bags', '2024-04-16 14:19:14.000000', NULL, 'bag.svg', 'Bags', NULL, 'Bags', NULL, NULL),
(0xf1cd427965524fce80de8c93c7e06215, b'1', '', 'Earrings', '2024-04-16 14:24:03.000000', NULL, '', '', 0xa2bc21d0fd9841eeb8f393b3a0b30d09, '', NULL, NULL),
(0xf1d7621c279440ee8f9cdba64f3aa65a, b'1', '', 'Dress & Frock', '2024-04-16 14:25:23.000000', NULL, '', '', 0x4926407f58904cda9466102f34fe0525, '', NULL, NULL),
(0xf25f5ceb6b814dcc8419e2658d575c2c, b'1', 'Cosmetics', 'Cosmetics', '2024-04-16 14:18:33.000000', NULL, 'cosmetics.svg', 'Cosmetics', NULL, 'Cosmetics', NULL, NULL),
(0xf7bf1959923f4d3b841d5690debf702b, b'1', '', 'Sunglasses', '2024-04-16 14:28:21.000000', NULL, '', '', 0xcffac0eb690a4833894367807443a440, '', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `countries`
--

CREATE TABLE `countries` (
  `id` int(11) NOT NULL,
  `iso` varchar(255) NOT NULL,
  `iso3` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `num_code` int(11) DEFAULT NULL,
  `phone_code` int(11) NOT NULL,
  `upper_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `coupons`
--

CREATE TABLE `coupons` (
  `id` binary(16) NOT NULL,
  `code` varchar(255) NOT NULL,
  `coupon_end_date` datetime(6) NOT NULL,
  `coupon_start_date` datetime(6) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` binary(16) DEFAULT NULL,
  `discount_type` varchar(255) NOT NULL,
  `discount_value` decimal(10,0) NOT NULL,
  `max_usage` decimal(10,0) NOT NULL,
  `order_amount_limit` decimal(10,0) NOT NULL,
  `times_used` decimal(10,0) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` binary(16) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `email` text NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password_hash` text NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `resgister_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer_addresses`
--

CREATE TABLE `customer_addresses` (
  `id` binary(16) NOT NULL,
  `address_line1` text NOT NULL,
  `address_line2` text DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `customer_id` binary(16) NOT NULL,
  `dial_code` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `postal_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `galleries`
--

CREATE TABLE `galleries` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `image` text DEFAULT NULL,
  `is_thumbnail` bit(1) DEFAULT NULL,
  `placeholder` text DEFAULT NULL,
  `product_id` binary(16) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `galleries`
--

INSERT INTO `galleries` (`id`, `created_at`, `image`, `is_thumbnail`, `placeholder`, `product_id`, `updated_at`) VALUES
(0x0babe651fed3490bb56557007c45f9f8, '2024-04-16 23:09:45.000000', 'jacket-4.jpg', b'0', NULL, 0x28ce76796dd54df8952edb62604e5fe1, NULL),
(0x104b8a7c43d04ecbbe0e4eb10de012d4, '2024-04-17 00:58:55.000000', '4.jpg', b'0', NULL, 0x5a9654bdd49a42abac944b1ba7360028, NULL),
(0x18764815f48a49b084b4fd8ad98dc060, '2024-04-17 00:44:46.000000', 'clothes-2.jpg', b'0', NULL, 0x6e990539f6b844c9b4a9960785649cae, NULL),
(0x1bff73a54bf641ef8ad9599cd53c0429, '2024-04-17 00:53:31.000000', 'belt.jpg', b'0', NULL, 0xd9d3ea0952c644c8b2517373193ff4a8, NULL),
(0x206a6844428c49a4ad10db7cd1cd84a1, '2024-04-16 23:26:07.000000', 'watch-3.jpg', b'0', NULL, 0x8275477979a74457879d7ec1b19223f6, NULL),
(0x2bb1d7cba07148159fb710807d2a5531, '2024-04-17 00:55:33.000000', 'jewellery-3.jpg', b'0', NULL, 0xece2495e2a50454b84c2bb583a184d68, NULL),
(0x327768e7d52147689e0e2258c39345d2, '2024-04-16 23:16:33.000000', 'jacket-5.jpg', b'0', NULL, 0x62867712be4d485b93f32b4391485db9, NULL),
(0x387cae18cba6483d861b65f1e1d1c3e9, '2024-04-16 23:37:30.000000', 'jacket-1.jpg', b'0', NULL, 0xa44d4eb656214304a69107f952cb9b6a, NULL),
(0x3f7ae0b9251743e18c938d5cef577a33, '2024-04-17 00:47:51.000000', 'shoe-3.jpg', b'0', NULL, 0x3578479e0a024a8fbf680b08bed16bb2, NULL),
(0x3ff66af0afbf483b9e54e8b487c81161, '2024-04-16 23:37:34.000000', 'jacket-2.jpg', b'0', NULL, 0xa44d4eb656214304a69107f952cb9b6a, NULL),
(0x4968fbe5934846099379bfd53039fec3, '2024-04-17 00:44:00.000000', 'clothes-1.jpg', b'0', NULL, 0x411f1f9643c244e19a3233fd06847e56, NULL),
(0x49e1e511fc854d079f4a97b2d5afc505, '2024-04-16 23:10:42.000000', 'shirt-1.jpg', b'0', NULL, 0x458d1e4bf14b45619fe35a1f52859396, NULL),
(0x53280bbbc61b4abeb49c627465a20012, '2024-04-16 23:23:12.000000', 'shoe-2.jpg', b'0', NULL, 0x752c22d0923242f4b4f500683534fd8d, NULL),
(0x5b8e5e355a15400fb3903098f8fb59d1, '2024-04-16 23:45:19.000000', 'shoe-1.jpg', b'0', NULL, 0xd624545fc2384ae88dee53776737ca69, NULL),
(0x5c657e5a08c1437ba7afeb73def59caf, '2024-04-16 23:10:45.000000', 'shirt-1.jpg', b'0', NULL, 0x458d1e4bf14b45619fe35a1f52859396, NULL),
(0x5c96960d7b81472eba304452fb3d03ce, '2024-04-17 00:59:30.000000', '1.jpg', b'0', NULL, 0x844d7d219dde4e93b24aa2c3a08efc95, NULL),
(0x5ca816e961eb46ca8d1bd68be163590f, '2024-04-16 23:40:48.000000', 'sports-2.jpg', b'0', NULL, 0xaab9e50a680848469bc46124de136712, NULL),
(0x5d18391bd9de48c6ad33a92f04b27990, '2024-04-17 00:46:33.000000', 'sports-3.jpg', b'0', NULL, 0x24a64dbb1d964a98bdfdfa07a5d72157, NULL),
(0x5f1534384cd541d3a7a9c165655abe20, '2024-04-16 23:18:40.000000', 'clothes-3.jpg', b'0', NULL, 0x6ed88cbd23454d4a8a6d7e22d5885f12, NULL),
(0x72cce6722ba94ab7bd41e808d161d228, '2024-04-16 23:16:37.000000', 'jacket-6.jpg', b'0', NULL, 0x62867712be4d485b93f32b4391485db9, NULL),
(0x94da7d6d0e3b417bbd7c4a5253b7dd89, '2024-04-17 00:54:11.000000', 'perfume.jpg', b'0', NULL, 0xe028e6eb01c84331abc701c9b526c0a4, NULL),
(0x957b76960faf416c9dea5aed2a23cdba, '2024-04-17 00:54:50.000000', 'jewellery-1.jpg', b'0', NULL, 0xe6b3511381ea44b2b04bfc2179de4be0, NULL),
(0x966971e46fc7456ca575736e291d173e, '2024-04-16 23:47:25.000000', 'shorts-1.jpg', b'0', NULL, 0xfe49c5af59364718b6ef1bdee962b99f, NULL),
(0x98bd72f997dc4fc5a219881e2c7800af, '2024-04-16 23:18:46.000000', 'clothes-4.jpg', b'0', NULL, 0x6ed88cbd23454d4a8a6d7e22d5885f12, NULL),
(0x9a4419461e0343c586d0a285da7b17d6, '2024-04-16 23:28:11.000000', 'watch-1.jpg', b'0', NULL, 0x83683f7907ac4ade9b54132e39df240a, NULL),
(0x9b6eace33bfb4818a86c288d788d4c74, '2024-04-16 23:23:19.000000', 'shoe-2_1.jpg', b'0', NULL, 0x752c22d0923242f4b4f500683534fd8d, NULL),
(0x9f5a1c241f484256ae942c987bda3079, '2024-04-17 00:49:41.000000', 'sports-1.jpg', b'0', NULL, 0xbcaab1e43c334e5fae5f423b8f7d70ce, NULL),
(0x9f8242a4bafb459ebe2fb25552f12202, '2024-04-16 23:45:23.000000', 'shoe-1_1.jpg', b'0', NULL, 0xd624545fc2384ae88dee53776737ca69, NULL),
(0xab58c49a752541f49f7df3db04d9de80, '2024-04-16 23:09:41.000000', 'jacket-3.jpg', b'0', NULL, 0x28ce76796dd54df8952edb62604e5fe1, NULL),
(0xb3a9460a550c4481a0a8efe2741a7bf0, '2024-04-17 00:48:42.000000', 'sports-6.jpg', b'0', NULL, 0x7064b0a1673c43c084628b21065c833e, NULL),
(0xbb9bdd9cd1dd41f7991e4a7922836155, '2024-04-16 23:28:07.000000', 'watch-2.jpg', b'0', NULL, 0x83683f7907ac4ade9b54132e39df240a, NULL),
(0xcb7cd7ec17594ab1b2787132454c5212, '2024-04-16 23:26:03.000000', 'watch-4.jpg', b'0', NULL, 0x83683f7907ac4ade9b54132e39df240a, NULL),
(0xda0a4a2d4d0142d48a7df71ec03e5590, '2024-04-16 23:47:22.000000', 'shorts-2.jpg', b'0', NULL, 0xfe49c5af59364718b6ef1bdee962b99f, NULL),
(0xe46d819c2ad1417097ef2d5030152e24, '2024-04-16 23:40:45.000000', 'sports-4.jpg', b'0', NULL, 0xaab9e50a680848469bc46124de136712, NULL),
(0xeb7d5ca709074cbaaba924b7cbd7ffeb, '2024-04-16 23:35:26.000000', 'party-wear-1.jpg', b'0', NULL, 0x8644a91d9d354245920beb877ab11240, NULL),
(0xeb9ebf01e4f741a99661bc149546c056, '2024-04-17 01:00:55.000000', '3.jpg', b'0', NULL, 0x81211c5be9274ee1b277e50c370ace50, NULL),
(0xf0559c5e4193429c9d1e130f55c3fd54, '2024-04-17 00:52:00.000000', 'jewellery-2.jpg', b'0', NULL, 0x2286027a0d7c4fdbbb037a991e9c3ab8, NULL),
(0xf0e4d5d21a65421f9c886b8e1d9c602e, '2024-04-17 00:51:20.000000', 'shampoo.jpg', b'0', NULL, 0x10961277191a4b81ab71614547249038, NULL),
(0xf53f3eb55ca34e97a2c9098af2932c54, '2024-04-17 01:00:07.000000', '2.jpg', b'0', NULL, 0xd54cfb6268a64c3e84a70904bfd4a1cb, NULL),
(0xff395190defa4ee39a5598f286531359, '2024-04-16 23:35:31.000000', 'party-wear-2.jpg', b'0', NULL, 0x8644a91d9d354245920beb877ab11240, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE `notifications` (
  `id` binary(16) NOT NULL,
  `account_id` binary(16) NOT NULL,
  `content` text NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `notification_expiry_date` date DEFAULT NULL,
  `receive_time` datetime(6) DEFAULT NULL,
  `seen` bit(1) NOT NULL,
  `title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `coupon_id` binary(16) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `customer_id` binary(16) NOT NULL,
  `order_approved_at` datetime(6) DEFAULT NULL,
  `order_delivered_carrier_date` datetime(6) DEFAULT NULL,
  `order_delivered_customer_date` datetime(6) DEFAULT NULL,
  `order_status_id` binary(16) NOT NULL,
  `updated_by` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `id` binary(16) NOT NULL,
  `order_id` int(11) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `product_id` binary(16) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_statuses`
--

CREATE TABLE `order_statuses` (
  `id` binary(16) NOT NULL,
  `color` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `created_by` binary(16) NOT NULL,
  `privacy` varchar(255) NOT NULL,
  `status_name` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` binary(16) NOT NULL,
  `buying_price` decimal(10,0) DEFAULT NULL,
  `compare_price` decimal(10,0) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` binary(16) DEFAULT NULL,
  `disable_out_of_stock` tinyint(1) DEFAULT 1,
  `note` text DEFAULT NULL,
  `product_description` text DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `published` tinyint(1) DEFAULT 1,
  `quantity` int(11) DEFAULT NULL,
  `sale_percent` text DEFAULT NULL,
  `sale_price` decimal(10,0) DEFAULT NULL,
  `short_description` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `slug` text DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `buying_price`, `compare_price`, `created_at`, `created_by`, `disable_out_of_stock`, `note`, `product_description`, `product_name`, `product_type`, `published`, `quantity`, `sale_percent`, `sale_price`, `short_description`, `sku`, `slug`, `updated_at`, `updated_by`) VALUES
(0x10961277191a4b81ab71614547249038, '30', '0', '2024-04-15 21:28:01.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'shampoo conditioner packs', NULL, 0, 0, '', '20', NULL, '', 'string', NULL, NULL),
(0x2286027a0d7c4fdbbb037a991e9c3ab8, '65', '0', '2024-04-15 21:27:46.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Platinum Zircon Classic Ring', NULL, 0, 0, '', '62', NULL, '', 'string', NULL, NULL),
(0x24a64dbb1d964a98bdfdfa07a5d72157, '65', '0', '2024-04-15 21:25:53.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Sports Claw Women\'s Shoes', NULL, 0, 0, '', '54', NULL, '', 'string', NULL, NULL),
(0x28ce76796dd54df8952edb62604e5fe1, '75', '0', '2024-04-15 21:18:04.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Mens Winter Leathers Jackets', NULL, 0, 0, NULL, '48', NULL, 'MEN', 'Jacket', '2024-04-16 20:46:13.000000', NULL),
(0x3578479e0a024a8fbf680b08bed16bb2, '30', '0', '2024-04-15 21:26:29.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Boot With Suede Detail', NULL, 0, 0, '', '20', NULL, '', 'string', NULL, NULL),
(0x411f1f9643c244e19a3233fd06847e56, '45', '0', '2024-04-15 21:23:25.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Relaxed Short full Sleeve T-Shirt', NULL, 0, 0, '', '12', NULL, 'Relaxed Short full Sleeve T-Shirt', 'string', NULL, NULL),
(0x458d1e4bf14b45619fe35a1f52859396, '56', '0', '2024-04-15 21:19:29.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Pure Garment Dyed Cotton Shirt', NULL, 0, 0, NULL, '45', NULL, 'Pure Garment Dyed Cotton Shirt', 'shirt', '2024-04-16 23:20:45.000000', NULL),
(0x5a9654bdd49a42abac944b1ba7360028, '15', '0', '2024-04-15 21:29:06.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'woolen hat for men', NULL, 0, 0, '', '12', NULL, '', 'string', NULL, NULL),
(0x62867712be4d485b93f32b4391485db9, '45', '0', '2024-04-15 21:20:56.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'MEN Yarn Fleece Full-Zip Jacket', NULL, 0, 0, NULL, '32', NULL, 'MEN Yarn Fleece Full-Zip Jacket', 'jacket', '2024-04-16 23:15:47.000000', NULL),
(0x6e990539f6b844c9b4a9960785649cae, '61', '0', '2024-04-15 21:23:49.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Girls pnk Embro design Top', NULL, 0, 0, '', '19', NULL, 'Relaxed Short full Sleeve T-Shirt', 'string', NULL, NULL),
(0x6ed88cbd23454d4a8a6d7e22d5885f12, '64', '0', '2024-04-15 21:21:23.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Black Floral Wrap Midi Skirt', NULL, 0, 0, NULL, '58', NULL, 'black', 'skirt', '2024-04-16 23:18:16.000000', NULL),
(0x7064b0a1673c43c084628b21065c833e, '55', '0', '2024-04-15 21:26:13.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Air Trekking Shoes - white', NULL, 0, 0, '', '52', NULL, '', 'string', NULL, NULL),
(0x752c22d0923242f4b4f500683534fd8d, '105', '0', '2024-04-15 21:17:20.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Casual Men\'s Brown shoes', NULL, 0, 0, NULL, '99', NULL, 'Pure', 'Casual', '2024-04-16 23:33:17.000000', NULL),
(0x81211c5be9274ee1b277e50c370ace50, '5', '0', '2024-04-15 21:28:44.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'girls t-shirt', NULL, 0, 0, '', '3', NULL, '', 'string', NULL, NULL),
(0x8275477979a74457879d7ec1b19223f6, '170', '0', '2024-04-15 21:20:28.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Pocket Watch Leather Pouch', NULL, 0, 0, NULL, '150', NULL, 'Pocket Watch Leather Pouch', 'watch', '2024-04-17 01:19:22.000000', NULL),
(0x83683f7907ac4ade9b54132e39df240a, '120', '0', '2024-04-15 21:22:04.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Smart watche Vital Plus', NULL, 0, 0, NULL, '100', NULL, 'Smart watche Vital Plus', 'watches', '2024-04-16 23:39:13.000000', NULL),
(0x844d7d219dde4e93b24aa2c3a08efc95, '5', '0', '2024-04-15 21:22:51.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'baby fabric shoes', NULL, 0, 0, '', '4', NULL, 'baby fabric shoes', 'string', NULL, NULL),
(0x8644a91d9d354245920beb877ab11240, '30', '0', '2024-04-15 21:19:03.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Womens Party Wear Shoes', NULL, 0, 0, NULL, '25', NULL, 'Party', 'Womens', '2024-04-16 23:34:22.000000', NULL),
(0xa44d4eb656214304a69107f952cb9b6a, '45', '0', '2024-04-15 21:18:38.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Mens Winter Leathers Jackets', NULL, 0, 0, NULL, '32', NULL, 'jacket', 'jacket', '2024-04-16 23:37:08.000000', NULL),
(0xaab9e50a680848469bc46124de136712, '64', '0', '2024-04-15 21:19:53.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Trekking & Running Shoes - black', NULL, 0, 0, NULL, '58', NULL, 'sports Plus', 'sports', '2024-04-16 23:40:22.000000', NULL),
(0xac7f8ed1fc574fe4b4540db8fe2e9019, '68', '0', '2024-04-15 21:25:01.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Pure Garment Dyed Cotton Shirt', NULL, 0, 0, '', '31', NULL, '', 'string', NULL, NULL),
(0xb0da2962a6d846eeba7299caa7142fbb, '20', '0', '2024-04-15 21:25:17.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Better Basics French Terry Sweatshorts', NULL, 0, 0, '', '10', NULL, '', 'string', NULL, NULL),
(0xbcaab1e43c334e5fae5f423b8f7d70ce, '49', '0', '2024-04-15 21:25:34.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Running & Trekking Shoes - White', NULL, 0, 0, '', '15', NULL, '', 'string', NULL, NULL),
(0xd54cfb6268a64c3e84a70904bfd4a1cb, '17', '0', '2024-04-15 21:28:28.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'men\'s hoodies t-shirt', NULL, 0, 0, '', '7', NULL, '', 'string', NULL, NULL),
(0xd624545fc2384ae88dee53776737ca69, '65', '0', '2024-04-15 21:16:31.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Men\'s Leather Formal Wear shoes', NULL, 0, 0, NULL, '50', NULL, 'sports formal', 'formal', '2024-04-16 23:44:54.000000', NULL),
(0xd9d3ea0952c644c8b2517373193ff4a8, '24', '0', '2024-04-15 21:27:22.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Men\'s Leather Reversible Belt', NULL, 0, 0, '', '10', NULL, '', 'string', NULL, NULL),
(0xe028e6eb01c84331abc701c9b526c0a4, '42', '0', '2024-04-15 21:27:07.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Titan 100 Ml Womens Perfume', NULL, 0, 0, '', '10', NULL, '', 'string', NULL, NULL),
(0xe6b3511381ea44b2b04bfc2179de4be0, '30', '0', '2024-04-15 21:28:14.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Rose Gold Peacock Earrings', NULL, 0, 0, '', '20', NULL, '', 'string', NULL, NULL),
(0xece2495e2a50454b84c2bb583a184d68, '84', '0', '2024-04-15 21:26:49.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Silver Deer Heart Necklace', NULL, 0, 0, '', '30', NULL, '', 'string', NULL, NULL),
(0xfe49c5af59364718b6ef1bdee962b99f, '85', '0', '2024-04-15 21:22:27.000000', NULL, 0, NULL, 'Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor dolor sit amet consectetur Lorem ipsum dolor', 'Better Basics French Terry Sweatshorts', NULL, 0, 0, NULL, '78', NULL, 'shorts', 'shorts', '2024-04-16 23:46:55.000000', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `product_attributes`
--

CREATE TABLE `product_attributes` (
  `id` binary(16) NOT NULL,
  `attribute_id` binary(16) NOT NULL,
  `product_id` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_attribute_values`
--

CREATE TABLE `product_attribute_values` (
  `id` binary(16) NOT NULL,
  `attribute_value_id` binary(16) NOT NULL,
  `product_attribute_id` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_categories`
--

CREATE TABLE `product_categories` (
  `id` binary(16) NOT NULL,
  `category_id` binary(16) DEFAULT NULL,
  `product_id` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_categories`
--

INSERT INTO `product_categories` (`id`, `category_id`, `product_id`) VALUES
(0x087f00acc26d41ddb822618f8911478a, 0xa2bc21d0fd9841eeb8f393b3a0b30d09, 0xece2495e2a50454b84c2bb583a184d68),
(0x11823c9aa1b644a79840ef88fd7360e3, 0xa2bc21d0fd9841eeb8f393b3a0b30d09, 0xe6b3511381ea44b2b04bfc2179de4be0),
(0x1bef81153fd04eaf80a36b4e5f136339, 0x20a2d83ececa4514911844e1addc0705, 0x7064b0a1673c43c084628b21065c833e),
(0x1d571f71c2884fc581ed7fad033c5c6c, 0x20a2d83ececa4514911844e1addc0705, 0xbcaab1e43c334e5fae5f423b8f7d70ce),
(0x20aa64899f1147e0a2acc8d78c3a3e73, 0xa2bc21d0fd9841eeb8f393b3a0b30d09, 0x2286027a0d7c4fdbbb037a991e9c3ab8),
(0x2afef2e8a0a94692a7cdff1549202723, 0x98e93de3af1c4a9d9780d94e7185b490, 0x8644a91d9d354245920beb877ab11240),
(0x3e80f31a9d884b7082337759869bfc16, 0xa903614aacd5484c83e6099f0c7d36c3, 0x6e990539f6b844c9b4a9960785649cae),
(0x413034fd74f942cca74a57e90b08fb6e, 0xf25f5ceb6b814dcc8419e2658d575c2c, 0x10961277191a4b81ab71614547249038),
(0x488ca8d825684356a1f783b48643c01f, 0xa903614aacd5484c83e6099f0c7d36c3, 0x411f1f9643c244e19a3233fd06847e56),
(0x4cc1df7f650548789cae407569d8dbf7, 0x20a2d83ececa4514911844e1addc0705, 0x24a64dbb1d964a98bdfdfa07a5d72157),
(0x5188e0049aec4a228ca22c115969d179, 0x20a2d83ececa4514911844e1addc0705, 0x6ed88cbd23454d4a8a6d7e22d5885f12),
(0x54c285c0000f4ee4896bb9b086f40526, 0xa9bba1d3af7a4b86ac10144acf325ced, 0x28ce76796dd54df8952edb62604e5fe1),
(0x60a3bc732ef74844b8074ca773632594, 0x7d167491d9b04cc39fef3ea2ad23666d, 0x83683f7907ac4ade9b54132e39df240a),
(0x6b25fe3e7185490b9bbfa68e79dae9eb, 0x3075f814cb184af28d3eee6bbc144d02, 0x62867712be4d485b93f32b4391485db9),
(0x7915a7464f114359b5530d279e26f887, 0x2dc6276c82cf42d7b63d9dc023b11e3f, 0x752c22d0923242f4b4f500683534fd8d),
(0x79ac49a6766248d6993f021ec6618c23, 0xbf02e14cecd344d5a9121904c4e8871a, 0x458d1e4bf14b45619fe35a1f52859396),
(0x811815b63bf945229fd486ab0a807113, 0x8ed24bafc69945738c239e468f4a2305, 0xfe49c5af59364718b6ef1bdee962b99f),
(0x81205b58c8cd48d4ab7f9a8e92420acf, 0xbf02e14cecd344d5a9121904c4e8871a, 0xaab9e50a680848469bc46124de136712),
(0x8f81f1850a464dae864471f12566f33d, 0x4099cba8ca864b1b9ad028b7b762c016, 0x8275477979a74457879d7ec1b19223f6),
(0xb58b4d6a313947ae96278bff33def083, 0xa903614aacd5484c83e6099f0c7d36c3, 0xa44d4eb656214304a69107f952cb9b6a),
(0xc104394408f64504a7f32fae60e7a2d5, 0xbb9c8a350690444795d0638c43d1a69e, 0xd9d3ea0952c644c8b2517373193ff4a8),
(0xc3eaa4e601124390ab8de3788a678c9d, 0x98e93de3af1c4a9d9780d94e7185b490, 0x3578479e0a024a8fbf680b08bed16bb2),
(0xc424b5b4615942f0ac073baa11cd871a, 0xa130fa27c48c45749ef8d52e1ad3cf1a, 0xd624545fc2384ae88dee53776737ca69),
(0xdb8509a995c2424ab38e332b3f744503, 0x4926407f58904cda9466102f34fe0525, 0xe028e6eb01c84331abc701c9b526c0a4);

-- --------------------------------------------------------

--
-- Table structure for table `product_coupons`
--

CREATE TABLE `product_coupons` (
  `id` binary(16) NOT NULL,
  `coupon_id` binary(16) NOT NULL,
  `product_id` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_shipping_info`
--

CREATE TABLE `product_shipping_info` (
  `id` binary(16) NOT NULL,
  `dimension_depth` decimal(10,0) NOT NULL,
  `dimension_height` decimal(10,0) NOT NULL,
  `dimension_unit` varchar(255) NOT NULL,
  `dimension_width` decimal(10,0) NOT NULL,
  `product_id` binary(16) NOT NULL,
  `volume` decimal(10,0) NOT NULL,
  `volume_unit` varchar(255) NOT NULL,
  `weight` decimal(10,0) NOT NULL,
  `weight_unit` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_suppblier`
--

CREATE TABLE `product_suppblier` (
  `id` binary(16) NOT NULL,
  `product_id` binary(16) NOT NULL,
  `supplier_id` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_tags`
--

CREATE TABLE `product_tags` (
  `id` binary(16) NOT NULL,
  `product_id` binary(16) DEFAULT NULL,
  `tag_id` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_tags`
--

INSERT INTO `product_tags` (`id`, `product_id`, `tag_id`) VALUES
(0x09f43d4e6d6a4325bb136a40d45ca3a3, 0x8275477979a74457879d7ec1b19223f6, 0x0bd388ae1f7f4b31a236fb538f851067),
(0x0a573cc81d484ff9a50939fba5b9513a, 0x8644a91d9d354245920beb877ab11240, 0x38592f6f3a344703ad39fee7553e1f19),
(0x0ba0518498134576911192b1b8a2c83f, 0xe028e6eb01c84331abc701c9b526c0a4, 0x0bd388ae1f7f4b31a236fb538f851067),
(0x123c2ae85d6f45adb5877cdabd90fa42, 0xa44d4eb656214304a69107f952cb9b6a, 0x689fdc70986d48dc97982101024a1aa6),
(0x1966aa41a7b044a0929f7f11fbb63952, 0xd54cfb6268a64c3e84a70904bfd4a1cb, 0x5212070ef3db41aa8b70a131f29a4344),
(0x1a1b8174e1ce4ea2bee46efcbc27d9f0, 0x83683f7907ac4ade9b54132e39df240a, 0x38592f6f3a344703ad39fee7553e1f19),
(0x1c263b3cbf3942848dbe95bb84c92187, 0x24a64dbb1d964a98bdfdfa07a5d72157, 0x71edef19cd5044c6bc3e8bdb55e9e237),
(0x2036436972054d6e842f2e2e866936a2, 0x8644a91d9d354245920beb877ab11240, 0x71edef19cd5044c6bc3e8bdb55e9e237),
(0x22d19c389a914b12ad21e0bac571eca9, 0xfe49c5af59364718b6ef1bdee962b99f, 0x38592f6f3a344703ad39fee7553e1f19),
(0x2fa9b4829e0f48c9ac28a77d2b7a0056, 0x6ed88cbd23454d4a8a6d7e22d5885f12, 0x38592f6f3a344703ad39fee7553e1f19),
(0x35254ce38e654ff888cf90c36d402105, 0x752c22d0923242f4b4f500683534fd8d, 0x71edef19cd5044c6bc3e8bdb55e9e237),
(0x358f8bca347d442285da88f525845c8f, 0xa44d4eb656214304a69107f952cb9b6a, 0x38592f6f3a344703ad39fee7553e1f19),
(0x3d211f804f994e819daffc39df5a3e6a, 0xd9d3ea0952c644c8b2517373193ff4a8, 0x0bd388ae1f7f4b31a236fb538f851067),
(0x3df0b3c2b5d6468baa3baae6111abbeb, 0xaab9e50a680848469bc46124de136712, 0x71edef19cd5044c6bc3e8bdb55e9e237),
(0x48e588c0be784842aca2ba9f63ba6aa8, 0x6ed88cbd23454d4a8a6d7e22d5885f12, 0x689fdc70986d48dc97982101024a1aa6),
(0x4c00fac4cd66445c98180ce25dd32a39, 0x2286027a0d7c4fdbbb037a991e9c3ab8, 0x0bd388ae1f7f4b31a236fb538f851067),
(0x505007d9d8b94a16b86508530940acff, 0x28ce76796dd54df8952edb62604e5fe1, 0x689fdc70986d48dc97982101024a1aa6),
(0x5528e5620b674c50b75db6df0f5c6063, 0x81211c5be9274ee1b277e50c370ace50, 0x5212070ef3db41aa8b70a131f29a4344),
(0x57733c7b8efe4b8e9e0dc1d11f64be5a, 0x83683f7907ac4ade9b54132e39df240a, 0x0bd388ae1f7f4b31a236fb538f851067),
(0x5a1cfcc0fa2446278f9791f4854fb7ba, 0x28ce76796dd54df8952edb62604e5fe1, 0x38592f6f3a344703ad39fee7553e1f19),
(0x676c0215e18c40daa2502888e8bbc02d, 0x62867712be4d485b93f32b4391485db9, 0x38592f6f3a344703ad39fee7553e1f19),
(0x699599ca561d4e058ac328ff9e4bf023, 0x844d7d219dde4e93b24aa2c3a08efc95, 0x5212070ef3db41aa8b70a131f29a4344),
(0x8b53acd662bd49748d2673b67c5ad930, 0x752c22d0923242f4b4f500683534fd8d, 0x38592f6f3a344703ad39fee7553e1f19),
(0x92b2d7498ddc458f9c1efe0519f9bd04, 0x411f1f9643c244e19a3233fd06847e56, 0x689fdc70986d48dc97982101024a1aa6),
(0x92dec6db5e4c4a049497afd5e76e5335, 0x62867712be4d485b93f32b4391485db9, 0x689fdc70986d48dc97982101024a1aa6),
(0x9b42a7d7dbd94a839f6ad3a96a8e26a2, 0x458d1e4bf14b45619fe35a1f52859396, 0x689fdc70986d48dc97982101024a1aa6),
(0x9eb5602b882d49e6b021e5d101ce8a03, 0x8275477979a74457879d7ec1b19223f6, 0x38592f6f3a344703ad39fee7553e1f19),
(0xa2bff52839a645c8a67601f65fc5fbf9, 0xd624545fc2384ae88dee53776737ca69, 0x38592f6f3a344703ad39fee7553e1f19),
(0xac5f16556e544f4391bdf7ddd44ea416, 0xece2495e2a50454b84c2bb583a184d68, 0x0bd388ae1f7f4b31a236fb538f851067),
(0xb297b35d2c6643129d16c8951416d5ac, 0x7064b0a1673c43c084628b21065c833e, 0x71edef19cd5044c6bc3e8bdb55e9e237),
(0xb72826529c9c498798135ca8b2d1d852, 0x3578479e0a024a8fbf680b08bed16bb2, 0x71edef19cd5044c6bc3e8bdb55e9e237),
(0xbaa33b97ec314fbe8feb738ba5e3cc89, 0xe6b3511381ea44b2b04bfc2179de4be0, 0x0bd388ae1f7f4b31a236fb538f851067),
(0xbed6bb045ce340b6831c467bb0940222, 0x458d1e4bf14b45619fe35a1f52859396, 0x38592f6f3a344703ad39fee7553e1f19),
(0xbf5c06c0fff34a3883c1ab167f1c86b0, 0xaab9e50a680848469bc46124de136712, 0x38592f6f3a344703ad39fee7553e1f19),
(0xd939bb58b9414f128fa4eb71fed0d0fc, 0xfe49c5af59364718b6ef1bdee962b99f, 0x689fdc70986d48dc97982101024a1aa6),
(0xe5a4adc02276474aa2270a14b784a64e, 0xbcaab1e43c334e5fae5f423b8f7d70ce, 0x71edef19cd5044c6bc3e8bdb55e9e237),
(0xe84bbf1cba1d43d6ba7bd88a39be157c, 0x6e990539f6b844c9b4a9960785649cae, 0x689fdc70986d48dc97982101024a1aa6),
(0xea377cc4b3964dd3a2f0520695116f52, 0x10961277191a4b81ab71614547249038, 0x0bd388ae1f7f4b31a236fb538f851067),
(0xf9360269e96c43d6bb4b60aa1d780fb3, 0x5a9654bdd49a42abac944b1ba7360028, 0x5212070ef3db41aa8b70a131f29a4344),
(0xf94c309d57894691be2fb382d2ed8b75, 0xd624545fc2384ae88dee53776737ca69, 0x71edef19cd5044c6bc3e8bdb55e9e237);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `privileges` text NOT NULL,
  `role_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sells`
--

CREATE TABLE `sells` (
  `id` int(11) NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `product_id` binary(16) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `shipping_country_zores`
--

CREATE TABLE `shipping_country_zores` (
  `id` binary(16) NOT NULL,
  `country_id` int(11) NOT NULL,
  `shipping_zone_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `shipping_rates`
--

CREATE TABLE `shipping_rates` (
  `id` binary(16) NOT NULL,
  `max_value` double NOT NULL,
  `min_value` double NOT NULL,
  `no_max` tinyint(1) NOT NULL DEFAULT 1,
  `price` decimal(10,0) NOT NULL,
  `shipping_zone_id` int(11) NOT NULL,
  `weight_unit` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `shipping_zones`
--

CREATE TABLE `shipping_zones` (
  `id` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 0,
  `created_at` datetime(6) NOT NULL,
  `created_by` binary(16) DEFAULT NULL,
  `display_name` varchar(255) NOT NULL,
  `free_shipping` tinyint(1) NOT NULL DEFAULT 0,
  `name` varchar(255) NOT NULL,
  `rate_type` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `slideshows`
--

CREATE TABLE `slideshows` (
  `id` binary(16) NOT NULL,
  `btn_label` varchar(255) DEFAULT NULL,
  `clicks` int(11) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` binary(16) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `destination_url` text DEFAULT NULL,
  `display_order` int(11) NOT NULL,
  `image` text NOT NULL,
  `placeholder` text NOT NULL,
  `published` tinyint(1) DEFAULT 0,
  `styles` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `staff_accounts`
--

CREATE TABLE `staff_accounts` (
  `id` binary(16) NOT NULL,
  `active` bit(1) NOT NULL,
  `created_by` binary(16) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `image` text DEFAULT NULL,
  `last_name` varchar(100) NOT NULL,
  `password_hash` text NOT NULL,
  `phone_number` varchar(100) DEFAULT NULL,
  `placeholder` text DEFAULT NULL,
  `resgister_at` datetime(6) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `id` binary(16) NOT NULL,
  `address_line1` text NOT NULL,
  `address_line2` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `country_id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` binary(16) NOT NULL,
  `note` text NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `supplier_name` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tags`
--

CREATE TABLE `tags` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` binary(16) DEFAULT NULL,
  `icon` text DEFAULT NULL,
  `tag_name` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tags`
--

INSERT INTO `tags` (`id`, `created_at`, `created_by`, `icon`, `tag_name`, `updated_at`, `updated_by`) VALUES
(0x0bd388ae1f7f4b31a236fb538f851067, '2024-04-16 00:17:57.000000', NULL, 'string', 'Top Rated', NULL, NULL),
(0x17c6a4ad112f43818e113d8e35b29016, '2024-04-16 00:18:27.000000', NULL, 'string', 'Deal of the day', NULL, NULL),
(0x38592f6f3a344703ad39fee7553e1f19, '2024-04-16 00:18:12.000000', NULL, 'string', 'New Products', NULL, NULL),
(0x5212070ef3db41aa8b70a131f29a4344, '2024-04-16 00:18:05.000000', NULL, 'string', 'BEST SELLERS', NULL, NULL),
(0x68007c35f49c48d782f13f1b7a40bf8c, '2024-04-16 00:18:19.000000', NULL, 'string', 'BEST SELLERS', NULL, NULL),
(0x689fdc70986d48dc97982101024a1aa6, '2024-04-16 00:17:33.000000', NULL, 'new_arrivals', 'New Arrivals', NULL, NULL),
(0x71edef19cd5044c6bc3e8bdb55e9e237, '2024-04-16 00:17:51.000000', NULL, 'string', 'Trending', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `variants`
--

CREATE TABLE `variants` (
  `id` binary(16) NOT NULL,
  `product_id` binary(16) NOT NULL,
  `vailant_option` text NOT NULL,
  `variant_option_id` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `variant_options`
--

CREATE TABLE `variant_options` (
  `id` binary(16) NOT NULL,
  `active` tinyint(1) DEFAULT 1,
  `buying_price` decimal(10,0) DEFAULT NULL,
  `compare_price` decimal(10,0) DEFAULT NULL,
  `image_id` binary(16) NOT NULL,
  `product_id` binary(16) NOT NULL,
  `quantity` int(11) NOT NULL,
  `sale_price` decimal(10,0) DEFAULT NULL,
  `sku` varchar(255) NOT NULL,
  `title` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `variant_values`
--

CREATE TABLE `variant_values` (
  `id` binary(16) NOT NULL,
  `product_attribute_value_id` binary(16) NOT NULL,
  `variant_id` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attributes`
--
ALTER TABLE `attributes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkagsu8uri85emo6x7lxpsvs9p` (`created_by`),
  ADD KEY `FKtgiw6t3448ahf7moes0v5jgsk` (`updated_by`);

--
-- Indexes for table `attribute_values`
--
ALTER TABLE `attribute_values`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkaq0fvnivyrmqu857uy04xgmm` (`attribute_id`);

--
-- Indexes for table `cards`
--
ALTER TABLE `cards`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3ta7cnyyuv26sr3j2sxrr10bu` (`customer_id`);

--
-- Indexes for table `card_items`
--
ALTER TABLE `card_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5b0jbnfrpxa14s6p8pj4pr4p0` (`card_id`),
  ADD KEY `FKkdemwak5rm871ftwoc81834c9` (`product_id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsaok720gsu4u2wrgbk10b5n8d` (`parent_id`),
  ADD KEY `FKq8tdmuivklnln9qfhbd5t4h2i` (`created_by`),
  ADD KEY `FK575exl9wfoqsbed5al2srh6jn` (`updated_by`);

--
-- Indexes for table `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `coupons`
--
ALTER TABLE `coupons`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer_addresses`
--
ALTER TABLE `customer_addresses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrvr6wl9gll7u98cda18smugp4` (`customer_id`);

--
-- Indexes for table `galleries`
--
ALTER TABLE `galleries`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn4fllmf69rio4pq2q5k4xfc9l` (`product_id`);

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5dsqjxt1wpoa8icawskqijsec` (`account_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn1d1gkxckw648m2n2d5gx0yx5` (`coupon_id`),
  ADD KEY `FKpxtb8awmi0dk6smoh2vp1litg` (`customer_id`),
  ADD KEY `FKcbbqf26brulgfgvd0mf74rv4y` (`order_status_id`),
  ADD KEY `FKgclp4rs5m20onj4kjrs0kesx6` (`updated_by`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbioxgbv59vetrxe0ejfubep1w` (`order_id`),
  ADD KEY `FKocimc7dtr037rh4ls4l95nlfi` (`product_id`);

--
-- Indexes for table `order_statuses`
--
ALTER TABLE `order_statuses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe4b4y3muy8mopmamipe97nt5j` (`created_by`),
  ADD KEY `FKcg14f8n04d5xkfkpgnglots4n` (`updated_by`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKih40jfhwkc7lk0fhwlle8ev87` (`created_by`),
  ADD KEY `FK4smi13wyfknqmqchj8ivr6wxb` (`updated_by`);

--
-- Indexes for table `product_attributes`
--
ALTER TABLE `product_attributes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6ksuorb5567jpa08ihcumumy1` (`attribute_id`),
  ADD KEY `FKcex46yvx4g18b2pn09p79h1mc` (`product_id`);

--
-- Indexes for table `product_attribute_values`
--
ALTER TABLE `product_attribute_values`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcq2cdqxc2xn8a8ijv4ess9ifk` (`attribute_value_id`),
  ADD KEY `FKtcpenh8197oeo6a75jtbikim0` (`product_attribute_id`);

--
-- Indexes for table `product_categories`
--
ALTER TABLE `product_categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKd112rx0alycddsms029iifrih` (`category_id`),
  ADD KEY `FKlda9rad6s180ha3dl1ncsp8n7` (`product_id`);

--
-- Indexes for table `product_coupons`
--
ALTER TABLE `product_coupons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm8d6v5e6fv8mjg3d0iifq6sw1` (`coupon_id`),
  ADD KEY `FKiaiu1xxcnyw38cbcx4j80psij` (`product_id`);

--
-- Indexes for table `product_shipping_info`
--
ALTER TABLE `product_shipping_info`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2661qi678nh0prih01pbo2or0` (`product_id`);

--
-- Indexes for table `product_suppblier`
--
ALTER TABLE `product_suppblier`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpkq28lei520730ampm98hjwgo` (`product_id`),
  ADD KEY `FKgv0sd3sydpxiramnb1sqv2yso` (`supplier_id`);

--
-- Indexes for table `product_tags`
--
ALTER TABLE `product_tags`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5rk6s19k3risy7q7wqdr41uss` (`product_id`),
  ADD KEY `FKpur2885qb9ae6fiquu77tcv1o` (`tag_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sells`
--
ALTER TABLE `sells`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4u17xl8ugefnahmg6xa23du0b` (`product_id`);

--
-- Indexes for table `shipping_country_zores`
--
ALTER TABLE `shipping_country_zores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKo73dc4icujj3wktrxodmi0ns3` (`country_id`),
  ADD KEY `FK5rs2ct7exq5gdm0bhnbfxiipe` (`shipping_zone_id`);

--
-- Indexes for table `shipping_rates`
--
ALTER TABLE `shipping_rates`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgh1qqt17uy7boc8f8dgyaenal` (`shipping_zone_id`);

--
-- Indexes for table `shipping_zones`
--
ALTER TABLE `shipping_zones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsryt5m2wxlmvqomukka58bakt` (`created_by`),
  ADD KEY `FKj9e73dbvm96clp0qrubh90sj1` (`updated_by`);

--
-- Indexes for table `slideshows`
--
ALTER TABLE `slideshows`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm4f4t2ur1uu0e24jklw6b7c9j` (`created_by`),
  ADD KEY `FKklo16kmuxbd5jsvv7e4r21p81` (`updated_by`);

--
-- Indexes for table `staff_accounts`
--
ALTER TABLE `staff_accounts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKicmmixb56mmd16stkenpifr2q` (`role_id`),
  ADD KEY `FK2w05mq0lpmivr2519iuiowve3` (`created_by`),
  ADD KEY `FK8kt1rbp9uqo3us42qekqu2bwx` (`updated_by`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfiw13lay8hy782gbnxojca2b8` (`created_by`),
  ADD KEY `FKf018rv4htmcbcn4wjrpymxbme` (`updated_by`);

--
-- Indexes for table `tags`
--
ALTER TABLE `tags`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj4ujfjyqtl6j6ltrh16llax9a` (`created_by`),
  ADD KEY `FKbfktnbyp9l27sc3ys66hc92hc` (`updated_by`);

--
-- Indexes for table `variants`
--
ALTER TABLE `variants`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK95bued017vcya4rf4s7n31ew4` (`product_id`),
  ADD KEY `FKkbk89y0ekurxw90mx7jt3hx3q` (`variant_option_id`);

--
-- Indexes for table `variant_options`
--
ALTER TABLE `variant_options`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqf4y59exjrgjqdl359joj02nv` (`image_id`),
  ADD KEY `FKp80xsi8rl51rtft29wsia24hq` (`product_id`);

--
-- Indexes for table `variant_values`
--
ALTER TABLE `variant_values`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7ypqk6dc1kdhdcwphasb0q360` (`product_attribute_value_id`),
  ADD KEY `FKqhr8f6gw7fykcrd2ijd80o5te` (`variant_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `countries`
--
ALTER TABLE `countries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sells`
--
ALTER TABLE `sells`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `shipping_zones`
--
ALTER TABLE `shipping_zones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attributes`
--
ALTER TABLE `attributes`
  ADD CONSTRAINT `FKkagsu8uri85emo6x7lxpsvs9p` FOREIGN KEY (`created_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FKtgiw6t3448ahf7moes0v5jgsk` FOREIGN KEY (`updated_by`) REFERENCES `staff_accounts` (`id`);

--
-- Constraints for table `attribute_values`
--
ALTER TABLE `attribute_values`
  ADD CONSTRAINT `FKkaq0fvnivyrmqu857uy04xgmm` FOREIGN KEY (`attribute_id`) REFERENCES `attributes` (`id`);

--
-- Constraints for table `cards`
--
ALTER TABLE `cards`
  ADD CONSTRAINT `FK3ta7cnyyuv26sr3j2sxrr10bu` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`);

--
-- Constraints for table `card_items`
--
ALTER TABLE `card_items`
  ADD CONSTRAINT `FK5b0jbnfrpxa14s6p8pj4pr4p0` FOREIGN KEY (`card_id`) REFERENCES `cards` (`id`),
  ADD CONSTRAINT `FKkdemwak5rm871ftwoc81834c9` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `categories`
--
ALTER TABLE `categories`
  ADD CONSTRAINT `FK575exl9wfoqsbed5al2srh6jn` FOREIGN KEY (`updated_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FKq8tdmuivklnln9qfhbd5t4h2i` FOREIGN KEY (`created_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FKsaok720gsu4u2wrgbk10b5n8d` FOREIGN KEY (`parent_id`) REFERENCES `categories` (`id`);

--
-- Constraints for table `customer_addresses`
--
ALTER TABLE `customer_addresses`
  ADD CONSTRAINT `FKrvr6wl9gll7u98cda18smugp4` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`);

--
-- Constraints for table `galleries`
--
ALTER TABLE `galleries`
  ADD CONSTRAINT `FKn4fllmf69rio4pq2q5k4xfc9l` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `FK5dsqjxt1wpoa8icawskqijsec` FOREIGN KEY (`account_id`) REFERENCES `staff_accounts` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKcbbqf26brulgfgvd0mf74rv4y` FOREIGN KEY (`order_status_id`) REFERENCES `order_statuses` (`id`),
  ADD CONSTRAINT `FKgclp4rs5m20onj4kjrs0kesx6` FOREIGN KEY (`updated_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FKn1d1gkxckw648m2n2d5gx0yx5` FOREIGN KEY (`coupon_id`) REFERENCES `coupons` (`id`),
  ADD CONSTRAINT `FKpxtb8awmi0dk6smoh2vp1litg` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`);

--
-- Constraints for table `order_items`
--
ALTER TABLE `order_items`
  ADD CONSTRAINT `FKbioxgbv59vetrxe0ejfubep1w` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `FKocimc7dtr037rh4ls4l95nlfi` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `order_statuses`
--
ALTER TABLE `order_statuses`
  ADD CONSTRAINT `FKcg14f8n04d5xkfkpgnglots4n` FOREIGN KEY (`updated_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FKe4b4y3muy8mopmamipe97nt5j` FOREIGN KEY (`created_by`) REFERENCES `staff_accounts` (`id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FK4smi13wyfknqmqchj8ivr6wxb` FOREIGN KEY (`updated_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FKih40jfhwkc7lk0fhwlle8ev87` FOREIGN KEY (`created_by`) REFERENCES `staff_accounts` (`id`);

--
-- Constraints for table `product_attributes`
--
ALTER TABLE `product_attributes`
  ADD CONSTRAINT `FK6ksuorb5567jpa08ihcumumy1` FOREIGN KEY (`attribute_id`) REFERENCES `attributes` (`id`),
  ADD CONSTRAINT `FKcex46yvx4g18b2pn09p79h1mc` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `product_attribute_values`
--
ALTER TABLE `product_attribute_values`
  ADD CONSTRAINT `FKcq2cdqxc2xn8a8ijv4ess9ifk` FOREIGN KEY (`attribute_value_id`) REFERENCES `attribute_values` (`id`),
  ADD CONSTRAINT `FKtcpenh8197oeo6a75jtbikim0` FOREIGN KEY (`product_attribute_id`) REFERENCES `product_attributes` (`id`);

--
-- Constraints for table `product_categories`
--
ALTER TABLE `product_categories`
  ADD CONSTRAINT `FKd112rx0alycddsms029iifrih` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `FKlda9rad6s180ha3dl1ncsp8n7` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `product_coupons`
--
ALTER TABLE `product_coupons`
  ADD CONSTRAINT `FKiaiu1xxcnyw38cbcx4j80psij` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKm8d6v5e6fv8mjg3d0iifq6sw1` FOREIGN KEY (`coupon_id`) REFERENCES `coupons` (`id`);

--
-- Constraints for table `product_shipping_info`
--
ALTER TABLE `product_shipping_info`
  ADD CONSTRAINT `FK2661qi678nh0prih01pbo2or0` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `product_suppblier`
--
ALTER TABLE `product_suppblier`
  ADD CONSTRAINT `FKgv0sd3sydpxiramnb1sqv2yso` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`),
  ADD CONSTRAINT `FKpkq28lei520730ampm98hjwgo` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `product_tags`
--
ALTER TABLE `product_tags`
  ADD CONSTRAINT `FK5rk6s19k3risy7q7wqdr41uss` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKpur2885qb9ae6fiquu77tcv1o` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`);

--
-- Constraints for table `sells`
--
ALTER TABLE `sells`
  ADD CONSTRAINT `FK4u17xl8ugefnahmg6xa23du0b` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `shipping_country_zores`
--
ALTER TABLE `shipping_country_zores`
  ADD CONSTRAINT `FK5rs2ct7exq5gdm0bhnbfxiipe` FOREIGN KEY (`shipping_zone_id`) REFERENCES `shipping_zones` (`id`),
  ADD CONSTRAINT `FKo73dc4icujj3wktrxodmi0ns3` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);

--
-- Constraints for table `shipping_rates`
--
ALTER TABLE `shipping_rates`
  ADD CONSTRAINT `FKgh1qqt17uy7boc8f8dgyaenal` FOREIGN KEY (`shipping_zone_id`) REFERENCES `shipping_zones` (`id`);

--
-- Constraints for table `shipping_zones`
--
ALTER TABLE `shipping_zones`
  ADD CONSTRAINT `FKj9e73dbvm96clp0qrubh90sj1` FOREIGN KEY (`updated_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FKsryt5m2wxlmvqomukka58bakt` FOREIGN KEY (`created_by`) REFERENCES `staff_accounts` (`id`);

--
-- Constraints for table `slideshows`
--
ALTER TABLE `slideshows`
  ADD CONSTRAINT `FKklo16kmuxbd5jsvv7e4r21p81` FOREIGN KEY (`updated_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FKm4f4t2ur1uu0e24jklw6b7c9j` FOREIGN KEY (`created_by`) REFERENCES `staff_accounts` (`id`);

--
-- Constraints for table `staff_accounts`
--
ALTER TABLE `staff_accounts`
  ADD CONSTRAINT `FK2w05mq0lpmivr2519iuiowve3` FOREIGN KEY (`created_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FK8kt1rbp9uqo3us42qekqu2bwx` FOREIGN KEY (`updated_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FKicmmixb56mmd16stkenpifr2q` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

--
-- Constraints for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD CONSTRAINT `FKf018rv4htmcbcn4wjrpymxbme` FOREIGN KEY (`updated_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FKfiw13lay8hy782gbnxojca2b8` FOREIGN KEY (`created_by`) REFERENCES `staff_accounts` (`id`);

--
-- Constraints for table `tags`
--
ALTER TABLE `tags`
  ADD CONSTRAINT `FKbfktnbyp9l27sc3ys66hc92hc` FOREIGN KEY (`updated_by`) REFERENCES `staff_accounts` (`id`),
  ADD CONSTRAINT `FKj4ujfjyqtl6j6ltrh16llax9a` FOREIGN KEY (`created_by`) REFERENCES `staff_accounts` (`id`);

--
-- Constraints for table `variants`
--
ALTER TABLE `variants`
  ADD CONSTRAINT `FK95bued017vcya4rf4s7n31ew4` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKkbk89y0ekurxw90mx7jt3hx3q` FOREIGN KEY (`variant_option_id`) REFERENCES `variant_options` (`id`);

--
-- Constraints for table `variant_options`
--
ALTER TABLE `variant_options`
  ADD CONSTRAINT `FKp80xsi8rl51rtft29wsia24hq` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKqf4y59exjrgjqdl359joj02nv` FOREIGN KEY (`image_id`) REFERENCES `galleries` (`id`);

--
-- Constraints for table `variant_values`
--
ALTER TABLE `variant_values`
  ADD CONSTRAINT `FK7ypqk6dc1kdhdcwphasb0q360` FOREIGN KEY (`product_attribute_value_id`) REFERENCES `product_attribute_values` (`id`),
  ADD CONSTRAINT `FKqhr8f6gw7fykcrd2ijd80o5te` FOREIGN KEY (`variant_id`) REFERENCES `variants` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
