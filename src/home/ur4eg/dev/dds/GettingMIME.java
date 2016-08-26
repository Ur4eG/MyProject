package home.ur4eg.dev.dds;

/**
 * Created by Ur4eG on 17-Feb-16.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GettingMIME {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("d:\\d2fc511d_dsc_0488.jpg");
        System.out.println(Files.probeContentType(source));
    }
}
