package PB.hellospring.repository;

import PB.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;


// 이 interface repository가 필요한 이유는 시나리오 가정상 아직 회원 정보를 저장할 db를 정하지 못했지 때문이다.
// 따라서 일단 interface로 만들고 MemoryMemberRepository로 메모리에 회원 정보들을 저장하는 방식으로 일단 구현한다.
// 후에 db가 정해지면 repository interface가 존재하므로 이걸 emplements해서 구현하면 된다.
public interface MemberRepository {
    Member save(Member member);  // 회원 저장하면 저장된 회원 반환
    Optional<Member> findById(Long id);  // 회원 id로 찾기
    Optional<Member> findByName(String name);  // 회원 이름으로 찾기
    List<Member> findAll();  // 모든 회원 찾기
}

// Optional이 무엇?
// Optional은 NPE(NullPointerException)를 방지하기 위해 사용된다.
// 위에서 findById를 예로 들면 만약 회원 id로 못찾았을 때 null을 반환하지 않고, Optional.empty()를 반환하게 된다.

// java에서 list가 동적배열이고 그 종류로 linkedList랑 ArrayList가 있는데 ArrayList를 주로 씀. c++로 치면 vector같은거
// java에서 map은 HashMap이랑 TreeMap이 있음. c++의 map이랑 비슷한건 TreeMap이고 HashMap은 정렬 관계 없음 아무튼 c++과
// 비슷하게 map은 key -> value로 찾는 자료구조