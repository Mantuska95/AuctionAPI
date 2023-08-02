package lt.codeAcademy.AukcionoAPI.services;

import lombok.AllArgsConstructor;
import lt.codeAcademy.AukcionoAPI.converters.ItemConverter;
import lt.codeAcademy.AukcionoAPI.dto.ItemDTO;
import lt.codeAcademy.AukcionoAPI.entities.Item;
import lt.codeAcademy.AukcionoAPI.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    public ItemDTO addItem(Item item){
        itemRepository.save(item);
        return ItemConverter.convertItemToDTO(item);
    }

    public ItemDTO getItemById(Long id){
        return ItemConverter.convertItemToDTO(itemRepository.getReferenceById(id));
    }

    public List<ItemDTO> getAllItems(){
        return ItemConverter.convertItemsToDTO(itemRepository.findAll());
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    public ItemDTO updateItem(Item item){
        Item itemToUpdate = itemRepository.findById(item.getId()).orElseThrow(() -> new NoSuchElementException());
        itemToUpdate.setInformation(item.getInformation());
        itemToUpdate.setName(item.getName());
        itemToUpdate.setCurrentBid(item.getCurrentBid());
        return ItemConverter.convertItemToDTO(itemToUpdate);
    }
}
