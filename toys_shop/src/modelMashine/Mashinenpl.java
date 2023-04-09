package modelMashine;

import modelRepository.Toy;

import java.util.ArrayDeque;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Mashinenpl implements Mashine {

    private Queue<Toy> queue_toys = new ArrayDeque<>();
    @Override
    public void add(Toy toy) {
        Toy buff = new Toy(toy.getName(), toy.getFrequency());
        buff.setId(toy.getId());
        queue_toys.add(buff);
    }

    @Override
    public boolean play(int frequence) {
        return ((int)(Math.random()*(101-1))+1) <= frequence;
    }

    @Override
    public Toy get(boolean flag) throws NoSuchElementException {
        if(flag){
            return queue_toys.element();
        }
        return queue_toys.remove();
    }
    @Override
    public Queue<Toy> getQueue_toys() {
        return queue_toys;
    }
}
