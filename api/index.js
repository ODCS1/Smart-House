// AQUI É ONDE OS MODELS SERÃO MANIPULADOS

const database = require("./db");
const Cliente = require("./models/cliente");
const Pacote = require("./models/pacote");
const Compra = require("./models/compra");
const Casa = require("./models/casa");
const Endereco = require("./models/endereco");
const Comodo = require("./models/comodo");
const CasaComodo = require("./models/casaComodo");
const Led = require("./models/led");

// SINCRONIZAR AQUI COM O BD
(async () => {
    await database.sync();

    // AQUI DENTRO SERÁ SEITO A MANIPULAÇÃO DE DADOS

    // ----------------------------------------
    // EXEMPLO DE NOVO CLIENTE
    // CLIENTE
    const novoCliente = await Cliente.create({
        nome_cliente: 'Roberto',
        sobrenome_cliente: 'Chagas',
        email_cliente: 'roberto123@gmail.com',
        senha_cliente: 'rober123',
        cpf_cliente: 12312345698
    });
    console.log(novoCliente);

    let idCli = await Cliente.findOne({
        where: id_cliente = 4
    });

    let idPacote = 1

    // COMPRA
    const novaCompra = await Compra.create({
        id_cliente: idCli,
        id_pacote: idPacote
    });

    let qtdLed = 4;
    // CASA
    const novaCasa = await Casa.create({
        nome_casa: 'Roberto Casa',
        qtd_led_casa: qtdLed
    });

    const novoCep = 12345789;
    const novoLogradouro = 'R. Amorim Barbosa';
    const novoBairro = 'José Fernando';
    const novoNumero = 543;
    const novaCidade = 'Maribondo';
    const novoEstado = 'AL';
    const novoComplemento = null;

    const novoEndereco = await Endereco.create({
        cep: novoCep,
        logradouro: novoLogradouro,
        bairro: novoBairro,
        numero: novoNumero,
        cidade: novaCidade,
        estado: novoEstado,
        complemento: novoComplemento
    });

    
    // ---------------------------------------
})();
