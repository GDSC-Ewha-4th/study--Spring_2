package hello.core.order;
import hello.core.discount.discountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new
            MemoryMemberRepository();
    private final discountPolicy discountPolicys = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.FindById(memberId);
        int discountPrice = discountPolicys.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}