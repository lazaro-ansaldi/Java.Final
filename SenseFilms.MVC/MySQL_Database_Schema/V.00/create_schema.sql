-- Date: 23/03/2018
-- Database: sense
-- ------------------------------------------------------
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
  `Email` varchar(100) NOT NULL,
  `IsNewPassword` bit(1) NOT NULL DEFAULT b'0',
  `CreatedOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `IsActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UserID_UNIQUE` (`ID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `auditevent`;

CREATE TABLE `audit_event` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Event` varchar(50) NOT NULL,
  `Description` varchar(150) NOT NULL,
  `CreatedOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Comments` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `web_menu_item`;

CREATE TABLE `web_menu_item` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ItemUrl` varchar(100) DEFAULT NULL,
  `UserRole` smallint(6) NOT NULL DEFAULT '0',
  `Description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `web_menu_subitem`;

CREATE TABLE `web_menu_subitem` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ItemUrl` varchar(100) DEFAULT NULL,
  `UserRole` smallint(6) NOT NULL DEFAULT '0',
  `Description` varchar(100) DEFAULT NULL,
  `MenuItemID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `fk_menu_item_idx` (`MenuItemID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(150) NOT NULL,
  `LastName` varchar(150) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `CreatedOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `IsActive` bit(1) NOT NULL DEFAULT b'1',
  `ClientType` smallint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `sense`.`web_menu_item` 
(`ItemUrl`, `UserRole`, `Description`)
VALUES ('', 1, 'Clients');

INSERT INTO `sense`.`web_menu_item` 
(`ItemUrl`, `UserRole`, `Description`)
VALUES ('', 1, 'Users');

INSERT INTO `sense`.`web_menu_subitem`
(`ItemUrl`, `UserRole`, `Description`, `MenuItemID`)
VALUES ('/sensefilms/ManageClientsController/manageClients', 0, 'Client List', 1);

INSERT INTO `sense`.`web_menu_subitem`
(`ItemUrl`, `UserRole`, `Description`, `MenuItemID`)
VALUES ('/sensefilms/ManageUsersController/newUser', 0, 'Create User', 1);

