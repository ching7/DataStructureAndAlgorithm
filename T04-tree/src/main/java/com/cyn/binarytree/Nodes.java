package com.cyn.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/8
 * 给定一个n叉树。返回其节点值的前序遍历
 * 例如
 * 1
 * 3  2  4
 * 5  6
 * 前序遍历[1,3,5,6,2,4]
 */
public class Nodes {
    private Integer value;
    private List<Nodes> childrenNode;
    private ArrayList<Integer> frontNodeRes = new ArrayList<>();

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Nodes> getChildrenNode() {
        return childrenNode;
    }

    public void setChildrenNode(List<Nodes> childrenNode) {
        this.childrenNode = childrenNode;
    }

    public ArrayList<Integer> getFrontNodeRes() {
        return frontNodeRes;
    }

    public void setFrontNodeRes(ArrayList<Integer> frontNodeRes) {
        this.frontNodeRes = frontNodeRes;
    }

    public ArrayList<Integer> getHeadNodes(Nodes nodes) {
        return getNextNodeValue(nodes, frontNodeRes);
    }

    public ArrayList getNextNodeValue(Nodes allNodes, ArrayList<Integer> res) {
        res.add(allNodes.value);
        if (allNodes.childrenNode != null && allNodes.childrenNode.size() > 0) {
            for (Nodes nodes :
                    allNodes.childrenNode) {
                getNextNodeValue(nodes, res);
            }
        }
        return res;
    }
}
