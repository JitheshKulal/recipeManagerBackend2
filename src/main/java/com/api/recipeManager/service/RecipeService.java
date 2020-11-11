package com.api.recipeManager.service;

import java.io.FileOutputStream;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.recipeManager.dto.RecipeRequest;
import com.api.recipeManager.model.Recipe;
import com.api.recipeManager.repository.RecipeRepository;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RecipeService {
	private final RecipeRepository recipeRepository;
	
	
	public List<Recipe> getAllRecipe() {
		return this.recipeRepository.findAll();
	}
	
	public Recipe insertRecipe(RecipeRequest recipeRequest) {
		Recipe recipe = new Recipe();
		recipe.setShadeno(recipeRequest.getShadeNo());
		recipe.setColors(recipeRequest.getColors());
		recipe.setChemicals(recipeRequest.getChemicals());
		recipe.setSubmittime(Instant.now());
		return this.recipeRepository.save(recipe);
	}
	
	public Optional<Recipe> getRecipe(Long objectId) {
		return this.recipeRepository.findById(objectId);
	} 
	
	public void deleteRecipe(Long objectId) {
		this.recipeRepository.deleteById(objectId);
		return;
	} 
	
	public String process(String shadeNo, String count, String amount, String Customer, String liqourAmount,
			String machineNo, String dyeingDate, String colorDetails, String chemicalDetails) {
		Document document = new Document();
		try {
			document.setMargins(36, 36, 36, 36);
			PdfWriter.getInstance(document, new FileOutputStream("D:\\Temp.pdf"));
			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Paragraph pdfHead = new Paragraph( new Chunk("Ascent Global Textrade",font));
			pdfHead.setAlignment(Element.ALIGN_CENTER);
			document.add(pdfHead);
			document.add(new Paragraph(new Chunk(" ")) );
			PdfPTable table = new PdfPTable(4);
			//table1 header
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setColspan(4);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setPhrase(new Phrase("Recipe Sheet",font));
			table.addCell(header);
			String[] header2 = {"Shade No.","Count","KG","Customer",shadeNo,count,amount,Customer};
			for(String i : header2) {
				PdfPCell body = new PdfPCell();
				body.setHorizontalAlignment(Element.ALIGN_CENTER);
				body.setBorderWidth(2);
				body.setPhrase(new Phrase(i,font));
				table.addCell(body);
			}
			header2 = null;
			document.add(table);
			document.add(new Paragraph(new Chunk(" ")) );
			Paragraph subDataHeader = new Paragraph( new Chunk("Chemical and Color Details",font));
			subDataHeader.setAlignment(Element.ALIGN_CENTER);
			document.add(subDataHeader);
			document.add(new Paragraph(new Chunk(" ")) );
			//PdfPTable colorTable = new PdfPTable(2);
			//table body
			//color table
			PdfPTable colorTable = new PdfPTable(2);
			header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setColspan(2);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setPhrase(new Phrase("Color Details",font));
			colorTable.addCell(header);
			
			for(String i : colorDetails.split(",")) {
				PdfPCell header1 = new PdfPCell();
				header1.setBorderWidth(2);
				header1.setHorizontalAlignment(Element.ALIGN_CENTER);
				header1.setPhrase(new Phrase(i.split(":")[0].trim(),font));
				colorTable.addCell(header1);
				header1.setBorderWidth(2);
				header1.setHorizontalAlignment(Element.ALIGN_CENTER);
				header1.setPhrase(new Phrase((Float.parseFloat(i.split(":")[1].trim())*Float.parseFloat(amount))+"",font));
				colorTable.addCell(header1);
			}
			document.add(colorTable);
			document.add(new Paragraph(new Chunk(" ")) );
			
			PdfPTable chemiPdfPTable = new PdfPTable(2);
			header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setColspan(2);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setPhrase(new Phrase("Chemical Details",font));
			chemiPdfPTable.addCell(header);
			
			for(String i : chemicalDetails.split(",")) {
				PdfPCell header1 = new PdfPCell();
				header1.setBorderWidth(2);
				header1.setHorizontalAlignment(Element.ALIGN_CENTER);
				header1.setPhrase(new Phrase(i.split(":")[0].trim(),font));
				chemiPdfPTable.addCell(header1);
				header1.setBorderWidth(2);
				header1.setHorizontalAlignment(Element.ALIGN_CENTER);
				header1.setPhrase(new Phrase((Float.parseFloat(i.split(":")[1].trim())*Float.parseFloat(liqourAmount))+"",font));
				chemiPdfPTable.addCell(header1);
			}
			document.add(chemiPdfPTable);
			document.add(new Paragraph(new Chunk(" ")) );
			//chemical table
			//table body ends
			//bottom data
			Paragraph dyeingDte = new Paragraph( new Chunk("Dyeing Date : "+dyeingDate,font));
			document.add(dyeingDte);
			document.add(new Paragraph(new Chunk(" ")) );
			Paragraph machNo = new Paragraph( new Chunk("Machine Number : "+machineNo,font));
			document.add(machNo);
			document.add(new Paragraph(new Chunk(" ")) );
			Paragraph sample = new Paragraph( new Chunk("Sample :",font));
			document.add(sample);
			document.add(new Paragraph(new Chunk(" ")) );
			//bottom data end
			document.close();
		} catch (Exception e) {
			return "Creation failed";
		}
		return "Creation Success";
	}
}
