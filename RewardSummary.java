package com.customer.rewards.summary;

import java.util.*;

public class RewardSummary {
	public static void main(String[] args) {

		// Lists of invoices for each month
		List<Long> invoice_jan_customer1 = Arrays.asList(Long.valueOf(120), Long.valueOf(60));
		List<Long> invoice_feb_customer1 = Arrays.asList(Long.valueOf(40), Long.valueOf(120), Long.valueOf(30));
		List<Long> invoice_mar_customer1 = Arrays.asList(Long.valueOf(150));

		// Map with list of invoices for each month
		Map<String, List<Long>> map_customer1 = new HashMap<>();
		map_customer1.put("jan", invoice_jan_customer1);
		map_customer1.put("feb", invoice_feb_customer1);
		map_customer1.put("mar", invoice_mar_customer1);

		long totalRewardPointsForThreeMonths = calculateRewardPointsForThreeMonths(map_customer1);
		System.out.println("totalRewardPointsForThreeMonths :: " + totalRewardPointsForThreeMonths);

	}

	// Sum reward points for invoices of three months
	private static long calculateRewardPointsForThreeMonths(Map<String, List<Long>> invoicesOfThreeMonths) {
		return invoicesOfThreeMonths.entrySet().stream().mapToLong((e) -> {
			return rewardPointsforEachMonth(e.getValue());
		}).sum();
	}

	// Sum reward points of all invoices in a month
	private static long rewardPointsforEachMonth(final List<Long> invoicesInEachmonth) {
		return invoicesInEachmonth.stream().mapToLong((transactionAmt) -> {
			return rewardPointsForEachInvoice(transactionAmt);
		}).sum();
	}

	// calculate reward points for each invoice
	private static long rewardPointsForEachInvoice(final long invoiceAmount) {
		if (invoiceAmount >= 50 && invoiceAmount <= 100) {
			return invoiceAmount - 50;
		} else if (invoiceAmount > 100) {
			return (invoiceAmount - 100) * 2 + 50;
		} else {
			return 0;
		}
	}
}
