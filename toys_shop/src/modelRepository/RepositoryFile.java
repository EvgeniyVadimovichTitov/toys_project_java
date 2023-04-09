package modelRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private FileOperation op;
    private  Mapper m;

    public RepositoryFile(FileOperation op, Mapper m) {
        this.op = op;
        this.m = m;
    }

    @Override
    public void saveALL(List<Toy> toys) {
        List<String> lines = new ArrayList<>();
        for(Toy toy:toys){
            lines.add(m.map(toy));
        }
        op.saveALL(lines);
    }

    @Override
    public void saveWin(Toy toy) {
        op.save(m.map(toy));
    }

    @Override
    public List<Toy> getAll() {
        List<Toy> toys = new ArrayList<>();
        List<String> lines = op.readALL();
        for(String line: lines) {
            toys.add(m.map(line));
        }
        return toys;
    }

    @Override
    public void create(Toy new_toy) {
        List<Toy> toys = getAll();
        int max = 0;
        for(Toy toy:toys){
            int id = toy.getId();
            if(max<id){
                max = id;
            }
        }
        new_toy.setId(++max);
        toys.add(new_toy);
        saveALL(toys);
    }
}
