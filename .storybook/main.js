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
  "core": {
    "builder": "webpack5"
  },
  webpackFinal: (config) => {
    const { rules } = config.module;
    config.module.rules = [...rules, ...appConfig.module.rules];

    config.plugins.push(new webpack.ProvidePlugin({
      process: 'process/browser',
    }));

    return config;
  },
}
