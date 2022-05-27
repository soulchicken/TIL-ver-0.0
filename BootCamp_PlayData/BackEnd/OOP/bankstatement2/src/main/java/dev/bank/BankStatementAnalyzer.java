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
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer {
	
	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String RESOURCES = "src/main/resources/";
	private final static BankStatementTSVParser tsvParser = new BankStatementTSVParser();

	public static void main(String[] args) throws IOException {
		// 1번째 기능 요구사항, 모든 거래내역(BankStatement)의 합 계산하기 / Phase1
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");

		
		final List<String> lines = Files.readAllLines(path);
		
		
		// 2. 읽어들인 파일 파싱
		List<BankTransaction> bankTransactions = tsvParser.parseLinesFromTSV(lines);

		
		
		// 3. 기능별 (총 입출금내역, 월별 입출금 내역, 카테고리 별 등) 연산 처리(Processing)용 객체 생성
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
		collectSummary(processor);
		
		
	}
	
	private static void collectSummary(BankStatementProcessor processor) {
		// 총액 확인
		System.out.println("전체 사용 총액은 " + processor.calculateTotalAmount());
		
		// 2월 총액 확인
		Month feb = Month.FEBRUARY;
		System.out.println("2월 사용 내역은 " + processor.caculateListInMonth(feb));
		
		// 카테고리 확인
		System.out.println("Tesco 카테고리 사용 총액은 "+processor.caculateTotalForCategory("Tesco"));
		
	}
}
