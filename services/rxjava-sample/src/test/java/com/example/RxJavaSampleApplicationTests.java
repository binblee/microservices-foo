package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void map_to_different_type(){
        Observable.just(PARAM)
            .map(s -> s.hashCode())
            .subscribe(s -> assertEquals(s.hashCode(),PARAM.hashCode()));
    }

    @Test
    public void from(){
        List<String> list = Arrays.asList(PARAM,PARAM,PARAM);
        Observable.from(list)
            .subscribe(s -> {
                assertEquals(PARAM,s);
                System.out.println(s);
            });
    }

    @Test
    public void filter(){
        List<String> list = Arrays.asList("Blah Blah", PARAM, "Blah Blah again");
        Observable.from(list)
            .filter(s -> s.equals(PARAM))
            .subscribe( s -> assertEquals(PARAM,s));
    }

    @Test
    public void take(){
        List<String> list = Arrays.asList("Blah Blah", PARAM, "Blah Blah again");
        Observable.from(list)
            .take(2)
            .subscribe(s -> System.out.println(s));
    }

    private Observable<List<String>> fakeQueryToGenerateStringList(){
        List<String> list = Arrays.asList(PARAM,PARAM,PARAM);
        return Observable.just(list);
    }

    // loopInSubscribe, observableInSubscribe and flatMap
    // three ways to implement loop within Observable objects

    @Test
    public void loopInSubscribe(){
        fakeQueryToGenerateStringList().subscribe(ss -> {
            for (String s : ss){
                System.out.println(s);
                assertEquals(PARAM, s);
            }
        });
    }

    @Test
    public void observableInSubscribe(){
        fakeQueryToGenerateStringList().subscribe(
            ss -> Observable.from(ss).subscribe(
                s -> {
                    System.out.println(s);
                    assertEquals(PARAM, s);
                }
            )
        );
    }

    @Test
    public void flatMap(){
        fakeQueryToGenerateStringList()
            .flatMap( ss -> Observable.from(ss) )
            .subscribe(s -> {
                System.out.println(s);
                assertEquals(PARAM,s);
            } )
        ;
    }

    private Observable<Integer> getStringLength(String s){
        Integer length = new Integer(s.length());
        return Observable.just(length);
    }
    @Test
    public void multipleFlatMap(){
        fakeQueryToGenerateStringList()
            .flatMap( ss -> Observable.from(ss) )
            .flatMap( s -> {
                System.out.println(s);
                return getStringLength(s);
            }).subscribe(
                s -> System.out.println(s)
            );
    }

    @Test
    public void errorHandling(){
        fakeMethodThatThrowException()
            .subscribe(new Subscriber<String>(){
                @Override
                public void onCompleted() {
                    System.out.println("onCompleted is invoked.");
                }

                @Override
                public void onError(Throwable e) {
                    System.out.println("onError is invoked.");
                }

                @Override
                public void onNext(String s) {
                    System.out.println("onNext is invoked.");
                }
            });
    }

    // TODO why onError cannot catch this exception?
    private Observable<String> fakeMethodThatThrowException(){
//        return Observable.just(PARAM);
        throw new InvalidParameterException();
    }
}
