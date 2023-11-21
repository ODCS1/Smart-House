const database = require('../db');

const Led = database.sequelize.define('Leds', {
    cod_led: {
        type: database.Sequelize.STRING(10),
        allowNull: false,
        primaryKey: true
    },
    cod_comodo: {
        type: database.Sequelize.STRING(10),
        allowNull: false
    }
},
{
    timestamps: false
});

module.exports = Led;