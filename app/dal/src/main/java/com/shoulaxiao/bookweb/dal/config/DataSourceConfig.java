package com.shoulaxiao.bookweb.dal.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DataSourceConfig {


//    @Bean("dataSource")
//    @Primary
//    public DataSource getShardingDataSource(){
//        Map<String,DataSource> dataSourceMap = Maps.newHashMap();
//
//        StandardShardingStrategyConfiguration standardShardingStrategyConfiguration =
//                new StandardShardingStrategyConfiguration("company_code","customDbShadingAlgorithm");
//
//        //需要路由的表
//        List<ShardingTableRuleConfiguration> ruleConfigurations = Lists.newArrayList(
//                new ShardingTableRuleConfiguration("user")
//        );
//
//        ruleConfigurations.forEach(shardingTableRuleConfiguration ->
//                shardingTableRuleConfiguration.setDatabaseShardingStrategy(standardShardingStrategyConfiguration)
//        );
//
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//        shardingRuleConfig.getTables().addAll(ruleConfigurations);
//        shardingRuleConfig.getShardingAlgorithms().put("customDbShadingAlgorithm",new ShardingSphereAlgorithmConfiguration(ShardingTypeEnums.FIXED_SINGLE_COL.name(), null));
//
//        shardingRuleConfig.setDefaultDatabaseShardingStrategy(DataSourceEnum.BOOK_DB::name);
//
//        try {
//            return ShardingSphereDataSourceFactory.createDataSource(dataSourceMap, Collections.singleton(shardingRuleConfig),new Properties());
//        }catch (Exception e){
//            log.error("创建数据源分片异常",e);
//            throw new IllegalStateException("创建数据源分片异常");
//        }
//    }
//
//    @Bean("dataSource")
//    public DataSource getDataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//        return dataSource;
//    }


//    @Bean("datasourceProxy")
//    @Primary
//    public LazyConnectionDataSourceProxy getLazyConnectionDataSourceProxy(@Qualifier("dataSource") DataSource dataSource){
//        LazyConnectionDataSourceProxy dataSourceProxy = new LazyConnectionDataSourceProxy();
//        dataSourceProxy.setTargetDataSource(dataSource);
//        return dataSourceProxy;
//    }

    @Bean("transactionManager")
    @Primary
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
    @Bean("transactionTemplate")
    @Primary
    public TransactionTemplate getTransactionTemplate(@Qualifier("transactionManager") DataSourceTransactionManager transactionManager){
        TransactionTemplate transactionTemplate= new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager);
        return transactionTemplate;
    }
}
