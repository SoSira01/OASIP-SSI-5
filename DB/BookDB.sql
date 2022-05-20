SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS book DEFAULT CHARACTER SET utf8 ;
USE book ;

CREATE TABLE IF NOT EXISTS `book`.`category` (
  CategoryId INT NOT NULL auto_increment,
  CategoryName VARCHAR(100) NOT NULL,
  Duration INT NOT NULL,
  CategoryDescription VARCHAR(500) NULL,
  PRIMARY KEY (`CategoryId`),
  UNIQUE INDEX CategoryName_UNIQUE (`CategoryName` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `book`.`booking` (
  BookingId INT NOT NULL auto_increment,
  BookingName VARCHAR(100) NOT NULL,
  StartTime DATETIME NOT NULL,
  Email VARCHAR(45) NULL,
  Note VARCHAR(500) NULL,
  Category_CategoryId INT NOT NULL,
  PRIMARY KEY (`BookingId`),
  INDEX fk_booking_Category_idx (`Category_CategoryId` ASC) VISIBLE,
  CONSTRAINT fk_booking_Category
    FOREIGN KEY (`Category_CategoryId`)
    REFERENCES `book`.`category` (`CategoryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into category value(1,'Project Management Clinic','30','ตารางนัดหมายนี้ใช้สำหรับนัดหมาย project management clinic ในวิชา INT221 integrated project I ให้นักศึกษาเตรียมเอกสารที่เกี่ยวข้องเพื่อแสดงระหว่างขอคำปรึกษา'),
     (2,'DevOps/Infra Clinic','30','Use this event category for DevOps/Infra clinic'),
     (3,'Database Clinic','15','ตารางนัดหมายนี้ใช้สำหรับนัดหมาย database clinic ในวิชา INT221 integrated project I'),
     (4,'CLient-side Clinic','30','ตารางนัดหมายนี้ใช้สําหรับนัดหมาย client-side clinic ในวิชา INT221 integrated project I'),
     (5,'Server-side Clinic','30',null);