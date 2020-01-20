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
public class ArrayQueue {
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
    private Integer[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new Integer[maxSize];
        // 指向队列头部
        front = 0;
        // 指向队列尾部
        rear = 0;
    }

    /**
     * 判断队列是否以满
     *
     * @return
     */
    public boolean isFull() {
        /**
         * MaxSize是你的数组的大小，如果最后一个元素位置被使用后，要再存下一个元素，
         * 那么按循环队列的定义，应该是存到数组的开头，而对MaxSize取余则可以使得下标从MaxSize-1变为0，然后递增，达到循环的目的。
         */
        boolean isFull = (rear + 1) % maxSize == front;
        return isFull;
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
        //添加数据
        arr[rear] = n;
        //尾部后移
        rear = (rear + 1) % maxSize;

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
        int res = arr[front];
        front = (front + 1) % maxSize;
        return res;
    }

    /**
     * 获取所有队列信息
     */
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
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
        return arr[front];
    }

    /**
     * 判断数组有效数据个数
     *
     * @return
     */
    public int size() {
        int numCount = (rear + maxSize - front) % maxSize;
        return numCount;
    }
}
