public class CPU {
    IO io;
    Cache cache;

    public CPU(IO io, Cache cache) {
        this.io = io;
        this.cache = cache;
    }

    public void Run(int address) throws EnderecoInvalido {
        io.OutPut(cache.calcAddress(address));
    }
}
