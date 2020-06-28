CREATE TABLE emp_proj (
  emp_id INT,
  proj_id INT
  );

ALTER TABLE emp_proj
ADD FOREIGN KEY (emp_id)
REFERENCES employees(employee_id);
