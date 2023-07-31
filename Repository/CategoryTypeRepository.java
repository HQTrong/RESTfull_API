package tmdt.tmdt_api.Repository;

import org.springframework.data.repository.CrudRepository;
import tmdt.tmdt_api.Entity.CategoryType;

import java.util.List;

public interface CategoryTypeRepository extends CrudRepository<CategoryType, Integer> {
    List<CategoryType> getAllByOrderById();

    CategoryType save(CategoryType categoryType);
}
