CREATE TABLE common_topic (
	id INT AUTO_INCREMENT,
	name VARCHAR(40) NOT NULL,
    PRIMARY KEY(id)
) ;

CREATE TABLE topic (
	id INT AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    common_topic_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (common_topic_id)  REFERENCES common_topic (id)
) ;

CREATE TABLE conference (
	id INT AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    common_topic_id INT NOT NULL,
    date DATETIME NOT NULL,
    location VARCHAR(60),
    PRIMARY KEY(id),
    FOREIGN KEY (common_topic_id)  REFERENCES common_topic (id)
) ;

CREATE TABLE user (
	id INT AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    surname VARCHAR(40) NOT NULL,
    address VARCHAR(60),
    email VARCHAR(40) UNIQUE,
    password VARCHAR(32) NOT NULL,
    admin_privilegies BOOLEAN NOT NULL,
    PRIMARY KEY(id)
) ;

CREATE TABLE speaker (
	id INT AUTO_INCREMENT,
    user_id INT NOT NULL,
    topic_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (user_id)  REFERENCES user (id),
    FOREIGN KEY (topic_id)  REFERENCES topic (id)
) ;

CREATE TABLE user_conference (
	id INT AUTO_INCREMENT,
    user_id INT NOT NULL,
    conference_id INT NOT NULL,
    isArrived BOOLEAN NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (user_id)  REFERENCES user (id),
    FOREIGN KEY (conference_id)  REFERENCES conference (id)
) ;