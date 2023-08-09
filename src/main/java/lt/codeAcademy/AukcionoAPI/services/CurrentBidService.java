package lt.codeAcademy.AukcionoAPI.services;

import lombok.AllArgsConstructor;
import lt.codeAcademy.AukcionoAPI.converters.CurrentBidConverter;
import lt.codeAcademy.AukcionoAPI.dto.request.CurrentBidDTO;
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
        return CurrentBidConverter.convertCurrentBidToDTORequest(currentBid);
    }

    public lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO getBidById(Long id) {
        return CurrentBidConverter.convertCurrentBidToDTOResponse(currentBidRepository.getReferenceById(id));
    }

    public List<lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO> getAllBids() {
        return CurrentBidConverter.convertCurrentBidsToCurrentBidsDTO(currentBidRepository.findAll());
    }

    public void deleteBidById(Long id) {
        currentBidRepository.deleteById(id);
    }

    public CurrentBid updateBid(Long id , lt.codeAcademy.AukcionoAPI.dto.response.CurrentBidDTO currentBid) {
        CurrentBid currentBidToUpdate = currentBidRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        currentBidToUpdate.setBid(currentBid.getBid());
        currentBidRepository.save(currentBidToUpdate);
        return currentBidToUpdate;
    }

}
