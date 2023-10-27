package tmdt.tmdt_api.Service;

import org.springframework.stereotype.Service;
import tmdt.tmdt_api.Entity.CategoryType;
import tmdt.tmdt_api.Model.DTO.CategoryTypeDTO;

import java.util.List;

@Service
public interface CategoryTypeService {
    List<CategoryTypeDTO> getAllCategoryType();

    CategoryTypeDTO addCategoryType(CategoryTypeDTO categoryTypeDTO);

    CategoryTypeDTO update(CategoryTypeDTO categoryTypeDTO);

}
