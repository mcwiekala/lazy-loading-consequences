package io.cwiekala.lazy.loading.repository;

import io.cwiekala.lazy.loading.model.Bid;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, UUID> {

    List<Bid> findByAuctionId(UUID auctionID);

}
