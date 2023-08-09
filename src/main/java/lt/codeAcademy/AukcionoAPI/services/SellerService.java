package lt.codeAcademy.AukcionoAPI.services;

import lombok.AllArgsConstructor;
import lt.codeAcademy.AukcionoAPI.converters.SellerConverter;
import lt.codeAcademy.AukcionoAPI.dto.request.SellerDTO;
import lt.codeAcademy.AukcionoAPI.entities.Seller;
import lt.codeAcademy.AukcionoAPI.repositories.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SellerService {

    private SellerRepository sellerRepository;

    public SellerDTO addSeller(Seller seller) {
        sellerRepository.save(seller);
        return SellerConverter.convertSellerToDTORequest(seller);
    }

    public lt.codeAcademy.AukcionoAPI.dto.response.SellerDTO getSellerById(Long id) {
        return SellerConverter.convertSellerToDTOResponse(sellerRepository.getReferenceById(id));
    }

    public List<lt.codeAcademy.AukcionoAPI.dto.response.SellerDTO> getAllSellers() {
        return SellerConverter.convertSellersToDTO(sellerRepository.findAll());
    }

    public void deleteSellerById(Long id) {
        sellerRepository.deleteById(id);
    }

    public Seller updateSeller(Long id,SellerDTO seller) {
        Seller sellerToUpdate = sellerRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        sellerToUpdate.setName(seller.getName());
        sellerToUpdate.setSurname(seller.getSurname());
        sellerRepository.save(sellerToUpdate);
        return sellerToUpdate;
    }
}
