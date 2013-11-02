import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import lombok.Getter;

public class PdfModel {

    @Getter
    private PdfPTable auditTable;

    public PdfModel() throws DocumentException {
        this.auditTable = createTable();
    }

    private PdfPTable createTable() throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 1, 1, 5});
        table.setHeaderRows(1); // Makes header row repeat on following pages
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Table 1", whiteFont()));
        cell.setBackgroundColor(yellowBackground());
        cell.setFixedHeight(100);
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell"));
        cell.setRowspan(2);
        table.addCell(cell);
        addCells(table);
        return table;
    }

    private void addCells(PdfPTable table) {
        for (int i = 0; i < 200; i++) {
            table.addCell("hi " + i);
        }

    }

    private Font whiteFont() {
        Font font = new Font();
        font.setColor(BaseColor.WHITE);
        font.setFamily("Times New Roman");
        return font;
    }

    private BaseColor yellowBackground() {
        return new BaseColor(255, 255, 136);  // got from OSX DigitalColor Meter to match document
    }

}




