import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Producers {


    static void streams() {
        List.of(1,2,3,4).stream();
        Stream.of("a", "b", "c");
        Stream.<String>builder().add("a").add("b").build();
        Stream.generate(() -> "element").limit(10);
        Stream.iterate(40, n -> n + 2).limit(20);
        IntStream.range(1, 3);
        "abc".chars();

        Stream.empty();
       

    }

    static void rxjava() {
        Observable.fromIterable(List.of(1,2,3,4));
        Observable.just("a", "b", "c");
        Observable.create(sink -> {
                    sink.onNext("a");
                    sink.onNext("b");
                });
        Observable.generate(sink -> sink.onNext("a"));
        Observable.range(40, 60);
       
        Observable.fromStream( Stream.of("a", "b", "c"));
       
        Observable.empty();

        Observable.interval(10, TimeUnit.SECONDS);

        Observable.fromArray(new Object[] {1,"hallo", new Date()});

    }

    static void reactor() {
        Flux.fromIterable(List.of(1,2,3,4));
        Flux.just("a", "b", "c");
        Flux.create(sink -> {
            sink.next("a");
            sink.next("b");
        });
        Flux.generate(sink -> sink.next("a"));
        Flux.range(40, 60);

        Flux.fromStream( Stream.of("a", "b", "c"));

        Flux.empty();

        Flux.interval(Duration.ofSeconds(10));
        Flux.fromArray(new Object[] {1,"hallo", new Date()});

    }
}
