package dev.bank;

import java.io.IOException;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;

// 클라이언트가 보는 메인 화면
public class MainApplication {
	
	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String fileName =  "bank-data-simple.csv";
	
	
	public static void main(String[] args) throws IOException {
		// Analyzer 생성
		BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
		
		// Parser 지정
		final BankStatementParser parser = new BankStatementCSVParser();
		
		// 분석 수행
		analyzer.analyze(fileName, parser);
	}
}
