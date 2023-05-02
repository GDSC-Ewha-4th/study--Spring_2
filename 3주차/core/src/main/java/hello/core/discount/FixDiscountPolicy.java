package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAccount = 1000; //1000원 할인
    @Override
    public int discount(Member member, int price) {
        //enum 타입은 비교시 == 사용
        if(member.getGrade() == Grade.VIP){
            return discountFixAccount;
        }else{
            return 0;
        }
    }
}
