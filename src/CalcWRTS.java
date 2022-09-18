public class CalcWRTS {
    // Retorna o valor w do endereco passado como parametro
    public static int calcW(int x) {
        int binaryMask = 0b111111;
        return x & binaryMask;
    }

    // Retorna o valor r do endereco passado como parametro
    public static int calcR(int x) {
        int binaryMask = 0b1111111000000;
        return (x & binaryMask) >> 6;
    }
    
    // Retorna o valor t do endereco passado como parametro
    public static int calcT(int x) {
        int binaryMask = 0b111111111110000000000000;
        return (x & binaryMask) >> 13;
    }

    // Concatena os bits t e r, resultando no s
    public static int resolveS(int t, int r) {
        return t << (32 - Integer.numberOfLeadingZeros(r)) | r;
    }
}
