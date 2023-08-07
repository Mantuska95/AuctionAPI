package lt.codeAcademy.AukcionoAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrentBidDTO {

    private Long id;
    private Double bid;
    private Long buyerDTOId;
    private Long itemDTOId;

}
