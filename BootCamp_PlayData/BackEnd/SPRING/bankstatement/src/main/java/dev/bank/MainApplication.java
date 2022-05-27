package dev.bank;

import java.io.IOException;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;
import dev.bank.data.BankStatementTSVParser;

// Ŭ���̾�Ʈ�� ���� ���� ȭ��
public class MainApplication {
	
	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
	private static final String fileName =  "bank-data-simple.txt";
	
	
	public static void main(String[] args) throws IOException {
		// before spring
		BankStatementFactory factory = new BankStatementFactory();
		BankStatementAnalyzer analyzer = factory.bankStatementAnalyzer();
		
		// after spring
		// spring IoC �����̳��� applicationContext ��ü ����
		// Bean ���� ������ ���K�� ����ϰ� �ִ� factory

		// �м� ����
		analyzer.analyze(fileName);
	}
}
