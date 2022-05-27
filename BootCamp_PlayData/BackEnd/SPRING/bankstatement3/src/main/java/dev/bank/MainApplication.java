package dev.bank;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Ŭ���̾�Ʈ�� ���� ���� ȭ��
public class MainApplication {
	
	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
	private static final String fileName =  "bank-data-simple.txt";
	
	
	public static void main(String[] args) throws IOException {
		
		// before spring
//		BankStatementFactory factory = new BankStatementFactory();
//		BankStatementAnalyzer analyzer = factory.bankStatementAnalyzer();
		
		// after spring
		// spring IoC �����̳��� applicationContext ��ü ����
		// Bean ���� ������ ���K�� ����ϰ� �ִ� factory
		
		final ApplicationContext applicationContext
			= new AnnotationConfigApplicationContext(BankStatementFactory.class);
		
		final BankStatementAnalyzer analyzer = applicationContext.getBean(BankStatementAnalyzer.class);
		analyzer.analyze(fileName);
	}
}
