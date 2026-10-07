package book;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Context context) {
        System.out.println(String.format("%" + context.getWidth() + "s", paragraph.getText()));
    }
}