package in.jt.reports;

import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.jt.response.binding.PlanInfo;

public class PDFReportGenerator {

	public void exportPDF(List<PlanInfo> plans,HttpServletResponse response) throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);
		
		Paragraph p = new Paragraph("LIST OF APPROVED PLANS", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(p);
		
		PdfPTable table = new PdfPTable(10);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {1.f,0.5f,1.5f,2.5f,1.0f,1.55f,1.5f,1.5f,1.5f,0.2f});
		table.setSpacingBefore(10);
		
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);
		
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font1.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("CD_ID",font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("CITIZEN_NAME",font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("CITIZEN_SSN",font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("CITIZEN_EMAIL",font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("CITIZEN_PLAN_NAME",font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("CITIZEN_PLAN_STATUS",font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("CITIZEN_START_DATE",font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("CITIZEN_END_DATE",font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("BENEFIT_AMOUNT",font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("DENIAL_REASON",font1));
		table.addCell(cell);
		
		for(PlanInfo plan : plans) {
			table.addCell(plan.getCdId()+"");
			table.addCell(plan.getName());
			table.addCell(plan.getSsn()+"");
			table.addCell(plan.getEmail());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getStartDate());
			table.addCell(plan.getEndDate());
			table.addCell(plan.getBenifitAmount()+"");
			table.addCell(plan.getDenialReason());
		}
		document.add(table);
		document.close();
	}
}
