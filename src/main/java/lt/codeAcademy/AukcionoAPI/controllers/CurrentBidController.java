package lt.codeAcademy.AukcionoAPI.controllers;

import lt.codeAcademy.AukcionoAPI.converters.CurrentBidConverter;
import lt.codeAcademy.AukcionoAPI.dto.CurrentBidDTO;
import lt.codeAcademy.AukcionoAPI.services.CurrentBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/current-bid")
public class CurrentBidController {

    @Autowired
    CurrentBidService currentBidService;

    @PostMapping
    public ResponseEntity<CurrentBidDTO> createBid(@RequestBody CurrentBidDTO currentBidDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(currentBidService.addBid(CurrentBidConverter.convertDTOToCurrentBid(currentBidDTO)));
    }

    @PutMapping
    public ResponseEntity<CurrentBidDTO> updateBid(@RequestBody CurrentBidDTO currentBidDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(currentBidService.updateBid(CurrentBidConverter.convertDTOToCurrentBid(currentBidDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrentBidDTO> getBidById(@PathVariable Long id) {
        return ResponseEntity.ok(currentBidService.getBidById(id));
    }

    @GetMapping
    public ResponseEntity<List<CurrentBidDTO>> getAllBids() {
        return ResponseEntity.ok(currentBidService.getAllBids());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyerById(@PathVariable Long id) {
        currentBidService.deleteBidById(id);
        return ResponseEntity.noContent().build();
    }
}
