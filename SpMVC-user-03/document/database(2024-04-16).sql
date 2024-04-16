-- userDB
USE userDB;
SHOW TABLES;
DROP TABLE tbl_rols;
DROP TABLE tbl_users;
SELECT * FROM tbl_users;
SELECT * FROM tbl_rols;

SELECT * FROM tbl_users U
	JOIN tbl_rols R
		ON U.username = R.r_username;
        
DELETE FROM tbl_users WHERE username = 'callor';
DELETE FROM tbl_users WHERE username = 'callor88';
SELECT LENGTH(password) FROM tbl_users;
