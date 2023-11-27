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
    nome_casa VARCHAR(40) NOT NULL,
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

-- 8 - TABELA LED
CREATE TABLE sistema_casa.Leds (
    cod_led VARCHAR(10),
    cod_comodo VARCHAR(10),
    PRIMARY KEY (cod_led)
);

-- 9 - TABELA CLIENTELEDS
CREATE TABLE ClienteLeds (
    id_cliente_led INT AUTO_INCREMENT,
    id_cliente INT,
    led_1 TINYINT NULL,
    led_2 TINYINT NULL,
    led_3 TINYINT NULL,
    led_4 TINYINT NULL,
    led_5 TINYINT NULL,
    led_6 TINYINT NULL,
    led_7 TINYINT NULL,
    led_8 TINYINT NULL,
    led_9 TINYINT NULL,
    led_10 TINYINT NULL,
    led_11 TINYINT NULL,
    led_12 TINYINT NULL,
    led_13 TINYINT NULL,
    PRIMARY KEY(id_cliente_led),
    FOREIGN KEY (id_cliente) REFERENCES sistema_casa.Clientes(id_cliente)
);

-- FAZENDO A INSERÇÃO DE DADOS FIXOS
-- 10 - INSERINDO EM Casa.Pacote
INSERT INTO sistema_casa.Pacotes (nome_pacote, valor_pacote, acesso)
VALUES
    ('Pacote básico', 250.30, 'Quartos'),
    ('Pacote Vip', 620.50, 'Cômodos Internos'),
    ('Pacote Master', 750.80, 'Cômodos Internos e Externos');

-- 11 - INSERINDO EM Casa.Comodo
INSERT INTO sistema_casa.Comodos (cod_comodo, nome_comodo)
VALUES
    ('q-1', 'Suíte Master'),
    ('q-2', 'Quarto Médio'),
    ('s-1', 'Sala de Jantar'),
    ('s-2', 'Sala de Estar'),
    ('s-3', 'Sala Tv'),
    ('c-1', 'Cozinha'),
    ('l-1', 'Lavanderia'),
    ('j-1', 'Quintal'),
    ('b-1', 'Banheiro Superior'),
    ('b-2', 'Banheiro Inferior');

-- 12 - INSERT LED
INSERT INTO sistema_casa.Leds (cod_led, cod_comodo)
VALUES
    ('led-1', 'q-1'),
    ('led-2', 'q-2'),
    ('led-3', 's-3'),
    ('led-4', 'b-1'),
    ('led-5', 's-1'),
    ('led-6', 's-2'),
    ('led-7', 'c-1'),
    ('led-8', 'b-2'),
    ('led-9', 'l-1'),
    ('led-10', 'j-1'),
    ('led-11', 'j-1'),
    ('led-12', 'j-1'),
    ('led-13', 'j-1');



-- AGORA SIMULANDO UM NOVO CLIENTE

-- 11 - INSERT CLIENTE
INSERT INTO sistema_casa.Clientes (nome_cliente, sobrenome_cliente, email_cliente, senha_cliente, cpf_cliente)
VALUES
    ('Vitor', 'Coelho', 'adm@v', '123', 12345678912),
    ('Diogo', 'Lourenco', 'adm@d', '123', 12345678913),
    ('Antonio', 'Ilton', 'adm@a', '123', 12345678914);

-- 12 - INSERT COMPRA
INSERT INTO sistema_casa.Compras (id_cliente, id_pacote)
VALUES
    (1, 2),
    (2, 1),
    (3, 3);

-- 13 - INSERT CASA
INSERT INTO sistema_casa.Casas (nome_casa, qtd_led_casa, id_cliente)
VALUES
    ('Vitor Casa', 9, 1),
    ('Diogo Casa', 2, 2),
    ('Antonio Casa', 13, 3);

-- 14 - INSERT ENDERECO
INSERT INTO sistema_casa.Enderecos (cep, logradouro, bairro, numero, cidade, estado, complemento, id_casa)
VALUES
    (12345678, 'R. Jardim Das Flores', 'Japão', 352, 'Santo André', 'SP', NULL, 1),
    (98765432, 'Av. Professor Ozório', 'Bairro Ciência', 872, 'Campinas', 'SP', NULL, 2),
    (45623987, 'Rua Luiz Bernardo', 'Coliseu', 352, 'Maribondo', 'RS', 'BL B, AP. 254', 3);



-- -- 15 - INSERT CLIENTELEDS
INSERT INTO sistema_casa.ClienteLeds (id_cliente, led_1, led_2, led_3, led_4, led_5, led_6, led_7, led_8, led_9, led_10, led_11, led_12, led_13)
VALUES
    (1, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null),
    (2, 0, 0, null, null, null, null, null, null, null, null, null, null, null),
    (3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- COMANDOS DE SELEÇÃO
SELECT * FROM sistema_casa.Clientes;
SELECT * FROM sistema_casa.Compras;
SELECT * FROM sistema_casa.Pacotes;
SELECT * FROM sistema_casa.Casas;
SELECT * FROM sistema_casa.Enderecos;
SELECT * FROM sistema_casa.Comodos;
SELECT * FROM sistema_casa.Leds;
SELECT * FROM sistema_casa.ClienteLeds;


-- COMANDOS DE DROP
-- DROP TABLE sistema_casa.Leds
-- DROP TABLE sistema_casa.ClienteLeds
-- DROP TABLE sistema_casa.Enderecos
-- DROP TABLE sistema_casa.Comodos
-- DROP TABLE sistema_casa.Casas
-- DROP TABLE sistema_casa.Compras
-- DROP TABLE sistema_casa.Clientes

-- AINDA FALTA O CREATE VIEW E A PARTE DE PROGRAMAÇÃO DENTRO DO BANCO DE DADOS.

-- VIEW PARA PEGAR TODAS AS INFORMAÇÕES REFERENTES AO USUÁRIO
CREATE VIEW ViewClienteDetalhes AS
SELECT 
    c.nome_cliente, 
    c.sobrenome_cliente, 
    c.email_cliente, 
    c.cpf_cliente, 
    p.nome_pacote, 
    p.acesso, 
    casa.nome_casa, 
    e.cep, 
    e.logradouro, 
    e.bairro, 
    e.numero, 
    e.cidade, 
    e.estado, 
    e.complemento, 
    cl.led_1, 
    cl.led_2, 
    cl.led_3, 
    cl.led_4, 
    cl.led_5, 
    cl.led_6, 
    cl.led_7, 
    cl.led_8, 
    cl.led_9,
    cl.led_10, 
    cl.led_11, 
    cl.led_12,
    cl.led_13
FROM sistema_casa.Clientes c
JOIN sistema_casa.Compras comp ON c.id_cliente = comp.id_cliente
JOIN sistema_casa.Pacotes p ON comp.id_pacote = p.id_pacote
JOIN sistema_casa.Casas casa ON c.id_cliente = casa.id_cliente
JOIN sistema_casa.Enderecos e ON casa.id_casa = e.id_casa
JOIN sistema_casa.ClienteLeds cl ON c.id_cliente = cl.id_cliente;

-- SP PARA CADASTRO DE INFORMAÇÕES PELO SITE
CREATE PROCEDURE sp_cadastroNovoCliente(
    -- parâmetros de entrada
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
    DECLARE id_cliente INT UNSIGNED;
    DECLARE qualPacoteId INT UNSIGNED;
    DECLARE qtdLedCasa INT UNSIGNED;
    DECLARE codComodos VARCHAR(50);
    DECLARE qtdLedComodos VARCHAR(50);
    DECLARE id_casa INT UNSIGNED;
    DECLARE posCodCom INT UNSIGNED;
    DECLARE posQtdLed INT UNSIGNED;

    START TRANSACTION;


     -- INSERÇÃO DO CLIENTE
    INSERT INTO sistema_casa.Clientes (nome_cliente, sobrenome_cliente, email_cliente, senha_cliente, cpf_cliente)
    VALUES (novoNome, novoSobrenome, novoEmail, novaSenha, novoCpf);
    
    -- OBTENÇÃO DO ID DO CLIENTE INSERIDO

    DECLARE @id_cliente INT;
    SELECT id_cliente = @id_cliente FROM sistema_casa.Clientes WHERE novoEmail;

    -- OBTENÇÃO DO ID DO PACOTE
    SELECT id_pacote INTO @qualPacoteId FROM sistema_casa.Pacotes WHERE nome_pacote = novoPacote;

    -- INSERÇÃO DA COMPRA
    INSERT INTO sistema_casa.Compras (id_cliente, id_pacote)
    VALUES (@id_cliente, @qualPacoteId);

    -- DEFINIÇÃO DOS VALORES BASEADO NO PACOTE
    CASE novoPacote
        WHEN 'Pacote básico' THEN
            SET qtdLedCasa = 2;
            INSERT INTO sistema_casa.ClienteLeds (id_cliente, led_1, led_2) VALUES (@id_cliente, 0, 0);
        WHEN 'Pacote Vip' THEN
            SET qtdLedCasa = 9;
            INSERT INTO sistema_casa.ClienteLeds (id_cliente, led_1, led_2, led_3, led_4, led_5, led_6, led_7, led_8, led_9)
            VALUES (@id_cliente, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        WHEN 'Pacote Master' THEN
            SET qtdLedCasa = 13;
            INSERT INTO sistema_casa.ClienteLeds (id_cliente, led_1, led_2, led_3, led_4, led_5, led_6, led_7, led_8, led_9, led_10, led_11, led_12, led_13)
            VALUES (@id_cliente, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        ELSE
            SET qtdLedCasa = 0;
    END CASE;

    -- INSERÇÃO CASA
    INSERT INTO sistema_casa.Casas (nome_casa, qtd_led_casa, id_cliente)
    VALUES (novoNomeCasa, qtdLedCasa, id_cliente);
    
    -- OBTENÇÃO DO ID DA CASA
    SET id_casa = LAST_INSERT_ID();

    -- INSERÇÃO DO ENDEREÇO
    INSERT INTO sistema_casa.Enderecos (cep, logradouro, bairro, numero, cidade, estado, complemento, id_casa)
    VALUES (novoCep, novoLogradouro, novoBairro, novoNumero, novaCidade, novoEstado, novoComplemento, id_casa);
    
    COMMIT;
END;





