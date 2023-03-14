package ua.denys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.denys.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
