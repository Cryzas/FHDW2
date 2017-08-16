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
		result = "Studienprogramm: " + program.getName() + " (" + program.getCreditPoints() + " CP)";
		
	}
	@Override
	public void handleServer(Server4Public server) throws PersistenceException {
		
		
	}
	@Override
	public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException {
		result = "Atomares Modul: " + moduleAtomar.getName() + " (" + moduleAtomar.getCreditPoints() + " CP)";
		
	}
	@Override
	public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException {
		result = "Module";
		
	}
	@Override
	public void handleUnit(Unit4Public unit) throws PersistenceException {
		result = "Unit: " + unit.getName() + " (" + unit.getCreditPoints() + " CP)";
		
	}
	@Override
	public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException {
		result = "Modul mit Units: " + moduleWithUnits.getName() + " (" + moduleWithUnits.getCreditPoints() + " CP)";
		
	}
	@Override
	public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException {
		result = "Programme";
		
	}
	@Override
	public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException {
		result = "Modulgruppe: " + moduleGroup.getName() + " (" + moduleGroup.getCreditPoints() + " CP)";
	}
	@Override
	public void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

}
