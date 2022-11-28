import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class BasicDemo {

    public static void main(String[] args) {


        Stream.of(1, 2, 3, 4, 5, 6)
                .filter(x -> x > 3)
                .map(x -> x * 2)
                .forEach(System.out::println);

        Flux.just(1, 2, 3, 4, 5, 6)
                .filter(x -> x > 3)
                .map(x -> x * 2)
                .subscribe(System.out::println);

        Observable.just(1, 2, 3, 4, 5, 6)
                .filter(x -> x > 3)
                .map(x -> x * 2)
                .subscribe(System.out::println);
    }
}
