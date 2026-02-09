package example.com;
import java.util.StringTokenizer;
public class WordCount {
    public static void main(String[] args) {
            String sentence = "Java is easy to learn";
            StringTokenizer st = new StringTokenizer(sentence);

            System.out.println("Number of words: " + st.countTokens());
        }
    }


