/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloader;

import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ProgressIndicator;

/**
 *
 * @author macb
 */
public class ThreadDowload implements Runnable {

    private String urlParam;
    private URL url;
    private FileChannel fChannel;
    private int posParam;

    public ThreadDowload(String url, int pos) {
        urlParam = url;
        posParam = pos;
    }

    @Override
    public void run() {
        try {
            Download();
            //Logic.EndDownload(posParam);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ThreadDowload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreadDowload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadDowload.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Download() throws MalformedURLException, IOException, InterruptedException {
        url = new URL(urlParam);
        URLConnection conn = url.openConnection();
        long fSize = conn.getContentLengthLong();

        FileOutputStream streamTo = new FileOutputStream("/Users/macb/Downloads/123/"+UUID.randomUUID().toString());
        FileChannel fChannel = streamTo.getChannel();
        
        ReadableByteChannel streamFrom = Channels.newChannel(url.openStream());
        
        fChannel.transferFrom(streamFrom, 0, fSize);
        
        
    
    }

}
