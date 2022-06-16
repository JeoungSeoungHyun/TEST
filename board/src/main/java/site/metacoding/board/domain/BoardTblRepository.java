package site.metacoding.board.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardTblRepository extends JpaRepository<BoardTbl, Integer> {

    @Query(value = "SELECT * FROM boardTbl WHERE title Like %:keyword%", nativeQuery = true)
    List<BoardTbl> mSearchByTitle(@Param("keyword") String keyword);

}
