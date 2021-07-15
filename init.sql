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


/*
    관리 정보 / 단일
*/
CREATE TABLE management{ 
    id INT PRIMARY KEY AUTO_INCREMENT,
    join_dt DATETIME NOT NULL
}/*Engine?*/;

/*
    소셜 로그인 정보 / 단일? 복수?
*/
CREATE TABLE sns_info{
    sns_platform VARCHAR(10) NOT NULL,
    sns_token NOT NULL,
    sns_id INT,
    FOREIGN KEY (sns_id) REFERENCES management (id)
};

/*
    유저 프로필 정보 / 단일
*/
CREATE TABLE user_profile{
    user_photo BLOB,
    user_name NVARCHAR(20) NOT NULL,
    user_nickname NVARCHAR(40),
    user_email NVARCHAR(40),
    user_country CHAR(3) NOT NULL,
    user_gender CHAR(1) NOT NULL,
    user_live VARCHAR(100), /* 비공개 가능 */
    user_desc NVARCHAR(4000) /* 미입력 가능 */,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES management (id)
}

/*
    언어 테이블 / 단일
*/
CREATE TABLE languages{
    korean CHAR(1) NOT NULL,
    english CHAR(1) NOT NULL,
    french CHAR(1) NOT NULL,
    japanese CHAR(1) NOT NULL,
    chinese  CHAR(1) NOT NULL
    lang_id INT,
    FOREIGN KEY (lang_id) REFERENCES management (id)
}


/*
    로그 테이블 / 단일? 복수?
*/
CREATE TABLE logs{
    login_time DATETIME,
    login_status VARCHAR(45),
    log_id INT,
    FOREIGN KEY (log_id) REFERENCES management (id)
};