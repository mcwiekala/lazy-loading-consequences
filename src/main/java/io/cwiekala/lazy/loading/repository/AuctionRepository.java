package io.cwiekala.lazy.loading.repository;

import io.cwiekala.lazy.loading.model.Auction;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, UUID> {

}
