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
	public void handleProgram(Program4Public program) throws PersistenceException {
		result = "Program: " + program.getName();
		
	}
	@Override
	public void handleServer(Server4Public server) throws PersistenceException {
		
		
	}
	@Override
	public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException {
		result = "Module: " + moduleAtomar.getName();
		
	}
	@Override
	public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException {
		result = "ModuleManager";
		
	}
	@Override
	public void handleUnit(Unit4Public unit) throws PersistenceException {
		result = "Unit: " + unit.getName();
		
	}
	@Override
	public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException {
		result = "Module: " + moduleWithUnits.getName();
		
	}
	@Override
	public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException {
		result = "ProgramManager";
		
	}

}
