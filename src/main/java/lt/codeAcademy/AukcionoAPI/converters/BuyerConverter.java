package lt.codeAcademy.AukcionoAPI.converters;

import lt.codeAcademy.AukcionoAPI.dto.BuyerDTO;
import lt.codeAcademy.AukcionoAPI.entities.Buyer;

import java.util.ArrayList;
import java.util.List;

public class BuyerConverter {

    public static BuyerDTO convertBuyerToDTO(Buyer buyer) {
        BuyerDTO buyerDTO = null;
        if (buyer != null) {
            buyerDTO = new BuyerDTO();
            buyerDTO.setId(buyer.getId());
            buyerDTO.setName(buyer.getName());
            buyerDTO.setSurname(buyer.getSurname());
        }
        return buyerDTO;
    }

    public static Buyer convertDTOToBuyer(BuyerDTO buyerDTO) {
        Buyer buyer = null;
        if (buyerDTO != null) {
            buyer = new Buyer();
            buyer.setId(buyerDTO.getId());
            buyer.setName(buyerDTO.getName());
            buyer.setSurname(buyerDTO.getSurname());
        }
        return buyer;
    }

    public static List<BuyerDTO> covertBuyersToBuyersDTO(Iterable<Buyer> buyerList) {
        List<BuyerDTO> buyerDTOList = null;
        if (buyerList != null) {
            buyerDTOList = new ArrayList<>();
            for (Buyer b : buyerList) {
                buyerDTOList.add(BuyerConverter.convertBuyerToDTO(b));
            }
        }
        return buyerDTOList;
    }
}
