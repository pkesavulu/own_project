package com.dumbu.ai.ai.utils;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;

public class ImageToPdf {

	public static void main(String... args) {
		String input = "src/main/resources/static/images/scooby2.jpg"; // .png,.gif and .jpg are ok too!
		String output = "src/main/resources/static/images/scooby2.pdf";
		imgToPdf(input, output);
	}

	public static void imgToPdf(String input, String output) {
		Document document = new Document();
		try {
			FileOutputStream fos = new FileOutputStream(output);
			PdfWriter writer = PdfWriter.getInstance(document, fos);
			writer.open();
			document.open();
			/*
			 * Image img = Image.getInstance (new
			 * java.net.URL("http://www.rgagnon.com/images/javahowto.jpg"));
			 * img.scalePercent(50); document.add(img);
			 */
			Image img = Image.getInstance(input);
			img.scalePercent(70);
			document.add(img);
			document.close();
			writer.close();
			System.out.println("converted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
