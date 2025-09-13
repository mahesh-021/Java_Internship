import java.io.File;

public class FileTxt {
    public static void main(String[] args) {
        File file = new File("demo.txt");
        if(file.exists()) {
            System.out.println("The File Exists");
            System.out.println("Path: " + file.getAbsolutePath());
        }
        else{
            System.err.println("file doesnot exists");
        }
    }
}