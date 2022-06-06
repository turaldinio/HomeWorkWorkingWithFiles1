import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean successful = true;

        System.out.println("Создание директории/файла \n" +
                "Укажите полный путь до директории/файла \n" +
                "Для выхода нажмите enter ");

        Scanner scan = new Scanner(System.in);

        String request = scan.nextLine();

        while (!request.isEmpty()) {
            try {
                successful &= createFilesOrDirectory(request);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\nУкажите полный путь до директории/файла ");
            request = scan.nextLine();
        }

        createFinalFile(successful);
    }


    private static boolean createFilesOrDirectory(String path) throws IOException {
        File file = new File(path);

        if (!path.contains(".")) {
            if (file.mkdir()) {
                System.out.printf("Директория %s успешна создана", path);
                return true;
            } else {
                System.out.printf("Не удалось создать директорию %s ", path);
                return false;
            }
        } else {
            if (file.createNewFile()) {

                System.out.printf("Файл %s успешно создан", path);
                return true;
            } else {
                System.out.printf("Не удалось создать файл %s ", path);
                return false;
            }
        }
    }

    private static void createFinalFile(boolean successful) {
        String file = String.format("C:%sGame%stemp%stemp.txt", File.separator, File.separator, File.separator);

        try (FileWriter writer = new FileWriter(file)) {
            if (successful) {
                writer.write("Все файлы успешно созданы");
            } else {
                writer.write("Не удалось создать все файлы");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}