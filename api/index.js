// AQUI É ONDE OS MODELS SERÃO MANIPULADOS

(async () => {

    const database = require("./db");
    const Produto = require("./models/produto");
    await database.sync();

})();