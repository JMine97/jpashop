package jpabook.jpashop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest //실제 스프링 프레임워크 띄워서 테스트
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    //처리 도중 에러가 났을 때 처리한 쿼리 자동 rollback
    @Transactional //@Transactional이 @Test에 있으면 테스트 끝나고 롤백함
    @Rollback(false) //Rollback 안 하고 commit 함함
   public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("최정민");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

        //같은 영속성 컨텍스트에서 아이디 값이 같으면 같은 객체로 인식한다
        assertThat(findMember).isEqualTo(member);
        System.out.println("findMember==member: " + (findMember==member));

    }


}