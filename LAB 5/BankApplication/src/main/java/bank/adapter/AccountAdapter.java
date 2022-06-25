package bank.adapter;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.dto.AccountDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountAdapter {

    public static Account getAccountFromAccountDTO(AccountDTO accountDTO){
        return new Account(accountDTO.getAccountnumber(),accountDTO.getCustomer());
    }

    public static AccountDTO getAccountDTOFromAccount(Account account){
        return new AccountDTO(account.getAccountnumber(),
                account.getEntryList(),account.getCustomer());
    }

    public static List<AccountDTO> getAccountDTOSFromAccounts(List<Account> account){
        List<AccountDTO> temp = new ArrayList<>();

        for(Account acc : account) {
            temp.add(new AccountDTO(acc.getAccountnumber(), acc.getEntryList(), acc.getCustomer()));
        }
        return temp;
    }


}


//    long accountnumber;
//    Collection<AccountEntry> entryList ;
//    Customer customer;
//}
