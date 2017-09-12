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
		result = server.getUser();
	}
	@Override
	public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException {
		result = "Atomares Modul: " + moduleAtomar.getName() + " (" + moduleAtomar.getCreditPoints() + " CP) " + "NotenSchema: " + moduleAtomar.getGradeSystem().toString();
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
		result = "Atomares Modul: " + moduleAtomarSGroup.getName() + " (" + moduleAtomarSGroup.getCreditPoints() + " CP) " + "NotenSchema: " + moduleAtomarSGroup.getGradeSystem().toString();
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
		result = "Atomares Modul: " + moduleAtomarStudent.getName() + " (" + moduleAtomarStudent.getCreditPoints() + " CP / Note: " + moduleAtomarStudent.getGrade().toString() + ") " + "NotenSchema: " + ((ModuleAtomarSGroup4Public)moduleAtomarStudent.getModuleCopy()).getGradeSystem().toString();
	}
	@Override
	public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException {
		result = "Studienprogramm: " + programStudent.getName() + " (" + programStudent.getCreditPoints() + " CP / Note: " + programStudent.getGrade().toString() + ")";	
	}
	@Override
	public void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent)
			throws PersistenceException {
		result = "Modul mit Units: " + moduleWithUnitsStudent.getName() + " (" + moduleWithUnitsStudent.getCreditPoints() + " CP / Note: " + moduleWithUnitsStudent.getGrade().toString() + ")";	
	}
	@Override
	public void handleStudentManager(StudentManager4Public studentManager) throws PersistenceException {
		result = "Studenten";		
	}
	@Override
	public void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException {
		result = "Modulgruppe: " + moduleGroupStudent.getName() + " (" + moduleGroupStudent.getCreditPoints() + " CP / Note: " + moduleGroupStudent.getGrade().toString() + ")";
	}
	@Override
	public void handleStudent(Student4Public student) throws PersistenceException {
		result = "Student: " + student.getFirstName() + " " + student.getLastName() + " (" + student.getMatrNr() + ")";
	}
	@Override
	public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException {
		result = "Unit: " + unitStudent.getName() + " (" + unitStudent.getCreditPoints() + " CP / Note: " + unitStudent.getGrade().toString() + ")";
	}
	@Override
	public void handleThirdGradeSystem(ThirdGradeSystem4Public ThirdGradeSystem) throws PersistenceException {
		result = "Drittelnoten";
	}
	@Override
	public void handleSimpleGradeSystem(SimpleGradeSystem4Public SimpleGradeSystem) throws PersistenceException {
		result = "Zweiwertig";
	}
	@Override
	public void handlePassed(Passed4Public passed) throws PersistenceException {
		result = "Bestanden";
	}
	@Override
	public void handleT_2_3(T_2_34Public t_2_3) throws PersistenceException {
		result = "2,3";
	}
	@Override
	public void handleT_2_0(T_2_04Public t_2_0) throws PersistenceException {
		result = "2,0";		
	}
	@Override
	public void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException {
		result = "Nicht bestanden";
	}
	@Override
	public void handleT_1_3(T_1_34Public t_1_3) throws PersistenceException {
		result = "1,3";
	}
	@Override
	public void handleT_1_7(T_1_74Public t_1_7) throws PersistenceException {
		result = "1,7";
	}
	@Override
	public void handleT_1_0(T_1_04Public t_1_0) throws PersistenceException {
		result = "1,0";		
	}
	@Override
	public void handleT_3_7(T_3_74Public t_3_7) throws PersistenceException {
		result = "3,7";			
	}
	@Override
	public void handleZ_1_0(Z_1_04Public z_1_0) throws PersistenceException {
		result = "1,0";	
	}
	@Override
	public void handleZ_1_1(Z_1_14Public z_1_1) throws PersistenceException {
		result = "1,1";			
	}
	@Override
	public void handleZ_3_0(Z_3_04Public z_3_0) throws PersistenceException {
		result = "3,0";			
	}
	@Override
	public void handleZ_1_2(Z_1_24Public z_1_2) throws PersistenceException {
		result = "1,2";			
	}
	@Override
	public void handleZ_4_0(Z_4_04Public z_4_0) throws PersistenceException {
		result = "4,0";			
	}
	@Override
	public void handleZ_2_2(Z_2_24Public z_2_2) throws PersistenceException {
		result = "2,2";			
	}
	@Override
	public void handleZ_2_3(Z_2_34Public z_2_3) throws PersistenceException {
		result = "2,3";			
	}
	@Override
	public void handleZ_2_4(Z_2_44Public z_2_4) throws PersistenceException {
		result = "2,4";			
	}
	@Override
	public void handleZ_2_5(Z_2_54Public z_2_5) throws PersistenceException {
		result = "2,5";			
	}
	@Override
	public void handleZ_2_6(Z_2_64Public z_2_6) throws PersistenceException {
		result = "2,6";			
	}
	@Override
	public void handleZ_2_7(Z_2_74Public z_2_7) throws PersistenceException {
		result = "2,7";			
	}
	@Override
	public void handleZ_2_8(Z_2_84Public z_2_8) throws PersistenceException {
		result = "2,8";			
	}
	@Override
	public void handleZ_2_9(Z_2_94Public z_2_9) throws PersistenceException {
		result = "2,9";			
	}
	@Override
	public void handleT_4_0(T_4_04Public t_4_0) throws PersistenceException {
		result = "4,0";			
	}
	@Override
	public void handleT_2_7(T_2_74Public t_2_7) throws PersistenceException {
		result = "2,7";			
	}
	@Override
	public void handleZ_2_0(Z_2_04Public z_2_0) throws PersistenceException {
		result = "2,0";			
	}
	@Override
	public void handleZ_2_1(Z_2_14Public z_2_1) throws PersistenceException {
		result = "2,1";			
	}
	@Override
	public void handleZ_3_1(Z_3_14Public z_3_1) throws PersistenceException {
		result = "3,1";			
	}
	@Override
	public void handleZ_1_3(Z_1_34Public z_1_3) throws PersistenceException {
		result = "1,3";			
	}
	@Override
	public void handleZ_5_0(Z_5_04Public z_5_0) throws PersistenceException {
		result = "5,0";			
	}
	@Override
	public void handleZ_3_2(Z_3_24Public z_3_2) throws PersistenceException {
		result = "3,2";			
	}
	@Override
	public void handleZ_1_4(Z_1_44Public z_1_4) throws PersistenceException {
		result = "1,4";			
	}
	@Override
	public void handleZ_3_3(Z_3_34Public z_3_3) throws PersistenceException {
		result = "3,3";			
	}
	@Override
	public void handleZ_1_5(Z_1_54Public z_1_5) throws PersistenceException {
		result = "1,5";			
	}
	@Override
	public void handleZ_3_4(Z_3_44Public z_3_4) throws PersistenceException {
		result = "3,4";			
	}
	@Override
	public void handleZ_1_6(Z_1_64Public z_1_6) throws PersistenceException {
		result = "1,6";			
	}
	@Override
	public void handleZ_3_5(Z_3_54Public z_3_5) throws PersistenceException {
		result = "3,5";			
	}
	@Override
	public void handleZ_1_7(Z_1_74Public z_1_7) throws PersistenceException {
		result = "1,7";			
	}
	@Override
	public void handleZ_3_6(Z_3_64Public z_3_6) throws PersistenceException {
		result = "3,6";			
	}
	@Override
	public void handleZ_1_8(Z_1_84Public z_1_8) throws PersistenceException {
		result = "1,8";			
	}
	@Override
	public void handleZ_3_7(Z_3_74Public z_3_7) throws PersistenceException {
		result = "3,7";			
	}
	@Override
	public void handleZ_1_9(Z_1_94Public z_1_9) throws PersistenceException {
		result = "1,9";			
	}
	@Override
	public void handleZ_3_8(Z_3_84Public z_3_8) throws PersistenceException {
		result = "3,8";			
	}
	@Override
	public void handleZ_3_9(Z_3_94Public z_3_9) throws PersistenceException {
		result = "3,9";			
	}
	@Override
	public void handleT_5_0(T_5_04Public t_5_0) throws PersistenceException {
		result = "5,0";			
	}
	@Override
	public void handleT_3_0(T_3_04Public t_3_0) throws PersistenceException {
		result = "3,0";			
	}
	@Override
	public void handleT_3_3(T_3_34Public t_3_3) throws PersistenceException {
		result = "3,3";			
	}
	@Override
	public void handleNoGrade(NoGrade4Public noGrade) throws PersistenceException {
		result = "Keine Note";
	}
	@Override
	public void handleGradeChange(GradeChange4Public gradeChange) throws PersistenceException {
		result = "Von \"" + gradeChange.getFromGrade().toString() + "\" zu \"" + gradeChange.getToGrade().toString() + "\" / Kommentar: " + gradeChange.getComment() + " / " + gradeChange.getDateOfChange().toLocalDate().toString();
	}
	@Override
	public void handleBFalse(BFalse4Public bFalse) throws PersistenceException {
		result = "false";		
	}
	@Override
	public void handleBTrue(BTrue4Public bTrue) throws PersistenceException {
		result = "true";
	}
	@Override
	public void handleNoProgram(NoProgram4Public noProgram) throws PersistenceException {
		result = "Kein aktuelles Studienprogramm";
	}
	@Override
	public void handleStudentService(StudentService4Public studentService) throws PersistenceException {
		result = studentService.getUsername();
	}
	@Override
	public void handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException {
		result = dozentenService.getUsername();
	}

}
