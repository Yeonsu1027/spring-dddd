-- Gallery

USE galleryDB;
SELECT * FROM tbl_gallerys;
SELECT g_time,length(g_image) FROM tbl_gallerys ORDER BY g_time DESC;