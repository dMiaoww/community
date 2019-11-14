CREATE TABLE `commentlike`(
  `id` INT NOT NULL AUTO_INCREMENT,
  `collector` VARCHAR(50) NOT NULL COMMENT 'user.accountID',
  `comment_id` INT(50) NOT NULL COMMENT '点赞的评论id',
  KEY (`collector`),
  PRIMARY KEY (`id`)
)ENGINE=INNODB CHARSET=utf8;