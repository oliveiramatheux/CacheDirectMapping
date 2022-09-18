public class RAM implements Memoria {
    private final int size; // tamanho total da memória
    private final int[] ram; // array que representa a memória ram

    public RAM(int k) {
        size = (int) Math.pow(2,k);
        this.ram = new int[size];
    }

    @Override
    public int Read(int address) throws EnderecoInvalido {
        // Função para ler da Ram
        // Faz validação do endereço passado no parâmetro,
        // Caso o endereço seja válido, realiza a leitura, se não lança exceção.
        if(isValid(address)) {
            return ram[address];
        }
        throw new EnderecoInvalido(address);
    }

    @Override
    public void Write(int address, int word) throws EnderecoInvalido {
        // Função para escrever na Ram
        // Faz validação do endereço passado no parâmetro,
        // Caso o endereço seja válido, realiza a escrita, se não lança exceção.
        if(isValid(address)) {
            ram[address] = word;
        } else {
            throw new EnderecoInvalido(address);
        }
    }

    private boolean isValid(int address) {
        // Função para validar endereço de leitura ou escrita
        // Para ser válido um endereço precisa ser menor que o tamanho total da memória e maior do que zero
        return (address >= 0 && address < size);
    }
}
