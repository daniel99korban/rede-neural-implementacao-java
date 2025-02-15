package components;

import java.util.Random;

public class Matrix {

    private int cols;
    private int rows;
    private Matrix A;
    private Matrix B;
    private Double data[][];
    private static Random generator = new Random();

    public Matrix(int rows, int cols){
        this.cols = cols;
        this.rows = rows;
        this.data = new Double[rows][cols];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                this.data[i][j] = generator.nextDouble(10);
            }
        };
    }

    public Matrix add(Matrix a, Matrix b){
        int n = a.data.length;
        int m = a.data[0].length;
        Double[][] dataSun = new Double[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                dataSun[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        Matrix matrixSun  = new Matrix(n, m);
        matrixSun.setData(dataSun);
        return matrixSun;
    }

    public Double[][] getData(){
        return this.data;
    }

    public void setData(Double[][] data) {
        this.data = data;
    }

    public static void exibirMatriz(String s, Double[][] _data){
        System.out.println(s);
        for (int i = 0; i < _data.length; i++){
            for (int j = 0; j < _data[0].length; j++){
                System.out.print(_data[i][j]);
                if(j<_data[0].length-1){
                    System.out.print("|");
                }
            }
            System.out.println("|");
        }
        System.out.println();
    }

    public Matrix randomize(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                this.data[i][j] = generator.nextDouble()*2-1;
            }
        }
        return this;
    }

    public static Matrix dataMultiply(Matrix a, Matrix b) {
        int n = a.data.length;
        int p = a.data[0].length;
        int m = b.data[0].length;
        Double[][] dataMult = new Double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dataMult[i][j] = 0d;
                for (int k = 0; k < p; k++) {
                    dataMult[i][j] += a.data[i][k] * b.data[k][j];
                }
            }
        }
        Matrix matrixMultiplyed  = new Matrix(n, m);
        matrixMultiplyed.setData(dataMult);
        return matrixMultiplyed;
    }

    public static Matrix arrayToMatrix(Double[] elem){
        int col = 1;
        Matrix m = new Matrix(elem.length, col);
        Double[][] matrizElem = m.getData();
//        exibirMatriz("Matriz antes de ser atribuida",m.getData());
        for (int i =0; i< elem.length ;i++){
            for (int j=0; j<col ;j++){
                matrizElem[i][j] = elem[i];
            }
        }
        m.setData(matrizElem);
//        exibirMatriz("Matriz depois de ser atribuida",m.getData());
        return m;
    }

    public Matrix map(FunctionAct f){
        Matrix m = new Matrix(this.rows, this.cols);
        Double[][] matrixAct = this.data;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                double v = this.data[i][j];
                matrixAct[i][j] = f.active(v);
            }
        }
        m.setData(matrixAct);
        return m;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}
