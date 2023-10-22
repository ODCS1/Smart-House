const Sequelize = require('sequelize');
const sequelize = new Sequelize('SistemaCasa', 'root', '123456', {
    dialect: 'mysql',
    host: 'localhost',
    // port: 1433 SQL SERVER
    port: 3306 //mysql
});

sequelize.authenticate()
.then(() => {
    console.log("Conexão com o banco de dados foi realizada com sucesso!");
}).catch(() => {
    console.log("ERRO: Não foi possível realizar a conexão com o banco de dados!");
})

module.exports = sequelize;