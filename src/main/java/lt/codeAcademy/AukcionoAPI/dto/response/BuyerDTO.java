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
public class BuyerDTO {

    private Long id;
    private String name;
    private String surname;
    private List<CurrentBidDTO> currentBidList;
}
