package lt.codeAcademy.AukcionoAPI.services;

import lombok.AllArgsConstructor;
import lt.codeAcademy.AukcionoAPI.converters.ItemConverter;
import lt.codeAcademy.AukcionoAPI.dto.request.ItemDTO;
import lt.codeAcademy.AukcionoAPI.entities.Item;
import lt.codeAcademy.AukcionoAPI.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    public ItemDTO addItem(Item item) {
        itemRepository.save(item);
        return ItemConverter.convertItemToDTORequest(item);
    }

    public lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO getItemById(Long id) {
        return ItemConverter.convertItemToDTOResponse(itemRepository.getReferenceById(id));
    }

    public List<lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO> getAllItems() {
        return ItemConverter.convertItemsToDTO(itemRepository.findAll());
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    public Item updateItem(Long id, lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO item) {
        Item itemToUpdate = itemRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        itemToUpdate.setInformation(item.getInformation());
        itemToUpdate.setName(item.getName());
        itemToUpdate.setReservedPrice(item.getReservedPrice());
        return itemToUpdate;
    }
}
