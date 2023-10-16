const Sequelize = require('sequelize');
const database = require('../db');

const Cliente = database.define('cliente', {
    id_cliente: {
        type: Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },

    nome: {
        type: Sequelize.STRING(150),
        allowNull: false
    },

    preco: Sequelize.DECIMAL,
    descricao: Sequelize.STRING
});

module.exports = Cliente;