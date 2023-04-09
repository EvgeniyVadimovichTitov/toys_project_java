package modelRepository;
import java.util.List;

public interface FileOperation {
    List<String> readALL();
    void saveALL(List<String> lines);
    void save(String line);
}
