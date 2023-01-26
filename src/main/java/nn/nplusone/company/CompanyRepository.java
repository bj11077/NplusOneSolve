package nn.nplusone.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    @Query("select e from Company e join fetch e.users")
    List<Company> findAllByFetchJoin();






}
