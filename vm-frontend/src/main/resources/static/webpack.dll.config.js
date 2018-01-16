const webpack = require("webpack")
const library = '[name]_lib'
const path = require("path")

module.exports = {
    entry: {
        vendors: ["react","antd"]
    },
    output: {
        filename: "[name].dll.js",
        path: __dirname+"/dist/",
        library
    },
    plugins: [
        new webpack.DllPlugin({
            path: path.join(__dirname, "dist/[name]-manifest.json"),
            name: library
        })
    ]
}