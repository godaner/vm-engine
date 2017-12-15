var path = require('path');

module.exports = {
    entry: './main/main.js',
    output: {
        path: path.join(__dirname, '/dist'),
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['.js', '.jsx'],
        // 别名，可以直接使用别名来代表设定的路径以及其他
        alias: {
            components: path.join(__dirname, './components')
        }
    },
    module: {
        loaders: [ {   //引入babel模块处理ES6代码
            test: /\.js|jsx$/,
            exclude: /node_modules/,
            loaders: 'babel-loader' ,

            query: {
                presets: ['react', 'es2015']
            }
        }]
    }
}