CREATE TABLE `user` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`account_id` VARCHAR(50) NULL DEFAULT NULL,
	`name` VARCHAR(10) NULL DEFAULT NULL,
	`bio` VARCHAR(255) NULL DEFAULT NULL COMMENT '简介',
	`token` VARCHAR(50) NULL DEFAULT NULL,
	`gmt_create` VARCHAR(20) NULL DEFAULT NULL,
	`gmt_modified` VARCHAR(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)