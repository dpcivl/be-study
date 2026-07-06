import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> tags = new HashSet<>();
        tags.add("자바");
        tags.add("스프링");
        tags.add("자바");

        System.out.println("개수: " + tags.size());
        System.out.println(tags.contains("스프링"));
    }
}