package lt.codeAcademy.AukcionoAPI.dto.request;

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

    private String name;
    private String surname;

}
