package modelRepository;

import java.util.List;

public interface Repository {
    void saveALL(List<Toy> toys);
    void saveWin(Toy toy);
    List<Toy> getAll();
    void create(Toy toy);
}
