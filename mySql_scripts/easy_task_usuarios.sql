-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: easy_task
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `usuarioId` int(11) NOT NULL AUTO_INCREMENT,
  `usuarioNome` varchar(200) DEFAULT NULL,
  `usuarioSobrenome` varchar(200) DEFAULT NULL,
  `usuarioEmail` varchar(200) DEFAULT NULL,
  `usuarioSenha` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`usuarioId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (2,'Idris Elba',NULL,NULL,'Ragnarok'),(4,'André','Cardoso','email','andre7678'),(5,'André','Cardoso','emaildante','andre7678'),(6,'André',NULL,'email','andre7678'),(7,'André',NULL,'email','andre7678'),(8,'André',NULL,'email','andre7678'),(9,'André','Cardoso','emaildante','andre7678'),(10,'André','Cardoso','emaildante','andre7678'),(11,'André','Cardoso','emaildante','andre7678'),(12,'André','Cardoso','emaildante','andre7678'),(13,'André','Cardoso','emaildante','andre7678'),(14,'André','Cardoso','emaildante','andre7678'),(15,'André','Cardoso','emailde','andre7678'),(16,'André','Cardoso','emailde','andre7678'),(17,'André','Cardoso','emailde','andre7678'),(18,'André','Cardoso','emailde','andre7678'),(19,'André','Cardoso','emaildante','andre7678'),(20,'André','Cardoso','emaildante','andre7678'),(21,'André','Cardoso','emaildante','andre7678'),(22,'André','Cardoso',NULL,'meteoro2018'),(23,'André','Luis','dantesparda10@live.com','meteoro');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-07 20:46:37
