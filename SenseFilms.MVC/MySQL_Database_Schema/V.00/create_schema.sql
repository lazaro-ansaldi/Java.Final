-- Date: 23/03/2018
-- Database: sense
-- ------------------------------------------------------

-- Create the schema
CREATE DATABASE  IF NOT EXISTS `sense`;
USE `sense`;

-- Table structure for table `user`

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `LastName` varchar(150) NOT NULL,
  `LastLogin` datetime DEFAULT NULL,
  `UserRole` smallint(6) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UserID_UNIQUE` (`ID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

