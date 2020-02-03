package com.cyn.pojo;

/**
 * 文件描述
 *
 * @ProjectName: dataStructure-algorithm
 * @Package: com.cyn.pojo
 * @Date 2020/1/21 16:01
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class SingleLinkedList {
    /**
     * 初始化头节点 - 固定不改动
     * 一般不存放具体数据，用于定位链表在内存中的位置-也可以头节点存放链表长度等，具体实现不同
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点
     * 不考虑编号顺序
     * 1.找到当前链表最后节点
     * 2.将最后节点的next指向新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        //head头节点不动，创建临时变量辅助遍历
        HeroNode temp = head;
        //遍历，找到最后一个节点
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            //没找到，temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp指向了链表的最后
        temp.next = heroNode;
    }

    /**
     * 按编号排序添加，重复编号提示添加失败
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        //head头节点不动，创建临时变量辅助遍历
        HeroNode temp = head;
        boolean flag = false;
        //判断是否有重复编号
        while (true) {
            if (temp.next == null) {
                break;//添加到了最后节点
            }
            if (temp.next.no > heroNode.no) {
                //位置找到，就在temp后面
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明编号已存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("data is existed");
        } else {
            //插入链表,在temp后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 显示列表-遍历
     */
    public void list() {
        //判断空
        if (head.next == null) {
            System.out.println("list is empty");
            return;
        }
        //head头节点不动，创建临时变量辅助遍历
        HeroNode temp = head.next;
        while (true) {
            //是否遍历到链表最后
            if (temp == null) {
                return;
            }
            //不为空，持续遍历输出
            System.out.println(temp);
            //后移遍历节点
            temp = temp.next;
        }
    }

    /**
     * 更新链表，根据编号更新
     *
     * @param heroNode
     */
    public void update(HeroNode heroNode) {
        //判断空
        if (head.next == null) {
            System.out.println("list is empty");
            return;
        }
        // 头节点遍历
        HeroNode temp = head.next;
        // 判断要更新的节点是否存在
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //遍历到了最后
                break;
            }
            if (temp.no == heroNode.no) {
                //当前temp为要更新的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
            //temp = heroNode;
        } else {
            System.out.println("node is not exist");
        }
    }

    /**
     * 根据输入的编号删除数据
     *
     * @param no
     */
    public void del(int no) {
        //临时变量
        HeroNode temp = head;
        //是否找到要删除的数据
        boolean flag = false;
        while (true) {
            //判断是否遍历到最后了
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //找到要删除的数据
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("no is not exist");
        }
    }
}
