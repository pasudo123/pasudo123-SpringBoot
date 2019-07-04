
/**
 * reference
 * - https://github.com/chimurai/http-proxy-middleware#http-proxy-middleware-options
 * - https://webpack.js.org/configuration/dev-server/#devserverport
 * @type {{devServer: {proxy: {}}}}
 */

module.exports = {
    devServer: {

        port:8090,

        proxy:{
            '/api': {
                target: 'http://localhost:8080'
            }
        }
    }
};
