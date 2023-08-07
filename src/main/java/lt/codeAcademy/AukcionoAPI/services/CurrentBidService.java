package lt.codeAcademy.AukcionoAPI.services;

import lombok.AllArgsConstructor;
import lt.codeAcademy.AukcionoAPI.converters.CurrentBidConverter;
import lt.codeAcademy.AukcionoAPI.dto.CurrentBidDTO;
import lt.codeAcademy.AukcionoAPI.entities.CurrentBid;
import lt.codeAcademy.AukcionoAPI.repositories.CurrentBidRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CurrentBidService {

    private CurrentBidRepository currentBidRepository;

    public CurrentBidDTO addBid(CurrentBid currentBid) {
        currentBidRepository.save(currentBid);
        return CurrentBidConverter.convertCurrentBidToDTO(currentBid);
    }

    public CurrentBidDTO getBidById(Long id) {
        return CurrentBidConverter.convertCurrentBidToDTO(currentBidRepository.getReferenceById(id));
    }

    public List<CurrentBidDTO> getAllBids() {
        return CurrentBidConverter.convertCurrentBidsToCurrentBidsDTO(currentBidRepository.findAll());
    }

    public void deleteBidById(Long id) {
        currentBidRepository.deleteById(id);
    }

    public CurrentBidDTO updateBid(CurrentBid currentBid) {
        CurrentBid currentBidToUpdate = currentBidRepository.findById(currentBid.getId()).orElseThrow(() -> new NoSuchElementException());
        currentBidToUpdate.setBid(currentBid.getBid());
        currentBidToUpdate.setBuyer(currentBid.getBuyer());
        currentBidToUpdate.setItem(currentBid.getItem());
        currentBidRepository.save(currentBidToUpdate);
        return CurrentBidConverter.convertCurrentBidToDTO(currentBidToUpdate);
    }

}
