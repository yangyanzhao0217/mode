package com.test.entity;

import lombok.Data;

import java.util.List;
@Data
public class UserList {
    /**
     * 由于Spring MVC不支持List类型的直接转换，需要对LIst集合进行包装
     */

    private List<User> users;
}
