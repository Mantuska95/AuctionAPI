package lt.codeAcademy.AukcionoAPI.controllers;

import lt.codeAcademy.AukcionoAPI.converters.SellerConverter;
import lt.codeAcademy.AukcionoAPI.dto.request.SellerDTO;
import lt.codeAcademy.AukcionoAPI.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;
    @PreAuthorize("hasAnyRole('ADMIN','SELLER')")
    @PostMapping
    public ResponseEntity<SellerDTO> createSeller(@RequestBody SellerDTO sellerDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(sellerService.addSeller(SellerConverter.convertDTOToSellerRequest(sellerDTO)));
    }
    @PreAuthorize("hasAnyRole('ADMIN','SELLER')")
    @PutMapping("/{id}")
    public ResponseEntity<lt.codeAcademy.AukcionoAPI.dto.response.SellerDTO> updateSeller(@RequestBody SellerDTO sellerDTO,@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(SellerConverter.convertSellerToDTOResponse(sellerService.updateSeller(id, sellerDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<lt.codeAcademy.AukcionoAPI.dto.response.SellerDTO> getSellerById(@PathVariable Long id) {
        return ResponseEntity.ok(sellerService.getSellerById(id));
    }

    @GetMapping
    public ResponseEntity<List<lt.codeAcademy.AukcionoAPI.dto.response.SellerDTO>> getAllSellers() {
        return ResponseEntity.ok(sellerService.getAllSellers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSellerById(@PathVariable Long id) {
        sellerService.deleteSellerById(id);
        return ResponseEntity.noContent().build();
    }
}
