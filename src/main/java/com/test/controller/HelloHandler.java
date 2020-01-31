package com.test.controller;

import com.test.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller     /**将该类交给IOC进行处理，同时使其成为一个控制器，接受客户端请求*/
@RequestMapping(value = "/hello")
public class HelloHandler {

    @RequestMapping( "index")
    public  String index(){
        System.out.printf("index 执行");
        return "index";
    }

    @RequestMapping(value = "index1",method = RequestMethod.GET)
    public  String index1(){
        String string=java.util.UUID.randomUUID().toString();
        System.out.println("代码："+string);
        System.out.printf("index185 执行");
        return "index";
    }

    @RequestMapping(value = "index2",method = RequestMethod.GET,params = {
            "name","id=10"
    })
    public  String index2(){

        System.out.printf("index1234 执行");
        return "index";
    }

    @RequestMapping(value = "index3",params = {
            "name","id=10"
    })
    /**实参形参相同直接传参*/
    public  String index3(String name){
        System.out.printf(name);
        System.out.printf("index 执行");
        return "index";
    }

    @RequestMapping(value = "index4",params = {
            "name","id=10"
    })
    /**    形参实参名不同用@RequestParam注解，其中参数value 表示传给方法形参的实参名
    *     requried 表示value值是否必填，true为是，false为否可省略，defaultValue为设置默认值,如果设置默认值，requried为TRUE也可以不填
    */

    public  String index4(@RequestParam("name") String str){  //再传参过程中自动完成数据类型转换，由handlerAdapter实现
        System.out.println(str);
        System.out.printf("index 执行");
        return "index";
    }

    @RequestMapping("/rest/{name}/{id}")
    /**restful风格URL：http://localhost:8080/rest/zhangsan/10
    *形参，实参名相同也无法传参，必须用注解@PathVariable
    */
     public  String rest(@PathVariable("name") String name){
        System.out.printf(name);
        System.out.printf("index 执行");
        return "index";
    }

    @RequestMapping("cookie")
    public  String cookie(@CookieValue(value = "JSESSIONID") String sessionid){
        System.out.printf(sessionid);
        return "index";
    }


    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public  String save(User user) {
        System.out.println(user);
        return "index";
    }

    @RequestMapping("/forward")
    public String forward(){
        return "forward:/index.jsp";
        /**
         *转发，不改变地址，服务器发送一次请求
         */
         }
    @RequestMapping("redirect")
    public String redirect(){
        return "redirect:/index.jsp";
        /**
         *重定向，改变地址，服务器和客户端均发送请求
         */
         }
}
