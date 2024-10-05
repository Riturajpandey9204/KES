package in.jt.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jt.reports.PDFReportGenerator;
import in.jt.response.binding.PlanInfo;
import in.jt.service.InsuranceService;

@RestController
public class InsuranceRestController {

	@Autowired
	private InsuranceService service;
	
	@GetMapping(value = "/pdf")
	public void generatePdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=InsurancePlans.pdf";
		response.setHeader(headerKey, headerValue);
		
		List<PlanInfo> plansInfo = service.searchPlans();
		PDFReportGenerator pdf = new PDFReportGenerator();
		pdf.exportPDF(plansInfo,response);
	}
	@GetMapping(value = "/excel")
	public void generateExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=InsurancePlans.xlsx";
		response.setHeader(headerKey, headerValue);
	}
}
