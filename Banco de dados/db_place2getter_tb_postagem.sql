-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_place2getter
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `tb_postagem`
CREATE TABLE `tb_postagem` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `curtidas` int NOT NULL,
  `data_publicacao` datetime(6) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `tema_id` bigint DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbs3gyvg64n0q2f3ce0trikhi3` (`tema_id`),
  KEY `FKr8awqpir4je3agsos18npscw7` (`usuario_id`),
  CONSTRAINT `FKbs3gyvg64n0q2f3ce0trikhi3` FOREIGN KEY (`tema_id`) REFERENCES `tb_tema` (`id`),
  CONSTRAINT `FKr8awqpir4je3agsos18npscw7` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dump completed on 2021-07-14 10:41:02
