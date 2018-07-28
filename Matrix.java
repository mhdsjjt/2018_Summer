
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int n,i,j;
        Scanner scr = new Scanner(System.in);
        System.out.println("请输入矩阵阶数n：");
        n = scr.nextInt();
        int num[][] = new int[n][n];
        for(i = 0;i < n; i++){
            System.out.println("请输入矩阵的第"+(i+1)+"行的"+n+"个数值：");
            for(j = 0;j < n; j++){
                num[i][j] = scr.nextInt();
            }
        }
        System.out.println("旋转前矩阵为：");
        printMatrix(num);

        changeMatrix(num,n);
        System.out.println("旋转后矩阵为：");
        printMatrix(num);
    }

    private static void printMatrix(int temp[][]){
        for(int i = 0;i < temp.length;i++){
            for(int j = 0;j < temp.length;j++){
                System.out.print(temp[i][j]+"\t");
            }
            System.out.println("");
        }
    }

    //顺时针90度旋转矩阵：把矩阵看成边长递减的多个正方形嵌套而成，每条边由对应的a[i][j]构成，则其边长递减公差为2，
    // 并从最外面的正方形开始依次编号，编号从0开始，最外圈正方形边长即为矩阵阶数n
    //找规律可发现，旋转即：a[i][j]的值赋给a[j][n-i-1];行变纵，纵变行
    private static void   changeMatrix(int a[][],int n){
        for(int i = 0; i < n/2;i++){  //需要旋转的圈数 = n/2；从最外圈正方形开始依次旋转

           /*每轮旋转，修改对应的各四条边上的1个元素，如3阶方阵的a[0][0]、a[0][2]、a[2][2]、a[2][0]这四个元素；
           则旋转正方形的一条边上的所有元素，需要改值的轮数 = 边长-1；边长 = n-2*正方形编号； */
            for(int j = i; j < (n-2*i) - 1+i; j++){
                int temp1,temp2,temp3,x,y;
                temp1 = a[i][j];
                x = i; y = j;
                for(int m = 0; m < 4;m++){  //每轮每条边有1个元素变动，则四边共4个元素的值需改变
                    temp2 = a[y][n-x-1];
                    a[y][n-x-1] = temp1;
                    temp1 = temp2;
                    temp3 = x;
                    x = y;
                    y = n-temp3-1;
                }
            }
        }
    }

}
