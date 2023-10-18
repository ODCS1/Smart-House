const Sequelize = require('sequelize');
const database = require('../db');

const Endereco = database.define('Endereco', {
    id_endereco: {
        type: Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },
    cep: {
        type: Sequelize.INTEGER,
        allowNull: false,
        validate: {
            is: /[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]/
        }
    },
    logradouro: {
        type: Sequelize.STRING(40),
        allowNull: false
    },
    bairro: {
        type: Sequelize.STRING(30),
        allowNull: false
    },
    numero: {
        type: Sequelize.INTEGER,
        allowNull: false
    },
    cidade: {
        type: Sequelize.STRING(40),
        allowNull: false
    },
    estado: {
        type: Sequelize.CHAR(2),
        allowNull: false
    },
    complemento: Sequelize.STRING(50),
    id_casa: {
        type: Sequelize.INTEGER
    }
});

module.exports = Endereco;