-- 1 - CRIANDO O ESQUEMA
CREATE DATABASE sistema_casa;

-- 2 - TABELA DE CLIENTE
CREATE TABLE sistema_casa.Clientes (
    id_cliente INT AUTO_INCREMENT,
    nome_cliente VARCHAR(30) NOT NULL,
    sobrenome_cliente VARCHAR(50) NULL,
    email_cliente VARCHAR(100) UNIQUE NOT NULL,
    senha_cliente VARCHAR(20) NOT NULL,
    cpf_cliente BIGINT UNSIGNED UNIQUE NOT NULL,
    PRIMARY KEY (id_cliente)
);

-- 3 - TABELA PACOTE
CREATE TABLE sistema_casa.Pacotes (
    id_pacote INT AUTO_INCREMENT,
    nome_pacote VARCHAR(50) UNIQUE NOT NULL,
    valor_pacote DECIMAL(10, 2) NOT NULL,
    acesso VARCHAR(27) NOT NULL,
    PRIMARY KEY (id_pacote)
);

-- 4 - TABELA DE COMPRA
CREATE TABLE sistema_casa.Compras (
    id_compra INT AUTO_INCREMENT,
    id_cliente INT,
    id_pacote INT,
    PRIMARY KEY (id_compra),
    FOREIGN KEY (id_cliente) REFERENCES sistema_casa.Clientes(id_cliente),
    FOREIGN KEY (id_pacote) REFERENCES sistema_casa.Pacotes(id_pacote)
);

-- 5 - TABELA CASA
CREATE TABLE sistema_casa.Casas (
    id_casa INT AUTO_INCREMENT,
    nome_casa VARCHAR(40) NULL,
    qtd_led_casa INT NOT NULL,
    id_cliente INT,
    PRIMARY KEY (id_casa),
    FOREIGN KEY (id_cliente) REFERENCES sistema_casa.Clientes(id_cliente)
);

-- 6 - TABELA ENDERECO
CREATE TABLE sistema_casa.Enderecos (
    id_endereco INT AUTO_INCREMENT,
    cep INT UNSIGNED NOT NULL,
    logradouro VARCHAR(40) NOT NULL,
    bairro VARCHAR(30) NOT NULL,
    numero INT NOT NULL,
    cidade VARCHAR(40) NOT NULL,
    estado CHAR(2) NOT NULL,
    complemento VARCHAR(50) NULL,
    id_casa INT,
    PRIMARY KEY (id_endereco),
    FOREIGN KEY (id_casa) REFERENCES sistema_casa.Casas(id_casa)
);

-- 7 - TABELA COMODO
CREATE TABLE sistema_casa.Comodos (
    cod_comodo VARCHAR(10),
    nome_comodo VARCHAR(25) UNIQUE NOT NULL,
    PRIMARY KEY (cod_comodo)
);

-- 8 - TABELA CASACOMODO
CREATE TABLE sistema_casa.CasaComodos (
    id_casa INT,
    cod_comodo VARCHAR(10),
    qtd_led_comodo INT NOT NULL,
    PRIMARY KEY (id_casa, cod_comodo),
    FOREIGN KEY (id_casa) REFERENCES sistema_casa.Casas(id_casa),
    FOREIGN KEY (cod_comodo) REFERENCES sistema_casa.Comodos(cod_comodo)
);

-- 9 - TABELA LED
CREATE TABLE sistema_casa.Leds (
    cod_led VARCHAR(10),
    situacao TINYINT NOT NULL,
    cod_comodo VARCHAR(10),
    PRIMARY KEY (cod_led),
    FOREIGN KEY (cod_comodo) REFERENCES sistema_casa.Comodos(cod_comodo)
);

-- FAZENDO A INSERÇÃO DE DADOS
-- 10 - INSERINDO EM Casa.Pacote
INSERT INTO sistema_casa.Pacotes (nome_pacote, valor_pacote, acesso)
VALUES
    ('Pacote básico', 250.30, 'Quartos'),
    ('Pacote Vip', 329.90, 'Cômodos Internos'),
    ('Pacote Master', 449.80, 'Cômodos Internos e Externos');

-- 11 - INSERINDO EM Casa.Comodo
INSERT INTO sistema_casa.Comodos (cod_comodo, nome_comodo)
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
INSERT INTO sistema_casa.Leds (cod_led, situacao, cod_comodo)
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
INSERT INTO sistema_casa.Clientes (nome_cliente, sobrenome_cliente, email_cliente, senha_cliente, cpf_cliente)
VALUES
    ('Sérgio', 'Rodrigo', 'sergioR@gmail.com', 'senha123Sergio', 12345678912),
    ('Carlos', 'Roberto', 'carlosR@gmail.com', 'senha123Carlos', 12345678913),
    ('Pedro', 'Queiróz', 'pedroQ@gmail.com', 'senha123Pedro', 12345678914);

-- 14 - INSERT COMPRA
INSERT INTO sistema_casa.Compras (id_cliente, id_pacote)
VALUES
    (1, 2),
    (2, 1),
    (3, 3);

-- 15 - INSERT CASA
INSERT INTO sistema_casa.Casas (nome_casa, qtd_led_casa, id_cliente)
VALUES
    ('Sérgio House', 6, 1),
    ('Carlos House', 4, 2),
    ('Pedro House', 10, 3);

-- 16 - INSERT ENDERECO
INSERT INTO sistema_casa.Enderecos (cep, logradouro, bairro, numero, cidade, estado, complemento, id_casa)
VALUES
    (12345678, 'R. Jardim Das Flores', 'Japão', 352, 'Santo André', 'SP', NULL, 1),
    (98765432, 'Av. Professor Ozório', 'Bairro Ciência', 872, 'Campinas', 'SP', NULL, 2),
    (45623987, 'Rua Luiz Bernardo', 'Coliseu', 352, 'Maribondo', 'RS', 'BL B, AP. 254', 3);

-- 17 - INSERT CASACOMODO
INSERT INTO sistema_casa.CasaComodos (id_casa, cod_comodo,qtd_led_comodo)
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
SELECT * FROM sistema_casa.Clientes;
SELECT * FROM sistema_casa.Compras;
SELECT * FROM sistema_casa.Pacotes;
SELECT * FROM sistema_casa.Casas;
SELECT * FROM sistema_casa.Enderecos;
SELECT * FROM sistema_casa.Comodos;
SELECT * FROM sistema_casa.CasaComodos;
SELECT * FROM sistema_casa.Leds;


-- COMANDOS DE DROP
-- DROP TABLE sistema_casa.Leds
-- DROP TABLE sistema_casa.CasaComodos
-- DROP TABLE sistema_casa.Enderecos
-- DROP TABLE sistema_casa.Comodos
-- DROP TABLE sistema_casa.Casas
-- DROP TABLE sistema_casa.Compras
-- DROP TABLE sistema_casa.Clientes

-- AINDA FALTA O CREATE VIEW E A PARTE DE PROGRAMAÇÃO DENTRO DO BANCO DE DADOS.


-- SP PARA CADASTRO DE INFORMAÇÕES PELO SITE
DELIMITER //

CREATE PROCEDURE cadastrarClienteCompleto(
    IN novoNome VARCHAR(30),
    IN novoSobrenome VARCHAR(50),
    IN novoEmail VARCHAR(100),
    IN novaSenha VARCHAR(20),
    IN novoCpf BIGINT UNSIGNED,
    IN novoPacote VARCHAR(50),
    IN novoNomeCasa VARCHAR(40),
    IN novoCep INT UNSIGNED,
    IN novoLogradouro VARCHAR(40),
    IN novoBairro VARCHAR(30),
    IN novoNumero INT,
    IN novaCidade VARCHAR(40),
    IN novoEstado CHAR(2),
    IN novoComplemento VARCHAR(50)
)
BEGIN
    DECLARE id_cliente INT;

    START TRANSACTION;

    -- INSERÇÃO DO CLIENTE
    INSERT INTO sistema_casa.Clientes (nome_cliente, sobrenome_cliente, email_cliente, senha_cliente, cpf_cliente)
    VALUES (novoNome, novoSobrenome, novoEmail, novaSenha, novoCpf);
    SET id_cliente = LAST_INSERT_ID();

    -- OBTENÇÃO DO ID DO PACOTE
    DECLARE qualPacoteId INT;
    SELECT id_pacote INTO qualPacoteId FROM sistema_casa.Pacotes WHERE nome_pacote = novoPacote;

    -- INSERÇÃO DA COMPRA
    INSERT INTO sistema_casa.Compras (id_cliente, id_pacote)
    VALUES (id_cliente, qualPacoteId);

    -- DEFINIÇÃO DOS VALORES BASEADO NO PACOTE
    DECLARE qtdLedCasa INT;
    DECLARE codComodos VARCHAR(255);
    DECLARE qtdLedComodos VARCHAR(255);

    IF novoPacote = 'Pacote básico' THEN
        SET qtdLedCasa = 4;
        SET codComodos = 'q-1,q-2,q-3,b-1';
        SET qtdLedComodos = '1,1,1,1';
    ELSEIF novoPacote = 'Pacote Vip' THEN
        SET qtdLedCasa = 6;
        SET codComodos = 'q-1,q-2,q-3,b-1,s-1,s-2';
        SET qtdLedComodos = '1,1,1,1,1,1';
    ELSEIF novoPacote = 'Pacote Master' THEN
        SET qtdLedCasa = 10;
        SET codComodos = 'q-1,q-2,q-3,b-1,s-1,s-2,j-1';
        SET qtdLedComodos = '1,1,1,1,1,1,4';
    END IF;

    -- INSERÇÃO DA CASA
    INSERT INTO sistema_casa.Casas (nome_casa, qtd_led_casa, id_cliente)
    VALUES (novoNomeCasa, qtdLedCasa, id_cliente);
    DECLARE id_casa INT;
    SET id_casa = LAST_INSERT_ID();

    -- INSERÇÃO DO ENDEREÇO
    INSERT INTO sistema_casa.Enderecos (cep, logradouro, bairro, numero, cidade, estado, complemento, id_casa)
    VALUES (novoCep, novoLogradouro, novoBairro, novoNumero, novaCidade, novoEstado, novoComplemento, id_casa);

    -- INSERÇÃO DA RELAÇÃO ENTRE CASA E COMODOS
    INSERT INTO sistema_casa.CasaComodos (id_casa, cod_comodo, qtd_led_comodo)
    VALUES (id_casa, codComodos, qtdLedComodos);

    COMMIT;
END //

DELIMITER ;