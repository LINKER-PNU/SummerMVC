/***********************************************************
    Summer MVC Eggcation table initializer
    2021-07-17
************************************************************/


/*
    DB 생성 및 사용
*/
CREATE DATABASE summer default CHARACTER SET UTF8;
USE summer;

CREATE TABLE user(
    global_user_no INT PRIMARY KEY AUTO_INCREMENT,
    user_auth_token NVARCHAR(50) NOT NULL DEFAULT "",
    user_name NVARCHAR(50) NOT NULL DEFAULT "",
    user_id NVARCHAR(50) NOT NULL DEFAULT "",
    user_skin_color VARCHAR(10) NOT NULL DEFAULT "FFFFFFFF",
    user_skin_role CHAR(1) NOT NULL DEFAULT "S",
    user_skin_cloth VARCHAR(10) NOT NULL DEFAULT "",
    user_join_dt DATETIME NOT NULL DEFAULT "2000-01-01 00:00:00"
);

CREATE TABLE room(
    global_room_no INT PRIMARY KEY AUTO_INCREMENT,
    room_name NVARCHAR(20) NOT NULL DEFAULT "" UNIQUE,
    room_code VARCHAR(6) NOT NULL DEFAULT "" UNIQUE,
    room_present INT NOT NULL DEFAULT 0,
    room_max INT NOT NULL DEFAULT 0,
    room_create_dt DATETIME NOT NULL DEFAULT "2000-01-01 00:00:00",
    room_agora_uid VARCHAR(20) NOT NULL DEFAULT "",
    room_agora_token VARCHAR(140) NOT NULL DEFAULT ""
);

CREATE TABLE joining( /*match user and room*/
    joining_user_no INT NOT NULL DEFAULT "0",
    FOREIGN KEY (joining_user_no) REFERENCES user (global_user_no),
    joining_room_no INT NOT NULL DEFAULT "0",
    FOREIGN KEY (joining_room_no) REFERENCES room (global_room_no)
);
ALTER TABLE joining ADD PRIMARY KEY (joining_room_no,joining_user_no);/*prevent duplicated pair*/

CREATE TABLE timer(
    global_timer_no INT PRIMARY KEY AUTO_INCREMENT,
    timer_subject NVARCHAR(20) NOT NULL DEFAULT "",
    timer_acc_time INT NOT NULL DEFAULT 0,
    timer_user_no INT NOT NULL DEFAULT 0,
    FOREIGN KEY (timer_user_no) REFERENCES user (global_user_no),
    timer_room_no INT NOT NULL DEFAULT 0,
    FOREIGN KEY (timer_room_no) REFERENCES room (global_room_no)
);

CREATE TABLE board(
    global_board_no INT PRIMARY KEY AUTO_INCREMENT,
    board_user_no INT NOT NULL DEFAULT 0,
    FOREIGN KEY (board_user_no) REFERENCES user (global_user_no),
    board_room_no INT NOT NULL DEFAULT 0,
    FOREIGN KEY (board_room_no) REFERENCES room (global_room_no),
    board_title NVARCHAR(50) NOT NULL DEFAULT "",
    board_content TEXT NOT NULL,
    board_write_dt DATETIME NOT NULL DEFAULT "2000-01-01 00:00:00",
    board_edit_dt DATETIME NOT NULL DEFAULT "2000-01-01 00:00:00",
    board_deadline DATETIME NOT NULL DEFAULT "2000-01-01 00:00:00",
    board_notice BOOLEAN NOT NULL DEFAULT 0,
    board_assignment BOOLEAN NOT NULL DEFAULT 0,
    board_visible BOOLEAN NOT NULL DEFAULT 1
);

CREATE TABLE logs(
    logs_time DATETIME,
    logs_status VARCHAR(45),
    logs_id INT,
    FOREIGN KEY (logs_id) REFERENCES user (global_user_no)
);

USE mysql;
CREATE user 'ghimmk'@'%' identified BY '5857';
GRANT all privileges ON summer.* TO ghimmk@'%';
flush privileges;


/*
CREATE TABLE user(
    global_user_no INT PRIMARY KEY AUTO_INCREMENT,
    user_auth_token NVARCHAR(40),
    user_name NVARCHAR(20) NOT NULL,
    user_id NVARCHAR(20) NOT NULL,
    user_join_dt DATETIME NOT NULL
    user_email NVARCHAR(40),
    user_gender CHAR(1) NOT NULL,
    user_birthday_year INT,
    user_birthday_month INT,
    user_birthday_day INT,
);
*/

/*
CREATE TABLE skin(
    skin_color INT NOT NULL DEFAULT 0,
    skin_role CHAR(1) NOT NULL DEFAULT "S",
    skin_user_no INT,
    FOREIGN KEY (skin_user_no) REFERENCES user (global_user_no)
);*/