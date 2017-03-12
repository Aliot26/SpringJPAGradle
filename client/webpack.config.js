const path = require('path');
const CommonsChunkPlugin = require('webpack/lib/optimize/CommonsChunkPlugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');


const loaders = {
    htmlCss: {
        test: /\.(html|css)$/,
        loader: 'raw-loader'
    },
    typescript: {
        test: /\.ts$/,
        loaders: ['awesome-typescript-loader', 'angular2-template-loader']
    }
};

module.exports = {
    entry: {
        polyfills: './src/polyfills.ts',
        vendor: './src/vendor.ts',
        main: './src/main.ts'
    },
    output: {
        filename: '[name].js',
        path: path.resolve('./dist')
    },
    resolve: {
        extensions: ['.ts', '.js']
    },
    module: {
        loaders: [
            loaders.typescript,
            loaders.htmlCss
        ]
    },
    plugins: [
        new CommonsChunkPlugin({
            name: ['vendor', 'polyfills']
        }),
        new HtmlWebpackPlugin({
            chunkSortMode: 'dependency',
            filename: 'index.html',
            template: './src/public/index.html'
        })
    ],
    devServer: {
        contentBase: './dist',
        port: 3000,
        proxy: {
            '/': 'http://localhost:8080/SpringJPAGradleN/'
        }
    }
};

