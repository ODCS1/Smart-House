// const Sequelize = require('sequelize');
const database = require('../db');

const CasaComodo = database.sequelize.define('CasaComodo', {
    id_casa: {
        type: database.Sequelize.INTEGER,
        allowNull: false
    },
    cod_comodo: {
        type: database.Sequelize.STRING(10),
        allowNull: false
    },
    qtd_led_comodo: {
        type: database.Sequelize.INTEGER,
        allowNull: false
    }
});

module.exports = CasaComodo;