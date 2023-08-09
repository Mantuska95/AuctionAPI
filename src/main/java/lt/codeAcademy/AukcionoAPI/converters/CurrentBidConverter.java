package lt.codeAcademy.AukcionoAPI.converters;

import lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO;
import lt.codeAcademy.AukcionoAPI.entities.Buyer;
import lt.codeAcademy.AukcionoAPI.entities.CurrentBid;
import lt.codeAcademy.AukcionoAPI.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class CurrentBidConverter {

    public static lt.codeAcademy.AukcionoAPI.dto.request.CurrentBidDTO convertCurrentBidToDTORequest(CurrentBid currentBid) {
        lt.codeAcademy.AukcionoAPI.dto.request.CurrentBidDTO currentBidDTO = null;
        if (currentBid != null) {
            currentBidDTO = new lt.codeAcademy.AukcionoAPI.dto.request.CurrentBidDTO();
            currentBidDTO.setBid(currentBid.getBid());
            currentBidDTO.setItemId(currentBid.getItem().getId());
            currentBidDTO.setBuyerId(currentBid.getBuyer().getId());
        }
        return currentBidDTO;
    }

    public static lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO convertCurrentBidToDTOResponse(CurrentBid currentBid) {
        lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO currentBidDTO = null;
        if (currentBid != null) {
            currentBidDTO = new lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO();
            currentBidDTO.setBid(currentBid.getBid());
            currentBidDTO.setId(currentBid.getId());
            currentBidDTO.setItemId(currentBid.getItem().getId());
            currentBidDTO.setBuyerId(currentBid.getBuyer().getId());
        }
        return currentBidDTO;
    }

    public static CurrentBid convertDTOToCurrentBidRequest(lt.codeAcademy.AukcionoAPI.dto.request.CurrentBidDTO currentBidDTO) {
        CurrentBid currentBid = null;
        if (currentBidDTO != null) {
            currentBid = new CurrentBid();
            currentBid.setBid(currentBidDTO.getBid());
            if (currentBidDTO.getItemId() != null) {
                Item item = new Item();
                item.setId(currentBidDTO.getItemId());
                currentBid.setItem(item);
            }
            if (currentBidDTO.getBuyerId() != null) {
                Buyer buyer = new Buyer();
                buyer.setId(currentBidDTO.getBuyerId());
                currentBid.setBuyer(buyer);
            }
        }
        return currentBid;
    }

    public static CurrentBid convertDTOToCurrentBidResponse(lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO currentBidDTO) {
        CurrentBid currentBid = null;
        if (currentBidDTO != null) {
            currentBid = new CurrentBid();
            currentBid.setId(currentBidDTO.getId());
            currentBid.setBid(currentBidDTO.getBid());
            if (currentBidDTO.getItemId() != null) {
                Item item = new Item();
                item.setId(currentBidDTO.getItemId());
                currentBid.setItem(item);
            }
            if (currentBidDTO.getBuyerId() != null) {
                Buyer buyer = new Buyer();
                buyer.setId(currentBidDTO.getBuyerId());
                currentBid.setBuyer(buyer);
            }
        }
        return currentBid;
    }

    public static List<lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO> convertCurrentBidsToCurrentBidsDTO(Iterable<CurrentBid> currentBidList) {
        List<lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO> currentBidDTOList = null;
        if (currentBidList != null) {
            currentBidDTOList = new ArrayList<>();
            for (CurrentBid c : currentBidList) {
                currentBidDTOList.add(CurrentBidConverter.convertCurrentBidToDTOResponse(c));
            }
        }
        return currentBidDTOList;
    }

    public static List<CurrentBid> convertCurrentBidsDTOToCurrentBids(Iterable<lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO> currentBidDTOList) {
        List<CurrentBid> currentBidList = null;
        if (currentBidDTOList != null) {
            currentBidList = new ArrayList<>();
            for (CurrentBidDTO a : currentBidDTOList) {
                currentBidList.add(CurrentBidConverter.convertDTOToCurrentBidResponse(a));
            }
        }
        return currentBidList;
    }
}
