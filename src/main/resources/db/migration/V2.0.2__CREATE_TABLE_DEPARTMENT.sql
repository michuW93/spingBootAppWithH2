CREATE TABLE department (
  department_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  manager VARCHAR(250) NOT NULL,
  mascot VARCHAR(250) DEFAULT NULL
);

ALTER TABLE department
ADD FOREIGN KEY (department_id)
REFERENCES department(department_id);