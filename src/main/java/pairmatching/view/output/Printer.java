package pairmatching.view.output;

public interface Printer {

    void printMessage(Output output);

    void printfMessage(Output output, Object... args);
}