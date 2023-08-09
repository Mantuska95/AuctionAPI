package lt.codeAcademy.AukcionoAPI.repositories;

import lt.codeAcademy.AukcionoAPI.entities.CurrentBid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentBidRepository extends JpaRepository<CurrentBid, Long> {


}
