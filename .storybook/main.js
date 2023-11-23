const appConfig = require('../webpack.config.js');
const webpack = require('webpack');

module.exports = {
  "stories": [
    "../public/js/stories/*_stories.js"
  ],

  "addons": [
    "@storybook/addon-links",
    "@storybook/addon-essentials"
  ],

  webpackFinal: (config) => {
    const { rules } = config.module;
    config.module.rules = [...rules, ...appConfig.module.rules];

    config.plugins.push(new webpack.ProvidePlugin({
      process: 'process/browser',
    }));

    return config;
  },

  docs: {
    autodocs: true
  },

  framework: {
    name: "@storybook/react-webpack5",
    options: {}
  }
}
