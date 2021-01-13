package com.cyn.binarytree;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/12
 * 1
 * 3    2
 * 5  6
 * 前序：1 3 5 6 2 abdecfg
 * 中序：5 3 6 1 2 dbeafcg
 * 后序：5 6 3 2 1 debfgca
 */
public class BinaryTree {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1);
        HeroNode heroNode2 = new HeroNode(2);
        HeroNode heroNode3 = new HeroNode(3);
        HeroNode heroNode5 = new HeroNode(5);
        HeroNode heroNode6 = new HeroNode(6);

        heroNode1.setLeft(heroNode3);
        heroNode1.setRight(heroNode2);

        heroNode3.setLeft(heroNode5);
        heroNode3.setRight(heroNode6);

        heroNode1.getFrontHead(heroNode1);
        System.out.println("===");
        heroNode1.getMidHead(heroNode1);
        System.out.println("===");
        heroNode1.getTailHead(heroNode1);
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

    public void setRight(HeroNode right) {
        this.right = right;
    }

    // 前序
    public void getFrontHead(HeroNode heroNode) {
        System.out.println(heroNode.val);
        if (heroNode.getLeft() != null) {
            getFrontHead(heroNode.getLeft());
        }
        if (heroNode.getRight() != null) {
            getFrontHead(heroNode.getRight());
        }
    }

    // 中序
    public void getMidHead(HeroNode heroNode) {
        if (heroNode.getLeft() != null) {
            getMidHead(heroNode.getLeft());
        }
        System.out.println(heroNode.val);
        if (heroNode.getRight() != null) {
            getMidHead(heroNode.getRight());
        }
    }

    // 后序
    public void getTailHead(HeroNode heroNode) {
        if (heroNode.getLeft() != null) {
            getTailHead(heroNode.getLeft());
        }
        if (heroNode.getRight() != null) {
            getTailHead(heroNode.getRight());
        }
        System.out.println(heroNode.val);

    }
}
