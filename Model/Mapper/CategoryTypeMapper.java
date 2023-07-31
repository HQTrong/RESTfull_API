package tmdt.tmdt_api.Model.Mapper;

import tmdt.tmdt_api.Entity.CategoryType;
import tmdt.tmdt_api.Model.DTO.CategoryTypeDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryTypeMapper {
    public static CategoryType toCategoryType(CategoryTypeDTO categoryTypeDTO) {
        CategoryType tmp = new CategoryType();
        tmp.setId(categoryTypeDTO.getId());
        tmp.setLoaiSanPham(categoryTypeDTO.getLoaiSanPham());
        return tmp;
    }

    public static List<CategoryTypeDTO> toCategoryTypeDTOList(List<CategoryType> categoryTypes) {
        List<CategoryTypeDTO> list = new ArrayList<>();
        for (CategoryType categoryType : categoryTypes) {
            CategoryTypeDTO tmp = new CategoryTypeDTO();
            tmp.setId(categoryType.getId());
            tmp.setLoaiSanPham(categoryType.getLoaiSanPham());
            list.add(tmp);
        }
        return list;
    }
}
