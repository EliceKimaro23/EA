package bank.dto;

import bank.domain.AccountEntry;
import bank.domain.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class AccountDTO {

	long accountnumber;
	Collection<AccountEntry> entryList ;
    Customer customer;


	public AccountDTO(long accountnumber, Collection<AccountEntry> entryList, Customer customer) {
		this.accountnumber = accountnumber;
		this.entryList = entryList;
		this.customer = customer;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	public void setEntryList(Collection<AccountEntry> entryList) {
		this.entryList = entryList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
