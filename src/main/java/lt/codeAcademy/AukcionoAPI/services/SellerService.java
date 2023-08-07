package lt.codeAcademy.AukcionoAPI.services;

import lombok.AllArgsConstructor;
import lt.codeAcademy.AukcionoAPI.converters.SellerConverter;
import lt.codeAcademy.AukcionoAPI.dto.SellerDTO;
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
        return SellerConverter.convertSellerToDTO(seller);
    }

    public SellerDTO getSellerById(Long id) {
        return SellerConverter.convertSellerToDTO(sellerRepository.getReferenceById(id));
    }

    public List<SellerDTO> getAllSellers() {
        return SellerConverter.convertSellersToDTO(sellerRepository.findAll());
    }

    public void deleteSellerById(Long id) {
        sellerRepository.deleteById(id);
    }

    public SellerDTO updateSeller(Seller seller) {
        Seller sellerToUpdate = sellerRepository.findById(seller.getId()).orElseThrow(() -> new NoSuchElementException());
        sellerToUpdate.setName(seller.getName());
        sellerToUpdate.setSurname(seller.getSurname());
        sellerToUpdate.setItem(seller.getItem());
        sellerRepository.save(sellerToUpdate);
        return SellerConverter.convertSellerToDTO(sellerToUpdate);
    }
}
