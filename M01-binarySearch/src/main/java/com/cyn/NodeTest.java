package com.cyn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/12
 *      1
 *   3  2  4
 * 5  6
 * 前序遍历[1,3,5,6,2,4]
 */
public class NodeTest {
    public static void main(String[] args) {
        Nodes nodes1 = new Nodes();
        List<Nodes> childrenNode1 = new ArrayList<>();
        List<Nodes> childrenNode3 = new ArrayList<>();

        nodes1.setValue(1);

        Nodes nodes2 = new Nodes();
        nodes2.setValue(2);
        Nodes nodes3 = new Nodes();
        nodes3.setValue(3);
        Nodes nodes4 = new Nodes();
        nodes4.setValue(4);
        Nodes nodes5 = new Nodes();
        nodes5.setValue(5);
        Nodes nodes6 = new Nodes();
        nodes6.setValue(6);

        childrenNode1.add(nodes3);
        childrenNode1.add(nodes2);
        childrenNode1.add(nodes4);
        childrenNode3.add(nodes5);
        childrenNode3.add(nodes6);

        nodes3.setChildrenNode(childrenNode3);
        nodes1.setChildrenNode(childrenNode1);
        ArrayList<Integer> headNodes = nodes1.getHeadNodes(nodes1);
        headNodes.forEach(System.out::println);

    }
}
