package top.by.xiceos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>Title: XiceosBlogApplication</p>
 * <p>Description: xiceos-blog启动类</p>
 *
 * <p>{@link EnableTransactionManagement}  开启事务</p>
 * <p>{@link ImportResource}               引入外部资源配置</p>
 * <p>{@link ServletComponentScan}         扫描注册的servlet</p>
 * <p>{@link SpringBootApplication}        启动</p>
 *
 * @author zwp
 * @date 2018/12/12 10:20
 */
@EnableTransactionManagement
@ImportResource(locations = {"classpath:config/application-bean.xml", "classpath:config/druid-bean.xml"})
@MapperScan("top.by.xiceos.dao")
@ServletComponentScan
@SpringBootApplication
public class XiceosBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiceosBlogApplication.class, args);
    }

}