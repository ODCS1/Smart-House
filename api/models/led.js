const Sequelize = require('sequelize');
const database = require('../db');

const Led = database.define('Led', {
    cod_led: {
        type: Sequelize.STRING(10),
        allowNull: false,
        primaryKey: true
    },
    situacao: {
        type: Sequelize.BOOLEAN,
        allowNull: false
    },
    cod_comodo: {
        type: Sequelize.STRING(10),
        allowNull: false
    }
});

module.exports = Led;