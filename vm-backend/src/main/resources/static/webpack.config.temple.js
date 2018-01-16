var webpack = require('webpack');
module.exports = {
    entry: [
        'webpack/hot/dev-server',
        'webpack-hot-middleware/client?http://0.0.0.0:3000',
        __dirname+'/public/assets/js/entry.js'
    ],
    output: {
        path: '/',
        publicPath: 'http://127.0.0.1:3000/public/assets/',
        filename: 'bundle.js'
    },
    // output: {
    //     path: '/public/assets/',
    //     publicPath: '/public/assets/',
    //     filename: 'bundle.js'
    // },
    plugins: [
        new webpack.HotModuleReplacementPlugin()
    ],
    module: {
        loaders: [
            {test: /\.js$/, loader: "jsx"},
            {test: /\.css$/, loader: "style!css"},
            {test: /\.(jpg|png)$/, loader: "url?limit=8192"},
            {test: /\.scss$/, loader: "style!css!sass"}
        ]
    }
};