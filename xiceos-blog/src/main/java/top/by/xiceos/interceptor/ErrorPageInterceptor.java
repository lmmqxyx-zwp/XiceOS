// package top.by.xiceos.interceptor;
//
// import org.springframework.stereotype.Component;
// import org.springframework.web.servlet.HandlerInterceptor;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.util.Arrays;
// import java.util.List;
//
// /**
//  * <p>Title: ErrorPageInterceptor</p>
//  * <p>Description: 错误页面拦截器(废弃)</p>
//  *
//  * @author zwp
//  * @date 2018/12/14 20:34
//  */
// @Component
// public class ErrorPageInterceptor implements HandlerInterceptor {
//
//     private List<Integer> errorCodes = Arrays.asList(403, 404, 500, 501);
//
//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         if (errorCodes.contains(response.getStatus())) {
//             response.sendRedirect(request.getRequestURI() + "/error/" + response.getStatus());
//         }
//         return true;
//     }
// }