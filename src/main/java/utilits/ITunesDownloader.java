package utilits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ITunesDownloader
{
    String urlFirst = "https://itunes.apple.com/search?term=";
    String urlSecond;
    String urlThird = "&limit=1";

    public String createUrl()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song, film or audiobook`s name using\n" +
                "only lowercase Latin letters and \"+\" instead of spaces (example - jack+johnson)");
        urlSecond = scanner.nextLine();
        return urlFirst + urlSecond + urlThird;
    }

    public String downloadPage(String url) throws IOException
    {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try(InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is)))
        {
            while((line = br.readLine())  != null) {
                result.append(line);
            }
        }
        return result.toString();
    }

    public String getPreviewURL() throws IOException
    {
        ITunesProduct product = new ITunesProduct();
        String url = createUrl();
        String page = downloadPage(url);

        int start = page.indexOf("previewUrl") + 13;
        int end = page.indexOf("\",", start);
        return product.previewUrl = page.substring(start, end);
    }

    public long downloadFile(String url) throws IOException
    {
        String[] arr = url.split("\\.");
        String fileExtension = arr[arr.length - 1];

        try (InputStream in = URI.create(url).toURL().openStream())
        {
            System.out.println("File " + urlSecond + "." + fileExtension + " downloaded. You can continue:");

            // "first" Parameter in a method Paths.get() is a path of user`s directory to download file.
            return Files.copy(in, Paths.get("C:/Users/legion/Downloads/" + urlSecond + "." + fileExtension));
        }
    }
}
