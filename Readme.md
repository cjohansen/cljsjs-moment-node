# Reproducing issue with cljsjs/moment and node

I'm running into an issue where `moment` cannot be loaded from a node build with
any other optimizations than `none`. To reproduce:

Observe that dev, e.g. no optimizations, works just fine:

```clj
clojure -m figwheel.main --build-once dev
node target/node/dev/dev-main.js
#=> => #object[Moment Tue Jan 02 2018 00:00:00 GMT+0100]
```

Observe that prod, e.g. simple optimizations, does not:

```clj
clojure -m figwheel.main --build-once prod
node target/node/prod/prod-main.js
# ...
#   return moment("2018-01-02");
#   ^
#
# ReferenceError: moment is not defined
# ...
```

Same thing happens when running tests with Kaocha:

```clj
clojure -A:dev:test
# ...
# Caused by: clojure.lang.ExceptionInfo: No such namespace: cljsjs.moment, could not locate cljsjs/moment.cljs, cljsjs/moment.cljc, or JavaScript source providing "cljsjs.moment" in file src/cljsjs_moment_test/core.cljs {:tag :cljs/analysis-error}
# ...
```
