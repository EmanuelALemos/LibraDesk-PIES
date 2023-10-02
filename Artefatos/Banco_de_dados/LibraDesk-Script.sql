
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