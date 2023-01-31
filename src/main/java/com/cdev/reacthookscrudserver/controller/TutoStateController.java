 package com.cdev.reacthookscrudserver.controller;

import java.io.Console;
//import java.awt.PageAttributes.MediaType;
import java.io.FileInputStream;
//import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


import com.cdev.reacthookscrudserver.repository.TutorialRepository;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;




//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080"}, allowCredentials = "false")
public class TutoStateController {

	
	 	@Autowired
	 	TutorialRepository tutorialRepository;
	
		@GetMapping("/pdf")
		//public String generatePdf() {
		public ResponseEntity <byte[]> generatePdf() {
			try {
				try {
					JRBeanCollectionDataSource beanCollectionDataSource  = new JRBeanCollectionDataSource(tutorialRepository.findAll());
					
					JasperReport compileReport = JasperCompileManager
							.compileReport(new FileInputStream("C:\\React-project\\Serveurs\\spring\\react-hooks-crud-server-2\\listTuto.jrxml"));

				
					Map<String, Object> map = new HashMap<>();
					JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
				
					//JasperExportManager.exportReportToPdfFile(jasperPrint,System.currentTimeMillis() + ".pdf");
					
					byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);
					
					//return "generated";
					//Map<String, List<String>>
					
					
					HttpHeaders headers = new HttpHeaders() ;
					
					headers.set("Content-Disposition", "inline; filename=citiesreport.pdf");
					headers.set(HttpHeaders.CONTENT_DISPOSITION,"inline;filename=listTuto.pdf");
					
					System.out.println(ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data));
					return  ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);

					
					
					
					
					/*
					HttpHeaders headers=new HttpHeaders();
					headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

					return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
*/
					
					
					
					
					
					
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}
}
