package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy  discountPolicy = new FixDiscountPolicy();

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
}
