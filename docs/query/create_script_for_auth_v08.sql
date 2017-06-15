-- MySQL Script generated by MySQL Workbench
-- Thu Jun 15 23:09:21 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mcp
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema auth
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema auth
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `auth` DEFAULT CHARACTER SET utf8 ;
USE `auth` ;

-- -----------------------------------------------------
-- Table `auth`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auth`.`user` (
  `user_no` INT NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` VARCHAR(50) NOT NULL COMMENT 'ID',
  `user_name` VARCHAR(50) NOT NULL COMMENT '이름',
  `user_type` VARCHAR(20) NOT NULL COMMENT '사용자 구분',
  `phone` VARCHAR(20) NULL COMMENT '전화번호',
  `email` VARCHAR(100) NULL COMMENT 'e-mail',
  `is_active` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '사용 여부',
  `has_privacy` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '개인정보 취급 여부',
  `creator` VARCHAR(50) NOT NULL COMMENT '생성자',
  `create_dt` DATETIME NOT NULL COMMENT '생성일시',
  `updater` VARCHAR(50) NULL COMMENT '수정자',
  `update_dt` DATETIME NULL COMMENT '수정일시',
  `description` VARCHAR(200) NULL COMMENT '설명',
  `memo` VARCHAR(200) NULL COMMENT '메모',
  PRIMARY KEY (`user_no`),
  INDEX `fk_user_user1_idx` (`creator` ASC),
  INDEX `fk_user_user2_idx` (`updater` ASC),
  UNIQUE INDEX `udx_user_id` (`user_id` ASC),
  INDEX `idx_create_dt` (`create_dt` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '사용자';


-- -----------------------------------------------------
-- Table `auth`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auth`.`group` (
  `group_no` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `group_name` VARCHAR(50) NOT NULL COMMENT '그룹명',
  `group_type` VARCHAR(20) NOT NULL COMMENT '권한 그룹 유형',
  `is_active` VARCHAR(1) NOT NULL COMMENT '사용 여부',
  `has_privacy` VARCHAR(1) NOT NULL COMMENT '개인정보 취급 여부',
  `creator` VARCHAR(50) NOT NULL COMMENT '생성자',
  `create_dt` DATETIME NOT NULL COMMENT '생성일시',
  `updater` VARCHAR(50) NULL COMMENT '수정자',
  `update_dt` DATETIME NULL COMMENT '수정일시',
  `description` VARCHAR(200) NULL COMMENT '상세',
  PRIMARY KEY (`group_no`),
  INDEX `fk_group_user1_idx` (`creator` ASC),
  INDEX `fk_group_user2_idx` (`updater` ASC),
  INDEX `idx_group_name` (`group_name` ASC),
  INDEX `idx_create_dt` (`create_dt` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 100000000000
DEFAULT CHARACTER SET = utf8
COMMENT = '그룹'
PACK_KEYS = Default;


-- -----------------------------------------------------
-- Table `auth`.`site_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auth`.`site_code` (
  `site_code_no` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `site_code` VARCHAR(20) NOT NULL COMMENT '사이트 코드',
  `site_name` VARCHAR(50) NOT NULL COMMENT '사이트명',
  PRIMARY KEY (`site_code_no`),
  UNIQUE INDEX `udx_site_code` (`site_code` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '사이트 코드';


-- -----------------------------------------------------
-- Table `auth`.`user_group_relation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auth`.`user_group_relation` (
  `user_no` INT NOT NULL COMMENT 'user FK',
  `group_no` BIGINT(20) NOT NULL COMMENT 'group FK',
  INDEX `fk_user_group_relation_user_idx` (`user_no` ASC),
  INDEX `fk_user_group_relation_group1_idx` (`group_no` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '사용자 그룹 매핑';


-- -----------------------------------------------------
-- Table `auth`.`authority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auth`.`authority` (
  `authority_no` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `site_code_no` INT(11) NOT NULL COMMENT 'site code FK',
  `parent_authority_no` INT(11) NOT NULL,
  `authority_name` VARCHAR(100) NOT NULL COMMENT '권한명',
  `authority_code` VARCHAR(20) NOT NULL COMMENT '권한코드',
  `has_privacy` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '개인정보 취급 여부',
  `view_name` VARCHAR(50) NULL COMMENT '화면이름',
  `view_uri` VARCHAR(200) NULL COMMENT '화면 URI',
  PRIMARY KEY (`authority_no`),
  INDEX `fk_authority_site_code1_idx` (`site_code_no` ASC),
  INDEX `fk_authority_authority1_idx` (`parent_authority_no` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '권한';


-- -----------------------------------------------------
-- Table `auth`.`group_authority_relation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auth`.`group_authority_relation` (
  `group_no` INT(11) NOT NULL COMMENT 'group FK',
  `authority_no` INT(11) NOT NULL COMMENT 'authority FK',
  `readable` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '읽기',
  `writable` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '쓰기',
  `editable` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '수정',
  `deletable` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '삭제',
  `downloadable` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '다운로드',
  INDEX `fk_group_authority_relation_authority1_idx` (`authority_no` ASC),
  INDEX `fk_group_authority_relation_group1_idx` (`group_no` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '그룹 권한 매핑';


-- -----------------------------------------------------
-- Table `auth`.`user_authority_relation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auth`.`user_authority_relation` (
  `user_no` INT NOT NULL COMMENT 'user FK',
  `authority_no` INT(11) NOT NULL COMMENT 'authority FK',
  `readable` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '읽기',
  `writable` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '쓰기',
  `editable` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '수정',
  `deletable` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '삭제',
  `downloadable` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '다운로드',
  INDEX `fk_user_authority_relation_user1_idx` (`user_no` ASC),
  INDEX `fk_user_authority_relation_authority1_idx` (`authority_no` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '사용자 권한 매핑 테이블';


-- -----------------------------------------------------
-- Table `auth`.`resource`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auth`.`resource` (
  `resource_no` INT NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `authority_no` INT(11) NOT NULL COMMENT 'authority FK',
  `resource_name` VARCHAR(50) NOT NULL COMMENT '리소스명',
  `resource_uri` VARCHAR(200) NOT NULL COMMENT '리소스 uri',
  PRIMARY KEY (`resource_no`),
  INDEX `fk_resource_authority1_idx` (`authority_no` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
