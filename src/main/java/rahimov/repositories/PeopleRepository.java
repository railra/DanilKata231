package rahimov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rahimov.models.User;
@Repository
public interface PeopleRepository extends JpaRepository<User, Integer> {
}
