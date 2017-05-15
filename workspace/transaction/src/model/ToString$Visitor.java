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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleDebit(Debit4Public debit) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleAccount(Account4Public account) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleServer(Server4Public server) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleCredit(Credit4Public credit) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleTransfer(Transfer4Public transfer) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

}
