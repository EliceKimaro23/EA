package bank.dao;

import java.util.Collection;

import bank.domain.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public interface IAccountDAO {
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(long accountnumber);
	public Collection<Account> getAccounts();
}
