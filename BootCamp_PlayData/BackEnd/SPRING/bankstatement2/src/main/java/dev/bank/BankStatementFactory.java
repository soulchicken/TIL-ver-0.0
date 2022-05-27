package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;
import dev.bank.data.BankStatementTSVParser;

@Configuration // �� Ŭ������ �� ��������(IoC �����̳�)�� Ȱ���� �� �ֵ��� ���� or ����
public class BankStatementFactory {
	
//	@Bean // bean ���� ���� �ȿ� 
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
