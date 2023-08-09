import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        StringBuilder textInfo = new StringBuilder();

        ArrayList<String> pathsMk = new ArrayList<>();

        pathsMk.add("D://Games//src///main//");
        pathsMk.add("D://Games//src///test//");
        pathsMk.add("D://Games//savegames//");
        pathsMk.add("D://Games//temp//");
        pathsMk.add("D://Games//res//drawables//");
        pathsMk.add("D://Games//res//vectors//");
        pathsMk.add("D://Games//res//icons//");

        createDirs(pathsMk, textInfo);

        ArrayList<String> pathsFiles = new ArrayList<>();

        pathsFiles.add("D://Games//src//main//Main.java");
        pathsFiles.add("D://Games//src//main//Utils.java");
        pathsFiles.add("D://Games//temp//temp.txt");

        createFiles(pathsFiles, textInfo);

        try {
            FileWriter text = new FileWriter("D://Games//temp//temp.txt", false);
            text.write(String.valueOf(textInfo));
            text.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void createDirs(ArrayList<String> pathsMk, StringBuilder textInfo) {
        for (String path : pathsMk) {
            File file = new File(path);
            if (file.mkdirs()) {
                textInfo.append("Directory " + file.getName() + " (" + file.getParent() + ")" + " created \n");
            } else {
                textInfo.append("Directory " + file.getName() + " not created or already exists (ERROR)\n");
            }
        }
    }

    public static void createFiles(ArrayList<String> pathsFiles, StringBuilder textInfo) {
        for (String path : pathsFiles) {
            File file = new File(path);
            try {
                file.createNewFile();
                textInfo.append("File " + file.getName() + " created \n");
            } catch (IOException e) {
                textInfo.append("File " + file.getName() + " not  created (" + e.getMessage() + ") (ERROR) \n");
                System.out.println(e.getMessage());
            }
        }
    }
}