SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `Book` DEFAULT CHARACTER SET utf8 ;
USE `Book` ;

DROP TABLE IF EXISTS `Book`.`Category` ;
CREATE TABLE IF NOT EXISTS `Book`.`Category` (
  `CategoryId` INT NOT NULL,
  `CategoryName` VARCHAR(100) NOT NULL,
  `Duration` INT NOT NULL,
  `CategoryDescription` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`CategoryId`),
  UNIQUE INDEX `CategoryName_UNIQUE` (`CategoryName` ASC) VISIBLE)
ENGINE = InnoDB;

DROP TABLE IF EXISTS `Book`.`booking` ;
CREATE TABLE IF NOT EXISTS `Book`.`booking` (
  `bookingId` INT NOT NULL,
  `bookingName` VARCHAR(100) NOT NULL,
  `StartTime` DATETIME NOT NULL,
  `Email` VARCHAR(45) NULL,
  `Note` VARCHAR(255) NULL,
  `Category_CategoryId` INT NOT NULL,
  PRIMARY KEY (`bookingId`),
  INDEX `fk_booking_Category_idx` (`Category_CategoryId` ASC) VISIBLE,
  CONSTRAINT `fk_booking_Category`
    FOREIGN KEY (`Category_CategoryId`)
    REFERENCES `Book`.`Category` (`CategoryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into Category 
value(1,'Project Management Clinic','30','This is Description');

insert into booking 
value(1,'Somchai Jaidee','2022-04-26 13:30','somchai.jai@kmutt.ac.th','Group 04','1');