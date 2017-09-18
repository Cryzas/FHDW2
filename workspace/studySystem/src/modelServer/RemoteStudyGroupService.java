
package modelServer;


import persistence.*;

public  class RemoteStudyGroupService extends RemotesubAdminService {

	
	public RemoteStudyGroupService(String connectionName, String userName, PersistentStudyGroupService server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> ToUnit_Path_In_SwapCPonModuleWithUnits(String moduleProxiString){
        try {
            PersistentModuleWithUnitsSGroup module = (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            UnitSGroupSearchList result = ((PersistentStudyGroupService)this.server).ToUnit_Path_In_SwapCPonModuleWithUnits(module);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> fromUnit_Path_In_SwapCPonModuleWithUnits(String moduleProxiString){
        try {
            PersistentModuleWithUnitsSGroup module = (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            UnitSGroupSearchList result = ((PersistentStudyGroupService)this.server).fromUnit_Path_In_SwapCPonModuleWithUnits(module);
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
            StudyGroupSearchList result = ((PersistentStudyGroupService)this.server).groups_Path_In_DeleteStudyGroups(manager);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> students_Path_In_AddStudentToGroup(){
        try {
            StudentSearchList result = ((PersistentStudyGroupService)this.server).students_Path_In_AddStudentToGroup();
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
            StudentSearchList result = ((PersistentStudyGroupService)this.server).students_Path_In_RemoveStudentFromGroup(group);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> studyGroupService_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentStudyGroupService)this.server).studyGroupService_Menu_Filter(anything);
            return createOKResult(result);
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
            ((PersistentStudyGroupService)this.server).addStudentToGroup(group, students);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createStudent(String groupProxiString, String firstName, String lastName, java.util.Date birthDate){
        try {
            PersistentStudyGroup group = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(groupProxiString));
            ((PersistentStudyGroupService)this.server).createStudent(group, firstName, lastName, new java.sql.Date(birthDate.getTime()));
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
            ((PersistentStudyGroupService)this.server).deleteStudyGroups(manager, groups);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> endStudyGroup(String studyGroupProxiString){
        try {
            PersistentStudyGroup studyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studyGroupProxiString));
            ((PersistentStudyGroupService)this.server).endStudyGroup(studyGroup);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeError(String errorProxiString){
        try {
            PersistentErrorDisplay error = (PersistentErrorDisplay)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(errorProxiString));
            ((PersistentStudyGroupService)this.server).removeError(error);
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
            ((PersistentStudyGroupService)this.server).removeStudentFromGroup(group, students);
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
            ((PersistentStudyGroupService)this.server).swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> updateMe(){
        try {
            ((PersistentStudyGroupService)this.server).updateMe();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> updatePLZImplementation(){
        try {
            ((PersistentStudyGroupService)this.server).updatePLZImplementation();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}