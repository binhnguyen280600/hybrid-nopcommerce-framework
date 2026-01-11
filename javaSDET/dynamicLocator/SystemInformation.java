package dynamicLocator;

import java.io.File;

public class SystemInformation {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");

        String projectPath = System.getProperty("user.dir");

        String separtor = System.getProperty("file.separator");
        System.out.println(separtor);

        String danangImagePath = projectPath + File.separator + "uploadFiles" + File.separator + "Hue.jpg";
        System.out.println(danangImagePath);

        System.out.println(File.separator);
    }
}
