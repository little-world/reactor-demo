import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class LazyEvaluation {

    public static void main(String[] args) {
        rxjava();

        reactor();
    }


    private static void rxjava() {
        Observable.fromStream(Stream.iterate(1, i -> i + 1))
                .doOnNext(i -> System.out.println("before: " + i))
                .map(i -> i * 2)
                .filter(i -> i > 5)
                .doOnNext(i -> System.out.println("after: " + i))
                .take(3)
                .subscribe(first -> System.out.println("subscribe : " + first));


    }

    private static void reactor() {
        Flux.fromStream(Stream.iterate(1, i -> i + 1))
                .doOnNext(i -> System.out.println("before: " + i))
                .map(i -> i * 2)
                .filter(i -> i > 5)
                .doOnNext(i -> System.out.println("after: " + i))
                .take(3)
                .subscribe(first -> System.out.println("subscribe : " + first));


    }
}
