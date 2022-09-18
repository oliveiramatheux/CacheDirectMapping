public class IO {
    java.io.PrintStream output;

    public IO(java.io.PrintStream output) {
        this.output = output;
    }

    public void OutPut(int word) {
        output.println(word);
    }
}
