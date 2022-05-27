package dev.bank.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

// 입출금 관련 도메인(비즈니스) 로직을 처리하는 클래스
public class BankStatementProcessor {
	
	private List<BankTransaction> bankTransactions;
	
	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}
	// 1. 총 입출금 내역 계산 로직
	public double calculateTotalAmount() {
		double total = 0d;
		for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}
	// 2. 해당 월 입출금 내역 계산 로직
	public List<BankTransaction> caculateListInMonth(Month month) {
		ArrayList<BankTransaction> monthTransaction = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if(month.equals(bankTransaction.getDate().getMonth())) {
				monthTransaction.add(bankTransaction);
			}
		}
		return monthTransaction;
	}
	
	// 3. 해당 카테고리별 입출금 내역 계산 로직
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
