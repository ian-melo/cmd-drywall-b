/*
 * Deixai toda esperança, ó vós que entrais!
 */
package cmd.testes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import net.sf.jasperreports.engine.util.FileBufferedOutputStream;

/**
 *
 * @author fe_mmo
 */
public class FolhaTeste 
{
    public static void main(String[] args) throws IOException
    {
        Document documento = new Document();
        String arquivo = "Pdf_teste.pdf";
        
        try
        {
            PdfWriter.getInstance(documento, new FileOutputStream(arquivo));
            documento.open();
       
            Paragraph p = new Paragraph("Relatório PDF");
            p.setAlignment(1);
            documento.add(p);
            p = new Paragraph("  ");
            documento.add(p);
            
            PdfPTable table = new PdfPTable(4);

            PdfPCell cel1 = new PdfPCell(new Paragraph("RG"));
            PdfPCell cel2 = new PdfPCell(new Paragraph("Nome"));
            PdfPCell cel3 = new PdfPCell(new Paragraph("Idade"));
            PdfPCell cel4 = new PdfPCell(new Paragraph("Tets"));
            table.addCell(cel1);
            table.addCell(cel2);
            table.addCell(cel3);
            table.addCell(cel4);
            
            documento.add(table);
            documento.close();
            Desktop.getDesktop().open(new File(arquivo));
        }
        catch(DocumentException e)
        {
            System.err.println("Erro ao criar docmuento: \n" + e);
        }
    }
    
}
