package cheboksarov.blps_lab3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long betId;
    @ManyToOne(fetch = FetchType.LAZY)
    private SiteUser siteUser;
    @ManyToOne
    @JoinColumn(name = "fk_coeff_id", referencedColumnName = "coeff_id")
    private Coefficient coefficient;
    private BetEvent betEvent;
    private BetStatus betStatus;
    private Double amount;

    public enum BetEvent{
        HostsWins,
        GuestsWins,
        TotalOne,
        TotalTwo,
        TotalThree
    }
    public enum BetStatus{
        Processing,
        Accepted,
        Win,
        Lose
    }
}
