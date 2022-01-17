package ch.atupri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CurlArtifactoryProd {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://artifactory.atuprinet.ch");
        URLConnection connection = url.openConnection();

        connection.connect();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = null;
        while((line = in.readLine()) != null) {
            System.out.println(line);
        }

    }
}
