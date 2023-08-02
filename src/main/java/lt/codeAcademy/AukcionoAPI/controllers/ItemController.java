package lt.codeAcademy.AukcionoAPI.controllers;

import lt.codeAcademy.AukcionoAPI.converters.BuyerConverter;
import lt.codeAcademy.AukcionoAPI.converters.ItemConverter;
import lt.codeAcademy.AukcionoAPI.dto.BuyerDTO;
import lt.codeAcademy.AukcionoAPI.dto.ItemDTO;
import lt.codeAcademy.AukcionoAPI.services.BuyerService;
import lt.codeAcademy.AukcionoAPI.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemService.addItem(ItemConverter.convertDTOToItem(itemDTO)));
    }

    @PutMapping
    public ResponseEntity<ItemDTO> updateItem(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.updateItem(ItemConverter.convertDTOToItem(itemDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItem() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }
}
