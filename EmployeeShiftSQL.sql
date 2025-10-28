CREATE DATABASE  IF NOT EXISTS `p01` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `p01`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: p01
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `clock_date`
--

DROP TABLE IF EXISTS `clock_date`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clock_date` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(255) NOT NULL,
  `work_date` date NOT NULL,
  `clock_on` time NOT NULL,
  `clock_off` time DEFAULT NULL,
  `total_hour` double DEFAULT '0',
  `has_double` bit(1) DEFAULT b'0',
  `score` int NOT NULL DEFAULT '0',
  `rest_start` time DEFAULT NULL,
  `rest_end` time DEFAULT NULL,
  PRIMARY KEY (`id`,`employee_id`,`work_date`,`clock_on`)
) ENGINE=InnoDB AUTO_INCREMENT=378 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clock_date`
--

LOCK TABLES `clock_date` WRITE;
/*!40000 ALTER TABLE `clock_date` DISABLE KEYS */;
INSERT INTO `clock_date` VALUES (1,'EMPAD0001','2025-09-01','19:47:32','00:12:01',4,_binary '\0',3,NULL,NULL),(2,'EMPAD0001','2025-09-02','08:14:17','13:14:49',5,_binary '\0',2,NULL,NULL),(3,'EMPAD0001','2025-09-04','07:58:12','12:01:01',4,_binary '\0',1,NULL,NULL),(4,'EMPAD0001','2025-09-05','15:38:18','00:02:54',7,_binary '\0',3,'19:42:37','20:50:13'),(5,'EMPAD0001','2025-09-06','11:42:39','17:01:11',5,_binary '\0',2,NULL,NULL),(6,'EMPAD0001','2025-09-06','20:03:28','00:12:37',4,_binary '\0',3,NULL,NULL),(8,'EMPAD0001','2025-09-08','07:51:02','12:17:54',4,_binary '\0',3,NULL,NULL),(9,'EMPAD0001','2025-09-09','11:57:24','16:16:11',4,_binary '\0',2,NULL,NULL),(10,'EMPAD0001','2025-09-10','07:41:19','12:10:01',4,_binary '\0',3,NULL,NULL),(11,'EMPAD0001','2025-09-10','15:57:21','20:03:20',4,_binary '\0',3,NULL,NULL),(12,'EMPAD0001','2025-09-11','20:11:33','00:18:24',4,_binary '\0',5,NULL,NULL),(13,'EMPAD0001','2025-09-12','12:18:47','20:20:13',7,_binary '\0',1,'15:27:52','16:30:32'),(17,'EMPAD0001','2025-09-15','15:46:18','00:11:44',7,_binary '\0',2,'20:21:14','21:31:34'),(19,'EMPAD0001','2025-09-16','19:44:51','00:09:23',4.5,_binary '\0',1,NULL,NULL),(20,'EMPAD0001','2025-09-17','16:15:47','00:18:09',7,_binary '\0',4,'21:32:16','22:41:12'),(23,'EMPAD0001','2025-09-19','11:45:55','16:14:26',4.5,_binary '\0',4,NULL,NULL),(24,'EMPAD0001','2025-09-19','20:06:44','00:25:19',4.5,_binary '\0',2,NULL,NULL),(25,'EMPAD0001','2025-09-20','12:01:18','20:22:17',7,_binary '\0',5,'16:32:16','17:34:56'),(29,'EMPAD0001','2025-09-23','15:52:55','20:27:49',4.5,_binary '\0',3,NULL,NULL),(30,'EMPAD0001','2025-09-24','11:44:33','16:21:27',4.5,_binary '\0',2,NULL,NULL),(31,'EMPAD0001','2025-09-25','12:05:12','16:14:56',4,_binary '\0',5,NULL,NULL),(32,'EMPAD0001','2025-09-26','07:45:42','12:06:38',4.5,_binary '\0',4,NULL,NULL),(33,'EMPAD0001','2025-09-27','16:02:59','00:19:11',7,_binary '\0',1,'20:17:34','21:23:21'),(38,'AACEO0001','2025-09-01','19:37:41','00:13:42',4.5,_binary '\0',3,NULL,NULL),(39,'AACEO0001','2025-09-02','08:14:52','12:00:23',3.5,_binary '\0',1,NULL,NULL),(40,'AACEO0001','2025-09-03','11:33:23','16:07:12',4.5,_binary '\0',2,NULL,NULL),(41,'AACEO0001','2025-09-04','07:41:29','12:01:51',4,_binary '\0',3,NULL,NULL),(42,'AACEO0001','2025-09-06','07:47:31','12:11:26',4,_binary '\0',3,NULL,NULL),(43,'AACEO0001','2025-09-06','15:51:11','20:07:58',4,_binary '\0',1,NULL,NULL),(44,'AACEO0001','2025-09-08','11:39:31','15:58:22',4,_binary '\0',3,NULL,NULL),(45,'AACEO0001','2025-09-09','11:58:42','16:15:22',4,_binary '\0',2,NULL,NULL),(46,'AACEO0001','2025-09-09','20:12:31','00:13:52',4,_binary '\0',3,NULL,NULL),(47,'AACEO0001','2025-09-10','15:41:57','20:01:12',4,_binary '\0',3,NULL,NULL),(48,'AACEO0001','2025-09-13','07:57:19','12:04:42',4,_binary '\0',1,NULL,NULL),(49,'AACEO0001','2025-09-14','19:46:21','00:10:12',4,_binary '\0',4,NULL,NULL),(50,'AACEO0001','2025-09-15','07:33:51','12:23:42',4.5,_binary '\0',3,NULL,NULL),(51,'AACEO0001','2025-09-18','19:38:32','00:01:42',4,_binary '\0',1,NULL,NULL),(52,'AACEO0001','2025-09-19','19:56:15','00:57:12',4,_binary '\0',2,NULL,NULL),(53,'AACEO0001','2025-09-20','07:58:21','12:03:52',4,_binary '\0',3,NULL,NULL),(54,'AACEO0001','2025-09-21','15:45:36','20:03:12',4,_binary '\0',3,NULL,NULL),(55,'AACEO0001','2025-09-23','07:31:46','11:49:22',4,_binary '\0',2,NULL,NULL),(56,'AACEO0001','2025-09-23','15:57:21','20:03:12',4,_binary '\0',3,NULL,NULL),(57,'AACEO0001','2025-09-25','19:38:01','00:11:23',4,_binary '\0',3,NULL,NULL),(58,'AACEO0001','2025-09-26','12:09:11','16:01:42',3.5,_binary '\0',2,NULL,NULL),(59,'AACEO0001','2025-09-28','07:47:41','12:01:42',4,_binary '\0',3,NULL,NULL),(89,'EMPAD0001','2025-10-01','12:11:43','16:05:43',3.5,_binary '\0',2,NULL,NULL),(90,'EMPAD0001','2025-10-02','16:22:50','19:58:55',3.5,_binary '\0',2,NULL,NULL),(91,'EMPAD0001','2025-10-04','07:58:25','12:17:57',4,_binary '\0',3,NULL,NULL),(92,'EMPAD0001','2025-10-05','07:34:23','12:00:46',4,_binary '\0',3,NULL,NULL),(93,'EMPAD0001','2025-10-05','15:37:41','20:23:18',4.5,_binary '\0',3,NULL,NULL),(94,'EMPAD0001','2025-10-06','16:16:43','23:50:42',6.5,_binary '',2,'19:34:31','20:36:51'),(96,'EMPAD0001','2025-10-08','11:39:57','16:21:06',4.5,_binary '\0',3,NULL,NULL),(97,'EMPAD0001','2025-10-09','07:53:21','12:14:32',4,_binary '\0',3,NULL,NULL),(98,'EMPAD0001','2025-10-10','08:23:59','15:50:07',6.5,_binary '',1,'11:49:21','12:51:35'),(100,'EMPAD0001','2025-10-11','11:43:34','15:54:55',4,_binary '\0',2,NULL,NULL),(101,'EMPAD0001','2025-10-12','12:26:09','20:26:00',7,_binary '\0',3,'17:13:12','18:14:31'),(103,'EMPAD0001','2025-10-15','12:15:38','16:06:06',3.5,_binary '\0',2,NULL,NULL),(104,'EMPAD0001','2025-10-15','20:13:56','00:08:07',3.5,_binary '\0',2,NULL,NULL),(105,'EMPAD0001','2025-10-16','11:34:04','16:29:14',4.5,_binary '\0',3,NULL,NULL),(106,'EMPAD0001','2025-10-17','16:12:05','00:25:35',7,_binary '\0',3,'18:57:32','20:01:35'),(108,'EMPAD0001','2025-10-19','07:47:55','12:23:00',4.5,_binary '\0',3,NULL,NULL),(109,'EMPAD0001','2025-10-19','19:43:44','00:16:47',4.5,_binary '\0',3,NULL,NULL),(110,'EMPAD0001','2025-10-20','12:09:41','20:15:49',7,_binary '\0',3,'16:45:38','17:49:21'),(112,'EMPAD0001','2025-10-23','12:12:12','16:13:12',4,_binary '\0',3,NULL,NULL),(113,'EMPAD0001','2025-10-24','08:17:26','11:58:32',3.5,_binary '\0',3,NULL,NULL),(114,'EMPAD0001','2025-10-25','20:11:41','00:23:19',4,_binary '\0',3,NULL,NULL),(115,'EMPAD0001','2025-10-26','11:34:56','16:26:29',4.5,_binary '\0',3,NULL,NULL),(116,'EMPAD0001','2025-10-27','07:48:51','12:23:23',4.5,_binary '\0',3,NULL,NULL),(117,'EMPAD0001','2025-10-31','07:43:51','12:15:59',4.5,_binary '\0',3,NULL,NULL),(118,'EMPAD0001','2025-10-31','20:03:24','00:23:22',4,_binary '\0',3,NULL,NULL),(147,'AACEO0001','2025-10-01','19:30:30','00:03:25',4.5,_binary '\0',3,NULL,NULL),(148,'AACEO0001','2025-10-02','12:26:43','16:12:31',4,_binary '\0',3,NULL,NULL),(149,'AACEO0001','2025-10-03','20:12:07','23:57:31',3.5,_binary '\0',3,NULL,NULL),(150,'AACEO0001','2025-10-04','12:10:27','16:10:21',4,_binary '\0',3,NULL,NULL),(151,'AACEO0001','2025-10-06','07:45:54','12:04:14',4,_binary '',3,NULL,NULL),(152,'AACEO0001','2025-10-06','19:48:09','00:20:23',4.5,_binary '',3,NULL,NULL),(153,'AACEO0001','2025-10-08','08:13:02','12:10:51',4,_binary '\0',3,NULL,NULL),(154,'AACEO0001','2025-10-09','12:10:45','16:32:41',4,_binary '\0',3,NULL,NULL),(155,'AACEO0001','2025-10-09','19:44:38','11:53:27',4,_binary '\0',3,NULL,NULL),(156,'AACEO0001','2025-10-10','11:40:56','15:48:12',4,_binary '',3,NULL,NULL),(157,'AACEO0001','2025-10-10','19:40:49','00:01:31',4,_binary '',3,NULL,NULL),(158,'AACEO0001','2025-10-13','07:51:15','12:01:07',4,_binary '\0',3,NULL,NULL),(159,'AACEO0001','2025-10-13','15:43:51','20:01:07',4,_binary '\0',3,NULL,NULL),(160,'AACEO0001','2025-10-14','07:35:30','12:01:07',4,_binary '\0',3,NULL,NULL),(161,'AACEO0001','2025-10-14','16:15:56','20:15:07',4,_binary '\0',3,NULL,NULL),(162,'AACEO0001','2025-10-15','08:03:12','12:03:07',4,_binary '\0',3,NULL,NULL),(163,'AACEO0001','2025-10-15','19:58:10','00:13:14',4,_binary '\0',3,NULL,NULL),(164,'AACEO0001','2025-10-18','12:11:17','16:11:41',4,_binary '\0',3,NULL,NULL),(165,'AACEO0001','2025-10-19','11:31:53','16:01:29',4.5,_binary '\0',3,NULL,NULL),(166,'AACEO0001','2025-10-19','19:35:36','00:01:05',4,_binary '\0',2,NULL,NULL),(167,'AACEO0001','2025-10-20','07:52:21','16:03:47',7,_binary '\0',3,'13:21:51','14:25:13'),(169,'AACEO0001','2025-10-21','08:17:48','16:01:41',7,_binary '\0',3,'14:32:23','15:33:15'),(171,'AACEO0001','2025-10-22','08:17:08','12:07:39',4,_binary '\0',3,NULL,NULL),(172,'AACEO0001','2025-10-22','15:43:21','20:01:31',4,_binary '\0',2,NULL,NULL),(173,'AACEO0001','2025-10-23','08:15:22','12:16:38',4,_binary '\0',3,NULL,NULL),(174,'AACEO0001','2025-10-23','15:36:45','20:07:01',4.5,_binary '\0',1,NULL,NULL),(175,'AACEO0001','2025-10-25','11:47:43','20:03:01',7,_binary '\0',3,'14:32:23','15:33:15'),(177,'AACEO0001','2025-10-28','08:18:25','12:18:04',4,_binary '\0',3,NULL,NULL),(178,'AACEO0001','2025-10-28','20:07:11','00:07:12',4,_binary '\0',3,NULL,NULL),(179,'AACEO0001','2025-10-30','08:10:39','12:15:57',4,_binary '\0',3,NULL,NULL),(180,'AACEO0001','2025-10-30','20:01:45','00:03:16',4,_binary '\0',3,NULL,NULL),(321,'EMPPT0001','2025-09-01','20:26:35','00:13:42',3.5,_binary '\0',1,NULL,NULL),(322,'EMPPT0001','2025-09-02','11:33:24','16:09:21',4.5,_binary '\0',3,NULL,NULL),(323,'EMPPT0001','2025-09-04','19:57:15','00:05:00',4,_binary '\0',1,NULL,NULL),(324,'EMPPT0001','2025-09-05','11:36:04','15:57:32',4,_binary '\0',3,NULL,NULL),(325,'EMPPT0001','2025-09-07','11:38:37','16:11:32',4.5,_binary '\0',3,NULL,NULL),(326,'EMPPT0001','2025-09-08','19:54:52','00:12:37',4,_binary '\0',3,NULL,NULL),(327,'EMPPT0001','2025-09-09','12:08:28','16:09:01',4,_binary '\0',2,NULL,NULL),(328,'EMPPT0001','2025-09-11','20:27:46','00:15:12',3.5,_binary '\0',3,NULL,NULL),(329,'EMPPT0001','2025-09-12','12:23:26','16:23:35',4,_binary '\0',3,NULL,NULL),(331,'EMPPT0001','2025-09-13','19:39:15','00:01:00',4,_binary '\0',2,NULL,NULL),(333,'EMPPT0001','2025-09-15','20:24:50','00:30:17',4,_binary '\0',3,NULL,NULL),(334,'EMPPT0001','2025-09-16','15:50:39','19:53:52',4,_binary '\0',3,NULL,NULL),(335,'EMPPT0001','2025-09-17','12:28:46','16:10:32',3.5,_binary '\0',3,NULL,NULL),(337,'EMPPT0001','2025-09-19','07:53:10','12:02:31',4,_binary '\0',3,NULL,NULL),(338,'EMPPT0001','2025-09-20','15:50:11','20:07:16',4,_binary '\0',3,NULL,NULL),(339,'EMPPT0001','2025-09-23','16:01:25','20:15:23',4,_binary '\0',3,NULL,NULL),(341,'EMPPT0001','2025-09-24','15:58:24','20:11:51',4,_binary '\0',3,NULL,NULL),(342,'EMPPT0001','2025-09-25','20:02:25','00:03:12',4,_binary '\0',3,NULL,NULL),(344,'EMPPT0001','2025-09-27','16:17:12','20:30:13',4,_binary '\0',3,NULL,NULL),(346,'EMPPT0001','2025-09-28','15:35:08','20:10:34',4.5,_binary '\0',3,NULL,NULL),(347,'EMPPT0001','2025-10-01','11:39:38','15:48:23',4,_binary '\0',3,NULL,NULL),(348,'EMPPT0001','2025-10-01','20:02:46','00:10:13',4,_binary '\0',3,NULL,NULL),(349,'EMPPT0001','2025-10-02','07:44:59','12:11:32',4,_binary '\0',3,NULL,NULL),(350,'EMPPT0001','2025-10-04','08:06:35','12:15:52',4,_binary '\0',3,NULL,NULL),(351,'EMPPT0001','2025-10-04','19:47:59','11:57:23',4,_binary '\0',3,NULL,NULL),(352,'EMPPT0001','2025-10-05','12:10:09','16:23:45',4,_binary '\0',3,NULL,NULL),(353,'EMPPT0001','2025-10-07','19:56:52','11:57:32',4,_binary '\0',3,NULL,NULL),(354,'EMPPT0001','2025-10-08','07:43:51','12:04:13',4,_binary '\0',3,NULL,NULL),(355,'EMPPT0001','2025-10-09','08:18:41','11:53:23',3.5,_binary '\0',3,NULL,NULL),(356,'EMPPT0001','2025-10-11','07:51:50','12:13:45',4,_binary '\0',2,NULL,NULL),(359,'EMPPT0001','2025-10-12','15:32:23','20:15:26',4.5,_binary '\0',2,NULL,NULL),(361,'EMPPT0001','2025-10-13','19:46:49','11:53:16',4,_binary '\0',3,NULL,NULL),(362,'EMPPT0001','2025-10-15','11:51:44','16:03:21',4,_binary '\0',3,NULL,NULL),(363,'EMPPT0001','2025-10-15','20:28:15','00:15:47',3.5,_binary '\0',3,NULL,NULL),(364,'EMPPT0001','2025-10-16','12:16:00','16:07:23',3.5,_binary '\0',3,NULL,NULL),(365,'EMPPT0001','2025-10-17','08:25:17','16:32:51',7,_binary '\0',3,'14:23:42','15:25:21'),(367,'EMPPT0001','2025-10-19','16:16:09','20:01:21',3.5,_binary '\0',3,NULL,NULL),(368,'EMPPT0001','2025-10-20','08:25:34','12:15:23',3.5,_binary '\0',3,NULL,NULL),(369,'EMPPT0001','2025-10-23','11:49:24','16:03:23',4,_binary '\0',3,NULL,NULL),(370,'EMPPT0001','2025-10-24','16:20:18','00:33:33',7,_binary '\0',3,'19:12:23','20:15:31'),(372,'EMPPT0001','2025-10-25','16:05:37','20:21:56',4,_binary '\0',3,NULL,NULL),(373,'EMPPT0001','2025-10-27','07:48:11','16:07:32',7,_binary '\0',2,'13:21:52','14:23:31'),(375,'EMPPT0001','2025-10-28','08:15:43','11:55:23',3.5,_binary '\0',3,NULL,NULL),(376,'EMPPT0001','2025-10-28','16:06:28','20:10:32',4,_binary '\0',3,NULL,NULL),(377,'EMPPT0001','2025-10-31','16:15:11','20:17:23',4,_binary '\0',3,NULL,NULL);
/*!40000 ALTER TABLE `clock_date` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `employment_status` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `join_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('AACEO0001','建男','主管','在職中','0912345679','eazy351Wu@gmail.com','万十店','$2a$10$SZpOc4UShvcIV.9BcVoO2OsyvngpsCQsrFAp43yMzJ8ektMXgYdDS','2025-10-19'),('EMPAD0001','國恒','正職人員','在職中','0912345677','kao13521_hrz@gmail.com','万十店','$2a$10$RT1iUd5h07hMdAJWr2XbU.yhkziQRS/GMdFOtaAAtTSKK6O8FgdcG','2025-10-19'),('EMPPT0001','頁羽','計時人員','在職中','0972878951','styyran19_sa@gmail.com','万十店','$2a$10$9bsDSO4ioXltL8TPavfKYOWzDE0q.Dz.cpcaxUJlu22pSV5cZ.pqm','2025-10-19'),('EMPPT0002','小鬍','計時人員','已離職','0911123458','xua1359@gmail.com','万十店','$2a$10$Ev.gK4i4553kLjO1bje.ZO8MDycc2Lr2WdVxZ.XQWuX.vWMAbMhk2','2025-10-19');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_notify`
--

DROP TABLE IF EXISTS `employee_notify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_notify` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `message` varchar(255) NOT NULL,
  `link_url` varchar(255) DEFAULT NULL,
  `created_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_notify`
--

LOCK TABLES `employee_notify` WRITE;
/*!40000 ALTER TABLE `employee_notify` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_notify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holiday`
--

DROP TABLE IF EXISTS `holiday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `holiday` (
  `id` int NOT NULL AUTO_INCREMENT,
  `holiday_date` date NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `has_double` bit(1) DEFAULT b'0',
  `has_workday` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_holiday_date` (`holiday_date`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday`
--

LOCK TABLES `holiday` WRITE;
/*!40000 ALTER TABLE `holiday` DISABLE KEYS */;
INSERT INTO `holiday` VALUES (65,'2025-01-01','元旦',_binary '',_binary '\0'),(66,'2025-01-27','春節假期',_binary '',_binary '\0'),(67,'2025-01-28','除夕',_binary '',_binary '\0'),(68,'2025-01-29','春節初一',_binary '',_binary '\0'),(69,'2025-01-30','春節假期',_binary '',_binary '\0'),(70,'2025-01-31','春節假期',_binary '',_binary '\0'),(71,'2025-02-01','春節假期',_binary '',_binary '\0'),(72,'2025-02-02','春節假期',_binary '',_binary '\0'),(73,'2025-02-28','和平紀念日',_binary '',_binary '\0'),(74,'2025-04-03','兒童節',_binary '',_binary '\0'),(75,'2025-04-04','清明節',_binary '',_binary '\0'),(76,'2025-05-01','勞動節',_binary '',_binary '\0'),(77,'2025-05-30','端午節',_binary '',_binary '\0'),(78,'2025-10-06','中秋節',_binary '',_binary '\0'),(79,'2025-10-10','國慶日',_binary '',_binary ''),(80,'2025-10-24','光復節（補假）',_binary '',_binary '\0');
/*!40000 ALTER TABLE `holiday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_application`
--

DROP TABLE IF EXISTS `leave_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_application` (
  `leave_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(20) NOT NULL,
  `leave_type` varchar(20) NOT NULL,
  `leave_description` varchar(250) NOT NULL,
  `leave_prove` longtext,
  `approved` tinyint DEFAULT NULL,
  PRIMARY KEY (`leave_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_application`
--

LOCK TABLES `leave_application` WRITE;
/*!40000 ALTER TABLE `leave_application` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave_application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_detail`
--

DROP TABLE IF EXISTS `leave_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `leave_id` int NOT NULL DEFAULT '0',
  `leave_date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `leave_hours` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`leave_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_detail`
--

LOCK TABLES `leave_detail` WRITE;
/*!40000 ALTER TABLE `leave_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notify`
--

DROP TABLE IF EXISTS `notify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notify` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `created_date` date NOT NULL,
  `link_url` varchar(255) DEFAULT NULL,
  `is_publish` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notify`
--

LOCK TABLES `notify` WRITE;
/*!40000 ALTER TABLE `notify` DISABLE KEYS */;
INSERT INTO `notify` VALUES (2,'中秋節放假公告','中秋節連假自10月4日至10月6日，共3天，請同仁提前完成手上工作。','2025-09-25',NULL,_binary ''),(3,'薪資調整說明會','人事部將於10月20日舉辦薪資制度說明會，歡迎全體員工參加。','2025-10-10','https://intra.company.com/meeting',_binary ''),(4,'門禁系統升級','新門禁系統將於10月21日啟用，請於啟用前完成卡片更換。','2025-10-15',NULL,_binary ''),(5,'IT客服窗口更新','IT問題請改由「內部客服系統」提交，舊信箱將於月底停用。','2025-09-28','https://intra.company.com/helpdesk',_binary ''),(6,'午休室維修通知','本週五午休室將進行冷氣維修，請同仁暫時使用三樓休息區。','2025-10-02',NULL,_binary '\0'),(7,'年度健檢報名開放','年度健康檢查報名開放至10月25日，請儘早完成登記。','2025-10-05','https://intra.company.com/healthcheck',_binary ''),(8,'防火演練通知','全公司防火演練將於10月30日上午舉行，請全體員工配合參與。','2025-10-12',NULL,_binary ''),(9,'員工旅遊意願調查','請於10月22日前填寫旅遊意願問卷。','2025-10-08','https://forms.company.com/travel',_binary ''),(10,'會議室預約系統更新','自下週起會議室預約將全面改用新系統，舊平台停止使用。','2025-10-14','https://intra.company.com/meetingroom',_binary ''),(11,'飲水機保養通知','本週三下午將進行飲水機清潔保養，暫停使用兩小時。','2025-10-07',NULL,_binary '\0'),(12,'生日慶生會','10月壽星慶生活動將於10月25日下午3點舉行。','2025-10-09',NULL,_binary ''),(13,'交通補助申請開放','交通補助申請至10月底截止，請有需要者於期限內申請。','2025-10-01','https://intra.company.com/transport',_binary ''),(14,'人事異動公告','自11月起，行政部門新增兩名新同仁，請大家多多指教。','2025-10-15',NULL,_binary ''),(15,'網頁維修公告','公司首頁將於今晚10點進行維修，預計影響30分鐘。','2025-10-13',NULL,_binary ''),(16,'加班申請流程調整','新的加班申請流程已上線，請參考人資公告說明。','2025-10-03','https://intra.company.com/ot',_binary ''),(17,'年終聚餐預告','年度尾牙聚餐暫定於12月20日舉行，細節稍後公布。','2025-10-17',NULL,_binary ''),(18,'會議紀錄上傳通知','所有部門會議紀錄請於會議後三日內上傳。','2025-10-11',NULL,_binary ''),(19,'環保日活動','10月26日舉辦環保淨灘活動，歡迎報名參加。','2025-10-06','https://intra.company.com/green',_binary ''),(20,'年度績效考核說明','績效考核將於11月初展開，詳情請參閱HR公告。','2025-10-16','https://intra.company.com/hr',_binary ''),(21,'停車場封閉通知','因進行重鋪工程，B2停車場將於10月20日封閉一日。','2025-10-09',NULL,_binary '\0'),(22,'安全衛生講座','安全衛生講座將於10月28日舉辦，參加者可獲教育時數。','2025-10-10','https://intra.company.com/safety',_binary ''),(23,'員工意見箱更新','新的匿名意見箱系統上線，歡迎大家提出建議。','2025-10-04','https://intra.company.com/feedback',_binary ''),(25,'午餐供應調整','為提升品質，午餐供應時間改為11:45至13:15。','2025-10-02',NULL,_binary ''),(26,'停電預告','本週六晚間進行電力檢測，部分樓層將暫時停電。','2025-10-14',NULL,_binary ''),(27,'員工教育訓練','新人訓練課程將於10月22日展開，請準時出席。','2025-10-05','https://intra.company.com/training',_binary ''),(28,'內部系統更新公告','ERP系統更新將於10月23日凌晨進行，請提前儲存資料。','2025-10-18',NULL,_binary ''),(29,'物品報修系統上線','新的報修平台已啟用，請使用該平台通報故障。','2025-10-17','https://intra.company.com/repair',_binary ''),(30,'辦公區清潔通知','本週五下午進行大掃除，請配合清空個人桌面。','2025-10-19',NULL,_binary '');
/*!40000 ALTER TABLE `notify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opinion`
--

DROP TABLE IF EXISTS `opinion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opinion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opinion`
--

LOCK TABLES `opinion` WRITE;
/*!40000 ALTER TABLE `opinion` DISABLE KEYS */;
INSERT INTO `opinion` VALUES (1,'EMPAD0001','希望增加員工午休時間','目前午休時間只有30分鐘，對於需要外出買午餐的員工比較緊湊，希望能延長至45分鐘。','2025-10-10'),(2,'EMPCTO0001','建議改善內部通訊系統','公司通訊系統常常延遲，尤其在排班通知時容易漏訊息，希望IT能優化。','2025-10-11'),(3,'EMPPM0001','希望增加計時人員福利','計時人員目前沒有年終獎金，希望公司能考慮提供績效獎勵或節日禮金。','2025-10-12'),(4,'EMPPT0001','制服材質太厚','夏天制服材質偏厚，上班容易流汗不舒服，建議改用透氣材質。','2025-10-13'),(5,'AACEO0001','鼓勵部門內部培訓','建議定期舉辦內部技能培訓，提升員工的專業能力與團隊凝聚力。','2025-10-14'),(6,'EMPAD0001','建議調整打卡位置','目前打卡機設在倉庫旁，早上人多容易擁擠，希望能移至入口區。','2025-10-15'),(7,'EMPCTO0001','希望能有彈性上下班制度','部分員工通勤時間較長，如果能提供彈性上下班制度，能提升工作效率。','2025-10-16'),(8,'EMPPM0001','咖啡機故障多次','茶水間咖啡機經常壞掉，希望能更換新的設備。','2025-10-17'),(9,'EMPPT0001','建議改善休息區照明','休息室燈光太暗，晚上班次使用不方便，希望能改善照明。','2025-10-17'),(10,'AACEO0001','感謝員工辛勞與建議','感謝各位同仁提出寶貴意見，管理層會持續優化公司制度。','2025-10-18');
/*!40000 ALTER TABLE `opinion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pre_schedule`
--

DROP TABLE IF EXISTS `pre_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pre_schedule` (
  `employee_id` varchar(255) NOT NULL,
  `apply_date` date NOT NULL,
  `shift_work_id` int NOT NULL DEFAULT '0',
  `is_accept` bit(1) DEFAULT NULL,
  PRIMARY KEY (`employee_id`,`apply_date`,`shift_work_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pre_schedule`
--

LOCK TABLES `pre_schedule` WRITE;
/*!40000 ALTER TABLE `pre_schedule` DISABLE KEYS */;
INSERT INTO `pre_schedule` VALUES ('AACEO0001','2025-09-01',4,_binary ''),('AACEO0001','2025-09-02',1,_binary ''),('AACEO0001','2025-09-03',2,_binary ''),('AACEO0001','2025-09-04',1,_binary ''),('AACEO0001','2025-09-05',0,_binary ''),('AACEO0001','2025-09-06',1,_binary ''),('AACEO0001','2025-09-06',3,_binary ''),('AACEO0001','2025-09-07',0,_binary ''),('AACEO0001','2025-09-08',2,_binary ''),('AACEO0001','2025-09-09',2,_binary ''),('AACEO0001','2025-09-09',4,_binary ''),('AACEO0001','2025-09-10',3,_binary ''),('AACEO0001','2025-09-11',0,_binary ''),('AACEO0001','2025-09-12',0,_binary ''),('AACEO0001','2025-09-13',1,_binary ''),('AACEO0001','2025-09-14',4,_binary ''),('AACEO0001','2025-09-15',1,_binary ''),('AACEO0001','2025-09-16',0,_binary ''),('AACEO0001','2025-09-17',0,_binary ''),('AACEO0001','2025-09-18',4,_binary ''),('AACEO0001','2025-09-19',4,_binary ''),('AACEO0001','2025-09-20',1,_binary ''),('AACEO0001','2025-09-21',3,_binary ''),('AACEO0001','2025-09-22',0,_binary ''),('AACEO0001','2025-09-23',1,_binary ''),('AACEO0001','2025-09-23',3,_binary ''),('AACEO0001','2025-09-24',0,_binary ''),('AACEO0001','2025-09-25',4,_binary ''),('AACEO0001','2025-09-26',2,_binary ''),('AACEO0001','2025-09-27',0,_binary ''),('AACEO0001','2025-09-28',1,_binary ''),('AACEO0001','2025-09-29',0,_binary ''),('AACEO0001','2025-09-30',0,_binary ''),('AACEO0001','2025-10-01',4,_binary ''),('AACEO0001','2025-10-02',2,_binary ''),('AACEO0001','2025-10-03',4,_binary ''),('AACEO0001','2025-10-04',2,_binary ''),('AACEO0001','2025-10-05',0,_binary ''),('AACEO0001','2025-10-06',1,_binary ''),('AACEO0001','2025-10-06',4,_binary ''),('AACEO0001','2025-10-07',0,_binary ''),('AACEO0001','2025-10-08',1,_binary ''),('AACEO0001','2025-10-09',2,_binary ''),('AACEO0001','2025-10-09',4,_binary ''),('AACEO0001','2025-10-10',2,_binary ''),('AACEO0001','2025-10-10',4,_binary ''),('AACEO0001','2025-10-11',0,_binary ''),('AACEO0001','2025-10-12',0,_binary ''),('AACEO0001','2025-10-13',1,_binary ''),('AACEO0001','2025-10-13',3,_binary ''),('AACEO0001','2025-10-14',1,_binary ''),('AACEO0001','2025-10-14',3,_binary ''),('AACEO0001','2025-10-15',1,_binary ''),('AACEO0001','2025-10-15',4,_binary ''),('AACEO0001','2025-10-16',0,_binary ''),('AACEO0001','2025-10-17',0,_binary ''),('AACEO0001','2025-10-18',2,_binary ''),('AACEO0001','2025-10-19',2,_binary ''),('AACEO0001','2025-10-19',4,_binary ''),('AACEO0001','2025-10-20',1,_binary ''),('AACEO0001','2025-10-20',2,_binary ''),('AACEO0001','2025-10-21',1,_binary ''),('AACEO0001','2025-10-21',2,_binary ''),('AACEO0001','2025-10-22',1,_binary ''),('AACEO0001','2025-10-22',3,_binary ''),('AACEO0001','2025-10-23',1,_binary ''),('AACEO0001','2025-10-23',3,_binary ''),('AACEO0001','2025-10-24',0,_binary ''),('AACEO0001','2025-10-25',2,_binary ''),('AACEO0001','2025-10-25',3,_binary ''),('AACEO0001','2025-10-26',0,_binary ''),('AACEO0001','2025-10-27',0,_binary ''),('AACEO0001','2025-10-28',1,_binary ''),('AACEO0001','2025-10-28',4,_binary ''),('AACEO0001','2025-10-29',0,_binary ''),('AACEO0001','2025-10-30',1,_binary ''),('AACEO0001','2025-10-30',4,_binary ''),('AACEO0001','2025-10-31',0,_binary ''),('EMPAD0001','2025-09-01',4,_binary ''),('EMPAD0001','2025-09-02',1,_binary ''),('EMPAD0001','2025-09-03',0,_binary ''),('EMPAD0001','2025-09-04',2,_binary ''),('EMPAD0001','2025-09-05',3,_binary ''),('EMPAD0001','2025-09-05',4,_binary ''),('EMPAD0001','2025-09-06',2,_binary ''),('EMPAD0001','2025-09-06',4,_binary ''),('EMPAD0001','2025-09-07',0,_binary ''),('EMPAD0001','2025-09-08',1,_binary ''),('EMPAD0001','2025-09-09',2,_binary ''),('EMPAD0001','2025-09-10',1,_binary ''),('EMPAD0001','2025-09-10',3,_binary ''),('EMPAD0001','2025-09-11',4,_binary ''),('EMPAD0001','2025-09-12',2,_binary ''),('EMPAD0001','2025-09-12',3,_binary ''),('EMPAD0001','2025-09-13',0,_binary ''),('EMPAD0001','2025-09-14',0,_binary ''),('EMPAD0001','2025-09-15',3,_binary ''),('EMPAD0001','2025-09-15',4,_binary ''),('EMPAD0001','2025-09-16',4,_binary ''),('EMPAD0001','2025-09-17',3,_binary ''),('EMPAD0001','2025-09-17',4,_binary ''),('EMPAD0001','2025-09-18',0,_binary ''),('EMPAD0001','2025-09-19',2,_binary ''),('EMPAD0001','2025-09-19',4,_binary ''),('EMPAD0001','2025-09-20',2,_binary ''),('EMPAD0001','2025-09-20',3,_binary ''),('EMPAD0001','2025-09-21',0,_binary ''),('EMPAD0001','2025-09-22',0,_binary ''),('EMPAD0001','2025-09-23',3,_binary ''),('EMPAD0001','2025-09-24',2,_binary ''),('EMPAD0001','2025-09-25',2,_binary ''),('EMPAD0001','2025-09-26',1,_binary ''),('EMPAD0001','2025-09-27',3,_binary ''),('EMPAD0001','2025-09-27',4,_binary ''),('EMPAD0001','2025-09-28',0,_binary ''),('EMPAD0001','2025-09-29',0,_binary ''),('EMPAD0001','2025-09-30',0,_binary ''),('EMPAD0001','2025-10-01',2,_binary ''),('EMPAD0001','2025-10-02',3,_binary ''),('EMPAD0001','2025-10-03',0,_binary ''),('EMPAD0001','2025-10-04',1,_binary ''),('EMPAD0001','2025-10-05',1,_binary ''),('EMPAD0001','2025-10-05',3,_binary ''),('EMPAD0001','2025-10-06',3,_binary ''),('EMPAD0001','2025-10-06',4,_binary ''),('EMPAD0001','2025-10-07',0,_binary ''),('EMPAD0001','2025-10-08',2,_binary ''),('EMPAD0001','2025-10-09',1,_binary ''),('EMPAD0001','2025-10-10',1,_binary ''),('EMPAD0001','2025-10-10',2,_binary ''),('EMPAD0001','2025-10-11',2,_binary ''),('EMPAD0001','2025-10-12',2,_binary ''),('EMPAD0001','2025-10-12',3,_binary ''),('EMPAD0001','2025-10-13',0,_binary ''),('EMPAD0001','2025-10-14',0,_binary ''),('EMPAD0001','2025-10-15',2,_binary ''),('EMPAD0001','2025-10-15',4,_binary ''),('EMPAD0001','2025-10-16',2,_binary ''),('EMPAD0001','2025-10-17',3,_binary ''),('EMPAD0001','2025-10-17',4,_binary ''),('EMPAD0001','2025-10-18',0,_binary ''),('EMPAD0001','2025-10-19',1,_binary ''),('EMPAD0001','2025-10-19',4,_binary ''),('EMPAD0001','2025-10-20',2,_binary ''),('EMPAD0001','2025-10-20',3,_binary ''),('EMPAD0001','2025-10-21',0,_binary ''),('EMPAD0001','2025-10-22',0,_binary ''),('EMPAD0001','2025-10-23',2,_binary ''),('EMPAD0001','2025-10-24',1,_binary ''),('EMPAD0001','2025-10-25',4,_binary ''),('EMPAD0001','2025-10-26',2,_binary ''),('EMPAD0001','2025-10-27',1,_binary ''),('EMPAD0001','2025-10-28',0,_binary ''),('EMPAD0001','2025-10-29',0,_binary ''),('EMPAD0001','2025-10-30',0,_binary ''),('EMPAD0001','2025-10-31',1,_binary ''),('EMPAD0001','2025-10-31',4,_binary ''),('EMPPT0001','2025-09-01',4,_binary ''),('EMPPT0001','2025-09-02',2,_binary ''),('EMPPT0001','2025-09-03',0,_binary ''),('EMPPT0001','2025-09-04',4,_binary ''),('EMPPT0001','2025-09-05',2,_binary ''),('EMPPT0001','2025-09-06',0,_binary ''),('EMPPT0001','2025-09-07',2,_binary ''),('EMPPT0001','2025-09-08',4,_binary ''),('EMPPT0001','2025-09-09',2,_binary ''),('EMPPT0001','2025-09-10',0,_binary ''),('EMPPT0001','2025-09-11',4,_binary ''),('EMPPT0001','2025-09-12',2,_binary ''),('EMPPT0001','2025-09-13',4,_binary ''),('EMPPT0001','2025-09-14',0,_binary ''),('EMPPT0001','2025-09-15',4,_binary ''),('EMPPT0001','2025-09-16',3,_binary ''),('EMPPT0001','2025-09-17',2,_binary ''),('EMPPT0001','2025-09-18',0,_binary ''),('EMPPT0001','2025-09-19',1,_binary ''),('EMPPT0001','2025-09-20',3,_binary ''),('EMPPT0001','2025-09-21',0,_binary ''),('EMPPT0001','2025-09-22',0,_binary ''),('EMPPT0001','2025-09-23',3,_binary ''),('EMPPT0001','2025-09-24',3,_binary ''),('EMPPT0001','2025-09-25',4,_binary ''),('EMPPT0001','2025-09-26',0,_binary ''),('EMPPT0001','2025-09-27',3,_binary ''),('EMPPT0001','2025-09-28',3,_binary ''),('EMPPT0001','2025-09-29',0,_binary ''),('EMPPT0001','2025-09-30',0,_binary ''),('EMPPT0001','2025-10-01',2,_binary ''),('EMPPT0001','2025-10-01',4,_binary ''),('EMPPT0001','2025-10-02',1,_binary ''),('EMPPT0001','2025-10-03',0,_binary ''),('EMPPT0001','2025-10-04',1,_binary ''),('EMPPT0001','2025-10-04',4,_binary ''),('EMPPT0001','2025-10-05',2,_binary ''),('EMPPT0001','2025-10-06',0,_binary ''),('EMPPT0001','2025-10-07',4,_binary ''),('EMPPT0001','2025-10-08',1,_binary ''),('EMPPT0001','2025-10-09',1,_binary ''),('EMPPT0001','2025-10-10',0,_binary ''),('EMPPT0001','2025-10-11',1,_binary ''),('EMPPT0001','2025-10-12',3,_binary ''),('EMPPT0001','2025-10-13',4,_binary ''),('EMPPT0001','2025-10-14',0,_binary ''),('EMPPT0001','2025-10-15',2,_binary ''),('EMPPT0001','2025-10-15',4,_binary ''),('EMPPT0001','2025-10-16',2,_binary ''),('EMPPT0001','2025-10-17',1,_binary ''),('EMPPT0001','2025-10-17',2,_binary ''),('EMPPT0001','2025-10-18',0,_binary ''),('EMPPT0001','2025-10-19',3,_binary ''),('EMPPT0001','2025-10-20',1,_binary ''),('EMPPT0001','2025-10-21',0,_binary ''),('EMPPT0001','2025-10-22',0,_binary ''),('EMPPT0001','2025-10-23',2,_binary ''),('EMPPT0001','2025-10-24',3,_binary ''),('EMPPT0001','2025-10-24',4,_binary ''),('EMPPT0001','2025-10-25',3,_binary ''),('EMPPT0001','2025-10-26',0,_binary ''),('EMPPT0001','2025-10-27',1,_binary ''),('EMPPT0001','2025-10-27',2,_binary ''),('EMPPT0001','2025-10-28',1,_binary ''),('EMPPT0001','2025-10-28',3,_binary ''),('EMPPT0001','2025-10-29',0,_binary ''),('EMPPT0001','2025-10-30',0,_binary ''),('EMPPT0001','2025-10-31',3,_binary '');
/*!40000 ALTER TABLE `pre_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary` (
  `employee_id` varchar(255) NOT NULL,
  `year_month` varchar(255) NOT NULL,
  `base_salary` int NOT NULL DEFAULT '0',
  `hourlyrate` int NOT NULL DEFAULT '0',
  `overtime_pay` int DEFAULT '0',
  `deduction` int DEFAULT '0',
  `insurance_fee` int DEFAULT '0',
  `total_salary` int NOT NULL DEFAULT '0',
  `tax_deduction` int DEFAULT NULL,
  PRIMARY KEY (`employee_id`,`year_month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES ('AACEO0001','2025-09',50000,208,0,208,1876,47916,NULL),('EMPAD0001','2025-09',32000,133,0,264,1200,30536,NULL),('EMPPT0001','2025-09',0,190,0,570,1030,13600,NULL);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shift_work`
--

DROP TABLE IF EXISTS `shift_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shift_work` (
  `id` int NOT NULL,
  `shift_work_id` int NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shift_work`
--

LOCK TABLES `shift_work` WRITE;
/*!40000 ALTER TABLE `shift_work` DISABLE KEYS */;
INSERT INTO `shift_work` VALUES (1,0,'00:00:00','23:59:59'),(2,1,'08:00:00','12:00:00'),(3,2,'12:00:00','16:00:00'),(4,3,'16:00:00','20:00:00'),(5,4,'20:00:00','00:00:00');
/*!40000 ALTER TABLE `shift_work` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-28 10:53:05
