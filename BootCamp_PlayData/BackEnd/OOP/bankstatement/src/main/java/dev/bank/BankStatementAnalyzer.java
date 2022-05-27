package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.data.BankStatementTSVParser;
import dev.bank.domain.BankTransaction;

public class BankStatementAnalyzer {
	
	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// 1��° ��� �䱸����, ��� �ŷ�����(BankStatement)�� �� ����ϱ� / Phase1
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");

		
		final List<String> lines = Files.readAllLines(path);
		
		final BankStatementTSVParser tsvParser = new BankStatementTSVParser();
		
		List<BankTransaction> bankTransactions = tsvParser.parseLinesFromTSV(lines);

		
		System.out.println("�� �ݾ�" + calcuateTotalAmount(bankTransactions));
		
		Month feb = Month.FEBRUARY;
		System.out.println("2�� ����� ������ " + selectInMonth(bankTransactions,feb).size() + "�� �Դϴ�.");
		
		
	}
	
	// �� ����� ���� Ȯ��
	 public static double calcuateTotalAmount(List<BankTransaction> bankTransactions) {
		 double total = 0d;
		 for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		 return total;
	 }
	 // Ư�� ���� ���� ����� ���� ��ȸ
	 public static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month) {
		 final List<BankTransaction> monthTransaction = new ArrayList<>();

		 for (BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDate().getMonth().equals(month)) {
				monthTransaction.add(bankTransaction);
			}
		}
		 
		 return monthTransaction;
	 }
	


}
