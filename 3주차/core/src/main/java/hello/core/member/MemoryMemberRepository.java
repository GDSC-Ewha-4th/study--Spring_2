package hello.core.member;

/*option + enter*/

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    //실전에서는 동시성 문제 때문에 concurrenthashmap을 사용해야함
    private static Map<Long,Member> store = new HashMap<>();

    /*option + enter 단축키*/

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
