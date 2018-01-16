var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');


var routes = require('./routes/index');
var users = require('./routes/users');


var app = express();


var webpack = require('webpack');


var webpackDevServer=require("webpack-dev-server")
var webpackMiddleware = require('webpack-dev-middleware');
var webpackHotMiddleware  = require('webpack-hot-middleware');
var config = require('./webpack.config.js');
var compiler = webpack(config);
app.use(webpackMiddleware(compiler,{
    publicPath: config.output.publicPath,
    noInfo: false,
    reload: true,
    stats: { colors: true }
}));
app.use(webpackHotMiddleware(compiler,{
    log: console.log
}));


// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');


// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));