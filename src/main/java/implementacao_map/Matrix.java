package implementacao_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Matrix {

    private int cols;
    private int rows;
    Map<String, Integer> map;
    private static int matrixId;
    private int id;

    public Matrix(int rows, int cols){
        this.map = new HashMap<>();

        this.cols = cols;
        this.rows = rows;

        Random generator = new Random();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                map.put("["+i+""+j+"]", generator.nextInt(10));
            }
        }
        this.id = matrixId;
        matrixId++;
    }

    static boolean add(components.Matrix a, components.Matrix b){
        return true;
    }

    public void exibirMatriz(){
        System.out.println("MATRIZ ["+ this.id +"]");
        map.forEach((key, value) -> {
            System.out.print(key + " = " + value);
            if (Integer.parseInt(key.split("")[2]) == 3){
                System.out.println();
            }
        });
    }
}
