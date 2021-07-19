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
    user_auth_token NVARCHAR(40),
    user_name NVARCHAR(20) NOT NULL,
    user_id NVARCHAR(20) NOT NULL,
    user_join_dt DATETIME NOT NULL
    /*
        user_email NVARCHAR(40),
        user_gender CHAR(1) NOT NULL,
        user_birthday_year INT,
        user_birthday_month INT,
        user_birthday_day INT,
    */
}

CREATE TABLE room{
    global_room_no INT PRIMARY KEY AUTO_INCREMENT,
    room_name NVARCHAR(20) NOT NULL,
    room_code CHAR(5) NOT NULL,
    room_present INT NOT NULL,
    room_max INT NOT NULL,
    room_create_dt DATETIME NOT NULL
}

CREATE TABLE joining{ /*match user and room*/
    joining_user_no INT,
    FOREIGN KEY (joining_user_no) REFERENCES user (global_user_no),
    joining_room_no INT,
    FOREIGN KEY (joining_room_no) REFERENCES room (global_room_no),
}

CREATE TABLE skin{
    skin_color INT NOT NULL,
    skin_role CHAR(1) NOT NULL, /*student or teacher*/
    skin_user_no INT,
    FOREIGN KEY (skin_user_no) REFERENCES user (global_user_no),
}

CREATE TABLE timer{
    timer_subject NVARCHAR(20) NOT NULL,
    timer_start_time DATETIME NOT NULL,
    timer_acc_time INT NOT NULL,
    timer_user_no INT,
    FOREIGN KEY (timer_user_no) REFERENCES user (global_user_no),
    timer_room_no INT,
    FOREIGN KEY (timer_room_no) REFERENCES room (global_room_no),
}

/*
    로그 테이블 / 단일? 복수?
*/
CREATE TABLE logs{
    logs_time DATETIME,
    logs_status VARCHAR(45),
    logs_id INT,
    FOREIGN KEY (logs_id) REFERENCES user (global_user_no)
};