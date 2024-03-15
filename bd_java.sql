CREATE DATABASE bd_java;
USE bd_java;

CREATE TABLE clientes (
    ID INT auto_increment PRIMARY KEY,
    nome VARCHAR(100),
    cpf DOUBLE,
    rg DOUBLE,
    data_nascimento DOUBLE,
    telefone DOUBLE,
    cep DOUBLE,
    endereco VARCHAR(150),
    email VARCHAR(100),
    genero VARCHAR(50)
);

SELECT 
    *
FROM
    clientes;

DROP DATABASE bd_java;