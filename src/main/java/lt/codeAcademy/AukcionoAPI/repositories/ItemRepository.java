package lt.codeAcademy.AukcionoAPI.repositories;

import lt.codeAcademy.AukcionoAPI.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
