package org.stella;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class MainTest {


    @ParameterizedTest(name = "{index} Typechecking well-typed program {0}")
    @ValueSource(strings = {
            "tests/well-typed/factorial.stella",
            "tests/well-typed/squares.stella",
            "tests/well-typed/higher-order-1.stella",
            "tests/well-typed/increment_twice.stella",
            "tests/well-typed/logical-operators.stella"})
    void testWellTyped(String filepath) throws Exception {
        String[] args = new String[0];
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(filepath);
        System.setIn(fips);
        Assertions.assertDoesNotThrow(() -> Main.main(args));
        System.setIn(original);
    }

    @ParameterizedTest(name = "{index} Typechecking ill-typed program {0}")
    @ValueSource(strings = {
            "tests/ill-typed/applying-non-function-1.stella",
            "tests/ill-typed/applying-non-function-2.stella",
            "tests/ill-typed/applying-non-function-3.stella",
            "tests/ill-typed/argument-type-mismatch-1.stella",
            "tests/ill-typed/argument-type-mismatch-2.stella",
            "tests/ill-typed/argument-type-mismatch-3.stella",
            "tests/ill-typed/bad-if-1.stella",
            "tests/ill-typed/bad-if-2.stella",
            "tests/ill-typed/bad-succ-1.stella",
            "tests/ill-typed/bad-succ-2.stella",
            "tests/ill-typed/bad-succ-3.stella",
            "tests/ill-typed/shadowed-variable-1.stella",
            "tests/ill-typed/undefined-variable-1.stella",
            "tests/ill-typed/undefined-variable-2.stella",
            "tests/ill-typed/bad-squares-1.stella",
            "tests/ill-typed/bad-squares-2.stella"})
    void testIllTyped(String filepath) throws Exception {
        String[] args = new String[0];
        final FileInputStream fips = new FileInputStream(filepath);
        System.setIn(fips);

        Exception exception = assertThrows(Exception.class, () -> Main.main(args), "Expected the type checker to fail!");
        System.out.println("Type Error: " + exception.getMessage());
    }

    @ParameterizedTest(name = "{index} Typechecking ill-typed program {0}")
    @MethodSource("provideWeek2TestFiles")
    void testWeek2IllTyped(String filepath) throws Exception {
        String[] args = new String[0];
        final FileInputStream fips = new FileInputStream(filepath);
        System.setIn(fips);

        Exception exception = assertThrows(Exception.class, () -> Main.main(args), "Expected the type checker to fail!");
        System.out.println("Type Error: " + exception.getMessage());
    }

    static Stream<String> provideWeek2TestFiles() {
        List<String> filePaths = new ArrayList<>();
        for (int i = 1; i <= 120; i++) {
            filePaths.add(String.format("tests/week-2/main/secret/%d.stella", i));
        }
        return filePaths.stream();
    }

    @ParameterizedTest(name = "{index} Typechecking ill-typed program {0}")
    @MethodSource("provideWeek3TestFiles")
    void testWeek3IllTyped(String filepath) throws Exception {
        String[] args = new String[0];
        final FileInputStream fips = new FileInputStream(filepath);
        System.setIn(fips);

        Exception exception = assertThrows(Exception.class, () -> Main.main(args), "Expected the type checker to fail!");
        System.out.println("Type Error: " + exception.getMessage());
    }

    static Stream<String> provideWeek3TestFiles() {
        List<String> filePaths = new ArrayList<>();
        for (int i = 2; i <= 76; i+=2) {
            filePaths.add(String.format("tests/week-3/main/secret/%d.stella", i));
        }
        return filePaths.stream();
    }

    @ParameterizedTest(name = "{index} Typechecking ill-typed program {0}")
    @MethodSource("provideWeek5TestFiles")
    void testWeek5IllTyped(String filepath) throws Exception {
        String[] args = new String[0];
        final FileInputStream fips = new FileInputStream(filepath);
        System.setIn(fips);

        Exception exception = assertThrows(Exception.class, () -> Main.main(args), "Expected the type checker to fail!");
        System.out.println("Type Error: " + exception.getMessage());
    }

    static Stream<String> provideWeek5TestFiles() {
        List<String> filePaths = new ArrayList<>();
        for (int i = 2; i <= 134; i+=2) {
            filePaths.add(String.format("tests/week-5/main/secret/%d.stella", i));
        }
        return filePaths.stream();
    }

    @ParameterizedTest(name = "{index} Typechecking ill-typed program {0}")
    @MethodSource("provideWeek6TestFiles")
    void testWeek6IllTyped(String filepath) throws Exception {
        String[] args = new String[0];
        final FileInputStream fips = new FileInputStream(filepath);
        System.setIn(fips);

        Exception exception = assertThrows(Exception.class, () -> Main.main(args), "Expected the type checker to fail!");
        System.out.println("Type Error: " + exception.getMessage());
    }

    static Stream<String> provideWeek6TestFiles() {
        List<String> filePaths = new ArrayList<>();
        for (int i = 2; i <= 174; i+=2) {
            filePaths.add(String.format("tests/week-6/main/secret/%d.stella", i));
        }
        return filePaths.stream();
    }
}
