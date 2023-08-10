package lt.codeAcademy.AukcionoAPI.converters;

import lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO;
import lt.codeAcademy.AukcionoAPI.entities.Item;
import lt.codeAcademy.AukcionoAPI.entities.Seller;

import java.util.ArrayList;
import java.util.List;

public class ItemConverter {

    public static lt.codeAcademy.AukcionoAPI.dto.request.ItemDTO convertItemToDTORequest(Item item){
        lt.codeAcademy.AukcionoAPI.dto.request.ItemDTO itemDTO = null;
        if(item != null){
            itemDTO = new lt.codeAcademy.AukcionoAPI.dto.request.ItemDTO();
            itemDTO.setName(item.getName());
            itemDTO.setInformation(item.getInformation());
            itemDTO.setReservedPrice(item.getReservedPrice());
            itemDTO.setSellerId(item.getSeller().getId());
        }
        return itemDTO;
    }

    public static lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO convertItemToDTOResponse(Item item){
        lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO itemDTO = null;
        if(item != null){
            itemDTO = new lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setName(item.getName());
            itemDTO.setInformation(item.getInformation());
            itemDTO.setReservedPrice(item.getReservedPrice());
            itemDTO.setCurrentBidList(CurrentBidConverter.convertCurrentBidsToCurrentBidsDTO(item.getCurrentBid()));
            itemDTO.setSellerId(item.getSeller().getId());
        }
        return itemDTO;
    }

    public static Item convertDTOToItemRequest(lt.codeAcademy.AukcionoAPI.dto.request.ItemDTO itemDTO){
        Item item = null;
        if (itemDTO != null){
            item = new Item();
            item.setName(itemDTO.getName());
            item.setInformation(itemDTO.getInformation());
            item.setReservedPrice(itemDTO.getReservedPrice());
            if (itemDTO.getSellerId() != null) {
                Seller seller = new Seller();
                seller.setId(itemDTO.getSellerId());
                item.setSeller(seller);
            }
        }
        return item;
    }

    public static Item convertDTOToItemResponse(lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO itemDTO){
        Item item = null;
        if (itemDTO != null){
            item = new Item();
            item.setId(itemDTO.getId());
            item.setName(itemDTO.getName());
            item.setInformation(itemDTO.getInformation());
            item.setReservedPrice(itemDTO.getReservedPrice());
            item.setCurrentBid(CurrentBidConverter.convertCurrentBidsDTOToCurrentBids(itemDTO.getCurrentBidList()));
            if (itemDTO.getSellerId() != null) {
                Seller seller = new Seller();
                seller.setId(itemDTO.getSellerId());
                item.setSeller(seller);
            }
        }
        return item;
    }

    public static List<lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO> convertItemsToDTO(Iterable<Item> itemList){
        List<lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO> itemDTOList = null;
        if(itemList != null){
            itemDTOList = new ArrayList<>();
            for (Item i : itemList){
                itemDTOList.add(ItemConverter.convertItemToDTOResponse(i));
            }
        }
        return itemDTOList;
    }

    public static List<Item> convertItemsDTOToItems(Iterable<lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO> itemListDTO){
        List<Item> itemList = null;
        if(itemListDTO != null){
            itemList = new ArrayList<>();
            for (ItemDTO i : itemListDTO){
                itemList.add(ItemConverter.convertDTOToItemResponse(i));
            }
        }
        return itemList;
    }
}
