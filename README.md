# CONTACTS


~~~
CREATE database contacts;
USE contacts;

CREATE TABLE contact(
 id INT PRIMARY KEY AUTO_INCREMENT,   
    name VARCHAR(35) NOT NULL,
    email VARCHAR(60) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO contact (name, email, phone)
VALUES 
('Martin', 'martin@gmail.com', '0908888444'),
('Zuzka', 'zuzka@gmail.com', '0911444111');

SELECT * FROM contact;
~~~

