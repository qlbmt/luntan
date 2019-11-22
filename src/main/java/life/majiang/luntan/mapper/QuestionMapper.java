package life.majiang.luntan.mapper;

import life.majiang.luntan.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by admin on 2019/11/21
 */
@Mapper
public interface QuestionMapper {

    @Insert("Insert into question (id,title,description,creator,tag,view_count,like_count,gmt_create,gmt_modified) values (${id},${title},${description},${creator},${tag},${viewCount},${likeCount},${gmtCreate},${gmtModified})")
    void create(Question question);

}
