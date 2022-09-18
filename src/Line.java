public class Line {
    public int tag;
    public boolean modif; // flag que indica se a cache foi modificada
    public int[] cacheLine; // array que representa a linha da cache

    public Line(int k) {
        // o tamanho da cacheLine é o valor de k passado como parâmetro
        this.cacheLine = new int[k];
    }
}
