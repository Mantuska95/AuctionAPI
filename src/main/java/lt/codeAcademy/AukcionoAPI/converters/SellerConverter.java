package lt.codeAcademy.AukcionoAPI.converters;

import lt.codeAcademy.AukcionoAPI.dto.SellerDTO;
import lt.codeAcademy.AukcionoAPI.entities.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerConverter {

    public static SellerDTO convertSellerToDTO(Seller seller) {
        SellerDTO sellerDTO = null;
        if (seller != null) {
            sellerDTO = new SellerDTO();
            sellerDTO.setId(seller.getId());
            sellerDTO.setName(seller.getName());
            sellerDTO.setSurname(seller.getSurname());
            sellerDTO.setItemListDTO(ItemConverter.convertItemsToDTO(seller.getItem()));
        }
        return sellerDTO;
    }

    public static Seller convertDTOToSeller(SellerDTO sellerDTO) {
        Seller seller = null;
        if (sellerDTO != null) {
            seller = new Seller();
            seller.setId(sellerDTO.getId());
            seller.setName(sellerDTO.getName());
            seller.setSurname(seller.getSurname());
            seller.setItem(ItemConverter.convertItemsDTOToItems(sellerDTO.getItemListDTO()));
        }
        return seller;
    }

    public static List<SellerDTO> convertSellersToDTO(Iterable<Seller> sellerList) {
        List<SellerDTO> sellerDTOList = null;
        if (sellerList != null) {
            sellerDTOList = new ArrayList<>();
            for (Seller s : sellerList) {
                sellerDTOList.add(SellerConverter.convertSellerToDTO(s));
            }
        }
        return sellerDTOList;
    }
}
