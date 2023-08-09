package PB.hellospring.service;

import PB.hellospring.domain.Member;
import PB.hellospring.repository.MemberRepository;
import PB.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    // 회원서비스 기능(핵심로직)을 구현하기 위해 데이터저장소에 저장된 데이터에 접근해야 한다.
    // 리포지토리(데이터저장소와 서비스 사이 기능 구현)를 통해 접근하게 되므로
    // 리포지토리를 선언한다. 이때, 변경할 여지가 없으므로 final로 선언한다.
    private final MemberRepository memberRepository=new MemoryMemberRepository();

    /* 회원 가입 */
    public Long join(Member member){
        validateDuplicatedMember(member);  // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    /* 중복 회원 검증 */
    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });  // ifPresent는 Optional 변수의 값이 있으면 람다식 ㄱㄱ
    }

    /* 전체 회원 조회 */
    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    /* id로 회원 조회 */
    public Optional<Member> findMember(Long memberId){
        return memberRepository.findById(memberId);
    }

    public MemoryMemberRepository getMemberRepository(){
        return (MemoryMemberRepository) memberRepository;
    }
}
