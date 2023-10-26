// const Sequelize = require('sequelize');
const database = require('../db');

const Pacote = database.sequelize.define('Pacote', {
    id_pacote: {
        type: database.Sequelize.INTEGER,
        allowNull: false,
        primaryKey: true
    },
    nome_pacote: {
        type: database.Sequelize.STRING(50),
        allowNull: false,
        unique: true
    },
    valor_pacote: {
        type: database.Sequelize.DECIMAL(10, 2),
        allowNull: false
    },
    acesso: {
        type: database.Sequelize.STRING(27),
        allowNull: false
    }
},
{
    timestamps: false
});

module.exports = Pacote;
