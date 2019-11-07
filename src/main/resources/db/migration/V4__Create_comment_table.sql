CREATE TABLE `community`.`comment`(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `parent_id` BIGINT NOT NULL COMMENT '父类id',
  `type` INT NOT NULL COMMENT '父类类型',
  `commentor` VARCHAR(50) NOT NULL COMMENT '评论人的accountID',
  `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
  `gmt_modified` DATETIME NOT NULL COMMENT '更新时间',
  `like_count` INT DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY (`commentor`)
) ENGINE=INNODB CHARSET=utf8;