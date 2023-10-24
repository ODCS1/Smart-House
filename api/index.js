const express = require('express')
const app = express()
const handlebars = require('express-handlebars')
const bodyParser = require('body-parser')
const porta = 3000

    // CONFIG
        // BD
        const database = require("./db");
        const Cliente = require("./models/cliente");
        const Pacote = require("./models/pacote");
        const Compra = require("./models/compra");
        const Casa = require("./models/casa");
        const Endereco = require("./models/endereco");
        const Comodo = require("./models/comodo");
        const CasaComodo = require("./models/casaComodo");
        const Led = require("./models/led");
        // TEMPLATE ENGINE
        app.engine('handlebars', handlebars.engine({defaultLayout: 'main'}))
        app.set('view engine', 'handlebars')
        // BODY PARSER
        app.use(bodyParser.urlencoded({extended: false}))
        app.use(bodyParser.json())

app.get("/", (req,res) => {
    res.send("<h1>Bem vindo a página principal!</h1>")
})

app.get("/cadastro", (req,res) => {
    res.render("cadastro")
})

app.post("/adicionar", (req,res) => {
    let novoNome = req.body.nome
    let novoSobrenome = req.body.sobrenome
    let novoEmail = req.body.email
    let novaSenha = req.body.senha
    let novoCpf = Number(req.body.cpf)
    (async () => {
        await database.sync();
    
        // AQUI DENTRO SERÁ SEITO A MANIPULAÇÃO DE DADOS
    
        // ----------------------------------------
        // EXEMPLO DE NOVO CLIENTE
        // CLIENTE
        const novoCliente = Cliente.create({
            nome_cliente: novoNome,
            sobrenome_cliente: novoSobrenome,
            email_cliente: novoEmail,
            senha_cliente: novaSenha,
            cpf_cliente: novoCpf
        });
        console.log(novoCliente);
    
        // let idCli = await Cliente.findOne({
        //     where: id_cliente = 4
        // });
    
        // let idPacote = 1
    
        // // COMPRA
        // const novaCompra = await Compra.create({
        //     id_cliente: idCli,
        //     id_pacote: idPacote
        // });
    
        // let qtdLed = 4;
        // // CASA
        // const novaCasa = await Casa.create({
        //     nome_casa: 'Roberto Casa',
        //     qtd_led_casa: qtdLed
        // });
    
        // const novoCep = 12345789;
        // const novoLogradouro = 'R. Amorim Barbosa';
        // const novoBairro = 'José Fernando';
        // const novoNumero = 543;
        // const novaCidade = 'Maribondo';
        // const novoEstado = 'AL';
        // const novoComplemento = null;
    
        // const novoEndereco = await Endereco.create({
        //     cep: novoCep,
        //     logradouro: novoLogradouro,
        //     bairro: novoBairro,
        //     numero: novoNumero,
        //     cidade: novaCidade,
        //     estado: novoEstado,
        //     complemento: novoComplemento
        // });
    
        
        // ---------------------------------------
    })();
})

app.listen(porta, () => {
    console.log(`Servidor rodando na porta ${porta}`)
})


// SINCRONIZAR AQUI COM O BD
// (async () => {
//     await database.sync();

//     // AQUI DENTRO SERÁ SEITO A MANIPULAÇÃO DE DADOS

//     // ----------------------------------------
//     // EXEMPLO DE NOVO CLIENTE
//     // CLIENTE
//     const novoCliente = await Cliente.create({
//         nome_cliente: 'Roberto',
//         sobrenome_cliente: 'Chagas',
//         email_cliente: 'roberto123@gmail.com',
//         senha_cliente: 'rober123',
//         cpf_cliente: 12312345698
//     });
//     console.log(novoCliente);

//     let idCli = await Cliente.findOne({
//         where: id_cliente = 4
//     });

//     let idPacote = 1

//     // COMPRA
//     const novaCompra = await Compra.create({
//         id_cliente: idCli,
//         id_pacote: idPacote
//     });

//     let qtdLed = 4;
//     // CASA
//     const novaCasa = await Casa.create({
//         nome_casa: 'Roberto Casa',
//         qtd_led_casa: qtdLed
//     });

//     const novoCep = 12345789;
//     const novoLogradouro = 'R. Amorim Barbosa';
//     const novoBairro = 'José Fernando';
//     const novoNumero = 543;
//     const novaCidade = 'Maribondo';
//     const novoEstado = 'AL';
//     const novoComplemento = null;

//     const novoEndereco = await Endereco.create({
//         cep: novoCep,
//         logradouro: novoLogradouro,
//         bairro: novoBairro,
//         numero: novoNumero,
//         cidade: novaCidade,
//         estado: novoEstado,
//         complemento: novoComplemento
//     });

    
//     // ---------------------------------------
// })();
