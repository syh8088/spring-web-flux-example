package org.example;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;
import java.util.List;

// 구독정보 (구독자, 어떤 데이터를 구독할지)
public class MySubscription implements Subscription {

    private final Subscriber subscriber;
    private final Iterator<Integer> iterator;

    public MySubscription(Subscriber subscriber, List<Integer> integers) {
        this.subscriber = subscriber;
        this.iterator = integers.iterator();
    }

    @Override
    public void request(long l) {
        while (l > 0) {
            if (iterator.hasNext()) {
                subscriber.onNext(iterator.next());
            }
            else {
                subscriber.onComplete();
                break;
            }
            l--;
        }
    }

    @Override
    public void cancel() {

    }
}
