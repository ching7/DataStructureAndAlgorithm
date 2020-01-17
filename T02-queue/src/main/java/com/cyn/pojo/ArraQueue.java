package com.cyn.pojo;

/**
 * 文件描述
 *
 * @ProjectName: dataStructure-algorithm
 * @Package: com.cyn.pojo
 * @Date 2020/1/17 17:30
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 队列类
 **/
public class ArraQueue {
    /**
     * 队列最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 存放队列数据，模拟队列
     */
    private int[] arr;

    public ArraQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        // 指向队列头部，头部前一个数据
        front = -1;
        // 指向队列尾部，包含尾部
        rear = -1;
    }

    /**
     * 判断队列是否以满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 队列添加数据
     */
    public void addQueue(int n) {
        // 判断是否满
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        //尾部后移
        rear++;
        //添加数据
        arr[rear] = n;
    }

    /**
     * 队列取数据
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        front++;
        return arr[front];
    }

    /**
     * 获取所有队列信息
     */
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d", i, arr[i]);
        }
    }

    /**
     * 查看数列头
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return arr[front+1];
    }
}
