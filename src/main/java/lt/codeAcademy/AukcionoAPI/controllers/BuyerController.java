package lt.codeAcademy.AukcionoAPI.controllers;

import lt.codeAcademy.AukcionoAPI.converters.BuyerConverter;
import lt.codeAcademy.AukcionoAPI.dto.request.BuyerDTO;
import lt.codeAcademy.AukcionoAPI.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerService buyerService;
    @PreAuthorize("hasAnyRole('ADMIN','BUYER')")
    @PostMapping
    public ResponseEntity<BuyerDTO> createBuyer(@RequestBody BuyerDTO buyerDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(buyerService.addBuyer(BuyerConverter.convertDTOToBuyerRequest(buyerDTO)));
    }

    @PreAuthorize("hasAnyRole('ADMIN','BUYER')")
    @PutMapping("/{id}")
    public ResponseEntity<lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO> updateBuyer(@RequestBody lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO buyerDTO, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(BuyerConverter.convertBuyerToDTOResponse(buyerService.updateBuyer(buyerDTO, id)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO> getBuyerById(@PathVariable Long id) {
        return ResponseEntity.ok(buyerService.getBuyerById(id));
    }

    @GetMapping
    public ResponseEntity<List<lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO>> getAllBuyers(@RequestParam Pageable pageable) {
        return ResponseEntity.ok(buyerService.getAllBuyers(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyerById(@PathVariable Long id) {
        buyerService.deleteBuyerById(id);
        return ResponseEntity.noContent().build();
    }

}
