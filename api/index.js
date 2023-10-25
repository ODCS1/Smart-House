const express = require('express')
const app = express()
const handlebars = require('express-handlebars')
const bodyParser = require('body-parser')
const porta = 3000

    // CONFIG
        // BD
        const database = require("./db");
        const Cliente = require("./models/Cliente");
        const Pacote = require("./models/Pacote");
        const Compra = require("./models/Compra");
        const Casa = require("./models/Casa");
        const Endereco = require("./models/Endereco");
        const Comodo = require("./models/Comodo");
        const CasaComodo = require("./models/CasaComodo");
        const Led = require("./models/Led");
        // database.sequelize.sync()
        // TEMPLATE ENGINE
        app.engine('handlebars',handlebars.engine({defautLayout: 'main',
            runtimeOptions: {
                allowProtoPropertiesByDefault: true,
                
                allowProtoMethodsByDefault: true,
            }}))
        app.set('view engine', 'handlebars')
        // BODY PARSER
        app.use(bodyParser.urlencoded({extended: false}))
        app.use(bodyParser.json())

// ROTAS

app.get("/", (req,res) => {
    res.render("home")
})

app.get("/cadastro", (req,res) => {
    res.render("cadastro")
})

app.post("/adicionar", (req,res) => {
    // DADOS CLIENTE
    let novoNome = req.body.nome
    let novoSobrenome = req.body.sobrenome
    let novoEmail = req.body.email
    let novaSenha = req.body.senha
    let novoCpf = Number(req.body.cpf)

    // DADOS PACOTE E CASA
    // let novoPacote = req.body.pacote
    // let novoNomeCasa = req.body.nomeCasa

    // DADOS ENDEREÇO
    // let novoCep = req.body.cep
    // let novoLogradouro = req.body.logradouro
    // let novoBairro = req.body.bairro
    // let novoNumero = req.body.numero
    // let novaCidade = req.body.cidade
    // let novoEstado = req.body.estado
    // let novoComplemento = req.body.complemento

    Cliente.create({
        nome_cliente: novoNome,
        sobrenome_cliente: novoSobrenome,
        email_cliente: novoEmail,
        senha_cliente: novaSenha,
        cpf_cliente: novoCpf
    }).then(() => {
        res.send("<h1>Dados Cadastrados com sucesso!</h1>")
    }).catch((erro) => {
        res.send("<h1>[ERRO]: " + erro + "</h1>")
    })
    
    // (async () => {
    //     await Cliente.create({
    //         nome_cliente: novoNome,
    //         sobrenome_cliente: novoSobrenome,
    //         email_cliente: novoEmail,
    //         senha_cliente: novaSenha,
    //         cpf_cliente: novoCpf
    //     })

    //     let idCliente = await Cliente.findPk({where: {cpf_cliente: novoCpf}})
    //     let qualPacote = await Pacote.findPk({where: {nome_pacote: novoPacote}})

    //     await Compra.create({
    //         id_cliente: idCliente,
    //         id_pacote: qualPacote
    //     })

    //     let qtdLedCasa
    //     let codComodos
    //     let qtdLedComodos
    //     if (qualPacote == 'Pacote básico') {
    //         qtdLedCasa = 4
    //         codComodos = ['q-1', 'q-2', 'q-3', 'b-1']
    //         qtdLedComodos = [1, 1, 1, 1]
    //     }else if (qualPacote == 'Pacote Vip') {
    //         qtdLedCasa = 6
    //         codComodos = ['q-1', 'q-2', 'q-3', 'b-1', 's-1', 's-2']
    //         qtdLedComodos = [1, 1, 1, 1, 1, 1]
    //     }else if (qualPacote = 'Pacote Master') {
    //         qtdLedCasa = 10
    //         codComodos = ['q-1', 'q-2', 'q-3', 'b-1', 's-1', 's-2', 'j-1']
    //         qtdLedComodos = [1, 1, 1, 1, 1, 1, 4]
    //     }

    //     await Casa.create({
    //         nome_casa: novoNomeCasa,
    //         qtd_led_casa: qtdLedCasa,
    //         id_cliente: idCliente
    //     })

    //     let idCasa = await Casa.findPk({where: {id_cliente: idCliente}})

    //     await Endereco.create({
    //         cep: novoCep,
    //         logradouro: novoLogradouro,
    //         bairro: novoBairro,
    //         numero: novoNumero,
    //         cidade: novaCidade,
    //         estado: novoEstado,
    //         complemento: novoComplemento,
    //         id_casa: idCasa
    //     })

    //     await CasaComodo.create({
    //         id_casa: idCasa,
    //         cod_comodo: codComodos,
    //         qtd_led_comodo: qtdLedComodos
    //     })
    // })

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
