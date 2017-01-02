package com.miles.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Junit整合Spring单元测试
 * 
 * @RunWith(SpringJUnit4ClassRunner.class)：表示使用自己定制的Junit4.5+运行器来运行测试，
 *    即完成SpringTestContext框架与Junit集成
 * @ContextConfiguration：指定要加载的Spring配置文件，此处注意我们的Spring资源配置文件为
 *    applicationContext-resources-test.xml
 * @Transaction：开启测试类的事务管理支持配置，并指定事务管理器和默认回滚行为
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional(transactionManager = "transactionManager", rollbackFor = Exception.class)
public class SpringJunit extends AbstractTransactionalJUnit4SpringContextTests {

}
