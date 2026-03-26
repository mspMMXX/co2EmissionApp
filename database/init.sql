-- MySQL dump 10.13  Distrib 9.6.0, for Linux (aarch64)
--
-- Host: localhost    Database: co2-mysql
-- ------------------------------------------------------
-- Server version	9.6.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (1,'markus','test123'),(2,'testuser','1234');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_emission`
--

DROP TABLE IF EXISTS `country_emission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country_emission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(255) NOT NULL,
  `year` int NOT NULL,
  `co2_emission` double DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_country_year` (`country`,`year`),
  KEY `fk_created_by` (`created_by`),
  CONSTRAINT `fk_created_by` FOREIGN KEY (`created_by`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=476 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_emission`
--

LOCK TABLES `country_emission` WRITE;
/*!40000 ALTER TABLE `country_emission` DISABLE KEYS */;
INSERT INTO `country_emission` VALUES (237,'Africa Eastern and Southern',2020,4359620024,NULL),(238,'Afghanistan',2020,6967576,NULL),(239,'Africa Western and Central',2020,172732488,NULL),(240,'Angola',2020,158516,NULL),(241,'Albania',2020,350656,NULL),(242,'Andorra',2020,3591075192,NULL),(243,'Arab League states',2020,141204232,NULL),(244,'United Arab Emirates',2020,15047096,NULL),(245,'Argentina',2020,12362872,NULL),(246,'Armenia',2020,539728,NULL),(247,'Antigua and Barbuda',2020,37968,NULL),(248,'Australia',2020,30319744,NULL),(249,'Austria',2023,12345.67,1),(250,'Azerbaijan',2020,274440,NULL),(251,'Burundi',2020,5707728,NULL),(252,'Belgium',2020,6829128,NULL),(253,'Benin',2020,638432,NULL),(254,'Burkina Faso',2020,436536,NULL),(255,'Bangladesh',2020,6839448,NULL),(256,'Bulgaria',2020,2731048,NULL),(257,'Bahrain',2020,2597616,NULL),(258,'Bosnia and Herzegovina',2020,1675744,NULL),(259,'Belarus',2020,438412,NULL),(260,'Belize',2020,55008,NULL),(261,'Bolivia',2020,1470024,NULL),(262,'Brazil',2020,33131104,NULL),(263,'Barbados',2020,876856,NULL),(264,'Brunei',2020,76704,NULL),(265,'Bhutan',2020,82816,NULL),(266,'Botswana',2020,46109496,NULL),(267,'Central African Republic',2020,18928,NULL),(268,'Canada',2020,41349896,NULL),(269,'Central Europe and the Baltics',2020,478792016,NULL),(270,'Switzerland',2020,2793288,NULL),(271,'Chile',2020,6786224,NULL),(272,'China',2020,875574896,NULL),(273,'Cote d\'Ivoire',2020,871592,NULL),(274,'Cameroon',2020,794272,NULL),(275,'Congo',2020,572312,NULL),(276,'Colombia',2020,6324608,NULL),(277,'Comoros',2020,26256,NULL),(278,'Cape Verde',2020,49648,NULL),(279,'Costa Rica',2020,557392,NULL),(280,'Caribbean small states',2020,26221592,NULL),(281,'Cuba',2020,1946224,NULL),(282,'Cyprus',2020,541744,NULL),(283,'Czech Republic',2020,7106816,NULL),(284,'Germany',2020,4826804,NULL),(285,'Djibouti',2020,34216,NULL),(286,'Dominica',2020,13024,NULL),(287,'Denmark',2020,218852,NULL),(288,'Dominican Republic',2020,1830504,NULL),(289,'Algeria',2020,1292504,NULL),(290,'East Asia & Pacific',2020,1012855856,NULL),(291,'Early-demographic dividend',2020,54445186456,NULL),(292,'East Asia & Pacific (all income levels)',2020,1176650848,NULL),(293,'Europe & Central Asia',2020,226457184,NULL),(294,'Europe & Central Asia (all income levels)',2020,45134181603936,NULL),(295,'Ecuador',2020,275448,NULL),(296,'Egypt',2020,16860184,NULL),(297,'Euro area',2020,1498268416,NULL),(298,'Eritrea',2020,56512,NULL),(299,'Spain',2020,16216464,NULL),(300,'Estonia',2020,5678016,NULL),(301,'Ethiopia',2020,144784,NULL),(302,'European Union',2020,1972020336,NULL),(303,'Fragile and conflict affected situations',2020,6074619408,NULL),(304,'Finland',2020,2906392,NULL),(305,'Fiji',2020,82256,NULL),(306,'France',2020,21372376,NULL),(307,'Micronesia',2020,860,NULL),(308,'Gabon',2020,427936,NULL),(309,'United Kingdom',2020,24692024,NULL),(310,'Georgia',2020,82040,NULL),(311,'Ghana',2020,15520928,NULL),(312,'Guinea',2020,363032,NULL),(313,'Guinea-Bissau',2020,2632,NULL),(314,'Equatorial Guinea',2020,348032,NULL),(315,'Greece',2020,4080176,NULL),(316,'Grenada',2020,2596,NULL),(317,'Guatemala',2020,1349216,NULL),(318,'Guyana',2020,22148,NULL),(319,'High income',2020,86919976563936,NULL),(320,'Honduras',2020,706832,NULL),(321,'Heavily indebted poor countries (HIPC)',2020,1799973088,NULL),(322,'Croatia',2020,1250152,NULL),(323,'Haiti',2020,2567232,NULL),(324,'Hungary',2020,3581544,NULL),(325,'IBRD only',2020,167620906456,NULL),(326,'IDA & IBRD total',2020,174903791544,NULL),(327,'IDA total',2020,7282885088,NULL),(328,'IDA blend',2020,37224112,NULL),(329,'Indonesia',2020,4505576,NULL),(330,'IDA only',2020,3560473888,NULL),(331,'India',2020,176066904,NULL),(332,'Ireland',2020,2699376,NULL),(333,'Iran',2020,49324904,NULL),(334,'Iraq',2020,1308092,NULL),(335,'Iceland',2020,115728,NULL),(336,'Israel',2020,4677744,NULL),(337,'Italy',2020,22502944,NULL),(338,'Jamaica',2020,466848,NULL),(339,'Jordan',2020,1677928,NULL),(340,'Japan',2020,81125176,NULL),(341,'Kazakhstan',2020,16951736,NULL),(342,'Kenya',2020,1555744,NULL),(343,'Kyrgyz Republic',2020,726408,NULL),(344,'Cambodia',2020,1492224,NULL),(345,'Kiribati',2020,4552,NULL),(346,'St. Kitts and Nevis',2020,1848,NULL),(347,'Korea',2020,45574544,NULL),(348,'Kuwait',2020,7384712,NULL),(349,'Latin America & Caribbean',2020,993760048,NULL),(350,'Lao PDR',2020,1534312,NULL),(351,'Lebanon',2020,1717992,NULL),(352,'Liberia',2020,9436,NULL),(353,'Libya',2020,355736,NULL),(354,'St. Lucia',2020,39936,NULL),(355,'Latin America & Caribbean (all income levels)',2020,1150464024,NULL),(356,'Least developed countries: UN classification',2020,2809843808,NULL),(357,'Low income',2020,1437319488,NULL),(358,'Liechtenstein',2020,1135968744,NULL),(359,'Sri Lanka',2020,1747704,NULL),(360,'Lower middle income',2020,385567664,NULL),(361,'Low & middle income',2020,171066049944,NULL),(362,'Lesotho',2020,184952,NULL),(363,'Late-demographic dividend',2020,12390678096,NULL),(364,'Lithuania',2020,935504,NULL),(365,'Luxembourg',2020,628248,NULL),(366,'Latvia',2020,554264,NULL),(367,'Morocco',2020,533756,NULL),(368,'Moldova',2020,688896,NULL),(369,'Madagascar',2020,219636,NULL),(370,'Maldives',2020,11632,NULL),(371,'Middle East & North Africa (all income levels)',2020,193285192,NULL),(372,'Mexico',2020,30650512,NULL),(373,'Marshall Islands',2020,880,NULL),(374,'Middle income',2020,169628730456,NULL),(375,'North Macedonia',2020,543736,NULL),(376,'Mali',2020,332056,NULL),(377,'Malta',2020,128856,NULL),(378,'Myanmar',2020,2709968,NULL),(379,'Middle East & North Africa',2020,10967512,NULL),(380,'Montenegro',2020,202176,NULL),(381,'Mongolia',2020,1694776,NULL),(382,'Mozambique',2020,55564,NULL),(383,'Mauritania',2020,307768,NULL),(384,'Mauritius',2020,297616,NULL),(385,'Malawi',2020,13120,NULL),(386,'Malaysia',2020,19611144,NULL),(387,'North America',2020,386992496,NULL),(388,'Namibia',2020,316224,NULL),(389,'Niger',2020,175836,NULL),(390,'Nigeria',2020,8958248,NULL),(391,'Nicaragua',2020,366576,NULL),(392,'Netherlands',2020,10425208,NULL),(393,'Norway',2020,2894192,NULL),(394,'Nepal',2020,1195936,NULL),(395,'Nauru',2020,3312,NULL),(396,'New Zealand',2020,2508776,NULL),(397,'OECD members',2020,8456620576,NULL),(398,'Oman',2020,568332,NULL),(399,'Other small states',2020,1453425656,NULL),(400,'Pakistan',2020,14728896,NULL),(401,'Panama',2020,766616,NULL),(402,'Peru',2020,3726312,NULL),(403,'Philippines',2020,10677704,NULL),(404,'Palau',2020,12656,NULL),(405,'Papua New Guinea',2020,43932,NULL),(406,'Poland',2020,22337904,NULL),(407,'Pre-demographic dividend',2020,3755952288,NULL),(408,'Dem. People\'s Rep. Korea',2020,4194976,NULL),(409,'Portugal',2020,311788,NULL),(410,'Paraguay',2020,606056,NULL),(411,'Pacific island small states',2020,17424,NULL),(412,'Post-demographic dividend',2020,7644664296,NULL),(413,'Qatar',2020,7006264,NULL),(414,'Romania',2020,549312,NULL),(415,'Russia',2020,12946168,NULL),(416,'Rwanda',2020,11056,NULL),(417,'South Asia',2020,2014747816,NULL),(418,'Saudi Arabia',2020,41084464,NULL),(419,'Sudan',2020,1663688,NULL),(420,'Senegal',2020,854416,NULL),(421,'Singapore',2020,349640,NULL),(422,'Solomon Islands',2020,17864,NULL),(423,'Sierra Leone',2020,8384,NULL),(424,'El Salvador',2020,510104,NULL),(425,'Somalia',2020,52832,NULL),(426,'Serbia',2020,3705944,NULL),(427,'Sub-Saharan Africa',2020,6082155304,NULL),(428,'South Sudan',2020,139416,NULL),(429,'Sub-Saharan Africa (all income levels)',2020,6086944904,NULL),(430,'Small states',2020,1733065576,NULL),(431,'Sao Tome and Principe',2020,11288,NULL),(432,'Suriname',2020,2081056,NULL),(433,'Slovak Republic',2020,2322864,NULL),(434,'Slovenia',2020,998184,NULL),(435,'Sweden',2020,2686088,NULL),(436,'Swaziland',2020,91816,NULL),(437,'Seychelles',2020,47896,NULL),(438,'Syrian Arab Republic',2020,2018768,NULL),(439,'Chad',2020,125472,NULL),(440,'East Asia & Pacific (IDA & IBRD)',2020,1008664192,NULL),(441,'Europe & Central Asia (IDA & IBRD)',2020,25553836,NULL),(442,'Togo',2020,193208,NULL),(443,'Thailand',2020,21238312,NULL),(444,'Tajikistan',2020,746304,NULL),(445,'Turkmenistan',2020,509240,NULL),(446,'Latin America & Caribbean (IDA & IBRD)',2020,1128160128,NULL),(447,'Timor-Leste',2020,35688,NULL),(448,'Middle East & North Africa (IDA & IBRD)',2020,10967512,NULL),(449,'Tonga',2020,9448,NULL),(450,'South Asia (IDA & IBRD)',2020,2014747816,NULL),(451,'Sub-Saharan Africa (IDA & IBRD)',2020,6086944904,NULL),(452,'Trinidad and Tobago',2020,123360,NULL),(453,'Tunisia',2020,234344,NULL),(454,'Turkey',2020,32592496,NULL),(455,'Tuvalu',2020,528,NULL),(456,'Tanzania',2020,115484,NULL),(457,'Uganda',2020,453968,NULL),(458,'Ukraine',2020,13253088,NULL),(459,'Upper middle income',2020,131071964056,NULL),(460,'Uruguay',2020,521144,NULL),(461,'United States',2020,34564260,NULL),(462,'Uzbekistan',2020,9246224,NULL),(463,'St. Vincent and the Grenadines',2020,17584,NULL),(464,'Venezuela',2020,580072,NULL),(465,'Vietnam',2020,28425848,NULL),(466,'Vanuatu',2020,9704,NULL),(467,'World',2020,26853142072,NULL),(468,'Samoa',2020,1652,NULL),(469,'Yemen',2020,796808,NULL),(470,'South Africa',2020,31459328,NULL),(471,'Zambia',2020,608568,NULL),(472,'Zimbabwe',2020,66500,NULL),(473,'Testland',2025,3248394.23,1),(474,'Testland 3',0,2382340293423,1),(475,'Testland 4',2025,23480920234.234,1);
/*!40000 ALTER TABLE `country_emission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-26 10:53:25
