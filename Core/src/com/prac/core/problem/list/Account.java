package com.prac.core.problem.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Account {

	public static void main(String[] args) {

		AccountDetails a1 = new AccountDetails("RK1", "Fixed");
		AccountDetails a2 = new AccountDetails("RK1", "Savings");
		AccountDetails a11 = new AccountDetails("RK1", "Trading");
		AccountDetails a3 = new AccountDetails("RK2", "Fixed");
		AccountDetails a4 = new AccountDetails("RK3", "Fixed");
		AccountDetails a5 = new AccountDetails("RK4", "Fixed");
		AccountDetails a6 = new AccountDetails("RK5", "Fixed");
		AccountDetails a7 = new AccountDetails("RK6", "Savings");
		AccountDetails a8 = new AccountDetails("RK6", "Fixed");
		AccountDetails a9 = new AccountDetails("RK7", "Savings");
		AccountDetails a10 = new AccountDetails("RK7", "Fixed");

		List<AccountDetails> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		list.add(a6);
		list.add(a7);
		list.add(a8);
		list.add(a9);
		list.add(a10);
		list.add(a11);

		Map<String, List<AccountDetails>> map = list.stream()
				.collect(Collectors.groupingBy(AccountDetails::getCustomerId));

		
		map.forEach((x, y) -> System.out.println("CustomerId: " + x + " --> "
				+ y.stream().map(a -> a.getAcountType()).collect(Collectors.joining(", "))));
		
		Map<Object, Long> nMap = list.stream().collect(Collectors.groupingBy(x->x.getCustomerId(), Collectors.counting()));
		System.out.println(nMap);
		
		//list.stream().collect(Collectors.toMap(x->x.getCustomerId(), x->x.getAcountType())).forEach((x,y)->System.out.println(x.toString()+" "+y.toString()));
	}
}

class AccountDetails {
	private String customerId;
	private String acountType;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAcountType() {
		return acountType;
	}

	public void setAcountType(String acountType) {
		this.acountType = acountType;
	}

	public AccountDetails(String customerId, String acountType) {
		super();
		this.customerId = customerId;
		this.acountType = acountType;
	}

	@Override
	public String toString() {
		return "AccountDetails [customerId=" + customerId + ", acountType=" + acountType + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(acountType, customerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDetails other = (AccountDetails) obj;
		return Objects.equals(acountType, other.acountType) && Objects.equals(customerId, other.customerId);
	}
}
