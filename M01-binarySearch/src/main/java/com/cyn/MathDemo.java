package com.cyn;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/22
 * 8+7 - 6*2
 */
public class MathDemo {
    static String chen = "*";
    static String chu = "/";
    static String jia = "+";
    static String jian = "-";

    public static void main(String[] args) {

        Stack mathStack = new Stack();
        // 8 7 6 2
        // String mathStrs = "8+7-6*2";
        String mathStrs = "8*2*2/2-2";
        // String mathStrs = "8*7-6/2+2*2";
        Integer res = null;
        String[] mathStrSplit = mathStrs.split("");

        //乘除处理
        for (int i = 0; i < mathStrSplit.length; i++) {
            Integer mathInt = null;
            String mathStr = null;
            try {
                mathInt = Integer.parseInt(mathStrSplit[i]);
            } catch (Exception e) {
                mathStr = mathStrSplit[i].toString();
            }
            //8+7-6*2
            if (mathInt != null) {
                mathStack.push(mathInt);
                continue;
            }
            Integer tempRes = null;
            if (mathStr.equals(chen) || mathStr.equals(chu)) {
                Integer pop = (Integer) mathStack.pop();
                if ((i + 1) != mathStrSplit.length) {
                    tempRes = getRes(pop, Integer.parseInt(mathStrSplit[i + 1]), mathStr);
                    mathStack.push(tempRes);
                    i++;
                }
            }
            if (mathStr.equals(jia) || mathStr.equals(jian)) {
                mathStack.push(mathStr);
            }
        }
        // 56-3+4
        ArrayList<Object> arrayList = new ArrayList<>();
        while (!mathStack.isEmpty()) {
            arrayList.add(mathStack.pop());
        }
        // 顺序变换
        arrayList.forEach(o -> {
            mathStack.push(o);
        });

        // 加减处理
        while (!mathStack.isEmpty()) {
            Integer mathInt = null;
            Object mathStr = null;
            Object o = mathStack.pop();
            int input2;
            try {
                mathInt = Integer.parseInt(o.toString());
            } catch (Exception e) {

            }
            if (mathStack.isEmpty()) {
                res = Integer.parseInt(o.toString());
                break;
            }
            mathStr = mathStack.pop();
            if (mathInt != null && mathStr != null) {
                input2 = Integer.parseInt(mathStack.pop().toString());
                mathStack.push(getRes(mathInt, input2, mathStr.toString()));
            }
        }

        System.out.println("===结果：" + res);
    }

    //基本运算
    public static Integer getRes(Integer mathInt1, Integer mathInt2, String mathStr) {

        if (mathStr.equals(chen)) {
            return mathInt1 * mathInt2;
        }
        if (mathStr.equals(chu)) {
            return mathInt1 / mathInt2;
        }
        if (mathStr.equals(jia)) {
            return mathInt1 + mathInt2;
        }
        if (mathStr.equals(jian)) {
            return mathInt1 - mathInt2;
        }
        return null;
    }
}
