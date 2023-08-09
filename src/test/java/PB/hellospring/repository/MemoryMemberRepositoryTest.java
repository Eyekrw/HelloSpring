package PB.hellospring.repository;

import PB.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  // 메소드 각각 테스트 끝난 후에 무엇을 할 지 정해준다.
    public void afterEach(){
        repository.clearStore();  // 여기서는 테스트 하나 끝나면 레포지토리를 비워줬다.
    }   // 비워주는 이유는 findAll()이 테스트 되고 findByName이 테스트될 때 findAll() 때 레포지토리에 들어간 요소들 때문에
        // findByName 테스트할 때 오류가 생기기 때문이다.
        // 즉, 테스트마다 의존 관계를 완전 제거해준다. <-- 중요
    @Test
    public void save(){
        Member member=new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 =new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> m=new ArrayList<>();
        m.add(member1);
        m.add(member2);

        List<Member> result=repository.findAll();
        assertThat(result).isEqualTo(m);
    }
}
