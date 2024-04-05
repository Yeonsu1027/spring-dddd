CREATE DATABASE 0401oneDB;
USE 0401oneDB;

CREATE TABLE tbl_iolist(
io_seq INT AUTO_INCREMENT PRIMARY KEY,
io_date VARCHAR(10),
io_time VARCHAR(10),
io_pname VARCHAR(30),
io_input INT,
io_price INT,
io_quan INT,
io_total INT
);


SELECT * FROM tbl_iolist ORDER BY io_date DESC, io_time ASC ;

INSERT INTO tbl_iolist 
(io_date, io_time, io_pname, io_input, io_price , io_quan, io_total)
VALUES ();

UPDATE tbl_iolist
SET io_pname = '고구마깡통0', io_price = 2980, io_input = 2, io_quan = 22
WHERE io_seq = 11;

DROP TABLE tbl_iolist;