package lt.codeAcademy.AukcionoAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeAcademy.AukcionoAPI.entities.Item;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SellerDTO {

    private Long id;
    private String name;
    private String surname;
    private List<Item> itemList;

}
