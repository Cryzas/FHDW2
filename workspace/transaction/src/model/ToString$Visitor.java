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
	public void handleServer(Server4Public server) throws PersistenceException {
	}
	@Override
	public void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException {
		result = serverConstants.ToStringConstants.TransferManagerToString;
	}
	@Override
	public void handleAccount(Account4Public account) throws PersistenceException {
		result = account.getName() + serverConstants.ToStringConstants.ColonSeparator + account.getBalance();
	}
	@Override
	public void handleDebit(Debit4Public debit) throws PersistenceException {
		this.handleEntry(debit, serverConstants.ToStringConstants.DebitToString);
	}
	private void handleEntry(Entry4Public entry, String kind) throws PersistenceException {		
		result = entry.getTransfer().getAmount() + kind + entry.getTransfer().getSubject();
	}
	@Override
	public void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException {
		result = accountWrppr.getAccount().toString(true);
	}
	@Override
	public void handleCredit(Credit4Public credit) throws PersistenceException {
		this.handleEntry(credit, serverConstants.ToStringConstants.CreditToString);		
	}
	@Override
	public void handleTransfer(Transfer4Public transfer) throws PersistenceException {
		result = transfer.getAmount() 
				+ serverConstants.ToStringConstants.FromInfix + transfer.getFromAccount().getName()
				+ serverConstants.ToStringConstants.ToInfix + transfer.getToAccount().getName()
				+ serverConstants.ToStringConstants.ColonSeparator + transfer.getSubject();
	}
	@Override
	public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException {
		result = serverConstants.ToStringConstants.AccounManagerToString;
	}
	@Override
	public void handleNotBooked(NotBooked4Public notBooked) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleBooked(Booked4Public booked) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleWrapperRecycle(WrapperRecycle4Public wrapperRecycle) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleNoAccount(NoAccount4Public noAccount) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

}
