package com.cyn.binarytree;

import java.util.*;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/12
 * 1
 * 3    2
 * 5  6
 * 前序：1 3 5 6 2 abdecfg
 * 中序：5 3 6 1 2 dbeafcg
 * 后序：5 6 3 2 1 debfgca
 * <p>
 * 前中后序遍历可以理解为特殊的深度遍历
 */
public class BinaryTree {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1);
        HeroNode heroNode2 = new HeroNode(2);
        HeroNode heroNode3 = new HeroNode(3);
        HeroNode heroNode5 = new HeroNode(5);
        HeroNode heroNode6 = new HeroNode(6);

        HashSet<String> strings = new HashSet<>();
        strings.add("1");
        heroNode1.setLeft(heroNode3);
        heroNode1.setRight(heroNode2);

        heroNode3.setLeft(heroNode5);
        heroNode3.setRight(heroNode6);

        heroNode1.getFrontNode();
        System.out.println("===");
        heroNode1.getFrontNodeNoRecursion();
        System.out.println("==getFrontNodeNoRecursion=");

        heroNode1.getMidNode();
        System.out.println("===");
        heroNode1.getMidNodeNoRecursion();
        System.out.println("==getMidNodeNoRecursion=");

        heroNode1.getTailNode();
        System.out.println("===");
        heroNode1.getTailNodeNoRecursion();
        System.out.println("==getTailNodeNoRecursion=");
        heroNode1.breadthFirstTraverse();
        System.out.println("==breadthFirstTraverse=");
        ArrayList<Integer> count = new ArrayList<>();
        heroNode1.findHeadNode(2, count, 0);

        heroNode1. breadthFirstTraverse();
        /*// 遍历次数
        System.out.println("=== " + count.size());
        // 二叉树层数
        System.out.println("=== " + count.stream().max(Comparator.naturalOrder()).get());
        count.forEach(findcount -> {
            System.out.println("=== " + findcount);
        });

        ArrayList<Integer> count1 = new ArrayList<>();
        heroNode1.findMidNode(2, count1, 0);
        // 遍历次数
        System.out.println("===1 " + count1.size());
        // 二叉树层数
        System.out.println("===1 " + count1.stream().max(Comparator.naturalOrder()).get());
        count1.forEach(findcount -> {
            System.out.println("===1 " + findcount);
        });

        ArrayList<Integer> count2 = new ArrayList<>();
        heroNode1.findTailNode(2, count2, 0);
        // 遍历次数
        System.out.println("===2 " + count2.size());
        // 二叉树层数
        System.out.println("===2 " + count2.stream().max(Comparator.naturalOrder()).get());
        count2.forEach(findcount -> {
            System.out.println("===2 " + findcount);
        });*/
    }
}

class HeroNode {
    private int val;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "val=" + val +
                '}';
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    //==遍历
    // 前序递归
    public void getFrontNode() {
        System.out.println(this.val);
        if (this.getLeft() != null) {
            this.getLeft().getFrontNode();
        }
        if (this.getRight() != null) {
            this.getRight().getFrontNode();
        }
    }

    // 前序非递归

    /**
     * * 1
     * * 3    2
     * * 5  6
     */
    public void getFrontNodeNoRecursion() {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode curNode = this;
        stack.push(curNode);
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            System.out.println(curNode.val);
            if (curNode.getRight() != null) {
                stack.push(curNode.getRight());
            }
            if (curNode.getLeft() != null) {
                stack.push(curNode.getLeft());
            }
        }
    }

    // 中序
    public void getMidNode() {
        if (this.getLeft() != null) {
            this.getLeft().getMidNode();
        }
        System.out.println(this.val);
        if (this.getRight() != null) {
            this.getRight().getMidNode();
        }
    }

    // 中序非递归 ****

    /**
     * * 1
     * * 3    2
     * * 5  6
     */
    public void getMidNodeNoRecursion() {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = this;
        //
        // 5 3 6 1 2
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                // 一直循环到二叉排序树最左端的叶子结点（currentNode是null）
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.getRight();
        }
    }

    // 后序
    public void getTailNode() {
        if (this.getLeft() != null) {
            this.getLeft().getTailNode();
        }
        if (this.getRight() != null) {
            this.getRight().getTailNode();
        }
        System.out.println(this.val);
    }

    /**
     * * 1
     * * 3    2
     * * 5  6
     */
    // 后序非递归
    // 1
    // 5 6 3 2 1
    public void getTailNodeNoRecursion() {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = this;
        HeroNode rightNode = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                // 一直循环到二叉排序树最左端的叶子结点（currentNode是null）
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();

            while (cur.getRight() == null || cur.getRight() == rightNode) {
                // 当前结点没有右结点或上一个结点（已经输出的结点）是当前结点的右结点，则输出当前结点
                System.out.println(cur.val);
                rightNode = cur;
                if (stack.isEmpty()) {
                    //root以输出，则遍历结束
                    return;
                }
                cur = stack.pop();
            }
            stack.push(cur); //还有右结点没有遍历
            cur = cur.right;
        }
    }

    // 广度遍历
    public void breadthFirstTraverse() {
        Queue<HeroNode> queue = new LinkedList<>();
        HeroNode curNode = null;
        queue.offer(this);
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            System.out.println(curNode.val);
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
    }

    //==查找
    // 前序
    private int findfloor = 0;

    public void findHeadNode(int val, ArrayList<Integer> count, int findfloor) {
        findfloor++;
        count.add(findfloor);
        System.out.println("find val in nodes " + this.toString());
        if (this.val == val) {
            System.out.println("find val = " + val);
        }
        if (this.left != null) {
            this.getLeft().findHeadNode(val, count, findfloor);
        }
        if (this.right != null) {
            this.getRight().findHeadNode(val, count, findfloor);
        }
    }

    // 中序
    public void findMidNode(int val, ArrayList<Integer> count, int findfloor) {
        findfloor++;
        count.add(findfloor);
        if (this.left != null) {
            this.getLeft().findMidNode(val, count, findfloor);
        }
        System.out.println("find val in nodes " + this.toString());
        if (this.val == val) {
            System.out.println("find val = " + val);
        }
        if (this.right != null) {
            this.getRight().findMidNode(val, count, findfloor);
        }
    }

    // 后序
    public void findTailNode(int val, ArrayList<Integer> count, int findfloor) {
        findfloor++;
        count.add(findfloor);
        if (this.left != null) {
            this.getLeft().findTailNode(val, count, findfloor);
        }
        if (this.right != null) {
            this.getRight().findTailNode(val, count, findfloor);
        }
        System.out.println("find val in nodes " + this.toString());
        if (this.val == val) {
            System.out.println("find val = " + val);
        }
    }
}
