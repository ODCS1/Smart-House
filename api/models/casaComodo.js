const Sequelize = require('sequelize');
const database = require('../db');

const CasaComodo = database.define('CasaComodo', {
    id_casa: {
        type: Sequelize.INTEGER,
        allowNull: false
    },
    cod_comodo: {
        type: Sequelize.STRING(10),
        allowNull: false
    },
    qtd_led_comodo: {
        type: Sequelize.INTEGER,
        allowNull: false
    }
});

module.exports = CasaComodo;