package io.cwiekala.lazy.loading.repository;

import io.cwiekala.lazy.loading.model.Address;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}
