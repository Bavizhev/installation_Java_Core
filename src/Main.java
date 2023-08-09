import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StringBuilder textInfo = new StringBuilder();

        File main = new File("D://Games", "src/main/");
        File test = new File("D://Games", "src/test/");
        File savegames = new File("D://Games", "savegames");
        File temp = new File("D://Games", "temp");

        createDirs(main, textInfo); // Создание сразу поддиректорий
        createDirs(test, textInfo);

        createDir(savegames, textInfo); // Создание одной директорий
        createDir(temp, textInfo);

        File drawables = new File("D://Games", "res/drawables/");
        File vectors = new File("D://Games", "res/vectors/");
        File icons = new File("D://Games", "res/icons/");

        createDirs(drawables, textInfo);
        createDirs(vectors, textInfo);
        createDirs(icons, textInfo);

        File mainFile = new File("D://Games//src//main//Main.java");
        File utilsFile = new File("D://Games//src//main//Utils.java");
        File tempFile = new File("D://Games//temp//temp.txt");

        createFiles(mainFile, textInfo); //Создание файлов
        createFiles(utilsFile, textInfo);
        createFiles(tempFile, textInfo);


        try {
            FileWriter text = new FileWriter("D://Games//temp//temp.txt", false);
            text.write(String.valueOf(textInfo));
            text.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void createDir(File dir, StringBuilder textInfo) { // <--- Для создания одной директорий
        if (dir.mkdir()) {
            textInfo.append("Directory " + dir.getName() + " (" + dir.getParent() + ")" + " created \n");
        } else {
            textInfo.append("Directory " + dir.getName() + " not created or already exists (ERROR)\n");
        }
    }

    public static void createDirs(File dirs, StringBuilder textInfo) { // <--- Для создания иерархий директорий (директория/поддиректория/...)
        if (dirs.mkdirs()) {
            textInfo.append("Directory " + dirs.getName() + " (" + dirs.getParent() + ")" + " created \n");
        } else {
            textInfo.append("Directory " + dirs.getName() + " not created or already exists (ERROR)\n");
        }
    }

    public static void createFiles(File file, StringBuilder textInfo) {
        try {
            file.createNewFile();
            textInfo.append("File " + file.getName() + " created \n");
        } catch (IOException e) {
            textInfo.append("File " + file.getName() + " not  created (" + e.getMessage() + ") (ERROR) \n");
            System.out.println(e.getMessage());
        }
    }
}