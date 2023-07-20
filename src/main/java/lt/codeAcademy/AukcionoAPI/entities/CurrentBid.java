package lt.codeAcademy.AukcionoAPI.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "currentBid")
public class CurrentBid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bid")
    private Double bid;

    @OneToMany(mappedBy = "currentBid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Buyer> buyers;

    @OneToMany(mappedBy = "currentBid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
