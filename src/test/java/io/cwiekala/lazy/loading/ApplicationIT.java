package io.cwiekala.lazy.loading;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.cwiekala.lazy.loading.model.Address;
import io.cwiekala.lazy.loading.model.Auction;
import io.cwiekala.lazy.loading.model.Bid;
import io.cwiekala.lazy.loading.model.User;
import io.cwiekala.lazy.loading.repository.AddressRepository;
import io.cwiekala.lazy.loading.repository.AuctionRepository;
import io.cwiekala.lazy.loading.repository.BidRepository;
import io.cwiekala.lazy.loading.repository.UserRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationIT {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    BidRepository bidRepository;

    @Test
    void testApplicationContext(){
        // given
        Address address1 = Address.builder().city("Warsaw").build();
        addressRepository.save(address1);

        Auction auction1 = Auction.builder().build();
        auctionRepository.save(auction1);

        User user = User.builder().build();
        userRepository.save(user);

        Bid bid = Bid.builder().build();
        bidRepository.save(bid);

        // when
        List<Address> addresses = addressRepository.findAll();
        List<User> users = userRepository.findAll();
        List<Auction> auctions = auctionRepository.findAll();
        List<Bid> bids = bidRepository.findAll();

        // then
        assertThat(addresses.size()).isEqualTo(1);
        assertThat(users.size()).isEqualTo(1);
        assertThat(auctions.size()).isEqualTo(1);
        assertThat(bids.size()).isEqualTo(1);
    }

    @BeforeEach
    void clean(){
        addressRepository.deleteAll();
        userRepository.deleteAll();
        auctionRepository.deleteAll();
        bidRepository.deleteAll();
    }

}
