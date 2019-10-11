CREATE TABLE `community`.`question`(
  `id` INT(50) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `description` TEXT NOT NULL,
  `gmt_create` DATETIME NOT NULL,
  `gmt_modified` DATETIME NOT NULL,
  `creator` VARCHAR(50) NOT NULL,
  `view_count` INT(16) NOT NULL,
  `like_count` INT(16) NOT NULL,
  `comment_count` INT(16) NOT NULL,
  `tag` VARCHAR(256),
   KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
