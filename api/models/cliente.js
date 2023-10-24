const database = require('../db');

const Cliente = database.define('Cliente', {
    id_cliente: {
        type: Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },
    nome_cliente: {
        type: Sequelize.STRING(30),
        allowNull: false
    },
    sobrenome_cliente: Sequelize.STRING(50),
    email_cliente: {
        type: Sequelize.STRING(100),
        allowNull: false,
        unique: true
    },
    senha_cliente: {
        type: Sequelize.STRING(20),
        allowNull: false,
        validate: {
            len: [8, 20]
        }
    },
    cpf_cliente: {
        type: Sequelize.BIGINT,
        allowNull: false,
        unique: true,
        validate: {
            is: /^[0-9]{11}$/
        }
    }
});

module.exports = Cliente;
