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
	// TSV,CSV ������ �Ϸ��� Ŭ���� ������ �ٲ����.
	
	
	
	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
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
		// �Ѿ� Ȯ��
		System.out.println("��ü ��� �Ѿ��� " + processor.calculateTotalAmount());
		
		// 2�� �Ѿ� Ȯ��
		Month feb = Month.FEBRUARY;
		System.out.println("2�� ��� ������ " + processor.caculateListInMonth(feb));
		
		// 2�� ��� �ݾ�
		
		// ī�װ� Ȯ��
		System.out.println("Tesco ī�װ� ��� �Ѿ��� "+processor.caculateTotalForCategory("Tesco"));
	}
}
