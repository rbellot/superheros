DROP TABLE IF EXISTS superhero;

CREATE TABLE superhero (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  skill VARCHAR(50),
  weight INTEGER
);

INSERT INTO superhero (name, skill, weight) VALUES
  ('Superman', 'Vuela', 85),
  ('Spiderman', 'Salta', 105),
  ('Manolito el fuerte', 'Pega', 71);