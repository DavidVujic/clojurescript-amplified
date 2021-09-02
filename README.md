### ClojureScript. Amplified.

In this repo, you will find examples on how to setup a `ClojureScript` web app with tools from the `JavaScript` ecosystem.

#### Up and running
If you want to try out the `AWS Amplify` specific code, you will need to install a CLI from AWS 
and run some initialization steps. Everything is described in the official [Amplify docs](https://docs.amplify.aws/start/getting-started/installation/q/integration/react/#option-1-watch-the-video-guide).

##### Want to try out Storybook, without having to setup AWS Amplify?
If so, then You can safely skip the Amplify init stuff, delete the `aws` specific requires and the initialization in the `app.core` namespace.
I plan to split the example code into branches (something like `with-amplify` and `with-storybook`) shortly.

##### Commands
``` shell
npm install
npm run watch
```

Emacs user? You can add a `.dir-locals.el` to the root of this repo to wire up the `shadow-cljs` commands,
insted of running the `npm run watch` command.

Emacs `.dir-locals.el` example:

``` emacs-lisp
((nil . ((cider-default-cljs-repl . shadow)
         (cider-shadow-default-options . ":app")
         (cider-shadow-watched-builds . (":app" ":stories")))))
```

Because of AWS Amplify, I had to split the Clojure compilation from the 3rd party JavaScript build by
using both `shadow-cljs` and `Webpack`. Explained in the blog post [Hey Webpack, Hey ClojureScript](https://davidvujic.blogspot.com/2021/08/hey-webpack-hey-clojurescript.html)

To build the JavaScript libraries, run this in a separate terminal:

``` shell
npm run pack
```

If you want to run `Storybook` and the stories available in this repo, there is a script ready for you:

``` shell
npm run storybook
```

#### About ClojureScript and AWS Amplify, using Webpack
[Hey Webpack, Hey ClojureScript](https://davidvujic.blogspot.com/2021/08/hey-webpack-hey-clojurescript.html)

#### About ClojureScript and Storybook
[Component Driven ClojureScript with Storybook](https://davidvujic.blogspot.com/2021/08/component-driven-clojurescript-with-storybook.html)

More example code, tools setup and blog posts in the making ...
