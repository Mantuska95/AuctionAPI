package lt.codeAcademy.AukcionoAPI.controllers;

import lt.codeAcademy.AukcionoAPI.converters.CurrentBidConverter;
import lt.codeAcademy.AukcionoAPI.dto.request.CurrentBidDTO;
import lt.codeAcademy.AukcionoAPI.services.CurrentBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/current-bid")
public class CurrentBidController {

    @Autowired
    CurrentBidService currentBidService;

    @PreAuthorize("hasAnyRole('ADMIN','BUYER')")
    @PostMapping
    public ResponseEntity<CurrentBidDTO> createBid(@RequestBody CurrentBidDTO currentBidDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(currentBidService.addBid(CurrentBidConverter.convertDTOToCurrentBidRequest(currentBidDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO> updateBid(@RequestBody lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO currentBidDTO, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CurrentBidConverter.convertCurrentBidToDTOResponse(currentBidService.updateBid(id, currentBidDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO> getBidById(@PathVariable Long id) {
        return ResponseEntity.ok(currentBidService.getBidById(id));
    }

    @GetMapping
    public ResponseEntity<List<lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO>> getAllBids() {
        return ResponseEntity.ok(currentBidService.getAllBids());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyerById(@PathVariable Long id) {
        currentBidService.deleteBidById(id);
        return ResponseEntity.noContent().build();
    }
}
