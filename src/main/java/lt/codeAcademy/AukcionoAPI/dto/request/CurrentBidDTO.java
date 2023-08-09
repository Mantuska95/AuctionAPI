package lt.codeAcademy.AukcionoAPI.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrentBidDTO {


    private Double bid;
    private Long buyerId;
    private Long itemId;

}
