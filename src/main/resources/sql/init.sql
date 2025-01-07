CREATE TABLE IF NOT EXISTS company
(
    id serial primary key,
    name varchar(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS company_locales
(
    company_id INT REFERENCES company (id),
    lang varchar(2),
    description varchar(255) NOT NULL,
    PRIMARY KEY (company_id, lang)
);

CREATE TABLE IF NOT EXISTS users
(
    id bigserial primary key,
    username varchar(128) NOT NULL UNIQUE,
    birth_date DATE,
    firstname varchar(64),
    lastname varchar(64),
    role varchar(32),
    company_id INT REFERENCES company (id)
);

CREATE TABLE IF NOT EXISTS payment
(
    id bigserial primary key,
    amount INT NOT NULL,
    receiver_id BIGINT NOT NULL REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS chat
(
    id bigserial primary key,
    name varchar(64)
);

CREATE TABLE IF NOT EXISTS users_chat
(
    id bigserial primary key,
    user_id BIGINT REFERENCES users (id),
    chat_id BIGINT REFERENCES chat (id)
);