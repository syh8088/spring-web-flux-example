package org.example;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;
import java.util.List;

public class MyPub implements Publisher<Integer> {

    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        System.out.println("구독자: 신문사야 나 너희 신문 볼께");
        System.out.println("신문사: 알겠어~~~ 구독정보를 만들어서 줄테니 기다려!!");
        MySubscription mySubscription = new MySubscription(subscriber, integers);

        System.out.println("신문사: 구독 정보 생성 완료");
        subscriber.onSubscribe(mySubscription);
    }
}
