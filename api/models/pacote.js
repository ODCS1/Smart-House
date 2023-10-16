const Sequelize = require('sequelize');
const database = require('../db');

const Pacote = database.define('Pacote', {
    id_pacote: {
        type: Sequelize.INTEGER,
        allowNull: false,
        primaryKey: true
    },
    nome_pacote: {
        type: Sequelize.STRING(50),
        allowNull: false,
        unique: true
    },
    valor_pacote: {
        type: Sequelize.DECIMAL(10, 2),
        allowNull: false
    },
    acesso: {
        type: Sequelize.STRING(27),
        allowNull: false
    }
});

module.exports = Pacote;
