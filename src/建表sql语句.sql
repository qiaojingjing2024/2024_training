CREATE TABLE Books (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL,
                       author VARCHAR(30) NOT NULL,
                       isbn VARCHAR(13) DEFAULT NULL,
                       press VARCHAR(20) DEFAULT NULL,
                       count TINYINT NOT NULL DEFAULT 0,
                       price DOUBLE NOT NULL,
                       borrow_number SMALLINT NOT NULL DEFAULT 0,
                       have_borrowed SMALLINT NOT NULL DEFAULT 0,
                       create_time DATETIME DEFAULT NULL,
                       create_user VARCHAR(50) DEFAULT NULL,
                       PRIMARY KEY (id)
);
CREATE TABLE Administrators (
                                id BIGINT NOT NULL AUTO_INCREMENT,
                                name VARCHAR(50) NOT NULL,
                                username VARCHAR(30) NOT NULL,
                                password VARCHAR(13) NOT NULL,
                                PRIMARY KEY (id)
);
CREATE TABLE Borrowers (
                           id BIGINT NOT NULL AUTO_INCREMENT,
                           name VARCHAR(50) NOT NULL,
                           sex TINYINT NOT NULL CHECK (sex IN (1, 2)),
                           age TINYINT NOT NULL,
                           username VARCHAR(30) NOT NULL,
                           password VARCHAR(13) NOT NULL,
                           PRIMARY KEY (id)
);
CREATE TABLE BorrowingRecords (
                                  id BIGINT NOT NULL AUTO_INCREMENT,
                                  user_id BIGINT NOT NULL,
                                  user_name VARCHAR(50) NOT NULL,
                                  book_id BIGINT NOT NULL,
                                  book_name VARCHAR(50) NOT NULL,
                                  borrow_time DATETIME NOT NULL,
                                  PRIMARY KEY (id),
                                  FOREIGN KEY (user_id) REFERENCES Borrowers(id),
                                  FOREIGN KEY (book_id) REFERENCES Books(id)
);
CREATE TABLE ReturnRecords (
                               id BIGINT NOT NULL AUTO_INCREMENT,
                               user_id BIGINT NOT NULL,
                               user_name VARCHAR(50) NOT NULL,
                               book_id BIGINT NOT NULL,
                               book_name VARCHAR(50) NOT NULL,
                               return_time DATETIME NOT NULL,
                               PRIMARY KEY (id),
                               FOREIGN KEY (user_id) REFERENCES Borrowers(id),
                               FOREIGN KEY (book_id) REFERENCES Books(id)
);