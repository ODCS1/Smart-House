const database = require('../db');

const Compra = database.sequelize.define('Compras', {
    id_compra: {
        type: database.Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },
    id_cliente: {
        type: database.Sequelize.INTEGER,
        allowNull: false
    },
    id_pacote: {
        type: database.Sequelize.INTEGER,
        allowNull: false
    }
},
{
    timestamps: false
});

module.exports = Compra;
