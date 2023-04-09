import controller.Controllable;
import controller.Controller;
import modelMashine.Mashinenpl;
import modelRepository.FileOperationmpl;
import modelRepository.Mapper;
import modelRepository.RepositoryFile;
import modelRepository.Toy;
import view.View;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        String file_db = "inMashine.csv";
        String file_win = "toyForWinner.csv";
        Controllable contr = new Controller(new RepositoryFile(new FileOperationmpl(file_db,file_win), new Mapper()),
                new Mashinenpl());
        View view = new View(contr);
        view.buttonClick();
        view = null;
        System.gc();
    }
}