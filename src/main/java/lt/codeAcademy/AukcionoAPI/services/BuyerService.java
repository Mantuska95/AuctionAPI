package lt.codeAcademy.AukcionoAPI.services;

import lombok.AllArgsConstructor;
import lt.codeAcademy.AukcionoAPI.converters.BuyerConverter;
import lt.codeAcademy.AukcionoAPI.dto.request.BuyerDTO;
import lt.codeAcademy.AukcionoAPI.entities.Buyer;
import lt.codeAcademy.AukcionoAPI.repositories.BuyerRepository;
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
        return BuyerConverter.convertBuyerToDTORequest(buyer);
    }

    public lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO getBuyerById(Long id) {
        return BuyerConverter.convertBuyerToDTOResponse(buyerRepository.getReferenceById(id));
    }

    public List<lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO> getAllBuyers(Pageable pageable) {
        if (pageable != null) {
            return BuyerConverter.covertBuyersToBuyersDTO(buyerRepository.findAll(pageable));
        }
        return BuyerConverter.covertBuyersToBuyersDTO(buyerRepository.findAll());
    }

    public void deleteBuyerById(Long id) {
        buyerRepository.deleteById(id);
    }

    public Buyer updateBuyer(lt.codeAcademy.AukcionoAPI.dto.response.BuyerDTO buyer, Long id) {
        Buyer buyerToUpdate = buyerRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        buyerToUpdate.setName(buyer.getName());
        buyerToUpdate.setSurname(buyer.getSurname());
        buyerRepository.save(buyerToUpdate);
        return buyerToUpdate;
    }

}
