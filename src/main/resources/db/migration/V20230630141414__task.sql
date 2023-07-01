CREATE TABLE user1(
    id BIGSERIAL PRIMARY KEY,
    role TEXT NOT NULL,
    username TEXT NOT NULL,
    password TEXT NOT NULL);

CREATE INDEX user1_username_idx ON user1(username);

CREATE TABLE task1(
    id BIGSERIAL PRIMARY KEY,
    task TEXT NOT NUll,
    student_id BIGSERIAL,
    date DATE NOT NULL,
    done boolean NOT NULL DEFAULT FALSE);

CREATE INDEX task1_student_id_idx ON task1(student_id);
CREATE INDEX task1_done_idx ON task1(done);