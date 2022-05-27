package dev.bank.data;

import java.util.List;

import dev.bank.domain.BankTransaction;

public interface BankStatementParser {
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLineFrom(List<String> lines);
}