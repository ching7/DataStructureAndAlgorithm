# DataStructureAndAlgorithm
常用的数据结构和算法demo

## 1 T01-sparseArray（稀疏数组）

需求：

* 二维数组 -> 稀疏数组

* 稀疏数组 -> 二维数组 

思路：

* 二维数组 -> 稀疏数组
  * 遍历二维数组，得到有效的数据个数sum
  
    ~~~java
  //定义一个整型数组:2行3列
    int a[][] = new int[2][3];
    //获取行数---2行
    int lenY = a.length;
    //获取列数---3列
    int lenX = a[0].length;
    其实很好理解，因为二维数组可以理解为是一维数组，只不过他的各处的元素是特殊元素—–一维数组
    [ a[0][0] a[0][1] a[0][2] ]  ,[ a[1][0] a[1][1] a[1][2] ]
    ~~~
  
  * 根据sum创建稀疏数组`sparseArr[sum+1][3]`
  
  * 将二维数组有效数据传入`sparseArr`中
  
* 稀疏数组 -> 二维数组 
  * 先读取`sparseArr`第一行的数据，创建对应的二维数组
  * 遍历`sparseArr`，将有效数据存入二维数组