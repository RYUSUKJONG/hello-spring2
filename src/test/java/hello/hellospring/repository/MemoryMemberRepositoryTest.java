package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.assertj.core.api.Assertions;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();   //테스트마다 저장소를 한번씩 비워줌
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        //repository.findById()

        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result);
        //org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);

    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        //org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1);
        System.out.println(result);

    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);


    }


}