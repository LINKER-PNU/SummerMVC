/***********************************************************
    Summer MVC Eggcation table initializer
    2021-07-17
************************************************************/


/*
    DB 생성 및 사용
*/
CREATE DATABASE summer default CHARACTER SET UTF8;
USE summer;

/* 권한설정? */

CREATE TABLE user{
    global_user_no INT PRIMARY KEY AUTO_INCREMENT,
    user_id NVARCHAR(20) NOT NULL,
    user_pw NVARCHAR(20) NOT NULL,
    user_name NVARCHAR(20) NOTNULL,
    user_email NVARCHAR(40),
    user_gender CHAR(1) NOT NULL,
    user_birthday_year INT,
    user_birthday_month INT,
    user_birthday_day INT,
    user_join_dt DATETIME NOT NULL
    /*joined room list?*/
}

CREATE TABLE skin{
    skin_user_no INT,
    FOREIGN KEY (skin_user_no) REFERENCES user (global_user_no),
    skin_color INT NOT NULL,
    skin_role CHAR(1) NOT NULL, /*student or teacher*/

}

CREATE TABLE room{
    global_room_no INT PRIMARY KEY AUTO_INCREMENT,
    room_name NVARCHAR(20) NOT NULL,
    room_present INT NOT NULL,
    room_max INT NOT NULL,
    room_create_dt DATETIME NOT NULL
    /*room member list?*/
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