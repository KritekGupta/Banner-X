package com.BannerX.BannerX.service;


import com.BannerX.BannerX.dto.LenderDTO;
import com.BannerX.BannerX.entity.Lender;
import com.BannerX.BannerX.entity.LenderCategory;
import com.BannerX.BannerX.repo.LenderRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LenderService{


    @Autowired
    private LenderRepo lenderRepo;


//    uploading image in cloudinary and getting the url
//public String uploadToCloudinary(MultipartFile file) throws IOException {
//    try {
//        System.out.println("Inside uploadToCloudinary method, trying to upload...");
//        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
//        System.out.println("Upload Result: " + uploadResult);
//        return uploadResult.get("secure_url").toString();
//    } catch (Exception e) {
//        System.out.println("Exception while uploading to Cloudinary: " + e.getMessage());
//        e.printStackTrace();
//        throw new IOException("Failed to upload to Cloudinary", e);
//    }
//}


    public Lender mapDtoToEntity(LenderDTO dto) {
        List<Lender.Screens> screens = dto.getScreens().stream().map(screenDTO -> {
            List<Lender.Screens.Field> fields = screenDTO.getFields().stream().map(fieldDTO ->
                    new Lender.Screens.Field(
                            fieldDTO.getName(),
                            fieldDTO.getExample(),
                            fieldDTO.getType(),
                            fieldDTO.isRequired(),
                            fieldDTO.isValidate(),
                            fieldDTO.getOptions()
                    )
            ).toList();

            return new Lender.Screens(screenDTO.getScreenTitle(), fields);
        }).toList();

        return new  Lender(null, dto.getTitle(), dto.getCategory(), dto.isDeployed(), screens, null,  null); // createdAt/updatedAt handled by Spring
    }


    public void saveLender(Lender lender) {
        lender.setDeployed(true);
        lenderRepo.save(lender);
    }

    public void saveForm(Lender lender) {
        lender.setDeployed(false);
        lenderRepo.save(lender);
    }

    public Lender getLenderDataById(String id) {
        return lenderRepo.findById(id).orElse(null);
    }

    public List<Lender> getAll() { return lenderRepo.findAll(); }

    public List<Lender> getAllLenders() { return lenderRepo.findByDeployedTrue(); }

    public Lender updateProduct(String lenderId, @Valid Lender lender) throws lenderNotFoundException {
        if (!lenderRepo.existsById(lenderId)) {
            throw new lenderNotFoundException("Product with ID " + lenderId + " not found, cannot update.");
        }

        lender.setId(lenderId);
        lender.setCreatedAt(lender.getCreatedAt());
        return lenderRepo.save(lender);
    }

    public boolean existByTitle(String title) {
        if (lenderRepo.existsByTitle(title)) {
            return true;
        }
        return false;
    }

//    public boolean existByTitleInForm(String title) {
//        return lenderRepo.existsByTitle(title);
//    }

    public void deleteLenderOrFormData(String lenderId) {
        if (!lenderRepo.existsById(lenderId)) {
            throw new RuntimeException("No lender found with ID: " + lenderId);
        }
        lenderRepo.deleteById(lenderId);
    }

    public List<Lender> getLendersByCategory(LenderCategory category) {
        return lenderRepo.findByCategory(category);
    }

    public List<String> getAllCategory() {
        List<String> categories = Arrays.stream(LenderCategory.values())
                .map(LenderCategory::getDisplayName)
                .collect(Collectors.toList());
        return categories;
    }

    public boolean saveToDeploy(String id) {
        Optional<Lender> optionalLender = lenderRepo.findById(id);
        if (optionalLender.isPresent()) {
            Lender lender = optionalLender.get();
            lender.setDeployed(true);
            lenderRepo.save(lender);
            return true;
        }
        return false;
    }

//          manually setting all the fields
//            throws IOException, lenderNotFoundException {
//        Optional<Lender> existingLenderOptional = lenderRepo.findById(lenderId);
//
//        if (existingLenderOptional.isEmpty()) {
//            throw new lenderNotFoundException("Product with ID " + lenderId + " not found, cannot update.");
//        }
//
//        Lender existingLender = existingLenderOptional.get();
//
//        // Update fields (only update fields you allow to change)
//        existingLender.setTitle(lender.getTitle());
//        existingLender.setScreens(lender.getScreens());
//        existingLender.setUpdatedAt(lender.getUpdatedAt());
//        existingLender.setCreatedAt(lender.getCreatedAt());
//        // Add more fields as needed
//
//        return lenderRepo.save(existingLender);
//    }
}
