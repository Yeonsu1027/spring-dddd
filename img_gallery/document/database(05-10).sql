CREATE DATABASE 0510galleryDB;
USE 0510galleryDB;

CREATE TABLE tbl_gallerys(
g_id varchar(125) PRIMARY KEY,
g_email varchar(125)  ,
g_password varchar(125)  ,
g_date varchar(10) ,
g_time varchar(10) ,
g_subject varchar(50) ,
g_content varchar(255) ,
g_origin_image varchar(255) ,
g_up_image varchar(255)
);

CREATE TABLE tbl_images(
i_id varchar(125) PRIMARY KEY,
i_gid varchar(125) ,
i_origin_image varchar(255) ,
i_up_image varchar(255)
);