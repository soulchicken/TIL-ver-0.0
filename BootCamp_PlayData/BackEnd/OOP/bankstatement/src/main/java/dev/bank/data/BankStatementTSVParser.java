package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

public class BankStatementTSVParser {

	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// �� �ٸ� �Ľ�, �� Ŭ���� �������� ����� ����
	// ���������� ��ȯŸ�� parseFromTSV (final String line)
	private BankTransaction parseFromTSV (String line) {
		String[] columns = line.split("\t");
		BankTransaction bankTransaction = new BankTransaction();

		bankTransaction.setDate(LocalDate.parse(columns[0], DATE_PATTERN));
		bankTransaction.setAmount(Integer.valueOf(columns[1]));
		bankTransaction.setDescription(columns[2]);
		return bankTransaction;
	}
	// �� �پ� �Ľ� ��, ����Ʈ�� �߰�
	// ���������� List<BankTransaction> parseLinesFromTSV(List <String> lines) {}
	
	public List<BankTransaction> parseLinesFromTSV(List <String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		for (String line : lines) {
			bankTransactions.add(parseFromTSV(line));
		}
		return bankTransactions;
	}
}
