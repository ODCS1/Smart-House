const Sequelize = require('sequelize');
const database = require('../db');

const Comodo = database.define('Comodo', {
    cod_comodo: {
        type: Sequelize.STRING(10),
        allowNull: false,
        primaryKey: true
    },
    nome_comodo: {
        type: Sequelize.STRING(25),
        allowNull: false,
        unique: true
    }
});

module.exports = Comodo;