package hello.core.order;
import hello.core.discount.discountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository; //지우기
    private final discountPolicy discountPolicys; //discountPolicy 인터페이스에만 의존

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, discountPolicy discountPolicys) { // 생성자 만들기
        this.memberRepository = memberRepository;
        this.discountPolicys = discountPolicys;
    }

    // private final discountPolicy discountPolicys = new FixDiscountPolicy();
   // private final discountPolicy discountPolicys = new RateDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.FindById(memberId);
        int discountPrice = discountPolicys.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    //test용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}