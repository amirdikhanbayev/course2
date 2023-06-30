CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    role TEXT NOT NULL,
    username TEXT NOT NULL,
    password TEXT NOT NULL);

CREATE INDEX user_username_idx ON user(username);