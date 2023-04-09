package controller;

import modelMashine.Mashine;
import modelRepository.Repository;
import modelRepository.Toy;

import java.util.List;

public class Controller implements Controllable{
    private Repository rep;
    private Mashine mashine;

    public Controller(Repository rep, Mashine mashine) {
        this.rep = rep;
        this.mashine = mashine;
    }

    @Override
    public Mashine getMashine() {
        return mashine;
    }

    @Override
    public void create(Toy new_toy) throws Exception{
        if ((new_toy.getFrequency()<101)&&(new_toy.getFrequency()>0)){
            rep.create(new_toy);
        }else{
            throw new Exception("Error frequence must in [0:100]!!!");
        }
    }

    @Override
    public Toy search(int id, List<Toy> toys) throws Exception {
        for(Toy toy: toys){
            if (toy.getId()==id){
                return toy;
            }
        }
        throw new Exception("toy not found");
    }

    @Override
    public List<Toy> readAll() {
        return rep.getAll();
    }

    @Override
    public void add(int id, List<Toy> toys) throws Exception {
        Toy toy = search(id,toys);
        toy.setCount(toy.getCount()+1);
        rep.saveALL(toys);
    }

    @Override
    public void update(int id, int new_frequence) throws Exception {
        if ((new_frequence<101)&&(new_frequence>0)){
            List <Toy> toys = rep.getAll();
            Toy toy = search(id, toys);
            toy.setFrequency(new_frequence);
            rep.saveALL(toys);
        }
        else {
            throw new Exception("Error frequence must in [0:100]!!!");
        }
    }
    @Override
    public void del(int id) throws Exception{
        List<Toy> toys = rep.getAll();
        Toy toy = search(id, toys);
        if (toy.getCount()==1){
            toys.remove(toy);
        }
        else {
            toy.setCount(toy.getCount()-1);
        }
        rep.saveALL(toys);
        rep.saveWin(toy);
    }
}
