package top.by.xiceos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * <p>Title: XiceosBlogApplication</p>
 * <p>Description: xiceos-blog启动类</p>
 *
 * @author zwp
 * @date 2018/12/12 10:20
 */
@ImportResource(locations = {"classpath:config/application-bean.xml", "classpath:config/druid-bean.xml"})
@MapperScan("top.by.xiceos.dao")
@ServletComponentScan
@SpringBootApplication
public class XiceosBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiceosBlogApplication.class, args);
    }

}