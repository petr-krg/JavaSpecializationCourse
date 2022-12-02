-- Новый скрипт в Postgre - [localhost].
-- Дата: 2 дек. 2022 г.
-- Время: 18:32:16

DROP DATABASE IF EXISTS test2 WITH (FORCE); 

CREATE USER test2;
CREATE DATABASE test2 WITH OWNER = test2 ENCODING = 'UTF-8';
GRANT ALL PRIVILEGES ON DATABASE test2 TO test2;