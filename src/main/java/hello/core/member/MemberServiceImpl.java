package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    //생성자를 통해서 member respository에 구현체가 뭐가 들어갈지를
    @Autowired //생성자에 의존관계 자동으로 주입해주기위해 붙여줌
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member){
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId){
        return memberRepository.findById((memberId));
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}