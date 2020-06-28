CREATE TABLE parking_space (
  parking_space_id INT AUTO_INCREMENT  PRIMARY KEY,
  lot VARCHAR(250) NOT NULL,
  location VARCHAR(250) NOT NULL
  );

ALTER TABLE parking_space
ADD FOREIGN KEY (parking_space_id)
REFERENCES parking_space(parking_space_id);