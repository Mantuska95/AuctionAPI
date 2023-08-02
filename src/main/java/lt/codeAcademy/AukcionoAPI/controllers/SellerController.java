package lt.codeAcademy.AukcionoAPI.controllers;

import lt.codeAcademy.AukcionoAPI.converters.BuyerConverter;
import lt.codeAcademy.AukcionoAPI.converters.SellerConverter;
import lt.codeAcademy.AukcionoAPI.dto.BuyerDTO;
import lt.codeAcademy.AukcionoAPI.dto.SellerDTO;
import lt.codeAcademy.AukcionoAPI.services.BuyerService;
import lt.codeAcademy.AukcionoAPI.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping
    public ResponseEntity<SellerDTO> createSeller(@RequestBody SellerDTO sellerDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(sellerService.addSeller(SellerConverter.convertDTOToSeller(sellerDTO)));
    }

    @PutMapping
    public ResponseEntity<SellerDTO> updateSeller(@RequestBody SellerDTO sellerDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(sellerService.updateSeller(SellerConverter.convertDTOToSeller(sellerDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerDTO> getSellerById(@PathVariable Long id) {
        return ResponseEntity.ok(sellerService.getSellerById(id));
    }

    @GetMapping
    public ResponseEntity<List<SellerDTO>> getAllSellers() {
        return ResponseEntity.ok(sellerService.getAllSellers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSellerById(@PathVariable Long id) {
        sellerService.deleteSellerById(id);
        return ResponseEntity.noContent().build();
    }
}
