package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;
import dev.bank.data.BankStatementTSVParser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer {
	// TSV,CSV 변경을 하려면 클래스 내용을 바꿔야함.
	
	
	
	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String RESOURCES = "src/main/resources/";
	private final BankStatementParser parser;
	
	
	public BankStatementAnalyzer(BankStatementParser parser) {
		this.parser = parser;
	}

	public void analyze(String fileName) throws IOException {
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);
		List<BankTransaction> bankTransactions = parser.parseLineFrom(lines);

		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
		collectSummary(processor);
		
	}
	
	private static void collectSummary(BankStatementProcessor processor) {
		// 총액 확인
		System.out.println("전체 사용 총액은 " + processor.calculateTotalAmount());
		
		// 2월 총액 확인
		Month feb = Month.FEBRUARY;
		System.out.println("2월 사용 내역은 " + processor.caculateListInMonth(feb));
		
		// 2월 사용 금액
		
		// 카테고리 확인
		System.out.println("Tesco 카테고리 사용 총액은 "+processor.caculateTotalForCategory("Tesco"));
	}
}
