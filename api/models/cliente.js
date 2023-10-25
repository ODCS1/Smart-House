const database = require('../db');

const Cliente = database.sequelize.define('Cliente', {
    id_cliente: {
        type: database.Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },
    nome_cliente: {
        type: database.Sequelize.STRING(30),
        allowNull: false
    },
    sobrenome_cliente: database.Sequelize.STRING(50),
    email_cliente: {
        type: database.Sequelize.STRING(100),
        allowNull: false,
        unique: true
    },
    senha_cliente: {
        type: database.Sequelize.STRING(20),
        allowNull: false,
        validate: {
            len: [8, 20]
        }
    },
    cpf_cliente: {
        type: database.Sequelize.BIGINT,
        allowNull: false,
        unique: true,
        validate: {
            is: /^[0-9]{11}$/
        }
    }
});

module.exports = Cliente;
