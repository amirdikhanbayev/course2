CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    role TEXT NOT NULL,
    username TEXT NOT NULL,
    password TEXT NOT NULL);

CREATE INDEX user_username_idx ON user(username);

CREATE TABLE task(
    id BIGSERIAL PRIMARY KEY,
    task TEXT,
    student_id BIGSERIAL,
    date DATE NOT NULL,
    done BOOLEAN NOT NULL DEFAULT FALSE);

CREATE INDEX task_student_id_idx ON task(student_id);
CREATE INDEX task_done_idx ON task(done);