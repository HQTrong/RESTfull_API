package tmdt.tmdt_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tmdt.tmdt_api.Entity.CategoryType;
import tmdt.tmdt_api.Model.DTO.CategoryTypeDTO;
import tmdt.tmdt_api.Model.Mapper.CategoryTypeMapper;
import tmdt.tmdt_api.Repository.CategoryTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryTypeServiceImp implements CategoryTypeService {
    List<CategoryTypeDTO> list = new ArrayList<>();
    @Autowired
    private CategoryTypeRepository dao;

    @Override
    public List<CategoryTypeDTO> getAllCategoryType() {
        list = CategoryTypeMapper.toCategoryTypeDTOList(dao.getAllByOrderById());
        return list != null ? list : null;
    }

    @Override
    public CategoryTypeDTO addCategoryType(CategoryTypeDTO categoryTypeDTO) {
        CategoryType categoryType = dao.save(CategoryTypeMapper.toCategoryType(categoryTypeDTO));
        return categoryType != null ? categoryTypeDTO : null;
    }

    @Override
    public CategoryTypeDTO update(CategoryTypeDTO categoryTypeDTO) {
        List<CategoryTypeDTO> list = CategoryTypeMapper.toCategoryTypeDTOList(dao.getAllByOrderById());
        for (CategoryTypeDTO categoryType : list) {
            if (categoryTypeDTO.getId() == categoryType.getId()) {
                dao.save(CategoryTypeMapper.toCategoryType(categoryTypeDTO));
                return categoryTypeDTO;
            }
        }
        return null;
    }
}
