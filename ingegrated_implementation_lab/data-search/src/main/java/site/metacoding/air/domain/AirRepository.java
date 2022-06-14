package site.metacoding.air.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AirRepository extends JpaRepository<Air, Integer> {

    @Query(value = "SELECT * FROM air WHERE msrste_nm=:gu", nativeQuery = true)
    List<Air> mFindByGu(@Param("gu") String gu);

    @Query(value = "SELECT * FROM air", nativeQuery = true)
    List<Air> mFindByGu();
}
