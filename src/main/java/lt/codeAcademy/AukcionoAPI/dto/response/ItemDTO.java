package lt.codeAcademy.AukcionoAPI.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeAcademy.AukcionoAPI.entities.CurrentBid;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemDTO {

    private Long id;
    private String name;
    private String information;
    private Double reservedPrice;
    private List<CurrentBidDTO> currentBidList;
    private Long sellerId;

}
