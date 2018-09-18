import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(String words) {
        int count = 0;
        for (String i: words.split(" ")) {
            if (!i.equals("")) {
                count++;
            }
        }
        return count;
    }

    public static int oneWordCount(String words, String target) {
        int count = 0;
        for (String i: words.split(" ")) {
            if (i.toLowerCase().contains(target.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(oneWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"),"prince"));
    }
}
