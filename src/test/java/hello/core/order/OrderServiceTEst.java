package hello.core.order;
        import hello.core.member.Grade;
        import hello.core.member.Member;
        import hello.core.member.MemberService;
        import hello.core.member.MemberSeriviceImpl;
        import org.assertj.core.api.Assertions;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.*;
class OrderServiceTEst {
    MemberService memberService = new MemberSeriviceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
