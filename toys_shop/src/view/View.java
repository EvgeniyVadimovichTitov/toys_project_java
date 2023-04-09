package view;

import controller.Controllable;
import modelMashine.Mashinenpl;
import modelRepository.Toy;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class View {
    private Controllable contr;

    public View(Controllable contr) {
        this.contr = contr;
    }

    public void buttonClick(){
        Commands com;
        Commands[] coms = Commands.values();
        System.out.println("Menu commands: ");
        for (Commands i:coms) {
            System.out.println(i);
        }
        while (true) {
            String command = sin("Input command:\n");
            try {
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com){
                    case CREATE -> create();
                    case ADD -> add();
                    case FREQUENCE -> frecuence();
                    case GET ->getToy();
                    case PLAY -> play();
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    private void play() throws Exception{
        if (contr.getMashine().play(contr.getMashine().get(true).getFrequency())){
            System.out.println("You win!!!");
            contr.del(contr.getMashine().get(false).getId());
        }
        else {
            System.out.println("You lose!");
        }


    }
    private void getToy() throws Exception {
        List<Toy> toys = contr.readAll();
        try{
            show(toys, contr.getMashine().getQueue_toys());
            contr.getMashine().add(contr.search(Integer.parseInt(sin("Enter id for add in queue: ")),
                    toys));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }

    }
    private void frecuence() throws Exception{
        show(contr.readAll(),contr.getMashine().getQueue_toys());
        try{
            contr.update(Integer.parseInt(sin("Enter id for update frecuence(int): ")),
                    Integer.parseInt(sin("Enter new frecuence(int): ")));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private void add() throws Exception{
        List<Toy> toys = contr.readAll();
        try {
            show(toys, contr.getMashine().getQueue_toys());
            contr.add(Integer.parseInt(sin("Enter id toy for add in mashine(int): ")), toys);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    private void create() throws Exception{
        try {
            contr.create(new Toy(sin("Enter name for toy: "
            ), Integer.parseInt(sin("Enter frecuence(int): "))));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    private String sin(String message){
        Scanner s = new Scanner(System.in);
        System.out.println(message);
        return s.nextLine();
    }
    private void show(List<Toy> toys, Queue<Toy> queue_toy) throws Exception{
        if (toys.size() == 0){
            throw new Exception("Mashine is empty!");
        }
        System.out.println("Toys in Mashine: ");
        for (Toy toy: toys){
            System.out.println(toy);
        }
        System.out.println("of which are in playing(queue): ");
        if (queue_toy != null) {
            for (Toy toy : queue_toy) {
                System.out.println(toy);
            }
        }
        else{
            System.out.println("Queue is empty!");
        }
    }
}

