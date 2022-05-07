DROP DATABASE IF EXISTS my_db;
CREATE DATABASE my_db
    DEFAULT CHARSET = utf8;

USE my_db;

CREATE TABLE users
(
    id         BIGINT(10)              NOT NULL AUTO_INCREMENT,
    name       VARCHAR(100)            NOT NULL,
    email      VARCHAR(255)            NOT NULL UNIQUE,
    password   VARCHAR(255)            NOT NULL,
    registered TIMESTAMP DEFAULT now() NOT NULL,
    enabled    BOOLEAN   DEFAULT TRUE  NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB;


CREATE TABLE books
(
    id           BIGINT(10)   NOT NULL AUTO_INCREMENT,
    title        VARCHAR(100) NOT NULL,
    description  VARCHAR(255) NOT NULL,
    author       VARCHAR(100) NOT NULL,
    isbn         VARCHAR(20)  NOT NULL,
    print_year   INT(4)       NOT NULL,
    read_already BOOLEAN      NOT NULL DEFAULT FALSE,
    user_id      BIGINT(10)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
)
    ENGINE = InnoDB;
