package lt.codeAcademy.AukcionoAPI.controllers;

import lt.codeAcademy.AukcionoAPI.converters.ItemConverter;
import lt.codeAcademy.AukcionoAPI.dto.request.ItemDTO;
import lt.codeAcademy.AukcionoAPI.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;
    @PreAuthorize("hasAnyRole('ADMIN','SELLER')")
    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemService.addItem(ItemConverter.convertDTOToItemRequest(itemDTO)));
    }
    @PreAuthorize("hasAnyRole('ADMIN','SELLER')")
    @PutMapping("/{id}")
    public ResponseEntity<lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO> updateItem(@RequestBody lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO itemDTO, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ItemConverter.convertItemToDTOResponse(itemService.updateItem(id ,itemDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @GetMapping
    public ResponseEntity<List<lt.codeAcademy.AukcionoAPI.dto.response.ItemDTO>> getAllItem() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }
}
