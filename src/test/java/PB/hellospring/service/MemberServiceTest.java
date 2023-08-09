package PB.hellospring.service;

import PB.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService service = new MemberService();

    @AfterEach
    public void afterEach(){
        service.getMemberRepository().clearStore();
    }
/*
    @Test
    public void joinTest(){
        Member member1=new Member();
        member1.setName("spring1");
        service.join(member1);

        Member member2 =new Member();
        member2.setName("spring1");
        try {
            service.join(member2);
        } catch(IllegalStateException e){
            e.printStackTrace();
        }
    }*/

    @Test
    void 회원가입() {

    }

    @Test
    void 모든회원찾기() {
    }

    @Test
    void 특정회원찾기() {
    }
}
