package PB.hellospring.repository;

import PB.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store=new HashMap<>();
    private static long sequence=0L;  // id 굴리는 거
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // null일 수도 있는 반환값을 Optional로 감싸 반환하면 클라이언트쪽에서 처리 가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member-> member.getName().equals(name))
                .findAny();  // findAny는 결과가 Optional로 반환됨 / store를 돌면서 filter에 맞는 value가 나오면 그냥 그거 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());  // store.values()는 store에 저장된 모든 Member들의 리스트
    }

    public void clearStore(){
        store.clear();
    }
}
