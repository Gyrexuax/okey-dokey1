package OkeyDokey.repository;

import OkeyDokey.domain.Cloth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClothRepository extends JpaRepository<Cloth, Long> {

    List<Cloth> findByIdIn(List<Long> ClothesIds);

    Page<Cloth> findAllByOrderByPriceAsc(Pageable pageable);

    @Query("SELECT cloth FROM Cloth cloth WHERE " +
            "(CASE " +
            "   WHEN :searchType = 'clothTitle' THEN UPPER(cloth.clothTitle) " +
            "   WHEN :searchType = 'clothType' THEN UPPER(cloth.clothType) " +
            "   ELSE UPPER(cloth.clother) " +
            "END) " +
            "LIKE UPPER(CONCAT('%',:text,'%')) " +
            "ORDER BY cloth.price ASC")
    Page<Cloth> searchClothes(String searchType, String text, Pageable pageable);

    @Query("SELECT cloth FROM Cloth cloth " +
            "WHERE (coalesce(:clothers, null) IS NULL OR cloth.clother IN :clothers) " +
            "AND (coalesce(:genders, null) IS NULL OR cloth.clothGender IN :genders) " +
            "AND (coalesce(:priceStart, null) IS NULL OR cloth.price BETWEEN :priceStart AND :priceEnd) " +
            "ORDER BY cloth.price ASC")
     Page<Cloth> getClothesByFilterParams(
            List<String> clothers,
            List<String> genders,
            Integer priceStart,
            Integer priceEnd,
            Pageable pageable);
}
