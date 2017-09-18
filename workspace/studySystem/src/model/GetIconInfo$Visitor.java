package model;

import common.Fraction;
import model.visitor.AnythingVisitor;
import persistence.*;

public class GetIconInfo$Visitor extends model.visitor.AnythingStandardVisitor {

	int result = 0;
	
	@Override
	protected void standardHandling(Anything anything) throws PersistenceException {
		result = 0;	
	}

	public int getIconInfo(Anything anything) throws PersistenceException {
		standardHandling(anything);
		anything.accept(new AnythingVisitor() {
			
			@Override
			public void handleStudentService(StudentService4Public studentService) throws PersistenceException {
			}
			
			@Override
			public void handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException {
			}
			
			@Override
			public void handleNoProgram(NoProgram4Public noProgram) throws PersistenceException {
				result = 5;				
			}
			
			@Override
			public void handleBTrue(BTrue4Public bTrue) throws PersistenceException {
			}
			
			@Override
			public void handleBFalse(BFalse4Public bFalse) throws PersistenceException {
			}
			
			@Override
			public void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent)
					throws PersistenceException {
				if(moduleWithUnitsStudent.getPassedCP().equals(Fraction.Null)){
					result = 5;
				} else if (moduleWithUnitsStudent.getPassedCP().equals(moduleWithUnitsStudent.getCreditPoints())) {
					result = 3;
				} else {
					result = 4;
				}
			}
			
			@Override
			public void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException {
				if(moduleGroupStudent.getPassedCP().equals(Fraction.Null)){
					result = 5;
				} else if (moduleGroupStudent.getPassedCP().equals(moduleGroupStudent.getCreditPoints())) {
					result = 3;
				} else {
					result = 4;
				}
			}
			
			@Override
			public void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException {
				if(moduleAtomarStudent.getPassedCP().equals(Fraction.Null)){
					result = 5;
				} else if (moduleAtomarStudent.getPassedCP().equals(moduleAtomarStudent.getCreditPoints())) {
					result = 3;
				} else {
					result = 4;
				}
			}
			
			@Override
			public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup)
					throws PersistenceException {
				result = 13;
			}
			
			@Override
			public void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException {
				result = 12;
			}
			
			@Override
			public void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException {
				result = 14;
			}
			
			@Override
			public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException {
				result = 13;
			}
			
			@Override
			public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException {
				result = 12;
			}
			
			@Override
			public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException {
				result = 14;
			}
			
			@Override
			public void handleThirdGradeSystem(ThirdGradeSystem4Public thirdGradeSystem) throws PersistenceException {
			}
			
			@Override
			public void handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGradeSystem) throws PersistenceException {
			}
			
			@Override
			public void handleZ_5_0(Z_5_04Public z_5_0) throws PersistenceException {
			}
			
			@Override
			public void handleZ_4_0(Z_4_04Public z_4_0) throws PersistenceException {
			}
			
			@Override
			public void handleZ_3_9(Z_3_94Public z_3_9) throws PersistenceException {
			}
			
			@Override
			public void handleZ_3_8(Z_3_84Public z_3_8) throws PersistenceException {
			}
			
			@Override
			public void handleZ_3_7(Z_3_74Public z_3_7) throws PersistenceException {
			}
			
			@Override
			public void handleZ_3_6(Z_3_64Public z_3_6) throws PersistenceException {
			}
			
			@Override
			public void handleZ_3_5(Z_3_54Public z_3_5) throws PersistenceException {
			}
			
			@Override
			public void handleZ_3_4(Z_3_44Public z_3_4) throws PersistenceException {
			}
			
			@Override
			public void handleZ_3_3(Z_3_34Public z_3_3) throws PersistenceException {
			}
			
			@Override
			public void handleZ_3_2(Z_3_24Public z_3_2) throws PersistenceException {
			}
			
			@Override
			public void handleZ_3_1(Z_3_14Public z_3_1) throws PersistenceException {
			}
			
			@Override
			public void handleZ_3_0(Z_3_04Public z_3_0) throws PersistenceException {
			}
			
			@Override
			public void handleZ_2_9(Z_2_94Public z_2_9) throws PersistenceException {
			}
			
			@Override
			public void handleZ_2_8(Z_2_84Public z_2_8) throws PersistenceException {
			}
			
			@Override
			public void handleZ_2_7(Z_2_74Public z_2_7) throws PersistenceException {
			}
			
			@Override
			public void handleZ_2_6(Z_2_64Public z_2_6) throws PersistenceException {
			}
			
			@Override
			public void handleZ_2_5(Z_2_54Public z_2_5) throws PersistenceException {
			}
			
			@Override
			public void handleZ_2_4(Z_2_44Public z_2_4) throws PersistenceException {
			}
			
			@Override
			public void handleZ_2_3(Z_2_34Public z_2_3) throws PersistenceException {
			}
			
			@Override
			public void handleZ_2_2(Z_2_24Public z_2_2) throws PersistenceException {
			}
			
			@Override
			public void handleZ_2_1(Z_2_14Public z_2_1) throws PersistenceException {
			}
			
			@Override
			public void handleZ_2_0(Z_2_04Public z_2_0) throws PersistenceException {
			}
			
			@Override
			public void handleZ_1_9(Z_1_94Public z_1_9) throws PersistenceException {
			}
			
			@Override
			public void handleZ_1_8(Z_1_84Public z_1_8) throws PersistenceException {
			}
			
			@Override
			public void handleZ_1_7(Z_1_74Public z_1_7) throws PersistenceException {
			}
			
			@Override
			public void handleZ_1_6(Z_1_64Public z_1_6) throws PersistenceException {
			}
			
			@Override
			public void handleZ_1_5(Z_1_54Public z_1_5) throws PersistenceException {
			}
			
			@Override
			public void handleZ_1_4(Z_1_44Public z_1_4) throws PersistenceException {
			}
			
			@Override
			public void handleZ_1_3(Z_1_34Public z_1_3) throws PersistenceException {
			}
			
			@Override
			public void handleZ_1_2(Z_1_24Public z_1_2) throws PersistenceException {
			}
			
			@Override
			public void handleZ_1_1(Z_1_14Public z_1_1) throws PersistenceException {
			}
			
			@Override
			public void handleZ_1_0(Z_1_04Public z_1_0) throws PersistenceException {
			}
			
			@Override
			public void handleT_5_0(T_5_04Public t_5_0) throws PersistenceException {
			}
			
			@Override
			public void handleT_4_0(T_4_04Public t_4_0) throws PersistenceException {
			}
			
			@Override
			public void handleT_3_7(T_3_74Public t_3_7) throws PersistenceException {
			}
			
			@Override
			public void handleT_3_3(T_3_34Public t_3_3) throws PersistenceException {
			}
			
			@Override
			public void handleT_3_0(T_3_04Public t_3_0) throws PersistenceException {
			}
			
			@Override
			public void handleT_2_7(T_2_74Public t_2_7) throws PersistenceException {
			}
			
			@Override
			public void handleT_2_3(T_2_34Public t_2_3) throws PersistenceException {
			}
			
			@Override
			public void handleT_2_0(T_2_04Public t_2_0) throws PersistenceException {
			}
			
			@Override
			public void handleT_1_7(T_1_74Public t_1_7) throws PersistenceException {
			}
			
			@Override
			public void handleT_1_3(T_1_34Public t_1_3) throws PersistenceException {
			}
			
			@Override
			public void handleT_1_0(T_1_04Public t_1_0) throws PersistenceException {
			}
			
			@Override
			public void handleNoGrade(NoGrade4Public noGrade) throws PersistenceException {
			}
			
			@Override
			public void handlePassed(Passed4Public passed) throws PersistenceException {
			}
			
			@Override
			public void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException {
			}
			
			@Override
			public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException {
				if(unitStudent.getPassedCP().equals(Fraction.Null)){
					result = 5;
				} else if (unitStudent.getPassedCP().equals(unitStudent.getCreditPoints())) {
					result = 3;
				} else {
					result = 4;
				}
			}
			
			@Override
			public void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException {
				result = 15;
			}
			
			@Override
			public void handleUnit(Unit4Public unit) throws PersistenceException {
				result = 15;
			}
			
			@Override
			public void handleSwapCPonModuleWithUnitsCommand(
					SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException {
			}
			
			@Override
			public void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException {
				// TODO Icon StudyGroupManager
			}
			
			@Override
			public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException {
				result = 7;
			}
			
			@Override
			public void handleStudentManager(StudentManager4Public studentManager) throws PersistenceException {
				// TODO Icon StudentManager
			}
			
			@Override
			public void handleStudent(Student4Public student) throws PersistenceException {
				result = 6;
			}
			
			@Override
			public void handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand)
					throws PersistenceException {
			}
			
			@Override
			public void handleServer(Server4Public server) throws PersistenceException {
				result = 6;
			}
			
			@Override
			public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException {
				if(programStudent.getPassedCP().equals(Fraction.Null)){
					result = 5;
				} else if (programStudent.getPassedCP().equals(programStudent.getCreditPoints())) {
					result = 3;
				} else {
					result = 4;
				}
			}
			
			@Override
			public void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException {
				result = 19;
			}
			
			@Override
			public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException {
				// TODO Icon ProgramManager
			}
			
			@Override
			public void handleProgram(Program4Public program) throws PersistenceException {
				result = 19;
			}
			
			@Override
			public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException {
				// TODO Icon ModuleManager
			}
			
			@Override
			public void handleGradeChange(GradeChange4Public gradeChange) throws PersistenceException {
				result = 16;
			}
			
			@Override
			public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException {
				result = 5;
			}
			
			@Override
			public void handleEndStudyGroupCommand(EndStudyGroupCommand4Public endStudyGroupCommand)
					throws PersistenceException {
			}
			
			@Override
			public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand)
					throws PersistenceException {
			}
			
			@Override
			public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand)
					throws PersistenceException {
			}
			
			@Override
			public void handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException {
			}
			
			@Override
			public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException {
			}
			
			@Override
			public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException {
			}
			
			@Override
			public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException {
			}
			
			@Override
			public void handleChangeGradeSystemCommand(ChangeGradeSystemCommand4Public changeGradeSystemCommand)
					throws PersistenceException {
			}
			
			@Override
			public void handleChangeGradeCommand(ChangeGradeCommand4Public changeGradeCommand) throws PersistenceException {
			}
			
			@Override
			public void handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand)
					throws PersistenceException {
			}
			
			@Override
			public void handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand)
					throws PersistenceException {
			}
			
			@Override
			public void handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException {
			}
			
			@Override
			public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand)
					throws PersistenceException {
			}
			
			@Override
			public void handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand)
					throws PersistenceException {
			}
			
			@Override
			public void handleAddModuleToGroupCommand(AddModuleToGroupCommand4Public addModuleToGroupCommand)
					throws PersistenceException {
			}

			@Override
			public void handleAdminService(AdminService4Public adminService) throws PersistenceException {
			}

			@Override
			public void handleUserManagerService(UserManagerService4Public userManagerService)
					throws PersistenceException {
			}

			@Override
			public void handleSubj(Subj4Public subj) throws PersistenceException {
			}

			@Override
			public void handleAdminServiceServices(AdminServiceServices4Public adminServiceServices)
					throws PersistenceException {
			}
			@Override
			public void handleProgramModuleService(ProgramModuleService4Public programModuleService)
					throws PersistenceException {
			}

			@Override
			public void handleStudentManageService(StudentManageService4Public studentManageService)
					throws PersistenceException {
			}

			@Override
			public void handleStudyGroupService(StudyGroupService4Public studyGroupService)
					throws PersistenceException {
			}

			@Override
			public void handleProgramModuleServiceModuleManager(
					ProgramModuleServiceModuleManager4Public programModuleServiceModuleManager)
					throws PersistenceException {
			}

			@Override
			public void handleProgramModuleServiceProgramManager(
					ProgramModuleServiceProgramManager4Public programModuleServiceProgramManager)
					throws PersistenceException {
			}

			@Override
			public void handleStudentManageServiceStudentManager(
					StudentManageServiceStudentManager4Public studentManageServiceStudentManager)
					throws PersistenceException {
			}

			@Override
			public void handleStudyGroupServiceGroupManager(
					StudyGroupServiceGroupManager4Public studyGroupServiceGroupManager) throws PersistenceException {
			}

		});
		return result;
	}

}
