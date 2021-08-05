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
    user_auth_token NVARCHAR(50),
    user_name NVARCHAR(50) NOT NULL,
    user_id NVARCHAR(50) NOT NULL,
    user_skin_color INT NOT NULL DEFAULT 0,
    user_skin_role CHAR(1) NOT NULL DEFAULT "S",
    user_join_dt DATETIME NOT NULL
);
/*
alter table user add user_skin_role CHAR(1) NOT NULL DEFAULT "S";
alter table user add user_skin_color INT NOT NULL DEFAULT 0;
*/

CREATE TABLE room(
    global_room_no INT PRIMARY KEY AUTO_INCREMENT,
    room_name NVARCHAR(20) NOT NULL UNIQUE,
    room_code VARCHAR(6) UNIQUE,
    room_present INT NOT NULL DEFAULT 0,
    room_max INT NOT NULL DEFAULT 0,
    room_create_dt DATETIME NOT NULL,
    room_agora_uid VARCHAR(20),
    room_agora_token VARCHAR(139)
);
/*
alter table room add room_agora_uid varchar(20);
alter table room add room_agora_token varchar(139);
*/

CREATE TABLE joining( /*match user and room*/
    joining_user_no INT,
    FOREIGN KEY (joining_user_no) REFERENCES user (global_user_no),
    joining_room_no INT,
    FOREIGN KEY (joining_room_no) REFERENCES room (global_room_no)
);
ALTER TABLE joining ADD PRIMARY KEY (joining_room_no,joining_user_no);/*prevent duplicated pair*/

CREATE TABLE timer(
    timer_subject NVARCHAR(20) NOT NULL,
    timer_start_time DATETIME NOT NULL,
    timer_acc_time INT NOT NULL,
    timer_user_no INT,
    FOREIGN KEY (timer_user_no) REFERENCES user (global_user_no),
    timer_room_no INT,
    FOREIGN KEY (timer_room_no) REFERENCES room (global_room_no)
);

CREATE TABLE board(
    global_board_no INT PRIMARY KEY AUTO_INCREMENT,
    board_user_no INT,
    FOREIGN KEY (board_user_no) REFERENCES user (global_user_no),
    board_room_no INT,
    FOREIGN KEY (board_room_no) REFERENCES room (global_room_no),
    board_title VARCHAR(50) NOT NULL,
    board_content TEXT NOT NULL,
    board_write_dt DATETIME,
    board_edit_dt DATETIME,
    board_notice BOOLEAN NOT NULL,
    board_activate BOOLEAN NOT NULL
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