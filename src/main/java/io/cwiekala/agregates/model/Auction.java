package io.cwiekala.agregates.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Auction {

    @Id
    private UUID id;

    private String title;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "auction", cascade = CascadeType.ALL) // TODO: kaskady!
    private List<Bid> bids;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    @Version
    private Integer version;

    @Builder
    public Auction(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.bids = new ArrayList<>();
    }

    public Bid placeBid(User user, BigDecimal amount, Currency currency) {
        Bid bid = new Bid(amount, user, this);
        addUserToAuction(user);
        user.addAuction(this);
        bids.add(bid);
        return bid;
    }

    private List<User> addUserToAuction(User user) {
        users.add(user);
        return users;
    }

}
