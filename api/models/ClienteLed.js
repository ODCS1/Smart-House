const database = require('../db');

const ClienteLed = database.sequelize.define('ClienteLeds', {
    id_cliente_led: {
        type: database.Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },
    id_cliente: {
        type: database.Sequelize.INTEGER,
        allowNull: false
    },
    led_1: {
        type: database.Sequelize.STRING(10),
        allowNull: false
    },
    led_2: {
        type: database.Sequelize.STRING(10),
        allowNull: false
    },
    led_3: {
        type: database.Sequelize.STRING(10),
        allowNull: true
    },
    led_4: {
        type: database.Sequelize.STRING(10),
        allowNull: true
    },
    led_5: {
        type: database.Sequelize.STRING(10),
        allowNull: true
    },
    led_6: {
        type: database.Sequelize.STRING(10),
        allowNull: true
    },
    led_7: {
        type: database.Sequelize.STRING(10),
        allowNull: true
    },
    led_8: {
        type: database.Sequelize.STRING(10),
        allowNull: true
    },
    led_9: {
        type: database.Sequelize.STRING(10),
        allowNull: true
    },
    led_10: {
        type: database.Sequelize.STRING(10),
        allowNull: true
    },
    led_11: {
        type: database.Sequelize.STRING(10),
        allowNull: true
    },
    led_12: {
        type: database.Sequelize.STRING(10),
        allowNull: true
    },
    led_13: {
        type: database.Sequelize.STRING(10),
        allowNull: true
    },
},
{
    timestamps: false
});

module.exports = ClienteLed;