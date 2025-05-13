package com.BannerX.BannerX.controller;


import com.BannerX.BannerX.dto.LenderDTO;
import com.BannerX.BannerX.entity.Lender;
import com.BannerX.BannerX.entity.LenderCategory;
import com.BannerX.BannerX.service.LenderService;
import com.BannerX.BannerX.service.lenderNotFoundException;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.BannerX.BannerX.consts.ApiConstants.*;

@RestController("/")

// needs to be removed in the future, while integrating
@CrossOrigin(origins = "*")
public class adminController {

    @Autowired
    private LenderService service;

//     saving lender form with image in cloudinary, but getting ssl certificate error
//    @PostMapping(value = storeLender, consumes = {"multipart/form-data"})
//    public ResponseEntity<?> createLender(
//            @RequestPart("lender") @Valid LenderDTO dto,
//            @RequestPart("image") MultipartFile imageFile) {
//        try {
//            String title = dto.getTitle();
//            boolean find = service.existBytitle(title);
//            if(find) {
//                return new ResponseEntity<>("Already have a lender with same name", HttpStatus.CONFLICT);
//            }
//
//            String imageUrl = null;
//            if (imageFile != null && !imageFile.isEmpty()) {
//                System.out.println("Calling uploadToCloudinary...");
//                imageUrl = service.uploadToCloudinary(imageFile);
//                System.out.println("Image uploaded. URL: " + imageUrl);
//            }
//
//            Lender lender = service.mapDtoToEntity(dto, imageUrl);
//            service.saveLenderData(lender);
//            return ResponseEntity.ok("Lender saved successfully");
//        } catch (IOException e) {
//            return new ResponseEntity<>("Image upload failed", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping(storeLender)
    public ResponseEntity<?> createLender(@RequestBody @Valid LenderDTO dto) {
            String title = dto.getTitle();
            boolean find = service.existByTitleInLender(title);
            if(find) {
                return new ResponseEntity<>("Already have a lender with same name", HttpStatus.CONFLICT);
            }


            Lender lender = service.mapDtoToEntity(dto);
            service.saveLenderAndDeleteFromForm(lender);
            return ResponseEntity.ok("Lender saved successfully");
    }

    @PostMapping(storeForm)
    public ResponseEntity<?> createForm(@RequestBody @Valid LenderDTO dto) {
        String title = dto.getTitle();
        boolean find = service.existByTitleInForm(title);
        if(find) {
            return new ResponseEntity<>("Already have a lender with same name", HttpStatus.CONFLICT);
        }


        Lender lender = service.mapDtoToEntity(dto);
        service.saveFormAndDeleteFromLender(lender);
        return ResponseEntity.ok("Lender saved successfully");
    }

    @GetMapping(getLenderById)
    public Lender fetchLenderData(@PathVariable String lenderId) {
        return service.getLenderDataById(lenderId);
    }


    @GetMapping(getAllLenders)
    public List<Lender> getAll() {
        return service.getAllLenders();
    }

    @GetMapping(getAll)
    public List<Lender> getAllLendersCombined() {
        List<Lender> liveLenders = service.getAllLenders();
        List<Lender> formLenders = service.getAllForms();

        // Combine both lists
        List<Lender> combined = new ArrayList<>();
        combined.addAll(liveLenders);
        combined.addAll(formLenders);

        return combined;
    }

    @PutMapping(edit)
    public ResponseEntity<?> updateLender(@PathVariable String lenderId, @Valid @RequestBody Lender lender) {
        Lender lender1 = null;
        try{
            lender1 = service.updateProduct(lenderId, lender);
        }
//        catch (IOException e){
//            return new ResponseEntity<>("Update Failed", HttpStatus.BAD_REQUEST);
//        }
        catch (lenderNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(lender1 != null){
            return new ResponseEntity<>("updated product", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update Failed", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(deleteFormOrLender)
    public ResponseEntity<?> deleteForm(@PathVariable String lenderId) {
        service.deleteLenderOrFormData(lenderId);
        return ResponseEntity.ok("Form or Lender removed successfully");
    }

    @GetMapping(lendersByCategory)
    public ResponseEntity<List<Lender>> getLendersByCategory(@PathVariable LenderCategory category) {
        List<Lender> lenders = service.getLendersByCategory(category);
        return ResponseEntity.ok(lenders);
    }

    @GetMapping(getAllCategory)
    public ResponseEntity<List<String>> getAllCategory() {
        List<String> categories = service.getAllCategory();
        return ResponseEntity.ok(categories);
    }
}
