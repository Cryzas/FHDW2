package model;

import model.visitor.GradeSystemReturnVisitor;
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
		result = "Atomares Modul: " + moduleAtomar.getName() + " (" + moduleAtomar.getCreditPoints() + " CP) " + "NotenSchema: " + moduleAtomar.getGradeSystem().accept(new GradeSystemReturnVisitor<String>() {

			@Override
			public String handleSimpleGrade(SimpleGrade4Public simpleGrade) throws PersistenceException {
				return "Zweiwertig";
			}

			@Override
			public String handleTenthGrade(TenthGrade4Public tenthGrade) throws PersistenceException {
				return "Zehntelnoten";
			}

			@Override
			public String handleThirdGrade(ThirdGrade4Public thirdGrade) throws PersistenceException {
				return "Drittelnoten";
			}
		});		
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
		result = "Studienprogramm: " + programSGroup.getName() + " (" + programSGroup.getCreditPoints() + " CP)";		
	}
	@Override
	public void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException {
		result = "Modulgruppe: " + moduleGroupSGroup.getName() + " (" + moduleGroupSGroup.getCreditPoints() + " CP)";
	}
	@Override
	public void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException {
		result = "Atomares Modul: " + moduleAtomarSGroup.getName() + " (" + moduleAtomarSGroup.getCreditPoints() + " CP)";
	}
	@Override
	public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException {
		result = "Studiengruppe: " + studyGroup.getName();		
	}
	@Override
	public void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException {
		result = "Unit: " + unitSGroup.getName() + " (" + unitSGroup.getCreditPoints() + " CP)";		
	}
	@Override
	public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup)
			throws PersistenceException {
		result = "Modul mit Units: " + moduleWithUnitsSGroup.getName() + " (" + moduleWithUnitsSGroup.getCreditPoints() + " CP)";		
	}
	@Override
	public void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException {
		result = "Studiengruppen";	
	}
	@Override
	public void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException {
		result = "Atomares Modul: " + moduleAtomarStudent.getName() + " (" + moduleAtomarStudent.getCreditPoints() + " CP)";
	}
	@Override
	public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException {
		result = "Studienprogramm: " + programStudent.getName() + " (" + programStudent.getCreditPoints() + " CP)";	
	}
	@Override
	public void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent)
			throws PersistenceException {
		result = "Modul mit Units: " + moduleWithUnitsStudent.getName() + " (" + moduleWithUnitsStudent.getCreditPoints() + " CP)";	
	}
	@Override
	public void handleStudentManager(StudentManager4Public studentManager) throws PersistenceException {
		result = "Studenten";		
	}
	@Override
	public void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException {
		result = "Modulgruppe: " + moduleGroupStudent.getName() + " (" + moduleGroupStudent.getCreditPoints() + " CP)";
	}
	@Override
	public void handleStudent(Student4Public student) throws PersistenceException {
		result = "Student: " + student.getFirstName() + " " + student.getLastName() + " (" + student.getMatrNr() + ")";
	}
	@Override
	public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException {
		result = "Unit: " + unitStudent.getName() + " (" + unitStudent.getCreditPoints() + " CP)";
	}
	@Override
	public void handleThirdGrade(ThirdGrade4Public thirdGrade) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleSimpleGrade(SimpleGrade4Public simpleGrade) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleTenthGrade(TenthGrade4Public tenthGrade) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

}
