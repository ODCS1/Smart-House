// const Sequelize = require('sequelize');
const database = require('../db');

const Casa = database.sequelize.define('Casa', {
    id_casa: {
        type: database.Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },
    nome_casa: database.Sequelize.STRING(40),
    qtd_led_casa: {
        type: database.Sequelize.INTEGER,
        allowNull: false
    },
    id_cliente: {
        type: database.Sequelize.INTEGER
    }
});

module.exports = Casa;
