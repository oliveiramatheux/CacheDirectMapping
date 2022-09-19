/*
Equipe:
Eric Nielsen França
Ivan Garbi Truti Assumpção
Matheus de Oliveira Teles da Silva
*/

public class Main {
    public static void main(String[] args) throws EnderecoInvalido {
        // entrada e saida
        IO es = new IO(System.out);
        RAM ram = new RAM(23);
        Cache cache = new Cache(ram, 64); 
        CPU cpu = new CPU(es, cache);
        
        ram.Write(32, 10);
        cpu.Run(01000000);
    }
}
