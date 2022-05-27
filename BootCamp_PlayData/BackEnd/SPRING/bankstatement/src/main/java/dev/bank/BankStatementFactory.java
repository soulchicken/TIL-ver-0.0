package dev.bank;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;
import dev.bank.data.BankStatementTSVParser;

public class BankStatementFactory {
	public BankStatementAnalyzer bankStatementAnalyzer() {
		BankStatementParser parser = new BankStatementTSVParser();
		
		BankStatementAnalyzer analyzer = new BankStatementAnalyzer(parser);
		
		return analyzer;
	}
	
	
}
