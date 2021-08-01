package dan.web.wiki.Service;

import dan.web.wiki.Mapper.homeMapper;
import dan.web.wiki.vo.homeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class homeServiceImpl implements homeService {

    @Autowired
    private homeMapper homeMapper;

    @Override
    public List<homeVo> selectHomeDB() {

        List<homeVo> selectDB = homeMapper.homeSelect();
        return selectDB;
    }
}
