public interface Memoria {
    // Interface da Ram ou cache
    int Read(int address) throws EnderecoInvalido;
    void Write(int address, int word) throws EnderecoInvalido;
}
