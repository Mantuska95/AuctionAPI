package lt.codeAcademy.AukcionoAPI.repositories;

import lt.codeAcademy.AukcionoAPI.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
