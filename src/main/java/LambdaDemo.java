import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
public class LambdaDemo
{
    public static final Function<String, Integer> stringlength = String::length;
    public static final Function<String, Character> firstsymbol = (s) -> Optional.ofNullable(s)
            .filter(x -> !x.isEmpty()).map(y -> y.charAt(0)).orElse(null);
    public static final Function<String, Boolean> space = (s) -> s.contains(" ");
    public static final Function<String, Integer> countWordsInString = (s)-> {
        if (s == null) {
            return null;
        }
        if(s.isEmpty())
        {
            return 0;
        }
        int i = 0;
        for(String ss : s.split(",")){
            if((!ss.isEmpty() && !ss.equals(" "))){
                i++;
            }
        }
        return i;
    };

    //5 - 1
    public static final Function<? super Human, Integer> getAgeOfHuman = Human::getAge;

    //6
    public static final BiFunction<? super Human, ? super Human, Boolean> equalsLastName = (h1, h2) -> h1.getLastname().equals(h2.getLastname());

    //7 - 1
    public static final Function<? super Human, String> makeStringHuman = (h) -> String.format("%s %s %s",h.getFirstname(), h.getMidlename(), h.getLastname());

    //8 - 1
    public static final Function<Human, Human> getOlder = (h) -> new Human(h.getFirstname(),h.getMidlename(), h.getLastname(), h.getAge() + 1, h.getGender());

    //9
    public static final EqualsHumansAndMaxAge checkYounger = (h1,h2,h3,maxAge) -> (h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge);


}
