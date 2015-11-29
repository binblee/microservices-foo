package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RxJavaSampleApplication.class)
public class RxJavaSampleApplicationTests {

    private final String PARAM = "Hello World.";
    private final String RESULT = "Hello World.";

    @Test
    public void boilerplate(){
        Observable<String> observable = Observable.create(
            new Observable.OnSubscribe<String>(){

                @Override
                public void call(Subscriber<? super String> sub) {
                    sub.onNext(PARAM);
                    sub.onCompleted();
                }
            }
        );
        Subscriber<String> subscriber = new Subscriber<String>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(String s) {
                // Do something.
            }
        };

        observable.subscribe(subscriber);
    }

    @Test
    public void boilerplate_shorter(){
        Observable<String> observable = Observable.just(PARAM);
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                assertEquals(RESULT,s);
            }
        };
        observable.subscribe(onNextAction);
    }

	@Test
	public void lambada() {
        Observable<String> observable = Observable.just(PARAM);
        observable.subscribe(
            s -> {
                assertEquals(RESULT,s);
            }
        );
	}

    @Test
    public void map() {
        Observable.just(PARAM).map( s -> s + " - map result").subscribe(
            s -> assertEquals(RESULT + " - map result" ,s)
        );
    }

}
