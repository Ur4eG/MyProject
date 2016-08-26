package home.ur4eg.dev.dds;

/**
 * Created by Ur4eG on 17-Feb-16.
 */
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

class ScreenCapture {
    public static void main(String args[]) throws
            AWTException, IOException {
        // capture the whole screen
        BufferedImage screencapture = new Robot().createScreenCapture(
                new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()) );

        /*BufferedImage image = new Robot().createScreenCapture(
                new Rectangle( myframe.getX(), myframe.getY(),
                        myframe.getWidth(), myframe.getHeight() ) );
        */
        // Save as JPEG
        File file = new File("d:\\screencapture.jpg");
        ImageIO.write(screencapture, "jpg", file);

        // Save as PNG
        file = new File("d:\\screencapture.png");
        ImageIO.write(screencapture, "png", file);
    }
}
