CREATE DATABASE `relation` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `relation`.`relation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `keyword` varchar(256) NOT NULL,
  `relation` json NOT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `keyword_UNIQUE` (`keyword`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
