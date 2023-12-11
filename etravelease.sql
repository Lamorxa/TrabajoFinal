-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: etravelease_test2
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
-- Table structure for table `empresatransporte`
--

DROP TABLE IF EXISTS `empresatransporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresatransporte` (
  `RucEmpresa` char(11) NOT NULL,
  `NombreEmpresa` varchar(50) NOT NULL,
  `Color` varchar(20) NOT NULL,
  `Estado` enum('activo','inactivo') NOT NULL,
  PRIMARY KEY (`RucEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresatransporte`
--

LOCK TABLES `empresatransporte` WRITE;
/*!40000 ALTER TABLE `empresatransporte` DISABLE KEYS */;
INSERT INTO `empresatransporte` VALUES ('10465106120','EMPRESA CHILINA SAC','negro','activo'),('10465106130','EMPRESA CIUDAD BLANCA SAC','verde','activo'),('10465106140','EMRESA PAUCARPATA TOURS','plomo','activo'),('10465106150','EMPRESA YURA SRL','marron','activo'),('10465106160','EMPRESA JBYR SAC','amarillo','activo'),('10465106170','EMPRESA UNION AQP S.A.','naranja','activo');
/*!40000 ALTER TABLE `empresatransporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `Dni` char(8) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `ApellidoPaterno` varchar(50) NOT NULL,
  `ApellidoMaterno` varchar(50) NOT NULL,
  `Telefono` char(11) NOT NULL,
  `CorreoElectronico` varchar(50) NOT NULL,
  `IdTipoPersona` int(11) NOT NULL,
  `RucEmpresa` char(11) DEFAULT NULL,
  `Estado` enum('activo','inactivo') NOT NULL,
  PRIMARY KEY (`Dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES ('46572845','aaaaa','aaaaaaaaaaaa','aaaaaaaaaa','4444444','aaaaaaaaaa',1,'44444444444','activo'),('49494949','Luis','Quispe','Mamani','984438444','luis1234@gmail.com',1,'10465106120','activo'),('54545454','jud','tadeo','martinelly','948882737','jud@gmail.com',2,NULL,'activo'),('72727272','Jose','Luna','Luenar','948882731','U21213717@utp.edu.pe',3,'10465106120','activo'),('72838393','Sebas','Torres','Tintaya','948882737','torrs@gmail.com',1,NULL,'activo'),('88888888','Juan','Peralta','Jimenez','948882737','JuanPeralta1@gmail.com',3,NULL,'activo');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registroconsumos`
--

DROP TABLE IF EXISTS `registroconsumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registroconsumos` (
  `CodConsumo` int(11) NOT NULL AUTO_INCREMENT,
  `MontoConsumo` decimal(18,2) NOT NULL,
  `CodTarjeta` char(11) NOT NULL,
  `CodUnidad` char(11) NOT NULL,
  `FechaConsumo` datetime NOT NULL,
  `Estado` enum('activo','inactivo') NOT NULL,
  PRIMARY KEY (`CodConsumo`)
) ENGINE=InnoDB AUTO_INCREMENT=1262 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registroconsumos`
--

LOCK TABLES `registroconsumos` WRITE;
/*!40000 ALTER TABLE `registroconsumos` DISABLE KEYS */;
INSERT INTO `registroconsumos` VALUES (1221,1.00,'42424242422','1001','2023-10-23 06:01:53','activo'),(1222,1.00,'42424242423','1002','2023-10-23 06:02:32','activo'),(1223,1.00,'42424242424','1003','2023-10-23 09:22:53','activo'),(1224,1.00,'42424242425','1004','2023-10-23 10:32:08','activo'),(1225,1.00,'42424242426','1005','2023-10-24 09:32:08','activo'),(1226,1.00,'42424242427','1006','2023-10-25 09:32:08','activo'),(1227,1.00,'42424242428','1007','2023-10-26 07:32:08','activo'),(1228,1.00,'42424242429','1007','2023-12-03 13:21:18','activo'),(1229,1.00,'42424242429','1007','2023-12-03 13:22:20','activo'),(1230,1.00,'42424242429','1007','2023-12-03 13:22:00','activo'),(1231,1.00,'42424242429','1006','2023-12-03 13:22:35','activo'),(1232,1.00,'42424242429','1006','2023-12-03 13:22:43','activo'),(1233,1.00,'42424242429','1006','2023-12-03 13:22:50','activo'),(1234,1.00,'42424242429','1006','2023-12-03 13:22:54','activo'),(1235,1.00,'42424242430','1005','2023-12-03 13:26:48','activo'),(1236,1.00,'42424242430','1005','2023-12-03 13:26:55','activo'),(1237,1.00,'42424242430','1005','2023-12-03 13:26:59','activo'),(1238,1.00,'42424242430','1005','2023-12-03 13:27:05','activo'),(1239,1.00,'42424242430','1005','2023-12-03 13:27:09','activo'),(1240,1.00,'42424242430','1005','2023-12-03 13:27:14','activo'),(1241,1.00,'42424242430','1004','2023-12-03 13:27:28','activo'),(1242,1.00,'42424242430','1004','2023-12-03 13:27:33','activo'),(1243,1.00,'42424242430','1004','2023-12-03 13:27:37','activo'),(1244,1.00,'42424242430','1004','2023-12-03 13:27:43','activo'),(1245,1.00,'42424242430','1004','2023-12-03 13:27:48','activo'),(1246,1.00,'42424242430','1003','2023-12-03 13:28:07','activo'),(1247,1.00,'42424242430','1003','2023-12-03 13:28:13','activo'),(1248,1.00,'42424242430','1003','2023-12-03 13:28:21','activo'),(1249,1.00,'42424242430','1003','2023-12-03 13:28:25','activo'),(1250,1.00,'42424242430','1003','2023-12-03 13:28:30','activo'),(1251,1.00,'42424242430','1003','2023-12-03 13:28:34','activo'),(1252,1.00,'42424242430','1002','2023-12-03 13:28:40','activo'),(1253,1.00,'42424242430','1002','2023-12-03 13:28:48','activo'),(1254,1.00,'42424242430','1002','2023-12-03 13:28:52','activo'),(1255,1.00,'42424242430','1002','2023-12-03 13:29:41','activo'),(1256,1.00,'42424242430','1001','2023-12-03 13:29:48','activo'),(1257,1.00,'42424242430','1001','2023-12-03 13:29:52','activo'),(1258,1.00,'42424242430','1001','2023-12-03 13:29:56','activo'),(1259,1.00,'42424242430','1001','2023-12-03 13:30:02','activo'),(1260,1.00,'42424242430','1001','2023-12-03 13:30:08','activo'),(1261,1.00,'42424242424','1001','2023-12-10 17:28:03','activo');
/*!40000 ALTER TABLE `registroconsumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrorecargas`
--

DROP TABLE IF EXISTS `registrorecargas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registrorecargas` (
  `CodRecarga` int(11) NOT NULL AUTO_INCREMENT,
  `MontoRecarga` decimal(18,2) NOT NULL,
  `CodTarjeta` char(11) NOT NULL,
  `FechaRecarga` datetime NOT NULL,
  `Estado` enum('activo','inactivo') NOT NULL,
  PRIMARY KEY (`CodRecarga`),
  KEY `CodTarjeta` (`CodTarjeta`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrorecargas`
--

LOCK TABLES `registrorecargas` WRITE;
/*!40000 ALTER TABLE `registrorecargas` DISABLE KEYS */;
INSERT INTO `registrorecargas` VALUES (1,5.50,'42424242424','2023-10-23 03:13:00','activo'),(2,10.00,'42424242422','2023-10-23 05:56:21','activo'),(3,25.50,'42424242423','2023-10-23 05:56:21','activo'),(4,100.00,'42424242422','2023-10-23 03:10:12','activo'),(5,10.00,'42424242424','2023-10-23 10:15:01','activo'),(6,15.00,'42424242423','2023-10-23 03:18:02','activo'),(7,25.00,'42424242423','2023-10-23 03:22:24','activo'),(8,35.00,'42424242423','2023-10-23 03:30:14','activo'),(9,38.00,'42424242423','2023-12-07 05:37:50','activo'),(10,22.00,'42424242424','2023-12-10 17:26:42','activo'),(11,34.00,'42424242423','2023-12-11 04:03:40','activo'),(12,11.00,'42424242426','2023-12-11 04:08:39','activo'),(13,12.00,'42424242422','2023-12-11 04:25:39','activo');
/*!40000 ALTER TABLE `registrorecargas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportesemp`
--

DROP TABLE IF EXISTS `reportesemp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportesemp` (
  `IdRuta` int(11) NOT NULL AUTO_INCREMENT,
  `NombreRuta` varchar(45) DEFAULT NULL,
  `MontoRuta` decimal(18,2) DEFAULT NULL,
  `RucEmpresa` varchar(45) DEFAULT NULL,
  `NombreEmpresa` varchar(200) DEFAULT NULL,
  `Color` varchar(45) DEFAULT NULL,
  `FechaConsumo` datetime DEFAULT NULL,
  PRIMARY KEY (`IdRuta`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportesemp`
--

LOCK TABLES `reportesemp` WRITE;
/*!40000 ALTER TABLE `reportesemp` DISABLE KEYS */;
INSERT INTO `reportesemp` VALUES (1,'ASA-MIRAFLORES',1.50,'1','EMPRESA DE TRANSPORTES UNION AQP S.A.','anaranjado','2023-10-23 00:00:00'),(2,'JLBR-CERCADO',1.00,'2','chilina','negro','2023-10-23 06:02:32'),(3,'JLBR-cayma',1.50,'3','ECONO','verde','2023-10-23 09:22:53'),(4,'JLBR-caymas',1.00,'4','Paucarpata','morado','2023-10-23 02:32:08'),(5,'JLBR-m2',2.00,'5','yura','gris','2023-10-22 01:32:08'),(6,'Paucarpata',1.00,'6','Correcaminos SRL','marron','2023-10-20 03:30:01');
/*!40000 ALTER TABLE `reportesemp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutas`
--

DROP TABLE IF EXISTS `rutas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rutas` (
  `IdRuta` int(11) NOT NULL AUTO_INCREMENT,
  `NombreRuta` varchar(50) NOT NULL,
  `MontoRuta` decimal(18,2) NOT NULL,
  `estado` enum('activo','inactivo') NOT NULL,
  `RucEmpresa` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`IdRuta`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutas`
--

LOCK TABLES `rutas` WRITE;
/*!40000 ALTER TABLE `rutas` DISABLE KEYS */;
INSERT INTO `rutas` VALUES (1,'ASA-MIRAFLORES',1.00,'activo','10465106120'),(2,'JLBR-CERCADO',1.00,'activo','10465106130'),(3,'JLBR-cayma',1.00,'inactivo','10465106140'),(4,'JLBR-caymas',1.00,'activo','10465106150'),(6,'JLBR-m2',1.00,'activo','10465106160'),(7,'Paucarpata Zona A',1.00,'activo','10465106170');
/*!40000 ALTER TABLE `rutas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetas`
--

DROP TABLE IF EXISTS `tarjetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjetas` (
  `CodTarjeta` char(11) NOT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Saldo` decimal(18,2) NOT NULL,
  `Dni` char(8) NOT NULL,
  `FechaCreacion` datetime NOT NULL,
  `FechaCaducidad` datetime NOT NULL,
  `Estado` enum('activo','inactivo') NOT NULL,
  PRIMARY KEY (`CodTarjeta`),
  KEY `Dni` (`Dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetas`
--

LOCK TABLES `tarjetas` WRITE;
/*!40000 ALTER TABLE `tarjetas` DISABLE KEYS */;
INSERT INTO `tarjetas` VALUES ('42424242422','Debito BCP',130.00,'49494949','2023-10-23 05:51:23','2024-10-23 05:51:23','activo'),('42424242423','Credimas BCP',107.00,'72727272','2023-10-23 05:51:23','2024-10-23 05:51:23','activo'),('42424242424','Debito Interbank',14.50,'88888888','2023-10-23 05:51:23','2024-10-23 05:51:23','activo'),('42424242426','Debito BCP',129.00,'72727272','2023-10-23 05:51:23','2024-10-23 05:51:23','activo');
/*!40000 ALTER TABLE `tarjetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopersona`
--

DROP TABLE IF EXISTS `tipopersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipopersona` (
  `idTipoPersona` int(11) NOT NULL,
  `TipoPersona` varchar(20) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`idTipoPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopersona`
--

LOCK TABLES `tipopersona` WRITE;
/*!40000 ALTER TABLE `tipopersona` DISABLE KEYS */;
INSERT INTO `tipopersona` VALUES (1,'administrador','el encargado de administrar el sistema'),(2,'conductor','Empleado'),(3,'usuario','simple usuario');
/*!40000 ALTER TABLE `tipopersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidades`
--

DROP TABLE IF EXISTS `unidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidades` (
  `CodUnidad` char(11) NOT NULL,
  `Dni` char(8) NOT NULL,
  `IdRuta` int(11) NOT NULL,
  `CodSoat` int(11) NOT NULL,
  `Estado` enum('activo','inactivo') NOT NULL,
  PRIMARY KEY (`CodUnidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidades`
--

LOCK TABLES `unidades` WRITE;
/*!40000 ALTER TABLE `unidades` DISABLE KEYS */;
INSERT INTO `unidades` VALUES ('1001','54545454',1,11223211,'activo'),('1002','46510620',2,11223212,'inactivo'),('1003','46510630',3,11223213,'activo'),('1004','46510640',4,11223214,'activo'),('1005','46510650',5,11223215,'activo'),('1006','46510660',6,11223216,'inactivo'),('1007','46510670',7,11223217,'activo');
/*!40000 ALTER TABLE `unidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `IdUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Dni` char(8) NOT NULL,
  `User` varchar(30) NOT NULL,
  `Contraseña` varchar(50) NOT NULL,
  `estado` enum('activo','inactivo') NOT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'72727272','usuario','123456','activo'),(2,'88888888','juanito','123456','activo'),(6,'54545454','conductor','123456','activo'),(9,'49494949','juanitoalimañan','14252','inactivo'),(10,'54545454','adminsss','123456','inactivo');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'etravelease_test2'
--

--
-- Dumping routines for database 'etravelease_test2'
--
/*!50003 DROP PROCEDURE IF EXISTS `reporteServiciosPasajero` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `reporteServiciosPasajero`(
	IN f_inicial VARCHAR(20),
    IN f_final VARCHAR(20),
    IN m_inicial VARCHAR(100),
    IN m_final VARCHAR(100)
)
BEGIN
	SELECT r.CodConsumo, t.Saldo, t.FechaCreacion, p.Dni, p.Nombres, p.ApellidoPaterno, p.ApellidoMaterno, p.Telefono FROM registroconsumos r
	INNER JOIN tarjetas t ON t.CodTarjeta = r.CodTarjeta
	INNER JOIN personas p ON p.Dni = t.Dni
	WHERE DATE(t.FechaCreacion) BETWEEN f_inicial AND f_final AND t.Saldo BETWEEN m_inicial AND m_final;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `reporteServiciosPorFechas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `reporteServiciosPorFechas`(
	IN f_inicial VARCHAR(20),
    IN f_final VARCHAR(20)
)
BEGIN
	SELECT e.RucEmpresa, e.NombreEmpresa, e.Color, r.NombreRuta, SUM(c.MontoConsumo) AS 'MontoConsumo', c.FechaConsumo FROM empresatransporte e
	INNER JOIN rutas r ON r.RucEmpresa = e.RucEmpresa
	INNER JOIN unidades u ON u.IdRuta = r.IdRuta
	INNER JOIN registroconsumos c ON c.CodUnidad = u.CodUnidad
	WHERE DATE(c.FechaConsumo) BETWEEN f_inicial AND f_final
	GROUP BY e.RucEmpresa;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `reporteTransportistasRutas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `reporteTransportistasRutas`(
	IN f_inicial VARCHAR(20),
    IN f_final VARCHAR(20),
    IN transp VARCHAR(100),
    IN rutas VARCHAR(100)
)
BEGIN
	IF transp = '' AND rutas = '' THEN
		SELECT e.RucEmpresa, e.NombreEmpresa, e.Color, r.NombreRuta, c.MontoConsumo, c.FechaConsumo FROM empresatransporte e
		INNER JOIN rutas r ON r.RucEmpresa = e.RucEmpresa
		INNER JOIN unidades u ON u.IdRuta = r.IdRuta
		INNER JOIN registroconsumos c ON c.CodUnidad = u.CodUnidad
		WHERE DATE(c.FechaConsumo) BETWEEN f_inicial AND f_final;
        -- WHERE DATE(c.FechaConsumo) >= f_inicial AND DATE(c.FechaConsumo) <= f_final;
    ELSE
		SELECT e.RucEmpresa, e.NombreEmpresa, e.Color, r.NombreRuta, c.MontoConsumo, c.FechaConsumo FROM empresatransporte e
		INNER JOIN rutas r ON r.RucEmpresa = e.RucEmpresa
		INNER JOIN unidades u ON u.IdRuta = r.IdRuta
		INNER JOIN registroconsumos c ON c.CodUnidad = u.CodUnidad
		WHERE DATE(c.FechaConsumo) BETWEEN f_inicial AND f_final AND r.NombreRuta = rutas AND e.NombreEmpresa = transp;
        -- WHERE DATE(c.FechaConsumo) >= f_inicial AND DATE(c.FechaConsumo) <= f_final AND r.NombreRuta = rutas AND e.NombreEmpresa = transp;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-11  9:19:29
