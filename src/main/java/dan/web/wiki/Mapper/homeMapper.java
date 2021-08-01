package dan.web.wiki.Mapper;

import dan.web.wiki.vo.homeVo;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface homeMapper {

    List<homeVo> homeSelect();

}
