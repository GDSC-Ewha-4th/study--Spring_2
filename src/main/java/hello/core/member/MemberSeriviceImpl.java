package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberSeriviceImpl implements  MemberService{
    private  final MemberRepository memberRepository; //지우고

    @Autowired  //ac.getBean(MemberRepository.class)
    public MemberSeriviceImpl(MemberRepository memberRepository) { //생성자를 통해서 선택
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.FindById(memberId);
    }


    //test용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
