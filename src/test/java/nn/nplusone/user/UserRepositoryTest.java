package nn.nplusone.user;

import jakarta.transaction.Transactional;
import nn.nplusone.company.Company;
import nn.nplusone.company.CompanyDto;
import nn.nplusone.company.CompanyWithoutFkDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;


    /**
     * findAll
     * FK를 안쓰는경우
     * N+1 문제없이 쿼리가 한번실행
     */
    @Test
    @Transactional
    void findAllListToWithoutFkDto(){
        List<User> process = repository.findAll();
        List<UserWithoutFkDto> result = process.stream().map(UserWithoutFkDto::new).collect(Collectors.toList());
        assertThat(result).isNotEmpty();
    }


    /**
     * findAll
     * FK를 쓰는경우
     * N+1 문제발생
     */
    @Test
    @Transactional
    void findAllListToDto(){
        List<User> process = repository.findAll();
        List<UserDto> result = process.stream().map(UserDto::new).collect(Collectors.toList());
        assertThat(result).isNotEmpty();
    }

    /**
     * FetchJoin
     * FK사용하는 DTO, fetch join 사용
     * N+1 문제없이 쿼리가 한번만 날라감
     */
    @Test
    @Transactional
    void findAllFetchJoinToDto(){
        List<User> process = repository.findAllByFetchJoin();
        List<UserDto> result = process.stream().map(UserDto::new).collect(Collectors.toList());
        assertThat(result).isNotEmpty();
    }



}