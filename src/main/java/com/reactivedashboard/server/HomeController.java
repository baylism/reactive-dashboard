// package com.reactivedashboard.server;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.CacheControl;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.reactive.config.EnableWebFlux;
// import org.springframework.web.reactive.config.ResourceHandlerRegistry;
// import org.springframework.web.reactive.config.WebFluxConfigurer;
//
// import java.util.concurrent.TimeUnit;
//
// // @RestController
// // public class HomeController {
// //
// //     // @RequestMapping(value = "/")
// //     // public String index() {
// //     //     return "index is foo";
// //     // }
// // }
// @Configuration
// @EnableWebFlux
// public class HomeController implements WebFluxConfigurer {
//
//     @Override
//     public void addResourceHandlers(ResourceHandlerRegistry registry) {
//         registry.addResourceHandler("/resources/**")
//                 .addResourceLocations("/public", "classpath:/static/")
//                 .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
//     }
//
// }