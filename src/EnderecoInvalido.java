class EnderecoInvalido extends Exception {
    private final int address;

    public EnderecoInvalido(int address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Invalid Address: " + address;
    }
}