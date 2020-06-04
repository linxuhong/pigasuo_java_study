
var Callable = Java.type("java.util.concurrent.Callable");
var Worker = Java.extend(Callable, {
    call: function() {
        return Math.random();
    }
});

var executor = java.util.concurrent.Executors.newFixedThreadPool(4);
var random, futures = [];
try {
    for (var i = 1; i <= 10; i++) {
        futures.push(executor["submit(java.util.concurrent.Callable)"](
            new Worker())
        );
    }

    var random = futures.map(function(f) f.get());
} finally {
    executor.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS);
    executor.shutdownNow();
}

print(projectId);


