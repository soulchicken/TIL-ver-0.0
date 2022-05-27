package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.bank.domain.BankTransaction;

@Component("parser")
public class BankStatementTSVParser implements BankStatementParser {

	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// �� �ٸ� �Ľ�, �� Ŭ���� �������� ����� ����
	// ���������� ��ȯŸ�� parseFromTSV (final String line)
	@Override
	public BankTransaction parseFrom (String line) {
		String[] columns = line.split("\t");
		BankTransaction bankTransaction = new BankTransaction();

		bankTransaction.setDate(LocalDate.parse(columns[0], DATE_PATTERN));
		bankTransaction.setAmount(Integer.valueOf(columns[1]));
		bankTransaction.setDescription(columns[2]);
		return bankTransaction;
	}
	// �� �پ� �Ľ� ��, ����Ʈ�� �߰�
	// ���������� List<BankTransaction> parseLinesFromTSV(List <String> lines) {}
	@Override
	public List<BankTransaction> parseLineFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		for (String line : lines) {
			bankTransactions.add(parseFrom(line));
		}
		return bankTransactions;
	}

}
