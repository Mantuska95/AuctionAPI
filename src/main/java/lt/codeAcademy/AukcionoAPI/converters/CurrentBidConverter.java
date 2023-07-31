package lt.codeAcademy.AukcionoAPI.converters;

import lt.codeAcademy.AukcionoAPI.dto.CurrentBidDTO;
import lt.codeAcademy.AukcionoAPI.entities.CurrentBid;

import java.util.ArrayList;
import java.util.List;

public class CurrentBidConverter {

    public static CurrentBidDTO convertCurrentBidToDTO(CurrentBid currentBid) {
        CurrentBidDTO currentBidDTO = null;
        if (currentBid != null) {
            currentBidDTO = new CurrentBidDTO();
            currentBidDTO.setBid(currentBid.getBid());
            currentBidDTO.setId(currentBid.getId());
        }
        return currentBidDTO;
    }

    public static CurrentBid convertDTOToCurrentBid(CurrentBidDTO currentBidDTO) {
        CurrentBid currentBid = null;
        if (currentBidDTO != null) {
            currentBid = new CurrentBid();
            currentBid.setId(currentBidDTO.getId());
            currentBid.setBid(currentBidDTO.getBid());
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
}
