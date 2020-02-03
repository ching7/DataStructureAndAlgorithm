package com.cyn.pojo;

/**
 * 文件描述
 *
 * @ProjectName: dataStructure-algorithm
 * @Package: com.cyn.pojo
 * @Date 2020/1/21 15:17
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 单链表节点
 **/
public class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + "'}";
    }
}
