package hello.core.member;

public class MemberSeriviceImpl implements  MemberService{
    private  final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.FindById(memberId);
    }
}
