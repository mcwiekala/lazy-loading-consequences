package io.cwiekala.lazy.loading.repository;

import io.cwiekala.lazy.loading.model.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

}
