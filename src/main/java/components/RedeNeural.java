package components;

public class RedeNeural {
    private Matrix biasInputHiddenLayer;
    private Matrix biasHiddenLayerOutput;
    private Matrix weightInputHidden;
    private Matrix weightHiddenOut;

    public RedeNeural(int numNeuronsI, int numNeuronsH, int numNeuronsO){
        this.biasInputHiddenLayer = new Matrix(numNeuronsH, 1).randomize();
        this.biasHiddenLayerOutput = new Matrix(numNeuronsO, 1).randomize();
        this.weightInputHidden = new Matrix(numNeuronsH, numNeuronsI).randomize();
        this.weightHiddenOut = new Matrix(numNeuronsO, numNeuronsH).randomize();
    }

    public Matrix getBiasInputHiddenLayer() {
        return biasInputHiddenLayer;
    }

    public Matrix getBiasHiddenLayerOutput() {
        return biasHiddenLayerOutput;
    }

    public Matrix getWeightInputHidden() {
        return weightInputHidden;
    }

    public Matrix getWeightHiddenOut() {
        return weightHiddenOut;
    }

    public void feedForWard(Double[] array){
        // Camada de input -> hidden
        Matrix inputs = Matrix.arrayToMatrix(array);
        Matrix hidden = Matrix.dataMultiply(this.weightInputHidden, inputs);
        hidden = hidden.add(hidden, this.weightInputHidden);
        Matrix.exibirMatriz("input -> hidden before activation", hidden.getData());
        hidden.map(new Sigmoid());
        Matrix.exibirMatriz("input -> hidden after activation", hidden.getData());

        // Camada hidden -> output
        Matrix output = Matrix.dataMultiply(this.weightHiddenOut, hidden);
        output = output.add(output, this.weightHiddenOut);
        Matrix.exibirMatriz("hidden -> output before activation", output.getData());
        output.map(new Sigmoid());
        Matrix.exibirMatriz("hidden -> output after activation", output.getData());
    }
}
