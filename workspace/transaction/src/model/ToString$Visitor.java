package model;

import persistence.*;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private String result;
	
	public ToString$Visitor() {
	}
	public synchronized String toString(Anything anything) throws PersistenceException {
		try {
			result = null;
			anything.accept(this);
			if (result == null) {
				this.standardHandling(anything);
			} else {
				if (common.RPCConstantsAndServices.test) 
					result = " " + anything.getClassId() + " , " + anything.getId() + "::  " + result; 
			}
		} catch (Exception ex){
			System.out.println("During toString of " + anything.getClass() + " happened " + ex);
			this.standardHandling(anything);
		}
		return result;
	}
	
	protected void standardHandling(Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException {
		result = "Transfers";
		
	}
	@Override
	public void handleDebit(Debit4Public debit) throws PersistenceException {
		result = "Debit: " + debit.getTransfer().getSubject();
		
	}
	@Override
	public void handleAccount(Account4Public account) throws PersistenceException {
		result = account.getName();
		
	}
	@Override
	public void handleServer(Server4Public server) throws PersistenceException {
		
	}
	@Override
	public void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException {
		result = accountWrppr.fetchAccount().getName();	
	}
	@Override
	public void handleCredit(Credit4Public credit) throws PersistenceException {
		result = "Credit: " + credit.getTransfer().getSubject();
		
	}
	@Override
	public void handleTransfer(Transfer4Public transfer) throws PersistenceException {
		result = transfer.getSubject();
		
	}
	@Override
	public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException {
		result = "Accounts";		
	}

}
