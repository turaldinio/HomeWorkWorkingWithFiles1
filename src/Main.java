import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        boolean check = true;

        File game = new File("C:\\Game");
        check = check && game.mkdir();

        File src = new File(game.getPath() + "\\src");
        check = check && src.mkdir();

        File res = new File(game.getPath() + "\\res");
        check = check && res.mkdir();

        File savegames = new File(game.getPath() + "\\savegames");
        check = check && savegames.mkdir();

        File temp = new File(game.getPath() + "\\temp");
        check = check && temp.mkdir();

        File main = new File(src.getPath() + "\\main");
        check = check && main.mkdir();

        File test = new File(src.getPath() + "\\test");
        check = check && test.mkdir();

        File main_java = new File(main.getPath() + "\\Main.java");
        try {
            check = check && main_java.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File utils_java = new File(main.getPath() + "\\Utils.java");
        try {
            check = check && utils_java.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File drawable = new File(res.getPath() + "\\drawable");
        check = check && drawable.mkdir();


        File vectors = new File(res.getPath() + "\\vectors");
        check = check && vectors.mkdir();

        File icon = new File(res.getPath() + "\\icon");
        check = check && icon.mkdir();

        File temp_txt = new File(temp.getPath() + "\\temp.txt");
        try {
            check = check && temp_txt.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(temp_txt)) {
            if (check) {
                writer.write("Все папки успешно созданы");
            } else {
                writer.write("Ошибка создания всех папок");
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}