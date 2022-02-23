package com.examplsss.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.examplsss.demo.entity.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: ljt
 * @time: 2021/11/29 0029 16:32
 */
public class TreeUtils {

    static List<Node> buildTree(List<Node> list,Integer pid){
        List<Node> tree=new ArrayList<>();
        for(Node node:list){
            if(Objects.equals(node.getPid(),pid)){
                tree.add(findChild(node,list));
            }
        }
        return tree;
    }

    static Node findChild(Node node, List<Node> list){
        for(Node n:list){
            if(Objects.equals(n.getPid(),node.getId())){
                if(node.getChildren() == null){
                    node.setChildren(new ArrayList<Node>());
                }
                node.getChildren().add(findChild(n,list));
            }
        }
        return node;
    }



    public static void main(String[] args) {
        Node node0 = new Node(0, "中国", -1);
        Node node1 = new Node(1, "湖北省", 0);
        Node node2 = new Node(2, "武汉市", 1);
        Node node3 = new Node(3, "洪山区", 2);
        Node node4 = new Node(4, "宜昌市", 1);
        Node node5 = new Node(5, "上海市", 0);
        Node node6 = new Node(6, "静安区", 5);
        Node nod7 = new Node(7, "安徽省", -1);
        Node nod8 = new Node(8, "安庆市", 7);
        List<Node> list = new ArrayList<>();


        list.add(node3);
        list.add(node4);
        list.add(node1);
        list.add(node2);
        list.add(node5);
        list.add(node6);
        list.add(node0);
        list.add(nod7);
        list.add(nod8);
        List<Node> nodes = buildTree(list, -1);

        JSONObject jsonObject =new JSONObject(true);
        jsonObject.put("aa",nodes);

        System.out.println(jsonObject);
    }


}
