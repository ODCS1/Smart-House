const Sequelize = require('sequelize');
const sequelize = new Sequelize('SistemaCasa', 'root', '123456', {
    dialect: 'mysql',
    host: 'localhost',
    // port: 1433 SQL SERVER
    port: 3306 //mysql
});

module.exports = sequelize;