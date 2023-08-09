package lt.codeAcademy.AukcionoAPI.converters;

import lt.codeAcademy.AukcionoAPI.dto.request.SellerDTO;
import lt.codeAcademy.AukcionoAPI.entities.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerConverter {

    public static lt.codeAcademy.AukcionoAPI.dto.request.SellerDTO convertSellerToDTORequest(Seller seller) {
        lt.codeAcademy.AukcionoAPI.dto.request.SellerDTO sellerDTO = null;
        if (seller != null) {
            sellerDTO = new lt.codeAcademy.AukcionoAPI.dto.request.SellerDTO();
            sellerDTO.setName(seller.getName());
            sellerDTO.setSurname(seller.getSurname());
        }
        return sellerDTO;
    }

    public static lt.codeAcademy.AukcionoAPI.dto.response.SellerDTO convertSellerToDTOResponse(Seller seller) {
        lt.codeAcademy.AukcionoAPI.dto.response.SellerDTO sellerDTO = null;
        if (seller != null) {
            sellerDTO = new lt.codeAcademy.AukcionoAPI.dto.response.SellerDTO();
            sellerDTO.setId(seller.getId());
            sellerDTO.setName(seller.getName());
            sellerDTO.setSurname(seller.getSurname());
            sellerDTO.setItemList(ItemConverter.convertItemsToDTO(seller.getItem()));
        }
        return sellerDTO;
    }

    public static Seller convertDTOToSellerRequest(lt.codeAcademy.AukcionoAPI.dto.request.SellerDTO sellerDTO) {
        Seller seller = null;
        if (sellerDTO != null) {
            seller = new Seller();
            seller.setName(sellerDTO.getName());
            seller.setSurname(sellerDTO.getSurname());
        }
        return seller;
    }

    public static Seller convertDTOToSellerResponse(lt.codeAcademy.AukcionoAPI.dto.response.SellerDTO sellerDTO) {
        Seller seller = null;
        if (sellerDTO != null) {
            seller = new Seller();
            seller.setId(sellerDTO.getId());
            seller.setName(sellerDTO.getName());
            seller.setSurname(sellerDTO.getSurname());
            seller.setItem(ItemConverter.convertItemsDTOToItems(sellerDTO.getItemList()));
        }
        return seller;
    }

    public static List<lt.codeAcademy.AukcionoAPI.dto.response.SellerDTO> convertSellersToDTO(Iterable<Seller> sellerList) {
        List<lt.codeAcademy.AukcionoAPI.dto.response.SellerDTO> sellerDTOList = null;
        if (sellerList != null) {
            sellerDTOList = new ArrayList<>();
            for (Seller s : sellerList) {
                sellerDTOList.add(SellerConverter.convertSellerToDTOResponse(s));
            }
        }
        return sellerDTOList;
    }
}
