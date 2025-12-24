/*
 * The "Hello Word!" program, just proves you can print to terminal.
 *
 * @author  Mr Coxall
 * @version 1.0
 * @since   2020-01-01
 */

/**
 * This is the standard "Hello, World!" program.
 */
public final class HelloWorld {

    /**
     * Prevent instantiation.
     * Throw an exception IllegalStateException.
     * if this is ever called
     *
     * @throws IllegalStateException if this is ever called
     *
     */
    private HelloWorld() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * A constant representing some number.
     */
    private static final int SOME_NUMBER = 42;

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(final String[] args) {
        // variables

        // print out "Hello, World!"
        System.out.println("Hello, World!");
        System.out.println(SOME_NUMBER);
        System.out.println("\nDone.");
    }
}
