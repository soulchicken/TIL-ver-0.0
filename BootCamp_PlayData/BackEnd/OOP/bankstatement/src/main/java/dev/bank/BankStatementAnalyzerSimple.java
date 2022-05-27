package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementAnalyzerSimple {
	final static DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// 1번째 기능 요구사항, 모든 거래내역(BankStatement)의 합 계산하기 / Phase1
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
//		System.out.println(path);
		
		final List<String> lines = Files.readAllLines(path);
//		System.out.println(lines);
		
		
		
//		for (String line : lines) {
//			final String[] columns = line.split("\t");
//			final double amount = Double.parseDouble(columns[1]);
//			total += amount;
//		}
//		
//		System.out.println("총 사용 금액은 " + total);
		System.out.println("1월의 총 사용 금액은 " + findTransctionsInJanuary(lines) + "원 입니다.");
	}
	
	// findTransctionsInJanuary
	
	public static double findTransctionsInJanuary(List<String> lines) {
		double total = 0d;
		for (String line : lines) {
			final String[] columns = line.split("\t");
			LocalDate dueDate = LocalDate.parse(columns[0], DATE_PATTERN);
			if (dueDate.getMonth().getValue() == 1) {
				final double amount = Double.parseDouble(columns[1]);
				total += amount;				
			}
		}
		return total;
	}

}
