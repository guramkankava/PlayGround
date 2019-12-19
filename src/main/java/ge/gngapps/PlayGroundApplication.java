package ge.gngapps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlayGroundApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PlayGroundApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        return;
    }

    private void renameFiles() throws Exception {
        Stream<Path> paths = Files.walk(Paths.get("C:/Users/Admin/Downloads/rename/f1"));

        paths.forEach( path -> {
            try {
                System.out.println(path);
                byte[] fileContent = Files.readAllBytes(path);

                Path pathToNewFile = Paths.get("C:/Users/Admin/Downloads/renamed/f1/" + path.getFileName().toString().replace(".png", ""));

                if(Files.exists(pathToNewFile)) {
                    System.out.println("File exists " + pathToNewFile + "skiping current iteration");
                    return;
                }
                pathToNewFile = Files.createFile(pathToNewFile);
                Files.write(pathToNewFile, fileContent);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return;
            }
        });

        paths.close();
    }
}
