package controller;

import modelMashine.Mashine;
import modelRepository.Toy;

import java.util.List;

public interface Controllable {
    void create(Toy new_toy) throws Exception;
    Toy search(int id, List<Toy> toys) throws Exception;
    List<Toy> readAll();
    void add(int id, List<Toy> toys) throws Exception;
    void update(int id, int new_frequence) throws Exception;
    void del(int id) throws Exception;
    Mashine getMashine();

}
