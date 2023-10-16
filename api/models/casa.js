const Sequelize = require('sequelize');
const database = require('../db');

const Casa = database.define('Casa', {
    id_casa: {
        type: Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },
    nome_casa: Sequelize.STRING(40),
    qtd_led_casa: {
        type: Sequelize.INTEGER,
        allowNull: false
    },
    id_cliente: {
        type: Sequelize.INTEGER
    }
});

module.exports = Casa;
