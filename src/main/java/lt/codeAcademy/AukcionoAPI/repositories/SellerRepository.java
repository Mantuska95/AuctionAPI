package lt.codeAcademy.AukcionoAPI.repositories;

import lt.codeAcademy.AukcionoAPI.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
