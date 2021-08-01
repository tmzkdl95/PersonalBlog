package dan.web.wiki.Service;

import dan.web.wiki.vo.homeVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface homeService {

    List<homeVo> selectHomeDB();

}
