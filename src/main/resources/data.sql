CREATE TABLE pessoa (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(250) NOT NULL,
cpf VARCHAR(11) NOT NULL,
data_nascimento DATETIME NOT NULL
);

INSERT INTO pessoa (cpf, nome, data_nascimento) VALUES
  ('06917699071', 'Marcos Vinicios', '1980-01-01'),
  ('98309637055', 'Andreia','1985-01-03'),
  ('63627695038', 'Marcos Ferreira','1978-01-01'),
  ('33644514003', 'Bruno Araujo','1975-03-01')  ;