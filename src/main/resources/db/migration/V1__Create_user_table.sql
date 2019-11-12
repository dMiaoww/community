CREATE TABLE `user` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `accountID` varchar(50) DEFAULT NULL,
  `token` varchar(50) DEFAULT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  `gmtModified` datetime DEFAULT NULL,
  `bio` varchar(256) DEFAULT NULL,
  `avatar_url` varchar(100) NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  CHARSET=utf8