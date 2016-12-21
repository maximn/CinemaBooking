CREATE TABLE userTest(user_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, 
user_name VARCHAR(60) NULL, 
user_password VARCHAR(32) NOT NULL, 
user_email VARCHAR(60) NOT NULL, 
user_role VARCHAR(60) NULL, 
PRIMARY KEY (user_id), 
UNIQUE (user_email));