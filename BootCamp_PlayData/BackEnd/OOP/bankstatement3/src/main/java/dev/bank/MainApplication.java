package dev.bank;

import java.io.IOException;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;

// Ŭ���̾�Ʈ�� ���� ���� ȭ��
public class MainApplication {
	
	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
	private static final String fileName =  "bank-data-simple.csv";
	
	
	public static void main(String[] args) throws IOException {
		// Analyzer ����
		BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
		
		// Parser ����
		final BankStatementParser parser = new BankStatementCSVParser();
		
		// �м� ����
		analyzer.analyze(fileName, parser);
	}
}
