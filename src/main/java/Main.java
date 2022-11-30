import utilites.ITunesDownloader;
import java.io.IOException;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        // This program will download from iTunes API demo file
        // or some song, book, audiobook or film yow want.

        String[] filesArray = new String[20];
        Arrays.fill(filesArray, "");

        for (int i = 0; i < filesArray.length; i++)
        {

            ITunesDownloader downloader = new ITunesDownloader();
            String myUrlPath = "";

            try
            {
                myUrlPath = downloader.getPreviewURL();
            } catch (Exception e)
            {
                System.err.println("Wrong name, try again!");
                continue;
            }

            boolean bool = true;

            for (int j = 0; j < filesArray.length; j++)
            {
                if (filesArray[j].equals(myUrlPath))
                {
                    System.out.println("This file is already added. Try again\n");
                    bool = false;
                    continue;
                }
                continue;
            }
            if (!bool) continue;


            filesArray[i] = myUrlPath;
            System.out.println("Added in array");

            downloader.downloadFile(myUrlPath);
        }
    }
}
