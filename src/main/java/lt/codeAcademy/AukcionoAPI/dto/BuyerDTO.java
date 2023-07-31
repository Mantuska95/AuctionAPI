package lt.codeAcademy.AukcionoAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BuyerDTO {

    private Long id;
    private String name;
    private String surname;

}
