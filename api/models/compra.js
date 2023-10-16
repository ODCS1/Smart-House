const Sequelize = require('sequelize');
const database = require('../db');

const Compra = database.define('Compra', {
    id_compra: {
        type: Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },
    id_cliente: {
        type: Sequelize.INTEGER,
        allowNull: false
    },
    id_pacote: {
        type: Sequelize.INTEGER,
        allowNull: false
    }
});

module.exports = Compra;
