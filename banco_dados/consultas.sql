SET SQL_SAFE_UPDATES = 0;

SET AUTOCOMMIT = 0;

SHOW DATABASES;

ALTER TABLE mysql.user
ADD COLUMN senha	VARCHAR(255) NOT NULL
AFTER authentication_string;

ALTER TABLE mysql.user DROP COLUMN senha;

GRANT ALL ON music_project.* TO "administrador"@"localhost";

UPDATE mysql.user
	SET authentication_string = "mudar@123";

SELECT user, authentication_string FROM mysql.user
	WHERE user = "administrador";

SHOW GRANTS FOR "administrador"@"localhost";
