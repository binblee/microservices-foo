# RxJava Example

### Operators

Run in RxJavaSampleApplicationTests:

- map
- filter
- from
- take

### Reference

[Grokking RxJava, Part 1: The Basics](http://blog.danlew.net/2014/09/15/grokking-rxjava-part-1/)

[Grokking RxJava, Part 2: Operator, Operator](http://blog.danlew.net/2014/09/22/grokking-rxjava-part-2/)

[Grokking RxJava, Part 3: Reactive with Benefits](http://blog.danlew.net/2014/09/30/grokking-rxjava-part-3/)

[Grokking RxJava, Part 4: Reactive Android](http://blog.danlew.net/2014/10/08/grokking-rxjava-part-4/)

### Schedulers (from [part 3](http://blog.danlew.net/2014/09/30/grokking-rxjava-part-3/) )
In RxJava, you can tell your Observer code which thread to run on using
subscribeOn(), and which thread your Subscriber should run on using observeOn():

```java
myObservableServices.retrieveImage(url)
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(bitmap -> myImageView.setImageBitmap(bitmap));
```
