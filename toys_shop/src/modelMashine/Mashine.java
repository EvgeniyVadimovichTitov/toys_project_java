package modelMashine;

import modelRepository.Toy;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public interface Mashine {
    void add(Toy toy);
    Toy get(boolean flag) throws Exception;
    boolean play(int frequence);
    Queue<Toy> getQueue_toys();
}
