package jpabook.jpashop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId(); //저장하면 return 값은 id 정도만 하는 걸로
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
