import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Tests {


    @Test
    public void firstTaskTest() {
        String s1 = "hello";

        Function<String, Integer> lambda = LambdaDemo.stringlength;
        assertEquals(Optional.of(5), Optional.ofNullable(LambdaRunner.run(lambda, s1)));
    }

    @Test
    public void secondTaskTest() {
        String s1 = "hello";
        Function<String, Character> lambda = LambdaDemo.firstsymbol;
        assertEquals(Optional.of('h'), Optional.ofNullable(LambdaRunner.run(lambda, s1)));
        assertNull(LambdaRunner.run(lambda, null));
        assertNull(LambdaRunner.run(lambda, ""));
    }

    @Test
    public void thirdTaskTest() {
        String s2 = "hello world";

        Function<String, Boolean> lambda = LambdaDemo.space;
        assertEquals(true, LambdaRunner.run(lambda, s2));
    }

    @Test
    public void fourthTaskTest() {
        String s3 = "Nikitos, machomen, magist";

        Function<String, Integer> lambda = LambdaDemo.countWordsInString;
        assertEquals(Optional.of(3), Optional.ofNullable(LambdaRunner.run(lambda, s3)));
        assertEquals(Optional.of(3), Optional.ofNullable(LambdaRunner.run(lambda, "aaa,,,aaa,,,aaa")));
    }

    @Test
    public void fifthTaskTest() {
        Human human1 = new Human("Асаевич", "Никита", "Сергеевич", 19, Gender.MALE);

        Function<? super Human, Integer> lambda = LambdaDemo.getAgeOfHuman;
        assertEquals(Optional.of(19), Optional.ofNullable(LambdaRunner.run(lambda, human1)));
    }

    @Test
    public void sixthTaskTest() {
        Human human1 = new Human("Асаевич", "Никита", "Сергеевич", 19, Gender.MALE);
        Student human2 = new Student("Иванов", "Иван", "Иванович", "OмГУ", "фмит", "математик",
                19, Gender.MALE);

        BiFunction<? super Human, ? super Human, Boolean> lambda = LambdaDemo.equalsLastName;
        assertEquals(false, LambdaRunner.biFunctionRun(lambda, human1, human2));
    }

    @Test
    public void seventhTaskTest() {
        Human human1 = new Human("Асаевич", "Никита", "Сергеевич", 19, Gender.MALE);

        Function<? super Human, String> lambda = LambdaDemo.makeStringHuman;
        assertEquals("Асаевич Никита Сергеевич", LambdaRunner.run(lambda, human1));
    }

    @Test
    public void eightTaskTest() {
        Human human1 = new Human("Асаевич", "Никита", "Сергеевич", 19, Gender.MALE);

        Function<Human, Human> lambda = LambdaDemo.getOlder;
        assertEquals(20, LambdaRunner.run(lambda, human1).getAge());
    }

    @Test
    public void ninthTaskTest() {
        Human human1 = new Human("Асаевич", "Никита", "Сергеевич", 19, Gender.MALE);
        Human human3 = new Human("Романовский", "Иван", "Владимирович", 21, Gender.MALE);
        Human human4 = new Human("Раховецкий", "Андрей", "Олегович", 30, Gender.MALE);


        int maxAge1 = 20;
        int maxAge2 = 18;

        assertTrue(LambdaDemo.checkYounger.checkHumansAndMaxAge(human1, human3, human4, maxAge1));
        assertFalse(LambdaDemo.checkYounger.checkHumansAndMaxAge(human1, human3, human4, maxAge2));
    }

    @Test
    public void tenTaskTest() {
        Human human1 = new Human("Асаевич", "Никита", "Сергеевич", 19, Gender.MALE);
        Student human2 = new Student("Иванов", "Иван", "Иванович", "OмГУ", "фмит", "математик",
                19, Gender.MALE);
        Human human3 = new Human("Романовский", "Иван", "Владимирович", 21, Gender.MALE);


        assertFalse(LambdaRunner.checkAgeRun(LambdaDemo.checkYounger, human1, human2, human3, 21));
    }


}
