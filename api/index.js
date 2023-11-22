const express = require('express');
const app = express();
const handlebars = require('express-handlebars');
const bodyParser = require('body-parser');
const session = require('express-session');
const { QueryTypes } = require('sequelize');
const porta = 3000;

    // CONFIG
        // BD
        const database = require("./db");
        const Cliente = require("./models/Cliente");
        const Pacote = require("./models/Pacote");
        const Compra = require("./models/Compra");
        const Casa = require("./models/Casa");
        const Endereco = require("./models/Endereco");
        const Comodo = require("./models/Comodo");
        const ClienteLed = require("./models/ClienteLed");
        const Led = require("./models/Led");
        // database.sequelize.sync()
        // TEMPLATE ENGINE
        app.engine('handlebars',handlebars.engine({defautLayout: 'main',
            runtimeOptions: {
                allowProtoPropertiesByDefault: true,
                
                allowProtoMethodsByDefault: true,
            }}));
        app.set('view engine', 'handlebars')
        // BODY PARSER
        app.use(bodyParser.urlencoded({extended: false}));
        app.use(bodyParser.json());
        // CAMINHO ARQUIVOS
        app.use(express.static("arquivos"));
        // VARIÁVEL DE SESSÃO
        app.use(session({
            secret: 'secretUser',
            resave: false,
            saveUninitialized: true
        }));

// ROTAS

app.get("/", (req,res) => {
    res.render("home");
});

app.get("/cadastro", (req,res) => {
    res.render("cadastroCompleto");
});

app.get("/pagamento", (req,res) => {
    res.render("pagamentoRealizado");
});

app.get("/login", (req,res) => {
    res.render("login");
});

app.get("/perfil", async (req, res) => {
    try {
        if (req.session.user) {
            const userEmail = req.session.user;

            const query = `SELECT * FROM ViewClienteDetalhes WHERE email_cliente = '${userEmail}'`;
            const result = await database.sequelize.query(query, { type: QueryTypes.SELECT });

            const cliente = result.length > 0 ? result[0] : null;
            res.render("perfil", { cliente });
        } else {
            res.redirect("/login");
        }
    } catch (error) {
        res.status(500).send("<h1>Ocorreu um erro ao carregar o perfil.</h1>" + `<p>[ERRO]: ${error}</p>`);
    }
});



app.post("/autenticar-login", async (req,res) => {
    try {
        const {
            email,
            senha
        } = req.body;

        const result = await database.sequelize.query('CALL autenticar_usuario(?, ?)',
            {
                replacements: [email, senha]
            }
        );
        
        req.session.user = email;
        // res.send("<h1>Login Efetuado com Successo!</h1>")
        res.redirect("/perfil");
    } catch (err) {
        res.status(500).send("<h1>Falha ao fazer o login<h1>" + `<p>[ERRO]: ${err}</p>`);
    }
});

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

        const result = await database.sequelize.query('CALL sp_cadastroNovoCliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)',
            {
                replacements: [nome, sobrenome, email, senha, cpf, pacote, nomeCasa, cep, logradouro, bairro, numero, cidade, estado, complemento]
            }
        );

        res.redirect("/login")
    } catch (err) {
        console.error(err);
        res.status(500).send("<h1>Ocorreu um erro durante o cadastro.</h1>" + `<p>[ERRO]: ${err}</p>`);
    }
});



app.listen(porta, () => {
    console.log(`Servidor rodando na porta ${porta}`);
});
