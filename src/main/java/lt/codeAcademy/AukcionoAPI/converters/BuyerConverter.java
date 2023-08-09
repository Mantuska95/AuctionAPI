package lt.codeAcademy.AukcionoAPI.converters;

import lt.codeAcademy.AukcionoAPI.entities.Buyer;

import java.util.ArrayList;
import java.util.List;

public class BuyerConverter {

    public static lt.codeAcademy.AukcionoAPI.dto.request.BuyerDTO convertBuyerToDTORequest(Buyer buyer) {
        lt.codeAcademy.AukcionoAPI.dto.request.BuyerDTO buyerDTO = null;
        if (buyer != null) {
            buyerDTO = new lt.codeAcademy.AukcionoAPI.dto.request.BuyerDTO();
            buyerDTO.setName(buyer.getName());
            buyerDTO.setSurname(buyer.getSurname());
        }
        return buyerDTO;
    }

    public static lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO convertBuyerToDTOResponse(Buyer buyer) {
        lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO buyerDTO = null;
        if (buyer != null) {
            buyerDTO = new lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO();
            buyerDTO.setId(buyer.getId());
            buyerDTO.setName(buyer.getName());
            buyerDTO.setSurname(buyer.getSurname());
            buyerDTO.setCurrentBidList(CurrentBidConverter.convertCurrentBidsToCurrentBidsDTO(buyer.getCurrentBid()));
        }
        return buyerDTO;
    }

    public static Buyer convertDTOToBuyerRequest(lt.codeAcademy.AukcionoAPI.dto.request.BuyerDTO buyerDTO) {
        Buyer buyer = null;
        if (buyerDTO != null) {
            buyer = new Buyer();
            buyer.setName(buyerDTO.getName());
            buyer.setSurname(buyerDTO.getSurname());
        }
        return buyer;
    }

    public static Buyer convertDTOToBuyerResponse(lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO buyerDTO) {
        Buyer buyer = null;
        if (buyerDTO != null) {
            buyer = new Buyer();
            buyer.setId(buyerDTO.getId());
            buyer.setName(buyerDTO.getName());
            buyer.setSurname(buyerDTO.getSurname());
            buyer.setCurrentBid(CurrentBidConverter.convertCurrentBidsDTOToCurrentBids(buyerDTO.getCurrentBidList()));
        }
        return buyer;
    }

    public static List<lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO> covertBuyersToBuyersDTO(Iterable<Buyer> buyerList) {
        List<lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO> buyerDTOList = null;
        if (buyerList != null) {
            buyerDTOList = new ArrayList<>();
            for (Buyer b : buyerList) {
                buyerDTOList.add(BuyerConverter.convertBuyerToDTOResponse(b));
            }
        }
        return buyerDTOList;
    }
}
