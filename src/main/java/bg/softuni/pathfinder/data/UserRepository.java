package bg.softuni.pathfinder.data;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.web.dto.UserLoginDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
