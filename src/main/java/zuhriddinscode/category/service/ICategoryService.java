package zuhriddinscode.category.service;
import zuhriddinscode.category.categoryDTO.CategoryDTO;
import zuhriddinscode.category.entity.CategoryEntity;
import java.util.List;

public interface ICategoryService {

    CategoryEntity getCategoryById(Integer id );
    List<CategoryEntity> getAllCategories();

    CategoryDTO addCategory(CategoryDTO categoryDTO);
}