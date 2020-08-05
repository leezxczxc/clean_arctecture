DROP TABLE IF EXISTS billionaires;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(40) NOT NULL,
  nickname VARCHAR(40) NOT NULL,
  email VARCHAR(255) DEFAULT NULL
);

INSERT INTO user (username, nickname, email) VALUES
  ('tester1', 'nick1', 'tester1@test.com'),
  ('tester2', 'nick2', 'tester2@test.com'),
  ('tester3', 'nick3', 'tester3@test.com');