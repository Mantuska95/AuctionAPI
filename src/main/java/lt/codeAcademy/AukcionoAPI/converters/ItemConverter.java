package lt.codeAcademy.AukcionoAPI.converters;

import lt.codeAcademy.AukcionoAPI.dto.ItemDTO;
import lt.codeAcademy.AukcionoAPI.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemConverter {

    public static ItemDTO convertItemToDTO(Item item){
        ItemDTO itemDTO = null;
        if(item != null){
            itemDTO = new ItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setName(item.getName());
            itemDTO.setInformation(item.getInformation());
        }
        return itemDTO;
    }

    public static Item convertDTOToItem(ItemDTO itemDTO){
        Item item = null;
        if (itemDTO != null){
            item = new Item();
            item.setId(itemDTO.getId());
            item.setName(itemDTO.getName());
            item.setInformation(itemDTO.getInformation());
        }
        return item;
    }

    public static List<ItemDTO> convertItemsToDTO(Iterable<Item> itemList){
        List<ItemDTO> itemDTOList = null;
        if(itemList != null){
            itemDTOList = new ArrayList<>();
            for (Item i : itemList){
                itemDTOList.add(ItemConverter.convertItemToDTO(i));
            }
        }
        return itemDTOList;
    }
}
