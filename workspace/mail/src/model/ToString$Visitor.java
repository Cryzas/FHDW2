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
	public void handleAccount(Account4Public account) throws PersistenceException {
		result = account.getName();
		
	}
	@Override
	public void handleServer(Server4Public server) throws PersistenceException {		
	}
	@Override
	public void handleFolder(Folder4Public folder) throws PersistenceException {
		result = folder.getName();
		
	}
	public void handleMail(Mail4Public mail) throws PersistenceException {
		result = mail.getSubject();
	}
	@Override
	public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException {
		result = "Accounts";
		
	}
	@Override
	public void handleDraft(Draft4Public draft) throws PersistenceException {
		result = draft.getSubject();
		
	}
	@Override
	public void handleMailEntry(MailEntry4Public mailEntry) throws PersistenceException {
		result = mailEntry.getSubject();	
	}
	@Override
	public void handleAccountWrapper(AccountWrapper4Public accountWrapper) throws PersistenceException {
		result = accountWrapper.getName();
	}

}
