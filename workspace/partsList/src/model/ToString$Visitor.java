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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleQuantifiedComponent(QuantifiedComponent4Public quantifiedComponent) throws PersistenceException {
		result = quantifiedComponent.getQuantity() + ": " + quantifiedComponent.getComponent().toString(true);
	}
	@Override
	public void handleProduct(Product4Public product) throws PersistenceException {
		result = "Product: " + product.getName();
		
	}
	@Override
	public void handleComponentLst(ComponentLst4Public componentLst) throws PersistenceException {
		result = "PartsManager";
		
	}
	@Override
	public void handleMaterial(Material4Public material) throws PersistenceException {
		result = "Material: " + material.getName();
		
	}
	@Override
	public void handlePartsListManager(PartsListManager4Public partsListManager) throws PersistenceException {
		result = "Current Components";		
	}

}
