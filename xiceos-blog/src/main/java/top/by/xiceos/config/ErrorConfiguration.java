// package top.by.xiceos.config;
//
// import org.springframework.boot.web.server.ErrorPage;
// import org.springframework.boot.web.server.ErrorPageRegistrar;
// import org.springframework.boot.web.server.ErrorPageRegistry;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Component;
//
// /**
//  * <p>Title: ErrorConfiguration</p>
//  * <p>Description: 注册错误页面，需要对应一个ErrorController，在Controller中写逻辑，覆盖掉spring的ErrorController</p>
//  *
//  * @author zwp
//  * @date 2018/12/17 15:41
//  */
// @Component
// public class ErrorConfiguration implements ErrorPageRegistrar {
//     @Override
//     public void registerErrorPages(ErrorPageRegistry registry) {
//         registry.addErrorPages(
//                 new ErrorPage(HttpStatus.FORBIDDEN, "/403"),
//                 new ErrorPage(HttpStatus.NOT_FOUND, "/404"),
//                 new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"),
//                 new ErrorPage(HttpStatus.NOT_IMPLEMENTED, "/501"),
//                 new ErrorPage(HttpStatus.BAD_GATEWAY, "/502")
//         );
//     }
// }