package modelRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperationmpl implements FileOperation {
    private String file_db;
    private  String file_win;

    public FileOperationmpl(String file_db, String file_win) {
        this.file_db = file_db;
        this.file_win = file_win;
        try {
            FileWriter w1 = new FileWriter(file_db, true);
            FileWriter w2 = new FileWriter(file_win, true);
            w1.flush();
            w2.flush();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<String> readALL() {
        List<String> lines = new ArrayList<>();
        try{
            FileReader r = new FileReader(file_db);
            BufferedReader reader = new BufferedReader(r);
            String line = reader.readLine();
            while (line!=null){
                lines.add(line);
                line=reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public void saveALL(List<String> lines) {
        try(FileWriter w = new FileWriter(file_db, false)){
            for (String line:lines) {
                w.write(line);
                w.write('\n');
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void save(String line) {
        try(FileWriter w = new FileWriter(file_win, true)){
            w.write(line);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
