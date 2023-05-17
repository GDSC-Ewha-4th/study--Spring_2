package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.discount.discountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberSeriviceImpl;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; //드디어 스프링이다

@Configuration
public class AppConfig {

    ///memberService 빈을 만드는 코드를 보면 memberRepository() 를 호출한다.
    //이 메서드를 호출하면 new MemoryMemberRepository() 를 호출한다.
    //orderService 빈을 만드는 코드도 동일하게 memberRepository() 를 호출한다.
    //이 메서드를 호출하면 new MemoryMemberRepository() 를 호출한다.
    //결과적으로 각각 다른 2개의 MemoryMemberRepository 가 생성되면서 싱글톤이 깨지는 것 처럼 보인다.
    //스프링 컨테이너는 이 문제를 어떻게 해결할까?
    @Bean
    public MemberService memberService(){ //interface인 멤버서비스를 반환
        System.out.println("call AppConfig.memberService");
        return new MemberSeriviceImpl(memberRepository()); // new MemberServiceImpl()
    //생성자 주입
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicys());
    }
    @Bean
    public discountPolicy discountPolicys(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
