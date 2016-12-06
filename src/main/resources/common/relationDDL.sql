CREATE DATABASE `relation` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `relation`.`relation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `keyword` varchar(256) NOT NULL,
  `relation` longtext NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `keyword_UNIQUE` (`keyword`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
