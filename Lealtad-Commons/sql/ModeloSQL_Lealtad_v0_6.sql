-- MySQL Script generated by MySQL Workbench
-- 12/14/15 16:08:45
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema lealtad_schema
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lealtad_schema` ;

-- -----------------------------------------------------
-- Schema lealtad_schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lealtad_schema` DEFAULT CHARACTER SET utf8 ;
USE `lealtad_schema` ;

-- -----------------------------------------------------
-- Table `lealtad_schema`.`T_COMPANIES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`T_COMPANIES` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`T_COMPANIES` (
  `id_company` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NULL,
  PRIMARY KEY (`id_company`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`CAT_PROFILES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`CAT_PROFILES` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`CAT_PROFILES` (
  `profile_id` INT NOT NULL,
  `profile` VARCHAR(50) NULL,
  `comments` VARCHAR(50) NULL,
  PRIMARY KEY (`profile_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`T_USERS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`T_USERS` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`T_USERS` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `fk_company` INT NOT NULL,
  `fk_profile` INT NOT NULL,
  `user_login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `full_name` VARCHAR(100) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name_1` VARCHAR(45) NULL,
  `last_name_2` VARCHAR(45) NULL,
  `tj_card_number` VARCHAR(45) NULL,
  `tj_account_number` VARCHAR(45) NULL,
  `tj_employer` VARCHAR(45) NULL,
  `tj_origin` VARCHAR(45) NULL,
  `tj_card_type` VARCHAR(45) NULL,
  `tj_product` VARCHAR(45) NULL,
  `tj_reference` VARCHAR(45) NULL,
  `tj_account_status` VARCHAR(45) NULL,
  `tj_card_status` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_T_USERS_T_COMPANIES1_idx` (`fk_company` ASC),
  INDEX `fk_T_USERS_CAT_PROFILES1_idx` (`fk_profile` ASC),
  CONSTRAINT `fk_T_USERS_T_COMPANIES1`
    FOREIGN KEY (`fk_company`)
    REFERENCES `lealtad_schema`.`T_COMPANIES` (`id_company`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_USERS_CAT_PROFILES1`
    FOREIGN KEY (`fk_profile`)
    REFERENCES `lealtad_schema`.`CAT_PROFILES` (`profile_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`CAT_FUNCTIONALITIES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`CAT_FUNCTIONALITIES` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`CAT_FUNCTIONALITIES` (
  `functionality_id` INT NOT NULL,
  `functionality_code` VARCHAR(20) NULL,
  `name` VARCHAR(80) NULL,
  PRIMARY KEY (`functionality_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`REL_PROFILE_FUNCTIONALITY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`REL_PROFILE_FUNCTIONALITY` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`REL_PROFILE_FUNCTIONALITY` (
  `functionality_id` INT NOT NULL,
  `profile_id` INT NOT NULL,
  INDEX `fk_REL_PROFILE_FUNCTIONALITY_CAT_FUNCTIONALITIES_idx` (`functionality_id` ASC),
  INDEX `fk_REL_PROFILE_FUNCTIONALITY_CAT_PROFILES1_idx` (`profile_id` ASC),
  PRIMARY KEY (`functionality_id`, `profile_id`),
  CONSTRAINT `fk_REL_PROFILE_FUNCTIONALITY_CAT_FUNCTIONALITIES`
    FOREIGN KEY (`functionality_id`)
    REFERENCES `lealtad_schema`.`CAT_FUNCTIONALITIES` (`functionality_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_REL_PROFILE_FUNCTIONALITY_CAT_PROFILES1`
    FOREIGN KEY (`profile_id`)
    REFERENCES `lealtad_schema`.`CAT_PROFILES` (`profile_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`CAT_VIEWS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`CAT_VIEWS` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`CAT_VIEWS` (
  `cat_view_id` INT NOT NULL,
  `colors` VARCHAR(100) NULL,
  `logos` VARCHAR(300) NULL,
  `messages` VARCHAR(300) NULL,
  PRIMARY KEY (`cat_view_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`CAT_CLASSIFICATION_USERS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`CAT_CLASSIFICATION_USERS` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`CAT_CLASSIFICATION_USERS` (
  `cat_classification_users_id` INT NOT NULL,
  `parent_classification_id` INT NULL,
  `fk_company` INT NOT NULL,
  `fk_view` INT NULL,
  `class_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NULL,
  PRIMARY KEY (`cat_classification_users_id`),
  INDEX `fk_CAT_CLASSIFICATION1_USERS_T_COMPANIES1_idx` (`fk_company` ASC),
  INDEX `fk_CAT_CLASSIFICATION_USERS_CAT_CLASSIFICATION_USERS1_idx` (`parent_classification_id` ASC),
  INDEX `fk_CAT_CLASSIFICATION_USERS_CAT_VIEWS1_idx` (`fk_view` ASC),
  CONSTRAINT `fk_CAT_CLASSIFICATION1_USERS_T_COMPANIES1`
    FOREIGN KEY (`fk_company`)
    REFERENCES `lealtad_schema`.`T_COMPANIES` (`id_company`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CAT_CLASSIFICATION_USERS_CAT_CLASSIFICATION_USERS1`
    FOREIGN KEY (`parent_classification_id`)
    REFERENCES `lealtad_schema`.`CAT_CLASSIFICATION_USERS` (`cat_classification_users_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CAT_CLASSIFICATION_USERS_CAT_VIEWS1`
    FOREIGN KEY (`fk_view`)
    REFERENCES `lealtad_schema`.`CAT_VIEWS` (`cat_view_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`T_CAMPAIGNS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`T_CAMPAIGNS` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`T_CAMPAIGNS` (
  `campaign_id` INT NOT NULL,
  `fk_company` INT NOT NULL,
  `start_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  `campaign_name` VARCHAR(150) NULL,
  `description` VARCHAR(150) NULL,
  PRIMARY KEY (`campaign_id`),
  INDEX `fk_T_CAMPAIGNS_T_COMPANIES1_idx` (`fk_company` ASC),
  CONSTRAINT `fk_T_CAMPAIGNS_T_COMPANIES1`
    FOREIGN KEY (`fk_company`)
    REFERENCES `lealtad_schema`.`T_COMPANIES` (`id_company`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`CAT_PUBLICATIONS_TYPE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`CAT_PUBLICATIONS_TYPE` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`CAT_PUBLICATIONS_TYPE` (
  `publication_type_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NULL,
  PRIMARY KEY (`publication_type_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`T_PUBLICATIONS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`T_PUBLICATIONS` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`T_PUBLICATIONS` (
  `publication_id` INT NOT NULL,
  `fk_campaign` INT NOT NULL,
  `fk_publication_type` INT NOT NULL,
  `published_date` DATETIME NULL,
  `name` VARCHAR(45) NULL,
  `template_file_path` VARCHAR(45) NULL,
  `template_file_blob` BLOB NULL,
  `data_file_path` VARCHAR(45) NULL,
  `data_file_page` VARCHAR(45) NULL,
  `data_file_blob` BLOB NULL,
  `description` VARCHAR(150) NULL,
  PRIMARY KEY (`publication_id`),
  INDEX `fk_T_NOTIFICATIONS_T_CAMPAIGNS1_idx` (`fk_campaign` ASC),
  INDEX `fk_T_PUBLICATIONS_CAT_PUBLICATIONS_TYPE1_idx` (`fk_publication_type` ASC),
  CONSTRAINT `fk_T_NOTIFICATIONS_T_CAMPAIGNS1`
    FOREIGN KEY (`fk_campaign`)
    REFERENCES `lealtad_schema`.`T_CAMPAIGNS` (`campaign_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_PUBLICATIONS_CAT_PUBLICATIONS_TYPE1`
    FOREIGN KEY (`fk_publication_type`)
    REFERENCES `lealtad_schema`.`CAT_PUBLICATIONS_TYPE` (`publication_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`REL_USERS_CAMPAIGNS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`REL_USERS_CAMPAIGNS` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`REL_USERS_CAMPAIGNS` (
  `campaign_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  INDEX `fk_REL_USERS_CAMPAIGNS_T_CAMPAIGNS1_idx` (`campaign_id` ASC),
  INDEX `fk_REL_USERS_CAMPAIGNS_T_USERS1_idx` (`user_id` ASC),
  PRIMARY KEY (`campaign_id`, `user_id`),
  CONSTRAINT `fk_REL_USERS_CAMPAIGNS_T_CAMPAIGNS1`
    FOREIGN KEY (`campaign_id`)
    REFERENCES `lealtad_schema`.`T_CAMPAIGNS` (`campaign_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_REL_USERS_CAMPAIGNS_T_USERS1`
    FOREIGN KEY (`user_id`)
    REFERENCES `lealtad_schema`.`T_USERS` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`CAT_CLASSIFICATION_CAMPAIGNS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`CAT_CLASSIFICATION_CAMPAIGNS` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`CAT_CLASSIFICATION_CAMPAIGNS` (
  `cat_classification_campaigns_id` INT NOT NULL,
  `parent_classification_id` INT NULL,
  `fk_company` INT NOT NULL,
  `fk_view` INT NULL,
  `class_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NULL,
  `level` INT NOT NULL,
  PRIMARY KEY (`cat_classification_campaigns_id`),
  INDEX `fk_CAT_CLASSIFICATION1_CAMPAIGNS_T_COMPANIES1_idx` (`fk_company` ASC),
  INDEX `fk_CAT_CLASSIFICATION_CAMPAIGNS_CAT_CLASSIFICATION_CAMPAIGN_idx` (`parent_classification_id` ASC),
  INDEX `fk_CAT_CLASSIFICATION_CAMPAIGNS_CAT_VIEWS1_idx` (`fk_view` ASC),
  CONSTRAINT `fk_CAT_CLASSIFICATION1_CAMPAIGNS_T_COMPANIES1`
    FOREIGN KEY (`fk_company`)
    REFERENCES `lealtad_schema`.`T_COMPANIES` (`id_company`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CAT_CLASSIFICATION_CAMPAIGNS_CAT_CLASSIFICATION_CAMPAIGNS1`
    FOREIGN KEY (`parent_classification_id`)
    REFERENCES `lealtad_schema`.`CAT_CLASSIFICATION_CAMPAIGNS` (`cat_classification_campaigns_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CAT_CLASSIFICATION_CAMPAIGNS_CAT_VIEWS1`
    FOREIGN KEY (`fk_view`)
    REFERENCES `lealtad_schema`.`CAT_VIEWS` (`cat_view_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`T_ATTACHED_FILES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`T_ATTACHED_FILES` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`T_ATTACHED_FILES` (
  `attached_file_id` INT NOT NULL AUTO_INCREMENT,
  `fk_publication` INT NOT NULL,
  `is_public` TINYINT(1) NULL,
  `file_name` VARCHAR(45) NULL,
  `file_path` VARCHAR(45) NULL,
  `file_extension` VARCHAR(45) NULL,
  `file_blob` BLOB NULL,
  PRIMARY KEY (`attached_file_id`),
  INDEX `fk_T_ATTACHED_FILES_T_NOTIFICATIONS1_idx` (`fk_publication` ASC),
  CONSTRAINT `fk_T_ATTACHED_FILES_T_NOTIFICATIONS1`
    FOREIGN KEY (`fk_publication`)
    REFERENCES `lealtad_schema`.`T_PUBLICATIONS` (`publication_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`REL_CAMPAIGNS_CLASSIFICATION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`REL_CAMPAIGNS_CLASSIFICATION` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`REL_CAMPAIGNS_CLASSIFICATION` (
  `classification_id` INT NOT NULL,
  `campaign_id` INT NOT NULL,
  PRIMARY KEY (`classification_id`, `campaign_id`),
  INDEX `fk_REL_CAMPAIGNS_CLASSIFICATION_T_CAMPAIGNS1_idx` (`campaign_id` ASC),
  CONSTRAINT `fk_REL_CAMPAIGNS_CLASSIFICATION_CAT_CLASSIFICATION_CAMPAIGNS1`
    FOREIGN KEY (`classification_id`)
    REFERENCES `lealtad_schema`.`CAT_CLASSIFICATION_CAMPAIGNS` (`cat_classification_campaigns_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_REL_CAMPAIGNS_CLASSIFICATION_T_CAMPAIGNS1`
    FOREIGN KEY (`campaign_id`)
    REFERENCES `lealtad_schema`.`T_CAMPAIGNS` (`campaign_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`REL_USERS_CLASSIFICATION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`REL_USERS_CLASSIFICATION` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`REL_USERS_CLASSIFICATION` (
  `classification_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`classification_id`, `user_id`),
  INDEX `fk_REL_USERS_CLASSIFICATION_T_USERS1_idx` (`user_id` ASC),
  CONSTRAINT `fk_REL_USERS_CLASSIFICATION_CAT_CLASSIFICATION_USERS1`
    FOREIGN KEY (`classification_id`)
    REFERENCES `lealtad_schema`.`CAT_CLASSIFICATION_USERS` (`cat_classification_users_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_REL_USERS_CLASSIFICATION_T_USERS1`
    FOREIGN KEY (`user_id`)
    REFERENCES `lealtad_schema`.`T_USERS` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lealtad_schema`.`CAT_PUBLICATION_USER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lealtad_schema`.`CAT_PUBLICATION_USER` ;

CREATE TABLE IF NOT EXISTS `lealtad_schema`.`CAT_PUBLICATION_USER` (
  `publication_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `data` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`publication_id`, `user_id`),
  INDEX `fk_T_PUBLICATIONS_has_T_USERS_T_USERS1_idx` (`user_id` ASC),
  INDEX `fk_T_PUBLICATIONS_has_T_USERS_T_PUBLICATIONS1_idx` (`publication_id` ASC),
  CONSTRAINT `fk_T_PUBLICATIONS_has_T_USERS_T_PUBLICATIONS1`
    FOREIGN KEY (`publication_id`)
    REFERENCES `lealtad_schema`.`T_PUBLICATIONS` (`publication_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_PUBLICATIONS_has_T_USERS_T_USERS1`
    FOREIGN KEY (`user_id`)
    REFERENCES `lealtad_schema`.`T_USERS` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
