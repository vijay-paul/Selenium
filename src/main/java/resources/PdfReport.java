package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class PdfReport extends base {
	
		Document pdfdoc;
		public void openPdfPath() throws FileNotFoundException, DocumentException{
			String fileName
			 = new File("").getAbsoluteFile().toString()+"/PDF Reports/PDF Reports.pdf";
	
		FileOutputStream fos = new FileOutputStream(fileName);
		pdfdoc = new Document();
		PdfWriter.getInstance(pdfdoc, fos);
		pdfdoc.open();
		}
		public void addData(String authorName, String title, String description){
		pdfdoc.addAuthor(authorName);
		pdfdoc.addTitle(title);
		pdfdoc.addSubject(description);
		}
		public void addParagraph(String text) throws DocumentException{
		pdfdoc.add(new Paragraph(text));
		}
		public void closePdf(){
		pdfdoc.close();
		}

}
