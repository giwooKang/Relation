package relation.repository;

import koreatech.cse.domain.Authority;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import relation.domain.RelationToJsonWrapper;

import java.util.List;

/**
 * Created by Cro on 2016-12-06.
 */

@Repository
public interface RelationMapper {
    @Insert("INSERT INTO relation.relation (KEYWORD, DATE, RELATION) VALUES (#{keyword}, #{date}, #{relation})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(RelationToJsonWrapper relationToJsonWrapper);

    @Update("UPDATE relation.relation SET KEYWORD = #{keyword}, DATE = #{date}, RELATION = #{relation} WHERE ID = #{id}")
    void update(RelationToJsonWrapper relationToJsonWrapper);

    @Select("SELECT * FROM relation.relation WHERE ID = #{id}")
    List<RelationToJsonWrapper> findById(@Param("id") int id);

    @Select("SELECT * FROM relation.relation WHERE KEYWORD = #{keyword}")
    List<RelationToJsonWrapper> findByKeyword(@Param("keyword") String keyword);

    @Delete("DELETE FROM relation.relation WHERE ID = #{id}")
    void delete(Authority authority);
}
