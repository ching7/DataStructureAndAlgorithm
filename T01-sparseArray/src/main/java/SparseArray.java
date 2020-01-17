import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件描述
 *
 * @ProjectName: dataStructure-algorithm
 * @Package: PACKAGE_NAME
 * @Date 2019/12/20 12:20
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 1）使用稀疏数组，来保留二维数组
 * 2）把稀疏数组存盘，并且可以从新恢复原来的二维数组数
 **/
public class SparseArray {
    public static void main(String[] args) {
       /* // 二维数组转稀疏数组
        int[][] arr = new int[11][11];
        arr[2][3] = 23;
        arr[4][5] = 45;
        arrToSparseArr(arr);

        // 稀疏数组转二维数组
        int[][] sparse = new int[3][3];
        sparse[0][0] = 10;
        sparse[0][1] = 11;
        sparse[0][2] = 2;

        sparse[1][0] = 4;
        sparse[1][1] = 5;
        sparse[1][2] = 56;

        sparse[2][0] = 5;
        sparse[2][1] = 6;
        sparse[2][2] = 67;
        sparseArrToArr(sparse);*/
        diskToData("D:\\map.data");
    }

    /**
     * 常规数组转稀疏数组
     *
     * @param arr
     */
    public static void arrToSparseArr(int[][] arr) {
        // 1 原始二维数组，11行11列，仅仅2个有效数据
        System.out.println("原始二维数组: ");
        arrStdOut(arr);
        // 找出有效数字数量
        int ableNum = 0;
        //记录有效数字位置及值
        List<Map<String, Integer>> ableNumList = new ArrayList<>();
        // 行
        for (int i = 0; i < arr.length; i++) {
            //列
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    //记录有效数字位置及值
                    Map<String, Integer> map = new HashMap<>(3);
                    map.put("row", i);
                    map.put("col", j);
                    map.put("val", arr[i][j]);
                    ableNumList.add(map);
                    ableNum += 1;
                }
            }
        }

        // 2 新建稀疏数组
        int[][] spareArr = new int[ableNum + 1][3];
        spareArr[0][0] = arr.length;
        spareArr[0][1] = arr[0].length;
        spareArr[0][2] = ableNum;
        int row = 1;
        for (int i = 0; i < ableNumList.size(); i++) {
            Map<String, Integer> valMap = ableNumList.get(i);
            spareArr[row][0] = valMap.get("row");
            spareArr[row][1] = valMap.get("col");
            spareArr[row][2] = valMap.get("val");
            row++;
        }
        System.out.println("稀疏数组: ");
        arrStdOut(spareArr);
        dataToDisk(spareArr);
    }

    /**
     * 稀疏数组转常规数组
     *
     * @param sparseArr
     */
    public static void sparseArrToArr(int[][] sparseArr) {
        // 1 遍历第一行数据构建二维数组
        System.out.println("原始稀疏数组: ");
        arrStdOut(sparseArr);
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] arr = new int[row][col];

        // 2 还原数据
        for (int i = 1; i < sparseArr.length; i++) {
            int tempRow = sparseArr[i][0];
            int tempCol = sparseArr[i][1];
            int tempVal = sparseArr[i][2];
            arr[tempRow][tempCol] = tempVal;
        }

        System.out.println("二维数组: ");
        arrStdOut(arr);
    }

    /**
     * 数组控制台打印
     *
     * @param arr
     */
    public static void arrStdOut(int[][] arr) {
        // 行
        for (int i = 0; i < arr.length; i++) {
            //列
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 数据存磁盘
     *
     * @param data
     */
    public static void dataToDisk(int[][] data) {
        try {
            // 相对路径，如果没有则要建立一个新的output.txt文件
            File writeName = new File("D:\\map.data");
            if (!writeName.exists()) {
                writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            }
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(writeName));
            out.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 磁盘取数据
     */
    public static void diskToData(String filePath) {
        try  {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
            int[][] data = (int[][]) inputStream.readObject();
            arrStdOut(data);
        } catch (Exception e) {

        }
    }
}
