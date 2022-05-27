package dev.bank;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 클라이언트가 보는 메인 화면
public class MainApplication {
	
	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String fileName =  "bank-data-simple.txt";
	
	
	public static void main(String[] args) throws IOException {
		
		// before spring
//		BankStatementFactory factory = new BankStatementFactory();
//		BankStatementAnalyzer analyzer = factory.bankStatementAnalyzer();
		
		// after spring
		// spring IoC 컨테이너인 applicationContext 객체 생성
		// Bean 구성 정보의 역핳을 담당하고 있는 factory
		
		final ApplicationContext applicationContext
			= new AnnotationConfigApplicationContext(BankStatementFactory.class);
		
		final BankStatementAnalyzer analyzer = applicationContext.getBean(BankStatementAnalyzer.class);
		analyzer.analyze(fileName);
	}
}
