CREATE DATABASE  IF NOT EXISTS `dogAdmin` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `dogAdmin`;
-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: localhost    Database: dogAdmin
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `breedingdog`
--

DROP TABLE IF EXISTS `breedingdog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `breedingdog` (
  `id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `matingdate` datetime DEFAULT NULL,
  `puppybirthday` datetime DEFAULT NULL,
  `epdate` datetime DEFAULT NULL,
  `feeder` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `readyforsell` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `chipid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `earid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `puppyaccount` int(11) DEFAULT NULL,
  `kennelid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `companycode` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remarks` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `breedingdog`
--

LOCK TABLES `breedingdog` WRITE;
/*!40000 ALTER TABLE `breedingdog` DISABLE KEYS */;
INSERT INTO `breedingdog` VALUES ('abc','2016-10-05 15:31:00','2016-10-05 15:31:00','2016-10-05 15:31:00','stonna',1,20,'abc','abc','导盲犬',10,'abc','none','abc','hello','naughty','2016-10-05 15:31:00');
/*!40000 ALTER TABLE `breedingdog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kennel`
--

DROP TABLE IF EXISTS `kennel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kennel` (
  `id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `kennelid` int(11) DEFAULT NULL,
  `regionid` int(11) DEFAULT NULL,
  `address` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kennel`
--

LOCK TABLES `kennel` WRITE;
/*!40000 ALTER TABLE `kennel` DISABLE KEYS */;
/*!40000 ALTER TABLE `kennel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owner` (
  `id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `petdog`
--

DROP TABLE IF EXISTS `petdog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `petdog` (
  `id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `traininglevel` int(11) DEFAULT NULL,
  `trainer` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `breeder` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `apperance` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `readyforsell` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `epdate` datetime DEFAULT NULL,
  `chipid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `earid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kennelid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `companycode` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remarks` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `petdog`
--

LOCK TABLES `petdog` WRITE;
/*!40000 ALTER TABLE `petdog` DISABLE KEYS */;
/*!40000 ALTER TABLE `petdog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainingdog`
--

DROP TABLE IF EXISTS `trainingdog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainingdog` (
  `id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ownerphone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kennelid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chipid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `earid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `courses` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  `companycode` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remarks` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ownerid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `epdate` datetime DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainingdog`
--

LOCK TABLES `trainingdog` WRITE;
/*!40000 ALTER TABLE `trainingdog` DISABLE KEYS */;
/*!40000 ALTER TABLE `trainingdog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `position` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('abc','Stonna Wang',21,'developer','male');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workingdog`
--

DROP TABLE IF EXISTS `workingdog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workingdog` (
  `id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `traininglevel` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `trainer` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `readyforworking` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `chipid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `earid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `companycode` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remarks` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `epdate` datetime DEFAULT NULL,
  `kennelid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workingdog`
--

LOCK TABLES `workingdog` WRITE;
/*!40000 ALTER TABLE `workingdog` DISABLE KEYS */;
INSERT INTO `workingdog` VALUES ('abc','牧羊犬','顺顺','熟练','Stonna','2016-03-04 08:00:00',1,20.22,1,'abc','abc','bcd','hello','2016-03-04 08:00:00','ecf'),('bcd','牧羊犬','liuliu','熟练','Stonna','2016-03-04 08:00:00',1,20.22,1,'abc','abc','bcd','hello','2016-03-04 08:00:00','ecf');
/*!40000 ALTER TABLE `workingdog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-08 17:16:20
