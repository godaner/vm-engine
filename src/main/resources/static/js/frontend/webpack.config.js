var path = require('path');

module.exports = {
    entry: './main/main.js',
    output: {
        path: path.join(__dirname, '/dist'),
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['.js', '.jsx']
    },
    module: {
        loaders: [ {   //引入babel模块处理ES6代码
            test: /\.js|jsx$/,
            exclude: /node_modules/,
            loaders: 'babel-loader' ,

            query: {
                presets: ['es2015', 'react']
            }
        }]
    }
}