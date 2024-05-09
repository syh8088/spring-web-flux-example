package org.example;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("구독자 : 구독 정보 잘 받았어");
        this.subscription = subscription;

        System.out.println("구독자: 나 이제 신문 한개씩 줘!");
        subscription.request(1); // 신문 한개씩 매일 줘! (백프레셔) 소비자가 한번에 처리 할수 있는 개수를 요청
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("구독 데이터 전달: onNext(): " + integer);
        System.out.println("하루지남");
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("구독중 에러");
    }

    @Override
    public void onComplete() {
        System.out.println("구독 완료");
    }
}
