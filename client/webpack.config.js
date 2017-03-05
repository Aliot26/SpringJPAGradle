const path = require('path');
const autoprefixer = require('autoprefixer');
const CommonsChunkPlugin = require('webpack/lib/optimize/CommonsChunkPlugin');
const ContextReplacementPlugin = require('webpack/lib/ContextReplacementPlugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const DefinePlugin = require('webpack/lib/DefinePlugin');
const ProgressPlugin = require('webpack/lib/ProgressPlugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const LoaderOptionsPlugin = require('webpack/lib/LoaderOptionsPlugin');

const HOST = 'localhost';
const PORT = 8088;

const loaders = {
    componentStyles: {
        test: /\.css$/,
        exclude: path.resolve('src', 'app'),
        loader: ExtractTextPlugin.extract({ fallbackLoader: 'style-loader', loader: 'css-loader' })
    },
    css:{
        test: /\.css$/,
        include: path.resolve('src', 'app'),
        loader: 'raw-loader'
    },
    html: {
        test: /\.html$/,
        loader: 'raw-loader'
    },
    json: {
        test: /\.json$/,
        loader: 'json-loader'
    },
    typescript: {
        test: /\.ts$/,
        loaders: ['awesome-typescript-loader?', 'angular2-template-loader'],
        exclude: /node_modules/
    }
};

const config = module.exports = {};

config.entry = {
    main: ['./src/main.ts'],
    polyfills: './src/polyfills.ts',
    vendor: './src/vendor.ts'
};

config.output = {
    filename: '[name].js',
    path: path.resolve('./dist')
};

config.resolve = {
    extensions: ['.ts', '.js', '.json', '.css', '.html']
};

config.module = {
    loaders: [
        loaders.typescript,
        loaders.html,
        loaders.componentStyles,
        loaders.css,
        loaders.json
    ]
};

config.plugins = [
    new ContextReplacementPlugin(
        /angular(\\|\/)core(\\|\/)(esm(\\|\/)src|src)(\\|\/)linker/,
        path.resolve('src')
    ),
    new LoaderOptionsPlugin({
        options: {
            tslint: {
                emitErrors: false,
                failOnHint: false
            },
            postcss: [
                autoprefixer({
                    browsers: ['last 2 version']
                })
            ]
        }
    })
];
config.plugins.push(
    new CommonsChunkPlugin({
        name: ['vendor', 'polyfills'],
        minChunks: Infinity
    }),
    new HtmlWebpackPlugin({
        chunkSortMode: 'dependency',
        filename: 'index.html',
        hash: false,
        inject: 'body',
        template: './src/public/index.html'
    }),
    new ExtractTextPlugin({filename: 'css/[name].css', disable: false})
);
config.devServer = {
    contentBase: './src/public',
    historyApiFallback: true,
    host: HOST,
    port: PORT,
    quiet: true,
    stats: 'minimal'
};