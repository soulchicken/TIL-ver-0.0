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
	
	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
	private static final String RESOURCES = "src/main/resources/";
	private final static BankStatementTSVParser tsvParser = new BankStatementTSVParser();

	public static void main(String[] args) throws IOException {
		// 1��° ��� �䱸����, ��� �ŷ�����(BankStatement)�� �� ����ϱ� / Phase1
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");

		
		final List<String> lines = Files.readAllLines(path);
		
		
		// 2. �о���� ���� �Ľ�
		List<BankTransaction> bankTransactions = tsvParser.parseLinesFromTSV(lines);

		
		
		// 3. ��ɺ� (�� ����ݳ���, ���� ����� ����, ī�װ� �� ��) ���� ó��(Processing)�� ��ü ����
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
		collectSummary(processor);
		
		
	}
	
	private static void collectSummary(BankStatementProcessor processor) {
		// �Ѿ� Ȯ��
		System.out.println("��ü ��� �Ѿ��� " + processor.calculateTotalAmount());
		
		// 2�� �Ѿ� Ȯ��
		Month feb = Month.FEBRUARY;
		System.out.println("2�� ��� ������ " + processor.caculateListInMonth(feb));
		
		// ī�װ� Ȯ��
		System.out.println("Tesco ī�װ� ��� �Ѿ��� "+processor.caculateTotalForCategory("Tesco"));
		
	}
}
