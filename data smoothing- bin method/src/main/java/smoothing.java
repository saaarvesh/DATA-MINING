
import java.util.Arrays;
import java.util.Scanner;

public class smoothing {

    static int a = 0;

    public static void main(String args[]) {
        
        smoothing sm = new smoothing();
        //scanning size
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array:");
        int size = sc.nextInt();

        //taking element of array
        int[] data = new int[size];
        System.out.println("enter elemeant of array:");
        for (int i = 0; i < size; i++) {
            data[i] = sc.nextInt();
        }

        //array sorting
        System.out.println("sorted array:");
        Arrays.sort(data);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        //bin depth
        System.out.println("enter the bin depth:");
        int bin_depth = sc.nextInt();

        //bin number
        int bin_number = data.length / bin_depth;

        //creating bin
        int[][] bin = new int[bin_number][bin_depth];

        for (int i = 0; i < bin_number; i++) {
            for (int j = 0; j < bin_depth; j++) {
                bin[i][j] = data[a];
                a++;
            }

        }
        //displying bin
        for (int i = 0; i < bin_number; i++) {
            System.out.print("bin" + (i + 1) + "--> ");
            for (int j = 0; j < bin_depth; j++) {
                System.out.print(" " + bin[i][j]);
            }
            System.out.println();

        }
        
        //creating mean array
        int[][] mean=new int[bin_number][bin_depth];
        for (int i = 0; i < bin_number; i++) {
            
            System.arraycopy(bin[i], 0, mean[i], 0, bin_depth);
            System.out.println();

        }
        
        //calling mean fuction for mean smoothing
        sm.mean(bin_number, bin_depth, mean);
        
         //creating median array
        int[][] median=new int[bin_number][bin_depth];
        for (int i = 0; i < bin_number; i++) {
            
            System.arraycopy(bin[i], 0, median[i], 0, bin_depth);
            System.out.println();

        }
      
       //calling mean fuction for median smoothing
       sm.median(bin_number, bin_depth, median);
       
       //creating median array
        int[][] boundary=new int[bin_number][bin_depth];
        for (int i = 0; i < bin_number; i++) {
            
            System.arraycopy(bin[i], 0, boundary[i], 0, bin_depth);
            System.out.println();

        }
        //creating median array
          sm.boundary(bin_number, bin_depth, boundary);
    }
        
    //mean
    void mean(int bin_number, int bin_depth, int[][] mean) {
        String s = "mean";
        double sum = 0;
        int sum1=0;
        for (int i = 0; i < bin_number; i++) {
            for (int j = 0; j < bin_depth; j++) {
                sum = sum + mean[i][j];
            }
            sum = sum / bin_depth;
            sum1=(int)sum;
            if((sum-sum1)>0.50)
                sum1++;
            for (int j = 0; j < bin_depth; j++) {
                mean[i][j] = sum1;
            }
            sum = 0;
            sum1= 0;
         //4, 8, 9, 15, 21, 21, 24, 25, 26, 28, 29, 34
        }
        display(bin_number, bin_depth, mean, s);

    }
    
    //median
    void median(int bin_number, int bin_depth, int[][] median) {
        String s = "median";

        int bin_depth1 = bin_depth / 2;
        for (int i = 0; i < bin_number; i++) {

            if (bin_depth1 % 2 == 0) {
                int replace = (median[i][bin_depth1] + median[i][bin_depth1 - 1]) / 2;
                for (int j = 0; j < bin_depth; j++) {
                    median[i][j] = replace;
                }
            } else {
                for (int j = 0; j < bin_depth; j++) {
                    median[i][j] = median[i][bin_depth1];
                }

            }

        }
        display(bin_number, bin_depth, median, s);

    }

    //displaying bins after smoothing
    void display(int bin_number, int bin_depth, int[][] normal, String s) {
        System.out.println("bins after " + s + " smoothing");
        for (int i = 0; i < bin_number; i++) {
            System.out.print("bin" + (i + 1) + "--> ");
            for (int j = 0; j < bin_depth; j++) {
                System.out.print(normal[i][j] + " ");
            }
            System.out.println();

        }
    }
   
    //boundary
    void boundary(int bin_number, int bin_depth, int[][] boundary) {
        String s = "boundary";
        
        int min1;
        int min2;
        
        for (int i = 0; i < bin_number; i++) {
            for (int j = 0; j < bin_depth - 2; j++) {
                if ((boundary[i][j+1]-boundary[i][j]) < (boundary[i][j + 2]-boundary[i][j + 1])) {
                    min1 = i;
                    min2 = j;
                } else {
                    min1 = i;
                    min2 = j + 1;
                }
                for (j = 1; j <= bin_depth - 2; j++) {
                boundary[i][j] = boundary[min1][min2];
            }
            }
           

        }
        display(bin_number, bin_depth, boundary, s);
    }

}

