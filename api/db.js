const Sequelize = require('sequelize');
const sequelize = new Sequelize('projeto_casa', 'user_adv', '12345678', {
    dialect: 'mysql',
    host: 'db4free.net',
    // port: 1433 SQL SERVER
    port: 3306 //mysql
});

sequelize.authenticate()
.then(() => {
    console.log("Conexão com o banco de dados foi realizada com sucesso!");
}).catch(() => {
    console.log("ERRO: Não foi possível realizar a conexão com o banco de dados!");
})

module.exports = {
    Sequelize: Sequelize,
    sequelize: sequelize
}