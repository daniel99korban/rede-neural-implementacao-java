# Rede Neural FeedForward em Java

Este projeto é uma implementação de uma rede neural do tipo FeedForward em Java, baseada no vídeo do canal [Fazendo uma Rede Neural do Zero! #1 - FeedForward](https://www.youtube.com/watch?v=d8U7ygZ48Sc&t=2154s).

## Descrição

Atualmente, a implementação contém apenas o processo de FeedForward. A rede neural é composta por camadas de entrada, escondida e saída, utilizando a função de ativação Sigmoid.

## Estrutura do Projeto

O projeto contém as seguintes classes principais:

- **Matrix**: Representa operações matriciais essenciais para os cálculos da rede neural.
- **FunctionAct**: Interface para funções de ativação.
- **Sigmoid**: Implementação da função de ativação Sigmoid.
- **RedeNeural**: Implementação da estrutura da rede neural, incluindo os pesos, bias e o método FeedForward.
- **Main**: Exemplo de uso da rede neural.

## Código de Exemplo

### Classe Matrix
```java
package components;

import java.util.Random;

public class Matrix {
    private int cols;
    private int rows;
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
        }
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

    public void setData(Double[][] data) {
        this.data = data;
    }
}
```

### Interface de Função de Ativação
```java
public interface FunctionAct {
    public Double active(Double v);
}
```

### Função Sigmoid
```java
public class Sigmoid implements FunctionAct{
    @Override
    public Double active(Double v) {
        return 1 / (1 + Math.exp(-v));
    }
}
```

### Classe RedeNeural
```java
package components;

public class RedeNeural {
    private Matrix weightInputHidden;
    private Matrix weightHiddenOut;

    public RedeNeural(int numNeuronsI, int numNeuronsH, int numNeuronsO){
        this.weightInputHidden = new Matrix(numNeuronsH, numNeuronsI).randomize();
        this.weightHiddenOut = new Matrix(numNeuronsO, numNeuronsH).randomize();
    }

    public void feedForWard(Double[] array){
        Matrix inputs = Matrix.arrayToMatrix(array);
        Matrix hidden = Matrix.dataMultiply(this.weightInputHidden, inputs);
        hidden.map(new Sigmoid());

        Matrix output = Matrix.dataMultiply(this.weightHiddenOut, hidden);
        output.map(new Sigmoid());
    }
}
```

### Exemplo de Uso
```java
package org.example;

import components.RedeNeural;

public class Main {
    public static void main(String[] args) {
        RedeNeural nn = new RedeNeural(1, 3, 5);
        Double[] elements = {1d, 2d};
        nn.feedForWard(elements);
    }
}
```

### Saída Esperada
```
hidden -> output before activation
1.02203028128652|
-0.2816450316415783|
-0.331895797855565|
-0.16267436605002555|
-0.18351671331268982|

hidden -> output after activation
0.7353678849381925|
0.43005052086316337|
0.417779417961062|
0.45942085603021365|
0.4542491508794754|
```

## Como Executar o Projeto
1. Clone este repositório.
2. Certifique-se de ter o JDK instalado.
3. Compile e execute a classe `Main`.

## Melhorias Futuras
- Implementação do Backpropagation.
- Adição de outras funções de ativação.
- Otimização do código e modularização.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

---

Este projeto é um estudo sobre redes neurais e está aberto a melhorias e colaborações.
