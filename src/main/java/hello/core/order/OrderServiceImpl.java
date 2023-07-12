package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class OrderServiceImpl implements OrderService{
    //구체적인 클래스에 대해서 OrderServiceImpl은 전혀 모름
    private final MemberRepository memberRepository;
    private final DiscountPolicy  discountPolicy;
    //private final DiscountPolicy  discountPolicy = new RateDiscountPolicy();


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository ,  @MainDiscountPolicy DiscountPolicy discountPolicy){

        this.memberRepository = memberRepository;
        this.discountPolicy =discountPolicy;
    }

    //주문 생성 요청이 오면
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원 정보를 조회를 하고
        Member member = memberRepository.findById(memberId);
        //할인에 대해서는 잘 모르겠어, discountPolicy가 알아서 해줘 , 결과만 알려줘
        //할인 정책에다가 회원을 넘기는 거임 뭘 넘길지는 내가 고민을 하면 됨
        int discountPrice =discountPolicy.discount(member,itemPrice);
        return new Order(memberId , itemName , itemPrice, discountPrice);
    }

    //테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}