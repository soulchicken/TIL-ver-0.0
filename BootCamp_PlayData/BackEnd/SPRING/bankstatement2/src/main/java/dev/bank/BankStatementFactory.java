package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;
import dev.bank.data.BankStatementTSVParser;

@Configuration // 이 클래스가 빈 구성정보(IoC 컨테이너)로 활용할 수 있도록 설정 or 지정
public class BankStatementFactory {
	
//	@Bean // bean 구성 정보 안에 
//	public BankStatementAnalyzer bankStatementAnalyzer() {	
//		return new BankStatementAnalyzer(new BankStatementTSVParser());
//	}
	
	@Bean
	public BankStatementTSVParser bankStatementTSV() {
		return new BankStatementTSVParser();
	}
	
	@Bean
	public BankStatementAnalyzer bankStatementAnalyzer() {
		return new BankStatementAnalyzer(bankStatementTSV());
	}
}
