--liquibase formatted sql

--changeset alex:1
CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(64) NOT NULL UNIQUE,
    email VARCHAR(64),
    password VARCHAR(64),
    test VARCHAR(64),
    role VARCHAR(32) NOT NULL
);

--changeset alex:2
INSERT INTO users ("login", "email", "password", "role") VALUES ('demo', 'demo@demo.org', '{noop}123', 'DEMO');
INSERT INTO users ("login", "email", "password", "role") VALUES ('alex', 'alex@rambler.ru', '{noop}123', 'USER');


--changeset alex:3
CREATE TABLE IF NOT EXISTS note
(
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    content VARCHAR(255),
    user_id BIGINT
);

--changeset alex:4
CREATE TABLE IF NOT EXISTS authorities
(
    username  VARCHAR,
    authority VARCHAR
);



