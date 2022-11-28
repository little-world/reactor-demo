import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class LettersZip {

    public static void main(String[] args) {
        rxjava();
        reactor();
    }


    public static void rxjava() {
        List<String> words = List.of("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
        Observable.fromIterable(words)
                .flatMap(word -> Observable.fromArray(word.split("")))
                .distinct()
                .sorted()
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string))
                .subscribe(System.out::println);
    }

    public static void reactor() {
        List<String> words = List.of("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
        Flux.fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string))
                .subscribe(System.out::println);
    }

}
