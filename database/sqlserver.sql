-- Aqui será feito a criação do Schema, das tabelas e inserções dos dados.

-- Seguir a ordem de execução, no final tem comando de seleção e de DROP.

-- 1 - CRIANDO O ESQUEMA
CREATE SCHEMA Casa

-- 2 - TABELA DE CLIENTE
CREATE TABLE Casa.Cliente (
    id_cliente INT IDENTITY,
    nome_cliente VARCHAR(30) NOT NULL,
    sobrenome_cliente VARCHAR(50) NULL,
    email_cliente VARCHAR(100) UNIQUE NOT NULL,
    senha_cliente VARCHAR(20) NOT NULL
        CHECK (LEN(senha_cliente) BETWEEN 8 AND 20),
    cpf_cliente BIGINT UNIQUE NOT NULL
        CHECK (cpf_cliente like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
    CONSTRAINT PK_Cliente PRIMARY KEY (id_cliente)
);

-- 3 - TABELA PACOTE
CREATE TABLE Casa.Pacote (
    id_pacote INT,
    nome_pacote VARCHAR(50) UNIQUE NOT NULL,
    valor_pacote DECIMAL(10, 2) NOT NULL,
    acesso VARCHAR(27) NOT NULL,
    CONSTRAINT PK_Pacote PRIMARY KEY (id_pacote)
);

-- 4 - TABELA DE COMPRA
CREATE TABLE Casa.Compra (
    id_compra INT IDENTITY,
    id_cliente INT,
    id_pacote INT,
    CONSTRAINT PK_Compra PRIMARY KEY (id_compra),
    CONSTRAINT FK_Compra_Cliente FOREIGN KEY (id_cliente) REFERENCES Casa.Cliente(id_cliente),
    CONSTRAINT FK_Compra_Pacote FOREIGN KEY (id_pacote) REFERENCES Casa.Pacote(id_pacote)
);

-- 5 - TABELA CASA
CREATE TABLE Casa.Casa (
    id_casa INT IDENTITY,
    nome_casa VARCHAR(40) NULL,
    qtd_led_casa INT NOT NULL,
    id_cliente INT,
    CONSTRAINT PK_Casa PRIMARY KEY (id_casa),
    CONSTRAINT FK_Casa_Cliente FOREIGN KEY (id_cliente) REFERENCES Casa.Cliente(id_cliente)
);

-- 6 - TABELA ENDERECO
CREATE TABLE Casa.Endereco (
    id_endereco INT IDENTITY,
    cep INT NOT NULL
        CHECK(cep like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
    logradouro VARCHAR(40) NOT NULL,
    bairro VARCHAR(30) NOT NULL,
    numero INT NOT NULL,
    cidade VARCHAR(40) NOT NULL,
    estado CHAR(2) NOT NULL,
    complemento VARCHAR(50) NULL,
    id_casa INT,
    CONSTRAINT PK_endereco PRIMARY KEY (id_endereco),
    CONSTRAINT FK_Endereco_Casa FOREIGN KEY (id_casa) REFERENCES Casa.Casa(id_casa)
);

-- 7 - TABELA COMODO
CREATE TABLE Casa.Comodo (
    cod_comodo VARCHAR(10),
    nome_comodo VARCHAR(25) UNIQUE NOT NULL,
    CONSTRAINT PK_Comodo PRIMARY KEY (cod_comodo)
);

-- 8 - TABELA CASACOMODO
CREATE TABLE Casa.CasaComodo (
    id_casa INT,
    cod_comodo VARCHAR(10),
    qtd_led_comodo int NOT NULL,
    CONSTRAINT PK_CasaComodo PRIMARY KEY CLUSTERED (id_casa, cod_comodo),
    CONSTRAINT FK_CasaComodo_Casa FOREIGN KEY (id_casa) REFERENCES Casa.Casa(id_casa),
    CONSTRAINT FK_CasaComodo_Comodo FOREIGN KEY (cod_comodo) REFERENCES Casa.Comodo(cod_comodo)
);

-- 9 - TABELA LED
CREATE TABLE Casa.Led (
    cod_led VARCHAR(10),
    situacao BIT NOT NULL,
    cod_comodo VARCHAR(10),
    CONSTRAINT PK_Led PRIMARY KEY (cod_led),
    CONSTRAINT FK_Led_Comodo FOREIGN KEY (cod_comodo) REFERENCES Casa.Comodo(cod_comodo)
);

-- FAZENDO A INSERÇÃO DE DADOS
-- 10 - INSERINDO EM Casa.Pacote
INSERT INTO Casa.Pacote (id_pacote, nome_pacote,valor_pacote, acesso)
VALUES
    (1, 'Pacote básico', 250.30, 'Quartos'),
    (2, 'Pacote Vip', 329.90, 'Cômodos Internos'),
    (3, 'Pacote Master', 449.80, 'Cômodos Internos e Externos');

-- 11 - INSERINDO EM Casa.Comodo
INSERT INTO Casa.Comodo (cod_comodo, nome_comodo)
VALUES
    ('q-1', 'Suíte Master'),
    ('q-2', 'Quarto Médio'),
    ('q-3', 'Quarto pequeno'),
    ('s-1', 'Sala de Jantar'),
    ('s-2', 'Sala de Estar'),
    ('j-1', 'Quintal'),
    ('b-1', 'Banheiro Suíte'),
    ('b-2', 'Banheiro Externo');

-- 12 - INSERINDO EM Casa.Led
INSERT INTO Casa.Led (cod_led, situacao, cod_comodo)
VALUES
    ('led-1', 0, 'q-1'),
    ('led-2', 0, 'q-1'),
    ('led-3', 0, 'q-2'),
    ('led-4', 0, 'q-3'),
    ('led-5', 0, 's-1'),
    ('led-6', 0, 's-2'),
    ('led-7', 0, 'j-1'),
    ('led-8', 0, 'j-1'),
    ('led-9', 0, 'j-1'),
    ('led-10', 0, 'j-1');


-- AGORA SIMULANDO UM NOVO CLIENTE

-- 13 - INSERT CLIENTE
INSERT INTO Casa.Cliente (nome_cliente, sobrenome_cliente, email_cliente, senha_cliente, cpf_cliente)
VALUES
    ('Sérgio', 'Rodrigo', 'sergioR@gmail.com', 'senha123Sergio', 12345678912),
    ('Carlos', 'Roberto', 'carlosR@gmail.com', 'senha123Carlos', 12345678913),
    ('Pedro', 'Queiróz', 'pedroQ@gmail.com', 'senha123Pedro', 12345678914);


-- 14 - INSERT COMPRA
INSERT INTO Casa.Compra (id_cliente, id_pacote)
VALUES
    (1, 2),
    (2, 1),
    (3, 3);

-- 15 - INSERT CASA
INSERT INTO Casa.Casa (nome_casa, qtd_led_casa, id_cliente)
VALUES
    ('Sérgio House', 6, 1),
    ('Carlos House', 4, 2),
    ('Pedro House', 10, 3);

-- 16 - INSERT ENDERECO
INSERT INTO Casa.Endereco (cep, logradouro, bairro, numero, cidade, estado, complemento, id_casa)
VALUES
    (12345678, 'R. Jardim Das Flores', 'Japão', 352, 'Santo André', 'SP', NULL, 1),
    (98765432, 'Av. Professor Ozório', 'Bairro Ciência', 872, 'Campinas', 'SP', NULL, 2),
    (45623987, 'Rua Luiz Bernardo', 'Coliseu', 352, 'Maribondo', 'RS', 'BL B, AP. 254', 3);


-- 17 - INSERT CASACOMODO
INSERT INTO Casa.CasaComodo(id_casa, cod_comodo,qtd_led_comodo)
VALUES
    (1, 'q-1', 2),
    (1, 'q-2', 1),
    (1, 'q-3', 1),
    (1, 's-1', 1),
    (1, 's-2', 1),
    (1, 'b-1', 1),
    (2, 'q-1', 2),
    (2, 'q-2', 1),
    (2, 'q-3', 1),
    (2, 'b-1', 1),
    (3, 'q-1', 2),
    (3, 'q-2', 1),
    (3, 'q-3', 1),
    (3, 's-1', 1),
    (3, 's-2', 1),
    (3, 'b-1', 1),
    (3, 'j-1', 4);


-- COMANDOS DE SELEÇÃO
SELECT * FROM Casa.Cliente
SELECT * FROM Casa.Compra
SELECT * FROM Casa.Pacote
SELECT * FROM Casa.Casa
SELECT * FROM Casa.Endereco
SELECT * FROM Casa.Comodo
SELECT * FROM Casa.CasaComodo
SELECT * FROM Casa.Led


-- COMANDOS DE DROP
--DROP TABLE Casa.LED
--DROP TABLE Casa.CasaComodo
-- DROP TABLE Casa.Endereco
-- DROP TABLE Casa.Comodo
-- DROP TABLE Casa.Casa
-- DROP TABLE Casa.Compra
-- DROP TABLE Casa.Cliente
-- DROP SCHEMA Casa

-- VIEW
CREATE VIEW Casa.View_Cliente AS
SELECT nome_cliente, sobrenome_cliente, email_cliente, cpf_cliente
FROM Casa.Cliente;

SELECT * FROM Casa.View_Cliente WHERE email_cliente = 'EMAIL'

CREATE VIEW [Cliente Segurança] AS
SELECT nome_cliente, sobrenome_cliente, email_cliente
FROM Casa.Cliente
WHERE id_cliente = idAtual

CREATE VIEW [Cliente Informações gerais] AS
SELECT CL.nome_cliente, CL.sobrenome_cliente, CL.email_cliente, CL.cpf_cliente
FROM Casa.Cliente CL
WHERE id_cliente = idAtual
INNER JOIN Casa.Endereco E ON CL.id_cliente = E.id_cliente


-- SP
-- AUTENTICAÇÃO DO CLIENTE POR EMAIL E SENHA
CREATE PROCEDURE Casa.AuthenticateCliente
    @email_cliente VARCHAR(100),
    @senha_cliente VARCHAR(20)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @id_cliente INT;

    SELECT @id_cliente = id_cliente
    FROM Casa.Cliente
    WHERE email_cliente = @email_cliente
      AND senha_cliente = @senha_cliente;


    SELECT @id_cliente AS Result;
END;

DECLARE @result INT;
EXEC Casa.AuthenticateCliente @email_cliente = 'email_do_cliente', @senha_cliente = 'senha_do_cliente';
SELECT @result;


-- SP PARA ATUALIZAR LEDS
CREATE PROCEDURE Casa.ControlarLED
    @cod_led VARCHAR(10),
    @situacao BIT
AS
BEGIN
    SET NOCOUNT ON;

    -- Atualize a situação do LED na tabela Casa.Led
    UPDATE Casa.Led
    SET situacao = @situacao
    WHERE cod_led = @cod_led;

    -- Você pode adicionar código adicional aqui, como notificar o Arduino
    -- sobre a mudança de estado do LED, se necessário.
END;


EXEC Casa.ControlarLED @cod_led = 'led-1', @situacao = 1;


-- SP PARA CADASTRO COMPLETO
CREATE PROCEDURE Casa.CadastrarClienteCompleto
    @nome_cliente VARCHAR(30),
    @sobrenome_cliente VARCHAR(50),
    @email_cliente VARCHAR(100),
    @senha_cliente VARCHAR(20),
    @cpf_cliente BIGINT,
    @id_pacote INT,
    @nome_casa VARCHAR(40),
    @qtd_led_casa INT,
    @cep INT,
    @logradouro VARCHAR(40),
    @bairro VARCHAR(30),
    @numero INT,
    @cidade VARCHAR(40),
    @estado CHAR(2),
    @complemento VARCHAR(50),
    @cod_comodo VARCHAR(10),
    @qtd_led_comodo INT
AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO Casa.Cliente (nome_cliente, sobrenome_cliente, email_cliente, senha_cliente, cpf_cliente)
    VALUES (@nome_cliente, @sobrenome_cliente, @email_cliente, @senha_cliente, @cpf_cliente);

    DECLARE @id_cliente INT;
    SET @id_cliente = SCOPE_IDENTITY();

    INSERT INTO Casa.Compra (id_cliente, id_pacote)
    VALUES (@id_cliente, @id_pacote);

    INSERT INTO Casa.Casa (nome_casa, qtd_led_casa, id_cliente)
    VALUES (@nome_casa, @qtd_led_casa, @id_cliente);

    INSERT INTO Casa.Endereco (cep, logradouro, bairro, numero, cidade, estado, complemento, id_casa)
    VALUES (@cep, @logradouro, @bairro, @numero, @cidade, @estado, @complemento, SCOPE_IDENTITY());

    INSERT INTO Casa.CasaComodo (id_casa, cod_comodo, qtd_led_comodo)
    VALUES (SCOPE_IDENTITY(), @cod_comodo, @qtd_led_comodo);
END;
