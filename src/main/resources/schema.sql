DROP TABLE IF EXISTS member;
CREATE TABLE member
(
    user_id  		VARCHAR(255) NOT NULL,
    password 		VARCHAR(255) NOT NULL,
    `name`   		VARCHAR(255),
    email    		VARCHAR(255),
    department_id	VARCHAR(255) NOT NULL,
    PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS department;
CREATE TABLE department
(
    department_id  	VARCHAR(255) NOT NULL,
    department_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (department_id)
);
