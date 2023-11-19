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
        // CAMINHO ARQUIVOS
        app.use(express.static("arquivos"))

// ROTAS

app.get("/", (req,res) => {
    res.render("home")
})

app.get("/cadastro", (req,res) => {
    res.render("cadastroCompleto")
})

app.get("/pagamento", (req,res) => {
    res.render("pagamentoRealizado")
})

app.get("/login", (req,res) => {
    res.render("login")
})

app.get("/conta", (req,res) => {
    res.render("conta")
})

app.post("/adicionar", async (req, res) => {
    try {
        const {
            nome,
            sobrenome,
            email,
            senha,
            cpf,
            pacote,
            nomeCasa,
            cep,
            logradouro,
            bairro,
            numero,
            cidade,
            estado,
            complemento
        } = req.body;

        const result = await database.sequelize.query('CALL cadastrarClienteCompleto(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)',
            {
                replacements: [nome, sobrenome, email, senha, cpf, pacote, nomeCasa, cep, logradouro, bairro, numero, cidade, estado, complemento]
            }
        );

        res.send("<h1>Dados Cadastrados com sucesso!</h1>");
    } catch (err) {
        console.error(err);
        res.status(500).send("<h1>Ocorreu um erro durante o cadastro.</h1>");
    }
});


// app.post("/adicionar", async (req, res) => {
//     console.log("TESTE!!!")

//     try {
//         // DADOS CLIENTE
//         let novoNome = req.body.nome
//         let novoSobrenome = req.body.sobrenome
//         let novoEmail = req.body.email
//         let novaSenha = req.body.senha
//         let novoCpf = Number(req.body.cpf)

//         // DADOS PACOTE E CASA
//         let novoPacote = req.body.pacote
//         let novoNomeCasa = req.body.nomeCasa

//         // DADOS ENDEREÇO
//         let novoCep = Number(req.body.cep)
//         let novoLogradouro = req.body.logradouro
//         let novoBairro = req.body.bairro
//         let novoNumero = Number(req.body.numero)
//         let novaCidade = req.body.cidade
//         let novoEstado = req.body.estado
//         let novoComplemento = req.body.complemento

//         // Criando o Cliente
//         await Cliente.create({
//             nome_cliente: novoNome,
//             sobrenome_cliente: novoSobrenome,
//             email_cliente: novoEmail,
//             senha_cliente: novaSenha,
//             cpf_cliente: novoCpf
//         }).then(async (cliente) => {
//             // Encontrando o id do Cliente e o Pacote
//             let idCliente = cliente.id;
//             let qualPacote = await Pacote.findOne({ where: { nome_pacote: novoPacote } }).catch((err) => {
//                 console.log("[ERRO]: " + err)
//                 res.send(`<h1>ERRO</h1> <p>${err}</p>`)
//             });

//             // Criando a Compra
//             await Compra.create({
//                 id_cliente: idCliente,
//                 id_pacote: qualPacote.id
//             });

//             // Definindo os valores com base no Pacote
//             let qtdLedCasa, codComodos, qtdLedComodos;
//             if (novoPacote === 'Pacote básico') {
//                 qtdLedCasa = 4;
//                 codComodos = ['q-1', 'q-2', 'q-3', 'b-1'];
//                 qtdLedComodos = [1, 1, 1, 1];
//             } else if (novoPacote === 'Pacote Vip') {
//                 qtdLedCasa = 6;
//                 codComodos = ['q-1', 'q-2', 'q-3', 'b-1', 's-1', 's-2'];
//                 qtdLedComodos = [1, 1, 1, 1, 1, 1];
//             } else if (novoPacote === 'Pacote Master') {
//                 qtdLedCasa = 10;
//                 codComodos = ['q-1', 'q-2', 'q-3', 'b-1', 's-1', 's-2', 'j-1'];
//                 qtdLedComodos = [1, 1, 1, 1, 1, 1, 4];
//             }

//             // Criando a Casa
//             let casa = await Casa.create({
//                 nome_casa: novoNomeCasa,
//                 qtd_led_casa: qtdLedCasa,
//                 id_cliente: idCliente
//             });

//             // Encontrando o id da Casa
//             let idCasa = casa.id;

//             // Criando o Endereco
//             await Endereco.create({
//                 cep: novoCep,
//                 logradouro: novoLogradouro,
//                 bairro: novoBairro,
//                 numero: novoNumero,
//                 cidade: novaCidade,
//                 estado: novoEstado,
//                 complemento: novoComplemento,
//                 id_casa: idCasa
//             });

//             // Criando a relação entre Casa e Comodo
//             await CasaComodo.create({
//                 id_casa: idCasa,
//                 cod_comodo: codComodos,
//                 qtd_led_comodo: qtdLedComodos
//             });

//             res.send("<h1>Dados Cadastrados com sucesso!</h1>");
//         }).catch((erro) => {
//             res.send("<h1>[ERRO]: " + erro + "</h1>" + `<p>Idcliente: ${idCliente}</p>`);
//         });
//     } catch (err) {
//         console.log(err);
//     }
// });


app.listen(porta, () => {
    console.log(`Servidor rodando na porta ${porta}`)
})
