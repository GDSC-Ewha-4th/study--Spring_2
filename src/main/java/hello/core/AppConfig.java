package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//애플리케이션 전체를 설정하고 구성함
@Configuration //설정 정보
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository() 두 번 호출됨 그러면 싱글톤이 깨지는 게 아니냐?라고 생각할 수 있음
    // 각각 다른 2개의 MemoryMemberRepository가 생성되면서 싱글톤이 깨지는 것처럼 보임 스프링 컨테이너는 이걸 어떻게 해결할까?


    @Bean //스프링 컨테이너에 등록이 됨
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");

        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {

        System.out.println("call AppConfig.memberRepository");

        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){

        System.out.println("call AppConfig.orderService");

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        //   return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
