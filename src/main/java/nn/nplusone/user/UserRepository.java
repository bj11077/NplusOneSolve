package nn.nplusone.user;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select e from User e join fetch e.company")
    List<User> findAllByFetchJoin();


    @Override
    @EntityGraph(attributePaths = {"company"})
    List<User> findAll();
}
