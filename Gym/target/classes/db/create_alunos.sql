CREATE DATABASE IF NOT EXISTS alunos;

USE alunos;

CREATE TABLE IF NOT EXISTS aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(14) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    peso FLOAT NOT NULL,
    altura FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS historico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    aluno_id INT NOT NULL,
    data_registro DATE NOT NULL,
    peso FLOAT NOT NULL,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);