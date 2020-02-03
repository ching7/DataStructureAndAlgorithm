package com.cyn.demo;

import com.cyn.pojo.HeroNode;
import com.cyn.pojo.SingleLinkedList;

/**
 * 文件描述
 *
 * @ProjectName: dataStructure-algorithm
 * @Package: com.cyn
 * @Date 2020/1/21 15:16
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //create nodes
        HeroNode node1 = new HeroNode(1, "test1", "test11");
        HeroNode node4 = new HeroNode(4, "test4", "test44");
        HeroNode node2 = new HeroNode(2, "test2", "test22");
        HeroNode node3 = new HeroNode(3, "test3", "test33");
        HeroNode node5 = new HeroNode(1, "test15", "test15");

        //create list
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.update(node5);
        singleLinkedList.del(2);

        //show list
        singleLinkedList.list();
    }
}
