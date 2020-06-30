CREATE TABLE company (
  company_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  street VARCHAR(250),
  city VARCHAR(250),
  province VARCHAR(250),
  postal_code VARCHAR(250)
);