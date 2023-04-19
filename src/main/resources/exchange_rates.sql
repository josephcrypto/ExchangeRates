-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: exchange_rate_db
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer_db`
--

DROP TABLE IF EXISTS `customer_db`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_db` (
  `cid` bigint NOT NULL AUTO_INCREMENT,
  `account_transfer` varchar(255) DEFAULT NULL,
  `cash_in` varchar(255) DEFAULT NULL,
  `cash_out` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `deposit` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `exchange_amount` double DEFAULT NULL,
  `kbz_pay` varchar(255) DEFAULT NULL,
  `loan` varchar(255) DEFAULT NULL,
  `mobile_banking` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `top_up` varchar(255) DEFAULT NULL,
  `visa_card` varchar(255) DEFAULT NULL,
  `wave_money` varchar(255) DEFAULT NULL,
  `withdraw` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_db`
--

LOCK TABLES `customer_db` WRITE;
/*!40000 ALTER TABLE `customer_db` DISABLE KEYS */;
INSERT INTO `customer_db` VALUES (1,'','','124795','Michael Sara','2023-04-17','','',1510,'','','','09423561795',0.01,'','','',''),(2,'','','204780','Joseph','2023-04-16','','',2450,'','','','09428316117',0.01,'','','',''),(3,'','','209054','Joseph Crypto','2023-04-18','','',2540,'','','','09428316117',0.01,'','','',''),(4,'','','','Michael','2023-04-18','','',358000,'4297','','','0931547887',0.01,'','','',''),(5,'','','','Smith','2023-04-18','','',5600,'466667','','','0945689746',0.01,'','','','');
/*!40000 ALTER TABLE `customer_db` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exchange_rates`
--

DROP TABLE IF EXISTS `exchange_rates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exchange_rates` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `currency_from` varchar(255) DEFAULT NULL,
  `currency_to` varchar(255) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `date_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exchange_rates`
--

LOCK TABLES `exchange_rates` WRITE;
/*!40000 ALTER TABLE `exchange_rates` DISABLE KEYS */;
INSERT INTO `exchange_rates` VALUES (1,'THB','MMK',0.01215,'2023-04-18'),(2,'MMK','THB',0.0121,'2023-04-17'),(3,'YUAN','THB',2.35,'2023-04-13');
/*!40000 ALTER TABLE `exchange_rates` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-19  9:38:56
