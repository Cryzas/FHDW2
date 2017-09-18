
package modelServer;


import persistence.*;

public  class RemoteDozentenService extends RemotesubAdminService {

	
	public RemoteDozentenService(String connectionName, String userName, PersistentDozentenService server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> ToUnit_Path_In_SwapCPonModuleWithUnits(String moduleProxiString){
        try {
            PersistentModuleWithUnitsSGroup module = (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            UnitSGroupSearchList result = ((PersistentDozentenService)this.server).ToUnit_Path_In_SwapCPonModuleWithUnits(module);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> dozentenService_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentDozentenService)this.server).dozentenService_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> fromUnit_Path_In_SwapCPonModuleWithUnits(String moduleProxiString){
        try {
            PersistentModuleWithUnitsSGroup module = (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            UnitSGroupSearchList result = ((PersistentDozentenService)this.server).fromUnit_Path_In_SwapCPonModuleWithUnits(module);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> groups_Path_In_DeleteStudyGroups(String managerProxiString){
        try {
            PersistentStudyGroupManager manager = (PersistentStudyGroupManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            StudyGroupSearchList result = ((PersistentDozentenService)this.server).groups_Path_In_DeleteStudyGroups(manager);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> lecture_Path_In_ChangeGradeforStudent(String studentProxiString){
        try {
            PersistentStudent student = (PersistentStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studentProxiString));
            ModuleAbstractStudentSearchList result = ((PersistentDozentenService)this.server).lecture_Path_In_ChangeGradeforStudent(student);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> modules_Path_In_AddModuleToGroup(){
        try {
            ModuleAbstractSearchList result = ((PersistentDozentenService)this.server).modules_Path_In_AddModuleToGroup();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> modules_Path_In_AddModuleToProg(){
        try {
            ModuleAbstractSearchList result = ((PersistentDozentenService)this.server).modules_Path_In_AddModuleToProg();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> modules_Path_In_DeleteModules(String managerProxiString){
        try {
            PersistentModuleManager manager = (PersistentModuleManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            ModuleAbstractSearchList result = ((PersistentDozentenService)this.server).modules_Path_In_DeleteModules(manager);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> modules_Path_In_RemoveModuleFromGroup(String groupProxiString){
        try {
            PersistentModuleGroup group = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(groupProxiString));
            ModuleAbstractSearchList result = ((PersistentDozentenService)this.server).modules_Path_In_RemoveModuleFromGroup(group);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> modules_Path_In_RemoveModuleFromProg(String programProxiString){
        try {
            PersistentProgram program = (PersistentProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(programProxiString));
            ModuleAbstractSearchList result = ((PersistentDozentenService)this.server).modules_Path_In_RemoveModuleFromProg(program);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> programs_Path_In_DeletePrograms(String managerProxiString){
        try {
            PersistentProgramManager manager = (PersistentProgramManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            ProgramSearchList result = ((PersistentDozentenService)this.server).programs_Path_In_DeletePrograms(manager);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> students_Path_In_AddStudentToGroup(){
        try {
            StudentSearchList result = ((PersistentDozentenService)this.server).students_Path_In_AddStudentToGroup();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> students_Path_In_DeleteStudents(String managerProxiString){
        try {
            PersistentStudentManager manager = (PersistentStudentManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            StudentSearchList result = ((PersistentDozentenService)this.server).students_Path_In_DeleteStudents(manager);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> students_Path_In_RemoveStudentFromGroup(String groupProxiString){
        try {
            PersistentStudyGroup group = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(groupProxiString));
            StudentSearchList result = ((PersistentDozentenService)this.server).students_Path_In_RemoveStudentFromGroup(group);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> units_Path_In_RemoveUnit(String moduleProxiString){
        try {
            PersistentModuleWithUnits module = (PersistentModuleWithUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            UnitSearchList result = ((PersistentDozentenService)this.server).units_Path_In_RemoveUnit(module);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addModuleToGroup(String groupProxiString, java.util.Vector<String> modulesTrnsprt){
        try {
            PersistentModuleGroup group = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(groupProxiString));
            ModuleAbstractSearchList modules = new ModuleAbstractSearchList();
			java.util.Iterator<String> modulesItrtr = modulesTrnsprt.iterator();
			while (modulesItrtr.hasNext()){
				PersistentModuleAbstract currentProxi = (PersistentModuleAbstract)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(modulesItrtr.next()));
				modules.add(currentProxi);
			}
            ((PersistentDozentenService)this.server).addModuleToGroup(group, modules);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addModuleToProg(String programProxiString, java.util.Vector<String> modulesTrnsprt){
        try {
            PersistentProgram program = (PersistentProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(programProxiString));
            ModuleAbstractSearchList modules = new ModuleAbstractSearchList();
			java.util.Iterator<String> modulesItrtr = modulesTrnsprt.iterator();
			while (modulesItrtr.hasNext()){
				PersistentModuleAbstract currentProxi = (PersistentModuleAbstract)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(modulesItrtr.next()));
				modules.add(currentProxi);
			}
            ((PersistentDozentenService)this.server).addModuleToProg(program, modules);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addStudentToGroup(String groupProxiString, java.util.Vector<String> studentsTrnsprt){
        try {
            PersistentStudyGroup group = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(groupProxiString));
            StudentSearchList students = new StudentSearchList();
			java.util.Iterator<String> studentsItrtr = studentsTrnsprt.iterator();
			while (studentsItrtr.hasNext()){
				PersistentStudent currentProxi = (PersistentStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studentsItrtr.next()));
				students.add(currentProxi);
			}
            ((PersistentDozentenService)this.server).addStudentToGroup(group, students);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addUnit(String moduleProxiString, String name, String creditPointsAsString){
        try {
            PersistentModuleWithUnits module = (PersistentModuleWithUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentDozentenService)this.server).addUnit(module, name, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeCPOnModule(String moduleProxiString, String creditPointsAsString){
        try {
            PersistentModuleAtomar module = (PersistentModuleAtomar)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentDozentenService)this.server).changeCPOnModule(module, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeCPOnUnit(String unitProxiString, String creditPointsAsString){
        try {
            PersistentUnit unit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentDozentenService)this.server).changeCPOnUnit(unit, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeGradeOfModule(String moduleProxiString, String grade, String comment){
        try {
            PersistentModuleAtomarStudent module = (PersistentModuleAtomarStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            ((PersistentDozentenService)this.server).changeGradeOfModule(module, grade, comment);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeGradeOfUnit(String unitProxiString, String grade, String comment){
        try {
            PersistentUnitStudent unit = (PersistentUnitStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            ((PersistentDozentenService)this.server).changeGradeOfUnit(unit, grade, comment);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeGradeSystem(String moduleProxiString){
        try {
            PersistentModuleAtomar module = (PersistentModuleAtomar)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            ((PersistentDozentenService)this.server).changeGradeSystem(module);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeGradeforStudent(String studentProxiString, String lectureProxiString, String grade, String comment){
        try {
            PersistentStudent student = (PersistentStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studentProxiString));
            LectureWithGrade lecture = (LectureWithGrade)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(lectureProxiString));
            ((PersistentDozentenService)this.server).changeGradeforStudent(student, lecture, grade, comment);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createModule(String type, String name){
        try {
            ((PersistentDozentenService)this.server).createModule(type, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createProgram(String name){
        try {
            ((PersistentDozentenService)this.server).createProgram(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createStudent(String groupProxiString, String firstName, String lastName, java.util.Date birthDate){
        try {
            PersistentStudyGroup group = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(groupProxiString));
            ((PersistentDozentenService)this.server).createStudent(group, firstName, lastName, new java.sql.Date(birthDate.getTime()));
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> deleteModules(String managerProxiString, java.util.Vector<String> modulesTrnsprt){
        try {
            PersistentModuleManager manager = (PersistentModuleManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            ModuleAbstractSearchList modules = new ModuleAbstractSearchList();
			java.util.Iterator<String> modulesItrtr = modulesTrnsprt.iterator();
			while (modulesItrtr.hasNext()){
				PersistentModuleAbstract currentProxi = (PersistentModuleAbstract)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(modulesItrtr.next()));
				modules.add(currentProxi);
			}
            ((PersistentDozentenService)this.server).deleteModules(manager, modules);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> deletePrograms(String managerProxiString, java.util.Vector<String> programsTrnsprt){
        try {
            PersistentProgramManager manager = (PersistentProgramManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            ProgramSearchList programs = new ProgramSearchList();
			java.util.Iterator<String> programsItrtr = programsTrnsprt.iterator();
			while (programsItrtr.hasNext()){
				PersistentProgram currentProxi = (PersistentProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(programsItrtr.next()));
				programs.add(currentProxi);
			}
            ((PersistentDozentenService)this.server).deletePrograms(manager, programs);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> deleteStudents(String managerProxiString, java.util.Vector<String> studentsTrnsprt){
        try {
            PersistentStudentManager manager = (PersistentStudentManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            StudentSearchList students = new StudentSearchList();
			java.util.Iterator<String> studentsItrtr = studentsTrnsprt.iterator();
			while (studentsItrtr.hasNext()){
				PersistentStudent currentProxi = (PersistentStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studentsItrtr.next()));
				students.add(currentProxi);
			}
            ((PersistentDozentenService)this.server).deleteStudents(manager, students);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> deleteStudyGroups(String managerProxiString, java.util.Vector<String> groupsTrnsprt){
        try {
            PersistentStudyGroupManager manager = (PersistentStudyGroupManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            StudyGroupSearchList groups = new StudyGroupSearchList();
			java.util.Iterator<String> groupsItrtr = groupsTrnsprt.iterator();
			while (groupsItrtr.hasNext()){
				PersistentStudyGroup currentProxi = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(groupsItrtr.next()));
				groups.add(currentProxi);
			}
            ((PersistentDozentenService)this.server).deleteStudyGroups(manager, groups);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> endStudyGroup(String studyGroupProxiString){
        try {
            PersistentStudyGroup studyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studyGroupProxiString));
            ((PersistentDozentenService)this.server).endStudyGroup(studyGroup);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeError(String errorProxiString){
        try {
            PersistentErrorDisplay error = (PersistentErrorDisplay)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(errorProxiString));
            ((PersistentDozentenService)this.server).removeError(error);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeModuleFromGroup(String groupProxiString, java.util.Vector<String> modulesTrnsprt){
        try {
            PersistentModuleGroup group = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(groupProxiString));
            ModuleAbstractSearchList modules = new ModuleAbstractSearchList();
			java.util.Iterator<String> modulesItrtr = modulesTrnsprt.iterator();
			while (modulesItrtr.hasNext()){
				PersistentModuleAbstract currentProxi = (PersistentModuleAbstract)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(modulesItrtr.next()));
				modules.add(currentProxi);
			}
            ((PersistentDozentenService)this.server).removeModuleFromGroup(group, modules);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeModuleFromProg(String programProxiString, java.util.Vector<String> modulesTrnsprt){
        try {
            PersistentProgram program = (PersistentProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(programProxiString));
            ModuleAbstractSearchList modules = new ModuleAbstractSearchList();
			java.util.Iterator<String> modulesItrtr = modulesTrnsprt.iterator();
			while (modulesItrtr.hasNext()){
				PersistentModuleAbstract currentProxi = (PersistentModuleAbstract)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(modulesItrtr.next()));
				modules.add(currentProxi);
			}
            ((PersistentDozentenService)this.server).removeModuleFromProg(program, modules);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeStudentFromGroup(String groupProxiString, java.util.Vector<String> studentsTrnsprt){
        try {
            PersistentStudyGroup group = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(groupProxiString));
            StudentSearchList students = new StudentSearchList();
			java.util.Iterator<String> studentsItrtr = studentsTrnsprt.iterator();
			while (studentsItrtr.hasNext()){
				PersistentStudent currentProxi = (PersistentStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studentsItrtr.next()));
				students.add(currentProxi);
			}
            ((PersistentDozentenService)this.server).removeStudentFromGroup(group, students);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeUnit(String moduleProxiString, java.util.Vector<String> unitsTrnsprt){
        try {
            PersistentModuleWithUnits module = (PersistentModuleWithUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            UnitSearchList units = new UnitSearchList();
			java.util.Iterator<String> unitsItrtr = unitsTrnsprt.iterator();
			while (unitsItrtr.hasNext()){
				PersistentUnit currentProxi = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitsItrtr.next()));
				units.add(currentProxi);
			}
            ((PersistentDozentenService)this.server).removeUnit(module, units);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> startStudyGroup(String programProxiString, String name){
        try {
            PersistentProgram program = (PersistentProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(programProxiString));
            ((PersistentDozentenService)this.server).startStudyGroup(program, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> swapCPonModuleWithUnits(String moduleProxiString, String fromUnitProxiString, String ToUnitProxiString, String creditPointsAsString){
        try {
            PersistentModuleWithUnitsSGroup module = (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            PersistentUnitSGroup fromUnit = (PersistentUnitSGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fromUnitProxiString));
            PersistentUnitSGroup ToUnit = (PersistentUnitSGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(ToUnitProxiString));
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentDozentenService)this.server).swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> updateMe(){
        try {
            ((PersistentDozentenService)this.server).updateMe();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> updatePLZImplementation(){
        try {
            ((PersistentDozentenService)this.server).updatePLZImplementation();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}