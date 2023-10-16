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

// SINCRONIZAR COM AQUI COM O BD
(async () => {
    await database.sync();
})();
