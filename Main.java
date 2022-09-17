
import edu.sfsu.autograder.advanced.Autograder;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Main {
    
    public static void main(String[] args) {
        try {
            Autograder autograder = new Autograder();
            autograder.addErrorDictionary("./resources/errors.json");
            autograder.run(false, false, "./Project4cases", Project4.class.getCanonicalName(), null, new ArrayList<>(List.of(NoSuchElementException.class)));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
