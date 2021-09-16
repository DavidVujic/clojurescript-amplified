## ClojureScript. Amplified.

In this repo, you will find examples on how to setup a `ClojureScript` web app with tools from the `JavaScript` ecosystem.

### Up and running
If you want to try out the `AWS Amplify` specific code, you will need to install a CLI from AWS 
and run some initialization steps. Everything is described in the official [Amplify docs](https://docs.amplify.aws/start/getting-started/installation/q/integration/react/#option-1-watch-the-video-guide).

There's an alias in `shadow-cljs.edn` named `:app-with-amplify` that will start up a AWS Amplify enabled app. 

#### Want to try out Storybook or Material-UI, without having to setup AWS Amplify?
If so, then you can safely skip the Amplify init stuff, and just use the `:app` alias.

##### Commands
``` shell
npm install
```

and

``` shell
npm run watch
```

or

``` shell
npm run watch-with-amplify
```

Because of AWS Amplify, I had to split the Clojure compilation from the 3rd party JavaScript build by
using both `shadow-cljs` and `Webpack`. Explained in the blog post [Hey Webpack, Hey ClojureScript](https://davidvujic.blogspot.com/2021/08/hey-webpack-hey-clojurescript.html)

If you have started the `watch-with-amplify` script, also run this in a separate terminal (otherwise you can skip this step):

``` shell
npm run pack
```

If you want to run `Storybook` and the stories available in this repo, there is a script ready for you:

``` shell
npm run storybook
```

#### Emacs user?

You can add a `.dir-locals.el` to the root of this repo to wire up the `shadow-cljs` commands,
instead of running the `npm` commands.

Emacs .dir-locals.el example for starting the app with the __Material-UI__ and __Storybook__ examples:

``` emacs-lisp
((nil . ((cider-default-cljs-repl . shadow)
         (cider-shadow-default-options . ":app")
         (cider-shadow-watched-builds . (":app" ":stories")))))
```

For __AWS Amplify__ example code, replace the `:app` alias with `:app-with-amplify`, like this:

``` emacs-lisp
((nil . ((cider-default-cljs-repl . shadow)
         (cider-shadow-default-options . ":app-with-amplify")
         (cider-shadow-watched-builds . (":app-with-amplify" ":stories")))))
```

### Articles

#### Develop a ClojureScript web app, using cool tools from the JavaScript ecosystem.
[ClojureScript.Amplified.](https://davidvujic.blogspot.com/2021/09/clojurescript-amplified.html)

#### About ClojureScript and a setup for AWS Amplify, using Webpack
[Hey Webpack, Hey ClojureScript](https://davidvujic.blogspot.com/2021/08/hey-webpack-hey-clojurescript.html)

#### About ClojureScript and Storybook
[Component Driven ClojureScript with Storybook](https://davidvujic.blogspot.com/2021/08/component-driven-clojurescript-with-storybook.html)

#### About Clojurescript and Material-UI
[Material Design in a Functional World](https://davidvujic.blogspot.com/2021/09/material-design-in-a-functional-world.html)

