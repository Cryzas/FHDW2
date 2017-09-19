
package modelServer;


import persistence.*;

public  class RemoteProgramModuleService extends RemotesubAdminService {

	
	public RemoteProgramModuleService(String connectionName, String userName, PersistentProgramModuleService server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> modules_Path_In_AddModuleToGroup(){
        try {
            ModuleAbstractSearchList result = ((PersistentProgramModuleService)this.server).modules_Path_In_AddModuleToGroup();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> modules_Path_In_AddModuleToProg(){
        try {
            ModuleAbstractSearchList result = ((PersistentProgramModuleService)this.server).modules_Path_In_AddModuleToProg();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> modules_Path_In_DeleteModules(){
        try {
            ModuleAbstractSearchList result = ((PersistentProgramModuleService)this.server).modules_Path_In_DeleteModules();
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
            ModuleAbstractSearchList result = ((PersistentProgramModuleService)this.server).modules_Path_In_RemoveModuleFromGroup(group);
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
            ModuleAbstractSearchList result = ((PersistentProgramModuleService)this.server).modules_Path_In_RemoveModuleFromProg(program);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> programModuleService_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentProgramModuleService)this.server).programModuleService_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> programs_Path_In_DeletePrograms(){
        try {
            ProgramSearchList result = ((PersistentProgramModuleService)this.server).programs_Path_In_DeletePrograms();
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
            UnitSearchList result = ((PersistentProgramModuleService)this.server).units_Path_In_RemoveUnit(module);
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
            ((PersistentProgramModuleService)this.server).addModuleToGroup(group, modules);
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
            ((PersistentProgramModuleService)this.server).addModuleToProg(program, modules);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addUnit(String moduleProxiString, String name, String creditPointsAsString){
        try {
            PersistentModuleWithUnits module = (PersistentModuleWithUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentProgramModuleService)this.server).addUnit(module, name, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeCPOnModule(String moduleProxiString, String creditPointsAsString){
        try {
            PersistentModuleAtomar module = (PersistentModuleAtomar)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentProgramModuleService)this.server).changeCPOnModule(module, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeCPOnUnit(String unitProxiString, String creditPointsAsString){
        try {
            PersistentUnit unit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentProgramModuleService)this.server).changeCPOnUnit(unit, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeGradeSystem(String moduleProxiString){
        try {
            PersistentModuleAtomar module = (PersistentModuleAtomar)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleProxiString));
            ((PersistentProgramModuleService)this.server).changeGradeSystem(module);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createModule(String type, String name){
        try {
            ((PersistentProgramModuleService)this.server).createModule(type, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createProgram(String name){
        try {
            ((PersistentProgramModuleService)this.server).createProgram(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> deleteModules(java.util.Vector<String> modulesTrnsprt){
        try {
            ModuleAbstractSearchList modules = new ModuleAbstractSearchList();
			java.util.Iterator<String> modulesItrtr = modulesTrnsprt.iterator();
			while (modulesItrtr.hasNext()){
				PersistentModuleAbstract currentProxi = (PersistentModuleAbstract)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(modulesItrtr.next()));
				modules.add(currentProxi);
			}
            ((PersistentProgramModuleService)this.server).deleteModules(modules);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> deletePrograms(java.util.Vector<String> programsTrnsprt){
        try {
            ProgramSearchList programs = new ProgramSearchList();
			java.util.Iterator<String> programsItrtr = programsTrnsprt.iterator();
			while (programsItrtr.hasNext()){
				PersistentProgram currentProxi = (PersistentProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(programsItrtr.next()));
				programs.add(currentProxi);
			}
            ((PersistentProgramModuleService)this.server).deletePrograms(programs);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeError(String errorProxiString){
        try {
            PersistentErrorDisplay error = (PersistentErrorDisplay)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(errorProxiString));
            ((PersistentProgramModuleService)this.server).removeError(error);
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
            ((PersistentProgramModuleService)this.server).removeModuleFromGroup(group, modules);
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
            ((PersistentProgramModuleService)this.server).removeModuleFromProg(program, modules);
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
            ((PersistentProgramModuleService)this.server).removeUnit(module, units);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> startStudyGroup(String programProxiString, String name){
        try {
            PersistentProgram program = (PersistentProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(programProxiString));
            ((PersistentProgramModuleService)this.server).startStudyGroup(program, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> updateMe(){
        try {
            ((PersistentProgramModuleService)this.server).updateMe();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> updatePLZImplementation(){
        try {
            ((PersistentProgramModuleService)this.server).updatePLZImplementation();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}