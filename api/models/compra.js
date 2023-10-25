// const Sequelize = require('sequelize');
const database = require('../db');

const Compra = database.sequelize.define('Compra', {
    id_compra: {
        type: database.Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },
    id_cliente: {
        type: database.Sequelize.INTEGER,
        allowNull: false
    },
    id_pacote: {
        type: database.Sequelize.INTEGER,
        allowNull: false
    }
});

module.exports = Compra;
