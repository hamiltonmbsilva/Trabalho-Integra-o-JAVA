CREATE DATABASE  IF NOT EXISTS `auto_escola` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `auto_escola`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: auto_escola
-- ------------------------------------------------------
-- Server version	5.5.61

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `matricula` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `logradouro` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `matriculado` tinyint(4) NOT NULL,
  `data_nascimento` date NOT NULL,
  `login_id` int(11) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  PRIMARY KEY (`matricula`),
  KEY `fk_aluno_login1_idx` (`login_id`),
  CONSTRAINT `fk_aluno_login1` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (4,'Marcos Paulo Gamarano','marcos_gamarano@gmail.com','Rua Badi Geara','Ipiranga','897','casa','Juiz de Fora','MG',0,'1999-01-13',19,'123456789'),(6,'Adriano Werpel Silva','adriano.silva@viannasempre.com.br','Rua BarÃ£o do Rio Branco','Centro','1023','Apartamento 1001','Juiz de Fora','MG',1,'1985-07-13',25,'504.434.190-86'),(7,'Patricia Carneiro Medeiros','patyc_medeiros@yahoo.com.br','Rua BarÃ£o do Rio Branco','Centro','1023','Apartamento 1001','Juiz de Fora','MG',1,'1986-05-13',26,'020.849.940-71');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula_pratica`
--

DROP TABLE IF EXISTS `aula_pratica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aula_pratica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_aula` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tema` varchar(50) NOT NULL,
  `veiculo` varchar(12) NOT NULL,
  `professor_id` int(11) NOT NULL,
  `aluno_matricula` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_aula_pratica_professor1_idx` (`professor_id`),
  KEY `fk_aula_pratica_aluno1_idx` (`aluno_matricula`),
  CONSTRAINT `fk_aula_pratica_aluno1` FOREIGN KEY (`aluno_matricula`) REFERENCES `aluno` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aula_pratica_professor1` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula_pratica`
--

LOCK TABLES `aula_pratica` WRITE;
/*!40000 ALTER TABLE `aula_pratica` DISABLE KEYS */;
INSERT INTO `aula_pratica` VALUES (1,'2018-10-06 23:57:14','Baliza','Corsa 2013',3,6),(2,'2018-10-06 23:57:22','Direção Defensiva','Up 2014',4,6),(3,'2018-10-07 00:00:34','Iniciação na rua','Gol 2014',3,6),(4,'2018-10-07 00:00:45','Ré alinhada','Up 2014',4,6),(5,'2018-10-07 00:00:59','Controle de Embreagem','Gol 2014',3,6),(6,'2018-10-06 23:57:01','Treino pré exame','Corsa 2013',4,NULL),(16,'2018-10-06 23:57:01','Iniciação na Rua','Corsa 2013',3,NULL),(17,'2018-10-06 23:57:01','Controle de embreagem','Up 2014',4,NULL),(18,'2018-10-06 23:57:01','Ré Alinhada','Gol 2014',3,NULL),(19,'2018-10-06 23:17:29','Troca de Marcha','Up 2014',4,NULL),(20,'2018-10-06 23:57:01','Baliza','Corsa 2013',3,NULL),(21,'2018-10-06 23:17:29','Iniciação na Rua','Gol 2014',4,NULL),(25,'2018-10-06 23:57:01','Treino Pré Exame','Up 2014',3,NULL),(26,'2018-10-07 22:00:00','Treino Pré Exame','Gol 2014',4,NULL),(27,'2018-10-06 23:17:29','Baliza','Cosa 2013',3,NULL);
/*!40000 ALTER TABLE `aula_pratica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula_teorica`
--

DROP TABLE IF EXISTS `aula_teorica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aula_teorica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_aula` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tema` varchar(50) NOT NULL,
  `professor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_aula_teorica_professor1_idx` (`professor_id`),
  CONSTRAINT `fk_aula_teorica_professor1` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula_teorica`
--

LOCK TABLES `aula_teorica` WRITE;
/*!40000 ALTER TABLE `aula_teorica` DISABLE KEYS */;
INSERT INTO `aula_teorica` VALUES (1,'2018-10-01 20:00:00','Direção Defensiva',1),(2,'2018-10-01 21:00:00','Segurança no Trânsito',2),(3,'2018-10-01 22:00:00','Sinalização de Trânsito',1),(4,'2018-10-02 20:00:00','Perigos no Trânsito',2),(5,'2018-10-02 21:00:00','Educação no Trânsito',1),(6,'2018-10-02 22:00:00','Tema Livre',2),(7,'2018-10-03 20:00:00','Direção Defensiva',1),(8,'2018-10-03 21:00:00','Segurança no Trânsito',2),(9,'2018-10-03 22:00:00','Sinalização de Taânsito',1),(10,'2018-10-04 20:00:00','Perigos no Trânsito',2),(11,'2018-10-04 21:00:00','Educação no Trânsito',1),(12,'2018-10-04 22:00:00','Tema Livre',2),(13,'2018-10-05 20:00:00','Direção Defensiva',1),(14,'2018-10-05 21:00:00','Segurança no Trânsito',2),(15,'2018-10-05 22:00:00','Sinalização de Trânsito',1),(16,'2018-10-06 21:00:00','Perigos no Trânsito',2),(17,'2018-10-06 20:00:00','Educação no Trânsito',1),(18,'2018-10-06 22:00:00','Tema Livre',2);
/*!40000 ALTER TABLE `aula_teorica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula_teorica_has_aluno`
--

DROP TABLE IF EXISTS `aula_teorica_has_aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aula_teorica_has_aluno` (
  `aula_teorica_id` int(11) NOT NULL,
  `aluno_matricula` int(11) NOT NULL,
  PRIMARY KEY (`aula_teorica_id`,`aluno_matricula`),
  KEY `fk_aula_teorica_has_aluno_aluno1_idx` (`aluno_matricula`),
  KEY `fk_aula_teorica_has_aluno_aula_teorica1_idx` (`aula_teorica_id`),
  CONSTRAINT `fk_aula_teorica_has_aluno_aluno1` FOREIGN KEY (`aluno_matricula`) REFERENCES `aluno` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aula_teorica_has_aluno_aula_teorica1` FOREIGN KEY (`aula_teorica_id`) REFERENCES `aula_teorica` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula_teorica_has_aluno`
--

LOCK TABLES `aula_teorica_has_aluno` WRITE;
/*!40000 ALTER TABLE `aula_teorica_has_aluno` DISABLE KEYS */;
INSERT INTO `aula_teorica_has_aluno` VALUES (1,6),(2,6),(3,6),(4,6),(17,6),(18,7);
/*!40000 ALTER TABLE `aula_teorica_has_aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(25) NOT NULL,
  `senha` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (8,'Admin','Admin'),(9,'brunaboalento','123456'),(10,'anamaria','123456'),(11,'belmirosouza','123456'),(17,'claralucia','987654'),(18,'paulo_afonso','654321'),(19,'marcosgamarano','123456'),(25,'adrianowerpel','123456789012'),(26,'patriciamedeiros','123456789012');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `situacao` varchar(15) NOT NULL,
  `avista` tinyint(4) NOT NULL,
  `valor` decimal(10,0) NOT NULL,
  `num_parcelas` int(11) DEFAULT NULL,
  `valor_parcelas` decimal(10,0) DEFAULT NULL,
  `aluno_matricula` int(11) NOT NULL,
  `data_pagamento` date NOT NULL,
  `qtd_aula_pratica` int(11) NOT NULL,
  `qtd_aula_teorica` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pagamento_aluno1_idx` (`aluno_matricula`),
  CONSTRAINT `fk_pagamento_aluno1` FOREIGN KEY (`aluno_matricula`) REFERENCES `aluno` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (6,'PAGO',0,800,3,267,6,'2018-10-05',5,5),(8,'PAGO',1,1500,NULL,NULL,7,'2018-10-06',15,20);
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `data_nascimento` date NOT NULL,
  `logradouro` varchar(50) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `tipo_pessoa` enum('atendente','administrador') NOT NULL,
  `login_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pessoa_login1_idx` (`login_id`),
  CONSTRAINT `fk_pessoa_login1` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Geraldo Magela','1970-10-20','Avenida Rio Branco ','1045','Centro','Juiz de Fora','MG','administrador',8),(2,'Bruna Boalento Silva','2002-10-20','Rua Badi Geara','897','Ipiranga','Juiz de Fora','MG','atendente',9);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `login_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_professor_login1_idx` (`login_id`),
  CONSTRAINT `fk_professor_login1` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (1,'Ana Maria da Silva','ana_maria@gmail.com',10),(2,'Belmiro de Souza Silva','belmiro.souza@yahoo.com.br',11),(3,'Clara Lucia Medeiros','claralucia@gmail.com',17),(4,'Paulo Afonso Medeiros','paulo_afonso@bol.com.br',18);
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-09 17:24:06
