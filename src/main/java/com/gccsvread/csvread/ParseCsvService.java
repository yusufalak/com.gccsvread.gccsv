package com.gccsvread.csvread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ParseCsvService {

	public void run(ParseRequest req) throws Exception {

		List<Gc> clist = new ArrayList<>();

		Path path = Path.of(req.getSourceFile());
		File file = path.toFile();
		InputStream inputStream = FileUtils.openInputStream(file);

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		try {
			while (reader.ready()) {
				String line = reader.readLine();
				if (line.startsWith("region"))
					continue;
				String[] lineArray = line.split(",");

				String region = lineArray[0];
				String caseNumber = lineArray[1];
				String caseNumberFull = lineArray[2];
				String consulate = lineArray[3];
				String status = lineArray[4];
				String submitDate = lineArray[5];
				String statusDate = lineArray[6];
				String issued = lineArray[7];
				String ap = lineArray[8];
				String ready = lineArray[9];
				String refused = lineArray[10];
				String refused221g = lineArray[11];
				String inTransit = lineArray[12];
				String transfer = lineArray[13];
				String nvc = lineArray[14];
				String twoNlDate = lineArray[15];

				Gc gc = new Gc();
				gc.setAp(ap);
				gc.setCaseNumber(caseNumber);
				gc.setCaseNumberFull(caseNumberFull);
				gc.setConsulate(consulate);
				gc.setInTransit(inTransit);
				gc.setIssued(issued);
				gc.setNvc(nvc);
				gc.setReady(ready);
				gc.setRefused(refused);
				gc.setRefused221g(refused221g);
				gc.setRegion(region);
				gc.setStatus(status);
				gc.setStatusDate(statusDate);
				gc.setSubmitDate(submitDate);
				gc.setTransfer(transfer);
				gc.setTwoNlDate(twoNlDate);
				clist.add(gc);
			}
		} finally {
			reader.close();
			inputStream.close();
		}

		HSSFWorkbook workbook = new HSSFWorkbook();

		Map<String, List<Gc>> mappedValues = clist.stream().collect(Collectors.groupingBy(c -> c.getRegion()));

		for (Entry<String, List<Gc>> map : mappedValues.entrySet()) {

			String sheetName = map.getKey();

			List<Gc> lst = map.getValue();

			List<List<Gc>> subSets = ListUtils.partition(lst, 65530);
			int i = 0;
			for (List<Gc> subLst : subSets) {

				i++;
				HSSFSheet sheet = workbook.createSheet(sheetName + "_" + i);
				HSSFRow rowhead = sheet.createRow(0);
				rowhead.createCell(0).setCellValue("region");
				rowhead.createCell(1).setCellValue("caseNumber");
				rowhead.createCell(2).setCellValue("caseNumberFull");
				rowhead.createCell(3).setCellValue("consulate");
				rowhead.createCell(4).setCellValue("status");
				rowhead.createCell(5).setCellValue("submitDate");
				rowhead.createCell(6).setCellValue("statusDate");
				rowhead.createCell(7).setCellValue("issued");
				rowhead.createCell(8).setCellValue("ap");
				rowhead.createCell(9).setCellValue("ready");
				rowhead.createCell(10).setCellValue("refused");
				rowhead.createCell(11).setCellValue("refused221g");
				rowhead.createCell(12).setCellValue("inTransit");
				rowhead.createCell(13).setCellValue("transfer");
				rowhead.createCell(14).setCellValue("nvc");
				rowhead.createCell(15).setCellValue("2NlDate");

				int index = 1;
				for (Gc gc : subLst) {

					HSSFRow nextHead = sheet.createRow(index);

					nextHead.createCell(0).setCellValue(gc.getRegion());
					nextHead.createCell(1).setCellValue(gc.getCaseNumber());
					nextHead.createCell(2).setCellValue(gc.getCaseNumberFull());
					nextHead.createCell(3).setCellValue(gc.getConsulate());
					nextHead.createCell(4).setCellValue(gc.getStatus());
					nextHead.createCell(5).setCellValue(gc.getSubmitDate());
					nextHead.createCell(6).setCellValue(gc.getStatusDate());
					nextHead.createCell(7).setCellValue(gc.getIssued());
					nextHead.createCell(8).setCellValue(gc.getAp());
					nextHead.createCell(9).setCellValue(gc.getReady());
					nextHead.createCell(10).setCellValue(gc.getRefused());
					nextHead.createCell(11).setCellValue(gc.getRefused221g());
					nextHead.createCell(12).setCellValue(gc.getInTransit());
					nextHead.createCell(13).setCellValue(gc.getTransfer());
					nextHead.createCell(14).setCellValue(gc.getNvc());
					nextHead.createCell(15).setCellValue(gc.getTwoNlDate());

					index++;

				}

			}

		}

		String targetFileName = req.getSourceFile().replaceAll("\\.", "_") + ".xls";

		FileOutputStream fileOut = new FileOutputStream(targetFileName);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
	}

	public record GCInfo(List<Gc> lst) {

	}

}
