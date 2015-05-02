-- MySQL dump 10.13  Distrib 5.5.40, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: webrtc_app
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `AD_ITEM`
--

DROP TABLE IF EXISTS `AD_ITEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AD_ITEM` (
  `AD_ID` varchar(50) NOT NULL,
  `AD_TOPIC` varchar(255) NOT NULL,
  `AD_CATEGORY` varchar(255) NOT NULL,
  `AD_DESCRIPTION` varchar(255) DEFAULT NULL,
  `AD_ITEM_PRICE` varchar(255) DEFAULT NULL,
  `AD_POSTER_URL` varchar(255) DEFAULT NULL,
  `MOBILE_NUMBER` varchar(50) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `SCRIPT` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`AD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AD_ITEM`
--

LOCK TABLES `AD_ITEM` WRITE;
/*!40000 ALTER TABLE `AD_ITEM` DISABLE KEYS */;
INSERT INTO `AD_ITEM` VALUES ('57c83824-b9ad-4237-81a5-db1b37908cf0','Server 2','ELECTRONIC','Server For Sale','$2000','http://127.0.0.1:8080/images/Home-Server-icon.png','tel:94770102555','2015-05-02 09:43:24','Script'),('7f355b2b-6327-42ef-a7e8-016fa4ba339d','Server 5','ELECTRONIC','Server For Sale','$6000','http://127.0.0.1:8080/images/Home-Server-icon.png','tel:94770102555','2015-05-02 09:44:03','Script'),('b2f6ec6c-4b40-489a-b6f7-57d4337b8a87','Server 3','ELECTRONIC','Server For Sale','$5000','http://127.0.0.1:8080/images/Home-Server-icon.png','tel:94770102555','2015-05-02 09:43:37','Script'),('d2726af9-2254-4ee5-9be2-1ae27665b6a2','Server 4','ELECTRONIC','Server For Sale','$4000','http://127.0.0.1:8080/images/Home-Server-icon.png','tel:94770102555','2015-05-02 09:43:49','Script'),('d4f546d5-1eb4-44db-97a8-355119a03682','Server 1 ','ELECTRONIC','Server 1 For Sale','$3000','http://127.0.0.1:8080/images/Home-Server-icon.png','tel:94778908908','2015-05-02 09:42:52','Script');
/*!40000 ALTER TABLE `AD_ITEM` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-02  9:45:30
