import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    public static List<Integer> readFile(String name) throws IOException {
        List<String> list = new ArrayList<>();
        List<String[]> parts = Files.lines(Paths.get(name)).map(x -> x.split(":")).toList();

        parts.forEach(x -> list.addAll(Arrays.asList(x)));

        return list.stream().filter(x -> {
            try{
                Integer.parseInt(x);
                return true;
            }catch (Exception e){
                return false;
            }
        }).mapToInt(Integer::parseInt).boxed().toList();
    }

}
