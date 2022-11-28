import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.stream.IntStream;

public class CreateFlux {



    public static void main(String[] args) {

       // reactor_create();
        rxjava_create();
    }


    private static void rxjava_create() {

        System.out.println("rxjava");
        System.out.println("- 1 -");
        Observable<Integer> myObserver = Observable.create(subscriber -> {
            try {
                System.out.println("- 2 -");
                for (int i = 0; i < 5; i++)
                    subscriber.onNext(i);
                System.out.println("- 3 -");

                subscriber.onComplete();
            } catch (Exception e) {

                subscriber.onError(e);
            }

        });

        System.out.println("- 4 -");
        myObserver.subscribe(
                v -> System.out.println(v),
                e -> System.out.println(e),
                () -> System.out.println("complete")
        );
        System.out.println("- 5 -");
    }

    private static void reactor_create() {
        System.out.println("reactor");
        System.out.println("- 1 -");
        Flux<Integer> myObserver = Flux.create(subscriber -> {
            try {
                System.out.println("- 2 -");
                for (int i = 0; i < 5; i++)
                    subscriber.next(i);
                System.out.println("- 3 -");

                subscriber.complete();
            } catch (Exception e) {

                subscriber.error(e);
            }

        });

        System.out.println("- 4 -");
        myObserver.subscribe(
                v -> System.out.println(v),
                e -> System.out.println(e),
                () -> System.out.println("complete")
        );
        System.out.println("- 5 -");
    }
}
