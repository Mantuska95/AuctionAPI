package lt.codeAcademy.AukcionoAPI.converters;

import lt.codeAcademy.AukcionoAPI.dto.CurrentBidDTO;
import lt.codeAcademy.AukcionoAPI.entities.Buyer;
import lt.codeAcademy.AukcionoAPI.entities.CurrentBid;
import lt.codeAcademy.AukcionoAPI.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class CurrentBidConverter {

    public static CurrentBidDTO convertCurrentBidToDTO(CurrentBid currentBid) {
        CurrentBidDTO currentBidDTO = null;
        if (currentBid != null) {
            currentBidDTO = new CurrentBidDTO();
            currentBidDTO.setBid(currentBid.getBid());
            currentBidDTO.setId(currentBid.getId());
            currentBidDTO.setItemDTOId(currentBid.getItem().getId());
            currentBidDTO.setBuyerDTOId(currentBid.getBuyer().getId());
        }
        return currentBidDTO;
    }

    public static CurrentBid convertDTOToCurrentBid(CurrentBidDTO currentBidDTO) {
        CurrentBid currentBid = null;
        if (currentBidDTO != null) {
            currentBid = new CurrentBid();
            currentBid.setId(currentBidDTO.getId());
            currentBid.setBid(currentBidDTO.getBid());
            if (currentBidDTO.getItemDTOId() != null) {
                Item item = new Item();
                item.setId(currentBidDTO.getItemDTOId());
                currentBid.setItem(item);
            }
            if (currentBidDTO.getBuyerDTOId() != null) {
                Buyer buyer = new Buyer();
                buyer.setId(currentBidDTO.getId());
                currentBid.setBuyer(buyer);
            }
        }
        return currentBid;
    }

    public static List<CurrentBidDTO> convertCurrentBidsToCurrentBidsDTO(Iterable<CurrentBid> currentBidList) {
        List<CurrentBidDTO> currentBidDTOList = null;
        if (currentBidList != null) {
            currentBidDTOList = new ArrayList<>();
            for (CurrentBid c : currentBidList) {
                currentBidDTOList.add(CurrentBidConverter.convertCurrentBidToDTO(c));
            }
        }
        return currentBidDTOList;
    }

    public static List<CurrentBid> convertCurrentBidsDTOToCurrentBids(Iterable<CurrentBidDTO> currentBidDTOList) {
        List<CurrentBid> currentBidList = null;
        if (currentBidDTOList != null) {
            currentBidList = new ArrayList<>();
            for (CurrentBidDTO a : currentBidDTOList) {
                currentBidList.add(CurrentBidConverter.convertDTOToCurrentBid(a));
            }
        }
        return currentBidList;
    }
}
