CREATE TABLE vacation (
  emp_id INT AUTO_INCREMENT,
  start_date VARCHAR(250) NOT NULL,
  days_abs VARCHAR(250)
);

ALTER TABLE vacation
ADD FOREIGN KEY (emp_id)
REFERENCES employees(employee_id);