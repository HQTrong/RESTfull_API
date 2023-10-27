package tmdt.tmdt_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tmdt.tmdt_api.Model.DTO.CategoryTypeDTO;
import tmdt.tmdt_api.Service.CategoryTypeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categoryType")
public class CategoryTypeController {
    List<CategoryTypeDTO> list = new ArrayList<>();
    @Autowired
    private CategoryTypeService categoryTypeService;

    @GetMapping("")
    public ResponseEntity<?> getAllCategoryType() {
        list = categoryTypeService.getAllCategoryType();
        return ResponseEntity.ok(list);
    }

    @PostMapping("")
    public ResponseEntity<?> addCategoryType(@RequestBody CategoryTypeDTO categoryTypeDTO) {
        CategoryTypeDTO categoryType = categoryTypeService.addCategoryType(categoryTypeDTO);
        return ResponseEntity.ok(categoryType);
    }

    @PutMapping("")
    public ResponseEntity<?> updateCategoryType(@RequestBody CategoryTypeDTO categoryTypeDTO) {
        CategoryTypeDTO category = categoryTypeService.update(categoryTypeDTO);
        return ResponseEntity.ok(category);
    }
}
