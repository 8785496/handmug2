var path = require('path');

var node_dir = __dirname + '/node_modules';

module.exports = {
    entry: './src/main/js/app.js',
    devtool: 'sourcemaps',
    cache: true,
    debug: true,
    output: {
        path: __dirname + '/src/main/resources/static/admin/js/',
        publicPath: "/admin/js/",
        filename: 'bundle.js'
    },
    module: {
        loaders: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                loader: 'babel-loader'
            }
        ]
    },
    devServer: {
        port: 9000,
        contentBase: __dirname + '/src/main/resources/templates/admin',
        proxy: {
            '/admin**': {
                target: 'http://localhost:8080',
                secure: false
            },
            '/api**': {
                target: 'http://localhost:8080',
                secure: false
            }
        }
    }
};