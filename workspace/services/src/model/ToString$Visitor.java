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
		result = server.getUserName();
		
	}
	@Override
	public void handleAdministrator(Administrator4Public administrator) throws PersistenceException {
		result = "Administrator";
	}
	@Override
	public void handleCustomer(Customer4Public customer) throws PersistenceException {
		result = "Customer";
	}
	@Override
	public void handleUserManager(UserManager4Public userManager) throws PersistenceException {
		result = "UserManager";
	}
	@Override
	public void handleRegister(Register4Public register) throws PersistenceException {
		result = "Register";
	}

}
