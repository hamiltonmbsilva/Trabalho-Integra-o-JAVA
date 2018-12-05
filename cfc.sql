CREATE DATABASE  IF NOT EXISTS `cfc` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cfc`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cfc
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
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `disponivel` tinyint(4) NOT NULL,
  `aula_id` int(11) NOT NULL,
  `aluno_id` int(11) DEFAULT NULL,
  `professor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_agenda_aula1_idx` (`aula_id`),
  KEY `fk_agenda_pessoa1_idx` (`aluno_id`),
  KEY `fk_agenda_pessoa2_idx` (`professor_id`),
  CONSTRAINT `fk_agenda_aula1` FOREIGN KEY (`aula_id`) REFERENCES `aula` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agenda_pessoa1` FOREIGN KEY (`aluno_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agenda_pessoa2` FOREIGN KEY (`professor_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` VALUES (1,0,2,28,31),(2,0,1,28,31);
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aula` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `hora` varchar(5) NOT NULL,
  `tipo_aula_id` int(11) NOT NULL,
  `veiculo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_aula_tipo_aula1_idx` (`tipo_aula_id`),
  KEY `fk_aula_veiculo1_idx` (`veiculo_id`),
  CONSTRAINT `fk_aula_tipo_aula1` FOREIGN KEY (`tipo_aula_id`) REFERENCES `tipo_aula` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aula_veiculo1` FOREIGN KEY (`veiculo_id`) REFERENCES `veiculo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (1,'2018-10-02','12:00',1,2),(2,'2018-10-02','12:00',1,2);
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `validade` date NOT NULL,
  `pessoa_id` int(11) NOT NULL,
  `plano_pagamento_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contrato_pessoa1_idx` (`pessoa_id`),
  KEY `fk_contrato_plano_pagamento1_idx` (`plano_pagamento_id`),
  CONSTRAINT `fk_contrato_pessoa1` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contrato_plano_pagamento1` FOREIGN KEY (`plano_pagamento_id`) REFERENCES `plano_pagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES (21,'2020-03-04',47,2);
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato_has_tipo_aula`
--

DROP TABLE IF EXISTS `contrato_has_tipo_aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrato_has_tipo_aula` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contrato_id` int(11) NOT NULL,
  `tipo_aula_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contrato_has_tipo_aula_tipo_aula1_idx` (`tipo_aula_id`),
  KEY `fk_contrato_has_tipo_aula_contrato1_idx` (`contrato_id`),
  CONSTRAINT `fk_contrato_has_tipo_aula_contrato1` FOREIGN KEY (`contrato_id`) REFERENCES `contrato` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contrato_has_tipo_aula_tipo_aula1` FOREIGN KEY (`tipo_aula_id`) REFERENCES `tipo_aula` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato_has_tipo_aula`
--

LOCK TABLES `contrato_has_tipo_aula` WRITE;
/*!40000 ALTER TABLE `contrato_has_tipo_aula` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato_has_tipo_aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matricula` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pre_matricula` tinyint(4) DEFAULT '1',
  `psicotecnico` tinyint(2) DEFAULT '0',
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `email` varchar(200) NOT NULL,
  `pessoa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_matricula_pessoa1_idx` (`pessoa_id`),
  CONSTRAINT `fk_matricula_pessoa1` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (13,1,1,'tete','12345','teste@teste',14),(14,0,0,'teteyryrururuiu','8578578587\'','tete@tete',27),(15,1,1,'ddd','2344','tetet@gegdgd.com',28),(16,1,1,'fffff','fbb,b,','tetet@gegdgd.com',45),(17,1,1,'jessica','123','ze@botafogosegundadivisao.com.br',48),(18,1,1,'jroza','123','teste@teste',50);
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
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
  `dt_nascimento` date NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `sexo` tinyint(4) NOT NULL DEFAULT '0',
  `ativa` tinyint(4) NOT NULL,
  `tipo_pessoa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pessoa_tipo_pessoa_idx` (`tipo_pessoa_id`),
  CONSTRAINT `fk_pessoa_tipo_pessoa` FOREIGN KEY (`tipo_pessoa_id`) REFERENCES `tipo_pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (14,'tetet','2014-09-09','546464',1,1,3),(27,'Teste ','2010-09-09','12312345678',1,1,3),(28,'Pessoa','2010-09-09','1864758575888',1,1,2),(29,'ddddd','2010-09-09','12312312312',0,1,3),(31,'gordinho','2010-09-09','12312312345',0,1,4),(35,'gordinho','2010-09-09','3435343',0,1,3),(36,'ddddd','2010-09-09','12121212122',0,1,3),(39,'ddddd','2010-09-09','12312312312',0,1,3),(45,'ddddd','2010-09-09','12312312312',0,1,3),(47,'jessica','1990-10-29','kfjfjjfjf',1,1,3),(48,'Contrato','1990-10-29','123112312345',1,1,3),(50,'JÃ©ssica Roza da Silva','2018-01-01','1231231234578',1,1,3);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plano_pagamento`
--

DROP TABLE IF EXISTS `plano_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plano_pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qdt_parcelas` int(11) NOT NULL,
  `valor_total` double NOT NULL,
  `nome` varchar(45) NOT NULL,
  `vencimento` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plano_pagamento`
--

LOCK TABLES `plano_pagamento` WRITE;
/*!40000 ALTER TABLE `plano_pagamento` DISABLE KEYS */;
INSERT INTO `plano_pagamento` VALUES (1,1,1000,'À vista','10'),(2,12,1200,'12 x com juros','15');
/*!40000 ALTER TABLE `plano_pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recebimento`
--

DROP TABLE IF EXISTS `recebimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recebimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `contrato_id` int(11) NOT NULL,
  `valor` double NOT NULL,
  `pago` tinyint(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_recebimento_contrato1_idx` (`contrato_id`),
  CONSTRAINT `fk_recebimento_contrato1` FOREIGN KEY (`contrato_id`) REFERENCES `contrato` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4786 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recebimento`
--

LOCK TABLES `recebimento` WRITE;
/*!40000 ALTER TABLE `recebimento` DISABLE KEYS */;
INSERT INTO `recebimento` VALUES (4772,'2018-10-04',21,100,0),(4773,'2018-10-04',21,100,0),(4774,'2018-10-04',21,100,0),(4775,'2018-10-04',21,100,0),(4776,'2018-10-04',21,100,0),(4777,'2018-10-04',21,100,0),(4778,'2018-10-04',21,100,0),(4779,'2018-10-04',21,100,0),(4780,'2018-10-04',21,100,0),(4781,'2018-10-04',21,100,0),(4782,'2018-10-04',21,100,0),(4784,'2018-10-04',21,100,1),(4785,'2018-10-08',21,100,1);
/*!40000 ALTER TABLE `recebimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_aula`
--

DROP TABLE IF EXISTS `tipo_aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_aula` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `carga_minima` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_aula`
--

LOCK TABLES `tipo_aula` WRITE;
/*!40000 ALTER TABLE `tipo_aula` DISABLE KEYS */;
INSERT INTO `tipo_aula` VALUES (1,'Prática',100),(2,'Teorica',150);
/*!40000 ALTER TABLE `tipo_aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_pessoa`
--

DROP TABLE IF EXISTS `tipo_pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_pessoa`
--

LOCK TABLES `tipo_pessoa` WRITE;
/*!40000 ALTER TABLE `tipo_pessoa` DISABLE KEYS */;
INSERT INTO `tipo_pessoa` VALUES (1,'Administrador'),(2,'Funcionário'),(3,'Aluno'),(4,'Professor');
/*!40000 ALTER TABLE `tipo_pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_veiculo`
--

DROP TABLE IF EXISTS `tipo_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_veiculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_veiculo`
--

LOCK TABLES `tipo_veiculo` WRITE;
/*!40000 ALTER TABLE `tipo_veiculo` DISABLE KEYS */;
INSERT INTO `tipo_veiculo` VALUES (1,'Moto'),(2,'Carro');
/*!40000 ALTER TABLE `tipo_veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veiculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ano` int(11) NOT NULL,
  `placa` varchar(8) NOT NULL,
  `tipo_veiculo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_veiculo_tipo_veiculo1_idx` (`tipo_veiculo_id`),
  CONSTRAINT `fk_veiculo_tipo_veiculo1` FOREIGN KEY (`tipo_veiculo_id`) REFERENCES `tipo_veiculo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES (1,2018,'KAH2222',1),(2,1990,'abc1235',2),(3,2007,'DCJ9898',2);
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'cfc'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-30 19:00:18
