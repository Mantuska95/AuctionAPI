package lt.codeAcademy.AukcionoAPI.controllers;

import lt.codeAcademy.AukcionoAPI.converters.BuyerConverter;
import lt.codeAcademy.AukcionoAPI.dto.BuyerDTO;
import lt.codeAcademy.AukcionoAPI.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @PostMapping
    public ResponseEntity<BuyerDTO> createBuyer(@RequestBody BuyerDTO buyerDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(buyerService.addBuyer(BuyerConverter.convertDTOToBuyer(buyerDTO)));
    }

    @PutMapping
    public ResponseEntity<BuyerDTO> updateBuyer(@RequestBody BuyerDTO buyerDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(buyerService.updateBuyer(BuyerConverter.convertDTOToBuyer(buyerDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuyerDTO> getBuyerById(@PathVariable Long id) {
        return ResponseEntity.ok(buyerService.getBuyerById(id));
    }

    @GetMapping
    public ResponseEntity<List<BuyerDTO>> getAllBuyers(@RequestParam Pageable pageable) {
        return ResponseEntity.ok(buyerService.getAllBuyers(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyerById(@PathVariable Long id) {
        buyerService.deleteBuyerById(id);
        return ResponseEntity.noContent().build();
    }

}
