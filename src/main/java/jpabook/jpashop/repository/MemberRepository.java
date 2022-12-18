package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);

    boolean existsByName(String name);
}
