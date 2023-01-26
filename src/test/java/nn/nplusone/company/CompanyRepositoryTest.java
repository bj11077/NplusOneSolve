package nn.nplusone.company;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CompanyRepositoryTest {

    @Autowired
    CompanyRepository repository;

    @Test
    void findAllList(){
        List<Company> result = repository.findAll();
        assertThat(result).isNotEmpty();
    }

    /**
     * findAll
     * FK를 안쓰는경우
     * N+1 문제없이 쿼리가 한번실행
     */
    @Test
    @Transactional
    void findAllListToWithoutFkDto(){
        List<Company> process = repository.findAll();
        List<CompanyWithoutFkDto> result = process.stream().map(CompanyWithoutFkDto::new).collect(Collectors.toList());
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
        List<Company> process = repository.findAll();
        List<CompanyDto> result = process.stream().map(CompanyDto::new).collect(Collectors.toList());
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
        List<Company> process = repository.findAllByFetchJoin();
        List<CompanyDto> result = process.stream().map(CompanyDto::new).collect(Collectors.toList());
        assertThat(result).isNotEmpty();
    }

}