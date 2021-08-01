package dan.web.wiki.Controller;

import dan.web.wiki.vo.homeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Controller
public class homeController {

    @Autowired
    private dan.web.wiki.Service.homeService homeService;

    @RequestMapping("/")
    public String home(Model model){

        List<homeVo> hm = homeService.selectHomeDB();
        System.out.println("hm = "+hm);
        //model.addAttribute("homeSelect",hm);

        return "home";
    }

    @RequestMapping("/jdbcTest")
    public String jdbcTest(){

        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/studyweb?serverTimezone=UTC&characterEncoding=UTF-8";
        String id = "root";
        String pw = "1234";
        String sql = "SELECT USER_ID FROM T_USER_INF";
        try {
            con = DriverManager.getConnection(url,id,pw);
            System.out.println("connection Success");

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            System.out.println("CREATE STATEMENT 성공");

            while(rs.next()) { // ResultSet에 다음 값이 없을때까지 출력
                String Col1 = rs.getString("USER_ID");	// 컬럼 값 받아오기
                System.out.println(">>>>>"+Col1);
            }

            statement.close();
            con.close();
            rs.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return "home";
    }

}
