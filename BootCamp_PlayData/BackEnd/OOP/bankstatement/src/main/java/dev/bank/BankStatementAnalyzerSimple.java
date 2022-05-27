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
	
	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// 1��° ��� �䱸����, ��� �ŷ�����(BankStatement)�� �� ����ϱ� / Phase1
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
//		System.out.println("�� ��� �ݾ��� " + total);
		System.out.println("1���� �� ��� �ݾ��� " + findTransctionsInJanuary(lines) + "�� �Դϴ�.");
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
