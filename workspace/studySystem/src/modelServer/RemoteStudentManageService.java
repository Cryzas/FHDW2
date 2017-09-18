
package modelServer;


import persistence.*;

public  class RemoteStudentManageService extends RemotesubAdminService {

	
	public RemoteStudentManageService(String connectionName, String userName, PersistentStudentManageService server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> lecture_Path_In_ChangeGradeforStudent(String studentProxiString){
        try {
            PersistentStudent student = (PersistentStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studentProxiString));
            ModuleAbstractStudentSearchList result = ((PersistentStudentManageService)this.server).lecture_Path_In_ChangeGradeforStudent(student);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> studentManageService_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentStudentManageService)this.server).studentManageService_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> students_Path_In_DeleteStudents(String managerProxiString){
        try {
            PersistentStudentManager manager = (PersistentStudentManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            StudentSearchList result = ((PersistentStudentManageService)this.server).students_Path_In_DeleteStudents(manager);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeGradeOfModule(String moduleProxiString, String grade, String comment){
        try {
            PersistentModuleAtomarStudent module = (PersistentModuleAtomarStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            ((PersistentStudentManageService)this.server).changeGradeOfModule(module, grade, comment);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeGradeOfUnit(String unitProxiString, String grade, String comment){
        try {
            PersistentUnitStudent unit = (PersistentUnitStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            ((PersistentStudentManageService)this.server).changeGradeOfUnit(unit, grade, comment);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeGradeforStudent(String studentProxiString, String lectureProxiString, String grade, String comment){
        try {
            PersistentStudent student = (PersistentStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studentProxiString));
            LectureWithGrade lecture = (LectureWithGrade)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(lectureProxiString));
            ((PersistentStudentManageService)this.server).changeGradeforStudent(student, lecture, grade, comment);
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
            ((PersistentStudentManageService)this.server).deleteStudents(manager, students);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeError(String errorProxiString){
        try {
            PersistentErrorDisplay error = (PersistentErrorDisplay)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(errorProxiString));
            ((PersistentStudentManageService)this.server).removeError(error);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> updateMe(){
        try {
            ((PersistentStudentManageService)this.server).updateMe();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> updatePLZImplementation(){
        try {
            ((PersistentStudentManageService)this.server).updatePLZImplementation();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}