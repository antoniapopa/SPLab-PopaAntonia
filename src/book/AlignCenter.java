package book;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Context context) {
        int padding = Math.max(0, (context.getWidth() - paragraph.getText().length()) / 2);
        System.out.println(" ".repeat(padding) + paragraph.getText());
    }
}