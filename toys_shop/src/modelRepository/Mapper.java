package modelRepository;

public class Mapper implements Mapply {

    @Override
    public Toy map(String line) {
        String[] buff = line.split(";");
        return new Toy(Integer.parseInt(buff[0]),
                buff[1],
                Integer.parseInt(buff[2]),
                Integer.parseInt(buff[3]));
    }

    @Override
    public String map(Toy toy) {
        return String.format("%s;%s;%s;%s", toy.getId(),toy.getName(),toy.getCount(),
                toy.getFrequency());
    }
}
