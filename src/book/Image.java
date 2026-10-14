package book;

import java.util.concurrent.TimeUnit;

public class Image implements Element {
    private String url;

    public Image(String name) {
        url = name;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + url);
    }

    @Override
    public void accept(Visitor visitor) {
        // Image real nu e vizitat direct; se vizitează ImageProxy
    }
}