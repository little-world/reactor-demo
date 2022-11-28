import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Consumers {


    static void streams () {

        var source = Stream.of(1,2,3,4,5);
        source.forEach(System.out::println);
        long count = source.count();
        Optional<Integer> first = source.findFirst();

        Optional<Integer> reduce = source.reduce((a, b) -> a + b);
        List<Integer> collect = source.collect(Collectors.toList());

        List<Integer> integers = source.toList();// since java16
    }


    static void rxjava () {

        var source = Observable.just(1,2,3,4,5);
        source.forEach(System.out::println);

        long count = source.count().blockingGet();
        Maybe<Integer> first = source.firstElement();
        Maybe<Integer> reduce = source.reduce((a, b) -> a + b);
        Single<List<Integer>> collect = source.collect(Collectors.toList());


        Iterable<Integer> integers = source.blockingIterable();
        Single<@NonNull List<Integer>> list = source.toList();

        source.subscribe();
    }

    static void reactor () {

       var source = Flux.just(1,2,3,4,5);

        source.subscribe(System.out::println);
        long count = source.count().block();
        Integer first = source.blockFirst();
        Mono<Integer> reduce = source.reduce((a, b) -> a + b);
        Mono<List<Integer>> collect = source.collect(Collectors.toList());

        Iterable<Integer> integers = source.toIterable();
        Mono<List<Integer>> listMono = source.collectList();


    }



}
