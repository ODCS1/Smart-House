const database = require('../db');

const Endereco = database.sequelize.define('Enderecos', {
    id_endereco: {
        type: database.Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },
    cep: {
        type: database.Sequelize.INTEGER,
        allowNull: false,
        validate: {
            is: /^[0-9]{8}$/
        }
    },
    logradouro: {
        type: database.Sequelize.STRING(40),
        allowNull: false
    },
    bairro: {
        type: database.Sequelize.STRING(30),
        allowNull: false
    },
    numero: {
        type: database.Sequelize.INTEGER,
        allowNull: false
    },
    cidade: {
        type: database.Sequelize.STRING(40),
        allowNull: false
    },
    estado: {
        type: database.Sequelize.CHAR(2),
        allowNull: false
    },
    complemento: database.Sequelize.STRING(50),
    id_casa: {
        type: database.Sequelize.INTEGER
    }
},
{
    timestamps: false
});

module.exports = Endereco;