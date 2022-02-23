package com.examplsss.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: ljt
 * @time: 2021/11/29 0029 16:31
 */

@Data
@AllArgsConstructor
public class Node{
    private Integer id;
    private String city;
    private Integer pid;

    private List<Node> children;

    public Node(Integer id, String city, Integer pid) {
        this.id = id;
        this.city = city;
        this.pid = pid;
    }
}
