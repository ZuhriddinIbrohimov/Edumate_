package zuhriddinscode.something.service;
import zuhriddinscode.something.dto.CategoryDTO;
import zuhriddinscode.something.entity.CategoryEntity;
import java.util.List;

public interface ICategoryService {

//    CategoryEntity getCategoryById(Integer id );
    List<CategoryEntity> getAllCategories();

    CategoryDTO addCategory(CategoryDTO categoryDTO);
//    List < CategoryEntity >  findById( Integer categoryId ) ;

}