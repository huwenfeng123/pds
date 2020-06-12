package com.zhihuisystem.pds.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.zhihuisystem.pds.mapper"}, sqlSessionTemplateRef = "pdsSqlSessionTemplate")
public class PDSMysqlDynamicDataSource {
    @Value("${mybatis.mapper-locations}")
    private String  mapperLocations;


    @Bean(name = "pdsDataSource")
    @ConfigurationProperties(prefix = "pds.datasource") // application.properteis中对应属性的前缀
    @Primary
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "pdsSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("pdsDataSource")DataSource dataSource ) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        return factoryBean.getObject();

    }

    @Bean(name = "pdsTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("pdsDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "pdsSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("pdsSqlSessionFactory")SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }


}
