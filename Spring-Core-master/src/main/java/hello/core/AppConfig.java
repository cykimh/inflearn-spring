package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 구성정보
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    // 역할이 다 들어난다
    // 이 코드만 바꾸면 된다
    private MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    // 역할이 들어난다
    public DiscountPolicy discountPolicy() {
//         return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
