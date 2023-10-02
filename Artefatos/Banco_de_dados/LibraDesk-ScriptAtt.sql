
CREATE TABLE Pessoa
(
  pnome VARCHAR(50) NOT NULL,
  sobrenome VARCHAR(50) NOT NULL,
  id SERIAL NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Bibliotecaria
(
  senha VARCHAR(40) NOT NULL,
  cpf CHAR(14) NOT NULL,
  id_pessoa SERIAL NOT NULL,
  PRIMARY KEY (cpf)
);

ALTER TABLE Bibliotecaria ADD CONSTRAINT id_pessoa_fk 
FOREIGN KEY (id_pessoa) 
REFERENCES Pessoa(id)
ON DELETE CASCADE
ON UPDATE CASCADE;

CREATE TABLE Leitor
(
  telefone_um CHAR(14) NOT NULL,
  telefone_dois CHAR(14),
  cpf CHAR(14) NOT NULL,
  bairro VARCHAR(50) NOT NULL,
  cidade VARCHAR(50) NOT NULL,
  rua VARCHAR(50) NOT NULL,
  numero INT NOT NULL,
  id_pessoa SERIAL NOT NULL,
  PRIMARY KEY (cpf)
  
);

ALTER TABLE Leitor ADD CONSTRAINT id_pessoa_fk 
FOREIGN KEY (id_pessoa) 
REFERENCES Pessoa(id)
ON DELETE CASCADE
ON UPDATE CASCADE;

CREATE TABLE Emprestimo
(
  data_devolucao DATE NOT NULL,
  data_emprestimo DATE NOT NULL,
  multa FLOAT NOT NULL,
  id SERIAL NOT NULL,
  cpf_leitor CHAR(14) NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE Emprestimo ADD CONSTRAINT cpf_leitor_fk 
FOREIGN KEY (cpf_leitor) 
REFERENCES Leitor(cpf)
ON DELETE CASCADE
ON UPDATE CASCADE;

CREATE TABLE Livro
(
  id SERIAL NOT NULL,
  local_biblioteca VARCHAR(30) NOT NULL,
  num_exemplares INT NOT NULL,
  titulo VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Livros_Emprestimo
(
  id_livro INT NOT NULL,
  id_emprestimo INT NOT NULL,
  PRIMARY KEY (id_livro)
  
);

ALTER TABLE Livros_Emprestimo ADD CONSTRAINT id_livro_fk 
FOREIGN KEY (id_livro) 
REFERENCES Livro(id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE Livros_Emprestimo ADD CONSTRAINT id_emprestimo_fk 
FOREIGN KEY (id_emprestimo) 
REFERENCES Emprestimo(id)
ON DELETE CASCADE
ON UPDATE CASCADE;

--Pessoas
INSERT INTO Pessoa (pnome, sobrenome, id)
VALUES
  ('João', 'Silva', 1),
  ('Felipe', 'Oliveira', 2),
  ('Pedro', 'Ferreira', 3),
  ('Ana', 'Oliveira', 4),
  ('Luiz', 'Pereira', 5),
  ('Mariana', 'Rocha', 6),
  ('Carlos', 'Almeida', 7),
  ('Julia', 'Gomes', 8),
  ('Rafael', 'Martins', 9),
  ('Larissa', 'Costa', 10);

--Bibliotecária
INSERT INTO Bibliotecaria (senha, cpf, id_pessoa)
VALUES ('senha1', '111.111.111-11', 1);

INSERT INTO Bibliotecaria (senha, cpf, id_pessoa)
VALUES ('senha2', '222.222.222-22', 2);

INSERT INTO Bibliotecaria (senha, cpf, id_pessoa)
VALUES ('senha3', '333.333.333-33', 3);

INSERT INTO Bibliotecaria (senha, cpf, id_pessoa)
VALUES ('senha4', '444.444.444-44', 4);

INSERT INTO Bibliotecaria (senha, cpf, id_pessoa)
VALUES ('senha5', '555.555.555-55', 5);

INSERT INTO Bibliotecaria (senha, cpf, id_pessoa)
VALUES ('senha6', '666.666.666-66', 6);

INSERT INTO Bibliotecaria (senha, cpf, id_pessoa)
VALUES ('senha7', '777.777.777-77', 7);

INSERT INTO Bibliotecaria (senha, cpf, id_pessoa)
VALUES ('senha8', '888.888.888-88', 8);

INSERT INTO Bibliotecaria (senha, cpf, id_pessoa)
VALUES ('senha9', '999.999.999-99', 9);

INSERT INTO Bibliotecaria (senha, cpf, id_pessoa)
VALUES ('senha10', '000.000.000-00', 10);

--Leitor
INSERT INTO Leitor (telefone_um, telefone_dois, cpf, bairro, cidade, rua, numero, id_pessoa)
VALUES ('(12) 9456-7890', '(98) 9654-3210', '111.111.111-11', 'Bairro A', 'Cidade A', 'Rua 1', 123, 1);

INSERT INTO Leitor (telefone_um, telefone_dois, cpf, bairro, cidade, rua, numero, id_pessoa)
VALUES ('(23) 9567-8901', NULL, '222.222.222-22', 'Bairro B', 'Cidade B', 'Rua 2', 234, 2);

INSERT INTO Leitor (telefone_um, telefone_dois, cpf, bairro, cidade, rua, numero, id_pessoa)
VALUES ('(34) 9678-9012', '(87) 9543-2109', '333.333.333-33', 'Bairro C', 'Cidade C', 'Rua 3', 345, 3);

INSERT INTO Leitor (telefone_um, telefone_dois, cpf, bairro, cidade, rua, numero, id_pessoa)
VALUES ('(45) 8789-0123', NULL, '444.444.444-44', 'Bairro D', 'Cidade D', 'Rua 4', 456, 4);

INSERT INTO Leitor (telefone_um, telefone_dois, cpf, bairro, cidade, rua, numero, id_pessoa)
VALUES ('(56) 9890-1234', '(98) 9654-3210', '555.555.555-55', 'Bairro E', 'Cidade E', 'Rua 5', 567, 5);

INSERT INTO Leitor (telefone_um, telefone_dois, cpf, bairro, cidade, rua, numero, id_pessoa)
VALUES ('(67) 9901-2345', NULL, '666.666.666-66', 'Bairro F', 'Cidade F', 'Rua 6', 678, 6);

INSERT INTO Leitor (telefone_um, telefone_dois, cpf, bairro, cidade, rua, numero, id_pessoa)
VALUES ('(78) 9012-3456', '(87) 9543-2109', '777.777.777-77', 'Bairro G', 'Cidade G', 'Rua 7', 789, 7);

INSERT INTO Leitor (telefone_um, telefone_dois, cpf, bairro, cidade, rua, numero, id_pessoa)
VALUES ('(89) 9123-4567', NULL, '888.888.888-88', 'Bairro H', 'Cidade H', 'Rua 8', 890, 8);

INSERT INTO Leitor (telefone_um, telefone_dois, cpf, bairro, cidade, rua, numero, id_pessoa)
VALUES ('(90) 9234-5678', '(98) 9654-3210', '999.999.999-99', 'Bairro I', 'Cidade I', 'Rua 9', 901, 9);

INSERT INTO Leitor (telefone_um, telefone_dois, cpf, bairro, cidade, rua, numero, id_pessoa)
VALUES ('(01) 9345-6789', NULL, '000.000.000-00', 'Bairro J', 'Cidade J', 'Rua 10', 1234, 10);


--Empréstimo
INSERT INTO Emprestimo (data_devolucao, data_emprestimo, multa, cpf_leitor)
VALUES ('2023-11-01', '2023-10-01', 0.0, '111.111.111-11');

INSERT INTO Emprestimo (data_devolucao, data_emprestimo, multa, cpf_leitor)
VALUES ('2023-11-05', '2023-10-03', 0.0, '222.222.222-22');

INSERT INTO Emprestimo (data_devolucao, data_emprestimo, multa, cpf_leitor)
VALUES ('2023-11-10', '2023-10-02', 2.5, '333.333.333-33');

INSERT INTO Emprestimo (data_devolucao, data_emprestimo, multa, cpf_leitor)
VALUES ('2023-11-08', '2023-10-04', 0.0, '444.444.444-44');

INSERT INTO Emprestimo (data_devolucao, data_emprestimo, multa, cpf_leitor)
VALUES ('2023-11-15', '2023-10-05', 1.5, '555.555.555-55');

INSERT INTO Emprestimo (data_devolucao, data_emprestimo, multa, cpf_leitor)
VALUES ('2023-11-18', '2023-10-06', 0.0, '666.666.666-66');

INSERT INTO Emprestimo (data_devolucao, data_emprestimo, multa, cpf_leitor)
VALUES ('2023-11-25', '2023-10-07', 0.0, '777.777.777-77');

INSERT INTO Emprestimo (data_devolucao, data_emprestimo, multa, cpf_leitor)
VALUES ('2023-11-20', '2023-10-08', 3.0, '888.888.888-88');

INSERT INTO Emprestimo (data_devolucao, data_emprestimo, multa, cpf_leitor)
VALUES ('2023-11-30', '2023-10-09', 0.0, '999.999.999-99');

INSERT INTO Emprestimo (data_devolucao, data_emprestimo, multa, cpf_leitor)
VALUES ('2023-11-25', '2023-10-10', 0.0, '000.000.000-00');

--Livros
INSERT INTO Livro (local_biblioteca, num_exemplares, titulo)
VALUES ('Estante A', 5, 'Livro 1');

INSERT INTO Livro (local_biblioteca, num_exemplares, titulo)
VALUES ('Estante B', 3, 'Livro 2');

INSERT INTO Livro (local_biblioteca, num_exemplares, titulo)
VALUES ('Estante C', 2, 'Livro 3');

INSERT INTO Livro (local_biblioteca, num_exemplares, titulo)
VALUES ('Estante D', 4, 'Livro 4');

INSERT INTO Livro (local_biblioteca, num_exemplares, titulo)
VALUES ('Estante E', 6, 'Livro 5');

INSERT INTO Livro (local_biblioteca, num_exemplares, titulo)
VALUES ('Estante F', 3, 'Livro 6');

INSERT INTO Livro (local_biblioteca, num_exemplares, titulo)
VALUES ('Estante G', 4, 'Livro 7');

INSERT INTO Livro (local_biblioteca, num_exemplares, titulo)
VALUES ('Estante H', 2, 'Livro 8');

INSERT INTO Livro (local_biblioteca, num_exemplares, titulo)
VALUES ('Estante I', 5, 'Livro 9');

INSERT INTO Livro (local_biblioteca, num_exemplares, titulo)
VALUES ('Estante J', 4, 'Livro 10');

--Livros_Empréstimo
INSERT INTO Livros_Emprestimo (id_livro, id_emprestimo)
VALUES (1, 1);

INSERT INTO Livros_Emprestimo (id_livro, id_emprestimo)
VALUES (2, 2);

INSERT INTO Livros_Emprestimo (id_livro, id_emprestimo)
VALUES (3, 3);

INSERT INTO Livros_Emprestimo (id_livro, id_emprestimo)
VALUES (4, 4);

INSERT INTO Livros_Emprestimo (id_livro, id_emprestimo)
VALUES (5, 5);

INSERT INTO Livros_Emprestimo (id_livro, id_emprestimo)
VALUES (6, 6);

INSERT INTO Livros_Emprestimo (id_livro, id_emprestimo)
VALUES (7, 7);

INSERT INTO Livros_Emprestimo (id_livro, id_emprestimo)
VALUES (8, 8);

INSERT INTO Livros_Emprestimo (id_livro, id_emprestimo)
VALUES (9, 9);

INSERT INTO Livros_Emprestimo (id_livro, id_emprestimo)
VALUES (10, 10);
