/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Thread.sleep;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressIndicator;

/**
 *
 * @author macb
 */
public class TaskDowload extends Task {

    private String URL;
    private int pB;

    public TaskDowload(String url, int pb) {
        URL = url;
        pB = pb;
    }

    @Override
    protected String call() throws Exception {

        URL url = new URL(URL);
        URLConnection conn = url.openConnection();
        conn.connect();
        System.out.println(conn.getRequestProperties().entrySet());

        long fSize = conn.getContentLengthLong();

        String fileName = new File(url.getFile()).getName();
//        System.out.println(fSize);

        try (InputStream inputStream = conn.getInputStream(); FileOutputStream streamTo = new FileOutputStream("/Users/macb/Downloads/123/" + fileName)) {
            long count = 0;

            while (count != fSize) {
                byte[] buffer = new byte[1024];

                int read = inputStream.read(buffer);

                count += read;
                System.out.println((count * 100 / fSize) + "%");

                streamTo.write(buffer, 0, read);
                streamTo.flush();
            }
        }

//        FileChannel fChannel = streamTo.getChannel();
//        
//        ReadableByteChannel streamFrom = Channels.newChannel(url.openStream());
//        
//        long bytes = fChannel.transferFrom(streamFrom, 0, fSize);
//        System.out.println("Readed: " + bytes);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//            sleep(200);
//        }
        Logic.EndDownload(URL, pB);
        return null;

    }

}
