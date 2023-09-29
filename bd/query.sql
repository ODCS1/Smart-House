-- Aqui será feito a criação do Schema, das tabelas e inserções dos dados.

-- Seguir a ordem de execução

-- 1 - CRIANDO O ESQUEMA
CREATE SCHEMA Casa

-- 2 - TABELA DE CLIENTE
CREATE TABLE Casa.Cliente (
    id_cliente INT IDENTITY,
    nome_cliente VARCHAR(30) NOT NULL,
    sobrenome_cliente VARCHAR(50) NULL,
    email_cliente VARCHAR(100) UNIQUE NOT NULL,
    senha_cliente VARCHAR(20) NOT NULL,
    cpf_cliente BIGINT UNIQUE NOT NULL,
    CONSTRAINT PK_Cliente PRIMARY KEY (id_cliente)
);


-- 3 - TABELA DE COMPRA
CREATE TABLE Casa.Compra (
    id_compra INT IDENTITY,
    valor_compra DECIMAL(10, 2) NOT NULL,
    pacote_comora VARCHAR(50),
    id_cliente INT,
    CONSTRAINT PK_Compra PRIMARY KEY (id_compra),
    CONSTRAINT FK_Compra_Cliente FOREIGN KEY (id_cliente) REFERENCES Casa.Cliente(id_cliente)
);

-- 4 - TABELA CASA
CREATE TABLE Casa.Casa (
    id_casa INT IDENTITY,
    nome_casa VARCHAR(40) NULL,
    qtd_led INT NOT NULL,
    id_cliente INT,
    CONSTRAINT PK_Casa PRIMARY KEY (id_casa),
    CONSTRAINT FK_Casa_Cliente FOREIGN KEY (id_cliente) REFERENCES Casa.Cliente(id_cliente)
);

-- 5 TABELA ENDERECO
CREATE TABLE Casa.Endereco (
    id_endereco INT IDENTITY,
    cep INT NOT NULL,
    logradouro VARCHAR(40) NOT NULL,
    bairro VARCHAR(30) NOT NULL,
    numero INT NOT NULL,
    cidade VARCHAR(40) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    complemento VARCHAR(50) NULL,
    id_casa INT,
    CONSTRAINT PK_endereco PRIMARY KEY (id_endereco),
    CONSTRAINT FK_Endereco_Casa FOREIGN KEY (id_casa) REFERENCES Casa.Casa(id_casa)
);

-- 6 - TABELA COMODO
CREATE TABLE Casa.Comodo (
    cod_comodo VARCHAR(10),
    nome_comodo VARCHAR(25) NOT NULL,
    CONSTRAINT PK_Comodo PRIMARY KEY (cod_comodo)
);

-- 7 - TABELA CASACOMODO
CREATE TABLE Casa.CasaComodo (
    id_casa INT,
    cod_comodo VARCHAR(10),
    qtd_led_comodo int NOT NULL,
    CONSTRAINT PK_CasaComodo PRIMARY KEY CLUSTERED (id_casa, cod_comodo),
    CONSTRAINT FK_CasaComodo_Casa FOREIGN KEY (id_casa) REFERENCES Casa.Casa(id_casa),
    CONSTRAINT FK_CasaComodo_Comodo FOREIGN KEY (cod_comodo) REFERENCES Casa.Comodo(cod_comodo)
);

-- 8 - TABELA LED
CREATE TABLE Casa.Led (
    cod_led VARCHAR(5),
    situacao BIT NOT NULL,
    cod_comodo VARCHAR(3),
    CONSTRAINT PK_Led PRIMARY KEY (cod_led),
    CONSTRAINT FK_Led_Comodo FOREIGN KEY (cod_comodo) REFERENCES Casa.Comodo(cod_comodo)
);


-- AINDA FALTA O INSERT INTO, CREATE VIEW, ADICIONAR OS CHECK NOS CREATE TABLE E A PARTE DE PROGRAMAÇÃO DENTRO DO BANCO DE DADOS.