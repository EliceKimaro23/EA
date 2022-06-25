package bank.adapter;

import bank.domain.AccountEntry;
import bank.dto.AccountDTO;
import bank.dto.AccountEntryDTO;

//private Date date;
//private double amount;
//private String description;
//private String fromAccountNumber;
//private String fromPersonName;

public class AccountEntryAdapter {
    public static AccountEntryDTO getAccountEntryDTOfromAccountEntry(AccountEntry accountEntry){
        return new AccountEntryDTO(accountEntry.getDate(),accountEntry.getAmount(),accountEntry.getDescription(),
                accountEntry.getFromAccountNumber(),accountEntry.getFromPersonName());
    }

    public static AccountEntry getAccountEntryfromAccountEntryDTO(AccountEntryDTO accountEntry){
        return new AccountEntry(accountEntry.getDate(),accountEntry.getAmount(),accountEntry.getDescription(),
                accountEntry.getFromAccountNumber(),accountEntry.getFromPersonName());
    }


}
