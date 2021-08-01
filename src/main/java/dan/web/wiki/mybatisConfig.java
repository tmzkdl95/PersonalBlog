package dan.web.wiki;

import org.springframework.context.annotation.Configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @MapperScan = dan.web.wiki.Mapper folder
 * PathMatchingResourcePatternResolver = resources/mapper/*Mapper.xml
 *
 * if not nse @MapperScan, occur errors.
 */
@Configuration
@MapperScan(value ={"dan.web.wiki.Mapper"})
public class mybatisConfig {
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:Mapper/*Mapper.xml");
        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }
}