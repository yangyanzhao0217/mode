package com.test.controller;

import com.test.entity.User;
import com.test.entity.UserList;
import com.test.entity.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
/**
*如果你的方法均为返回数据给客户端，而不返回视图，此处可写@RestController
 */
@RequestMapping("/data")
public class DataBindHandler {
    @RequestMapping("/baseType")
    @ResponseBody
/**接受前端JSON数据,将业务方法的返回值响应给客户端
    *没有该注解，就是将其返回给DispatcherServlet进行处理
 */
    public  String  baseType(int id){
        return  id+"";
    }

    @RequestMapping("/packageType")
    @ResponseBody
    public  String  baseType(Integer id){
        /**
         *         基本数据类型不接受NULL但包装类可以接受。
         */

        return  id+"";
    }

    @RequestMapping("/packageType1")
    @ResponseBody
/**
 *  required 为true 必须传值，false相当于 同名直接传，规则同上
  */
    public  String  baseType1(@RequestParam(value = "num",required = true,defaultValue = "0") Integer id){
        /**
         * 基本数据类型不接受NULL但包装类可以接受。，同时可以通过default设置默认参数
         */

        return  id+"";
    }

    @RequestMapping("/array")
    @ResponseBody
    public  String  array(String [] name){
        String str = Arrays.toString(name);
        return str;
    }

    @RequestMapping("/list")
    @ResponseBody
    public  String list(UserList userList){
        StringBuffer str = new StringBuffer();
        for (User user : userList.getUsers()){
            str.append(user);
        }
        return str.toString();
    }

    @RequestMapping("/map")
    @ResponseBody
    public  String map(UserMap userMap){
        StringBuffer str = new StringBuffer();
        for (String key:userMap.getUserMap().keySet()){
            User user= userMap.getUserMap().get(key);
            str.append(user);
        }
        return str.toString();
    }
    @RequestMapping("/json")
    @ResponseBody
    public User json(@RequestBody User user){//@RequestBody是发送JSON格式
        System.out.println(user);
        user.setId(6);
        user.setName("张柳");
        return user;
    }
}
