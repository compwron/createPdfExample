import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String... args) throws DocumentException, FileNotFoundException {
        Generator generator = new Generator();
        generator.generate("test.pdf", new PdfModel());
    }
}
