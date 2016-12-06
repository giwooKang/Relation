package relation.repository;

import koreatech.cse.domain.Authority;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import relation.domain.HotKeyword;
import relation.domain.RelationToJsonWrapper;

import java.util.List;

/**
 * Created by DK on 2016-12-06.
 */
@Repository
public interface HotKeywordMapper {
    @Insert("INSERT INTO RELATION.HOTKEYWORDS (KEYWORD, IMAGE, GOOGLE, NAVER, DAUM, DATETIME) VALUES (#{keyword}, #{image}, #{google}, #{naver}, #{daum}, #{datetime})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(HotKeyword hotKeyword);

    @Select("SELECT * FROM RELATION.HOTKEYWORDS WHERE KEYWORD = #{keyword}")
    List<HotKeyword> findByKeyword(@Param("keyword") String keyword);

}
