
package modelServer;


import persistence.*;

public  class RemoteServer extends RemoteServerMaster {

	protected PersistentServer server;

	public RemoteServer(String connectionName, String userName, PersistentServer server){
		super (connectionName, userName );
        this.server = server;
	}

	protected Remote getServer(){
        return this.server;
    }
 

    public synchronized java.util.HashMap<?,?> ToUnit_Path_In_SwapCPonModuleWithUnits(String moduleProxiString){
        try {
            PersistentModuleWithUnitsSGroup module = (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            UnitSGroupSearchList result = ((PersistentServer)this.server).ToUnit_Path_In_SwapCPonModuleWithUnits(module);
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
            UnitSGroupSearchList result = ((PersistentServer)this.server).fromUnit_Path_In_SwapCPonModuleWithUnits(module);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> module_Path_In_AddModuleToGroup(){
        try {
            ModuleAbstractSearchList result = ((PersistentServer)this.server).module_Path_In_AddModuleToGroup();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> module_Path_In_AddModuleToProg(){
        try {
            ModuleAbstractSearchList result = ((PersistentServer)this.server).module_Path_In_AddModuleToProg();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> server_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentServer)this.server).server_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> student_Path_In_AddStudentToGroup(){
        try {
            StudentSearchList result = ((PersistentServer)this.server).student_Path_In_AddStudentToGroup();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addModuleToGroup(String groupProxiString, String moduleProxiString){
        try {
            PersistentModuleGroup group = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(groupProxiString));
            PersistentModuleAbstract module = (PersistentModuleAbstract)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            ((PersistentServer)this.server).addModuleToGroup(group, module);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addModuleToProg(String programProxiString, String moduleProxiString){
        try {
            PersistentProgram program = (PersistentProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(programProxiString));
            PersistentModuleAbstract module = (PersistentModuleAbstract)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            ((PersistentServer)this.server).addModuleToProg(program, module);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addStudentToGroup(String groupProxiString, String studentProxiString){
        try {
            PersistentStudyGroup group = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(groupProxiString));
            PersistentStudent student = (PersistentStudent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studentProxiString));
            ((PersistentServer)this.server).addStudentToGroup(group, student);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addUnit(String moduleProxiString, String name, String creditPointsAsString){
        try {
            PersistentModuleWithUnits module = (PersistentModuleWithUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentServer)this.server).addUnit(module, name, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeCPOnModule(String moduleProxiString, String creditPointsAsString){
        try {
            PersistentModuleAtomar module = (PersistentModuleAtomar)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentServer)this.server).changeCPOnModule(module, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeCPOnUnit(String unitProxiString, String creditPointsAsString){
        try {
            PersistentUnit unit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentServer)this.server).changeCPOnUnit(unit, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeGradeSystem(String moduleProxiString){
        try {
            PersistentModuleAtomar module = (PersistentModuleAtomar)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            ((PersistentServer)this.server).changeGradeSystem(module);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createModule(String type, String name){
        try {
            ((PersistentServer)this.server).createModule(type, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createProgram(String name){
        try {
            ((PersistentServer)this.server).createProgram(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createStudent(String firstName, String lastName, java.util.Date birthDate){
        try {
            ((PersistentServer)this.server).createStudent(firstName, lastName, new java.sql.Date(birthDate.getTime()));
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeError(String errorProxiString){
        try {
            PersistentErrorDisplay error = (PersistentErrorDisplay)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(errorProxiString));
            ((PersistentServer)this.server).removeError(error);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> startStudyGroup(String programProxiString, String name){
        try {
            PersistentProgram program = (PersistentProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(programProxiString));
            ((PersistentServer)this.server).startStudyGroup(program, name);
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
            ((PersistentServer)this.server).swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}