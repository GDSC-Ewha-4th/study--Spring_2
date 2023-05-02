package hello.core.member;

//관례상 구현체가 하나만 있을 때 Impl을 붙임
public class MemberServiceImpl implements MemberService {

    //command shift enter 세미콜론 붙여줌
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
