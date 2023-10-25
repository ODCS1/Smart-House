const Sequelize = require('sequelize');
const database = require('../db');

const Led = database.sequelize.define('Led', {
    cod_led: {
        type: database.Sequelize.STRING(10),
        allowNull: false,
        primaryKey: true
    },
    situacao: {
        type: database.Sequelize.BOOLEAN,
        allowNull: false
    },
    cod_comodo: {
        type: database.Sequelize.STRING(10),
        allowNull: false
    }
});

module.exports = Led;