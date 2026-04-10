package day08.absstractClassEx;

abstract class DocumentConverter{
    abstract String convert(String content);
    void print(String content){
//        System.err.println(content);
        System.out.println(convert(content));

    }
}

class HtmlConverter extends  DocumentConverter{
    @Override
    String convert(String content) {
        return "<p>" + content + "</p>";
    }
}
class MarkdownConverter extends  DocumentConverter{
    @Override
    String convert(String content) {
        return "**" + content + "**";
    }
}
public class Ex3 {
    public static void main(String[] args) {
        String content = "Hello Java";

        DocumentConverter documentConverter1 = new HtmlConverter();
        documentConverter1.print(content);

        DocumentConverter documentConverter2 = new MarkdownConverter();
        documentConverter2.print(content);
    }
}
