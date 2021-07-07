/***********************************************************
    Summer MVC member information table initializer 
    2021-07-07
************************************************************/


/*
    DB 생성 및 사용
*/
CREATE DATABASE summer default CHARACTER SET UTF8;
USE summer;

/* 권한설정? */

CREATE TABLE management{
    _id INT PRIMARY KEY AUTO_INCREMENT,
    join_dt DATETIME NOT NULL,
    user_email NVARCHAR(40)
}/*Engine?*/;

CREATE TABLE sns_info{
    sns_platform VARCHAR(10) NOT NULL,
    sns_token NOT NULL,
};

CREATE TABLE user_profile{
    user_photo BLOB,
    user_name NVARCHAR(20) NOT NULL,
    user_nickname NVARCHAR(40),
    /* Languages */
    user_country CHAR(3) NOT NULL,
    user_gender CHAR(1), /*비공개 가능*/
    user_live VARCHAR(100), /*비공개 가능*/
    user_desc NVARCHAR(4000)

}

CREATE TABLE user_log{}