package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입
    public Long join(Member member) {
        validateDuplicateMember(member);
        Member joinMember = memberRepository.save(member);
        return joinMember.getId();
    }

    private void validateDuplicateMember(Member member) {
        if (memberRepository.existsByName(member.getName())) {
            throw new IllegalStateException("이미 존재하는 회원 이름입니다.");
        }
    }

    // 회원 전체 조회
    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 조회
    @Transactional(readOnly = true)
    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow();
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findById(id).orElseThrow();
        member.changeName(name);
    }
}
