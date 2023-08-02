package lt.codeAcademy.AukcionoAPI.services;

import lombok.AllArgsConstructor;
import lt.codeAcademy.AukcionoAPI.converters.BuyerConverter;
import lt.codeAcademy.AukcionoAPI.dto.BuyerDTO;
import lt.codeAcademy.AukcionoAPI.entities.Buyer;
import lt.codeAcademy.AukcionoAPI.repositories.BuyerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BuyerService {


    private BuyerRepository buyerRepository;

    public BuyerDTO addBuyer(Buyer buyer) {
        buyerRepository.save(buyer);
        return BuyerConverter.convertBuyerToDTO(buyer);
    }

    public BuyerDTO getBuyerById(Long id) {
        return BuyerConverter.convertBuyerToDTO(buyerRepository.getReferenceById(id));
    }

    public List<BuyerDTO> getAllBuyers(Pageable pageable) {
        if (pageable != null) {
            return BuyerConverter.covertBuyersToBuyersDTO(buyerRepository.findAll(pageable));
        }
        return BuyerConverter.covertBuyersToBuyersDTO(buyerRepository.findAll());
    }

    public void deleteBuyerById(Long id) {
        buyerRepository.deleteById(id);
    }

    public BuyerDTO updateBuyer(Buyer buyer) {
        Buyer buyerToUpdate = buyerRepository.findById(buyer.getId()).orElseThrow(() -> new NoSuchElementException());
        buyerToUpdate.setName(buyer.getName());
        buyerToUpdate.setSurname(buyer.getSurname());
        buyerToUpdate.setCurrentBid(buyer.getCurrentBid());
        buyerRepository.save(buyerToUpdate);
        return BuyerConverter.convertBuyerToDTO(buyerToUpdate);
    }

}
