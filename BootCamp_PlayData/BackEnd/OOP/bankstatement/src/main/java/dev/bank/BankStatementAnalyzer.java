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
	
	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// 1번째 기능 요구사항, 모든 거래내역(BankStatement)의 합 계산하기 / Phase1
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");

		
		final List<String> lines = Files.readAllLines(path);
		
		final BankStatementTSVParser tsvParser = new BankStatementTSVParser();
		
		List<BankTransaction> bankTransactions = tsvParser.parseLinesFromTSV(lines);

		
		System.out.println("총 금액" + calcuateTotalAmount(bankTransactions));
		
		Month feb = Month.FEBRUARY;
		System.out.println("2월 입출금 내역은 " + selectInMonth(bankTransactions,feb).size() + "건 입니다.");
		
		
	}
	
	// 총 입출금 내역 확인
	 public static double calcuateTotalAmount(List<BankTransaction> bankTransactions) {
		 double total = 0d;
		 for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		 return total;
	 }
	 // 특정 월에 대한 입출금 내역 조회
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
