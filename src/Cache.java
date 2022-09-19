public class Cache {
    private int w;
    private int r;
    private int t;
    private int s;
    private final int k; // número de palavras de uma cache line
    private Line[] cache; // array de cache lines
    private RAM ram; // instância da memória ram

    public Cache(RAM ram, int k) {
        this.ram = ram;
        this.k = k;

        cache = new Line[64];
        for(int i = 0; i < 64; i++) {
            cache[i] = new Line(k);
        }
    }

    // Escreve palavra na Ram
    private void write() throws EnderecoInvalido {
        for(int i=0; i < k; i++) {
            ram.Write(s+w, cache[r].cacheLine[i]);
        }
    }

    // Lê um bloco da Ram e salva em uma cache line
    private void read() throws EnderecoInvalido {
        for(int i = 0; i < k; i++) {
            cache[r].cacheLine[i] = ram.Read(s+w);
        }
    }

    // Significa que o endereço buscado está na cache, então apenas retorna a palavra correspondente
    private int hit() {
        return cache[r].cacheLine[w];
    }

    // Signiica que o endereço buscado não está na Cache, então verifica se a Line foi alterada, caso sim, salva na Ram, se não copia o bloco da Ram para a Cache
    private int miss() throws EnderecoInvalido {
        if(cache[r].modif) {
            write();
        }
        read();
        return cache[r].cacheLine[w];
    }

    // Separa os valores w, r, t e s do endereço solicitado para executar os calculos necessários
    public int calcAddress(int address) throws EnderecoInvalido {
        w = CalcWRTS.calcW(address);
        r = CalcWRTS.calcR(address);
        t = CalcWRTS.calcT(address);
        s = CalcWRTS.resolveS(t, r);

        if (t == cache[r].tag) {
            System.out.println("deu hit");
            return hit();
        } else {
            System.out.println("deu miss");
            return miss();
        }
    }
}
