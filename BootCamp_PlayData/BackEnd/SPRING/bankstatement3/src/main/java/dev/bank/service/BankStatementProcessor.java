package dev.bank.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

// ����� ���� ������(����Ͻ�) ������ ó���ϴ� Ŭ����
public class BankStatementProcessor {
	
	private List<BankTransaction> bankTransactions;
	
	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}
	// 1. �� ����� ���� ��� ����
	public double calculateTotalAmount() {
		double total = 0d;
		for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}
	// 2. �ش� �� ����� ���� ��� ����
	public List<BankTransaction> caculateListInMonth(Month month) {
		ArrayList<BankTransaction> monthTransaction = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if(month.equals(bankTransaction.getDate().getMonth())) {
				monthTransaction.add(bankTransaction);
			}
		}
		return monthTransaction;
	}
	
	// 3. �ش� ī�װ��� ����� ���� ��� ����
	public double caculateTotalForCategory(String category) {
		double total = 0d;
		for (BankTransaction bankTransaction : bankTransactions) {
			if(category.equals(bankTransaction.getDescription())) {
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}
}
