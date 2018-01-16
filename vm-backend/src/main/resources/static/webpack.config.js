const path = require('path');
const webpack = require('webpack');
// const ExtractTextPlugin = require('extract-text-webpack-plugin');
const UglifyJSPlugin = require('uglifyjs-webpack-plugin');


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
        loaders: [{   //引入babel模块处理ES6代码
            test: /\.js|jsx$/,
            exclude: /node_modules/,
            loaders: 'babel-loader',

            query: {
                presets: ['react', 'es2015']
            }
        }, {
            test: /\.(css|scss)$/,
            loader: "style-loader!css-loader!sass-loader"
        }]
    },
    plugins: [
        new webpack.optimize.UglifyJsPlugin({
            output: {
                comments: false,  // remove all comments
            },
            compress: {
                warnings: false
            }
        }),
        new webpack.DllReferencePlugin({
            context: __dirname,
            manifest: require("./dist/vendors-manifest.json")
        }),

    ]
}