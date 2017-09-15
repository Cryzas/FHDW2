
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class Program extends PersistentObject implements PersistentProgram{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Program4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theProgramFacade.getClass(objectId);
        return (Program4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Program4Public createProgram(String name) throws PersistenceException{
        return createProgram(name,false);
    }
    
    public static Program4Public createProgram(String name,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentProgram result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramFacade
                .newDelayedProgram(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramFacade
                .newProgram(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Program4Public createProgram(String name,boolean delayed$Persistence,Program4Public This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentProgram result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramFacade
                .newDelayedProgram(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramFacade
                .newProgram(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
        java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf){
                result = (java.util.HashMap<String,Object>)allResults.get(uniqueKey);
                if (result != null) return result;
            }
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, inDerived);
            if (leaf) allResults.put(uniqueKey, result);
            result.put("modules", this.getModules().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
            result.put("name", this.getName());
            result.put("creditPoints", this.getCreditPoints().toString());
        }
        return result;
    }
    
    public static ProgramSearchList getProgramByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theProgramFacade
            .getProgramByName(name);
    }
    
    public Program provideCopy() throws PersistenceException{
        Program result = this;
        result = new Program(this.name, 
                             this.This, 
                             this.getId());
        result.modules = this.modules.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Program_ModulesProxi modules;
    protected String name;
    protected PersistentProgram This;
    
    public Program(String name,PersistentProgram This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.modules = new Program_ModulesProxi(this);
        this.name = name;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 143;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 143) ConnectionHandler.getTheConnectionHandler().theProgramFacade
            .newProgram(name,this.getId());
        super.store();
        this.getModules().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theProgramFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Program_ModulesProxi getModules() throws PersistenceException {
        return this.modules;
    }
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theProgramFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    protected void setThis(PersistentProgram newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentProgram)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentProgram getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProgram result = (PersistentProgram)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentProgram)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProgram(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgram(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgram(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgram(this);
    }
    public void accept(programHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleProgram(this);
    }
    public <R> R accept(programHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgram(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgram(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgram(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModules().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsprogramHierarchy(final programHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<ModuleAbstract4Public> iterator0 = getThis().getModules().iterator();
		while(iterator0.hasNext())
			if(((programHierarchyHIERARCHY)iterator0.next()).containsprogramHierarchy(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentProgram)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public <T> T strategyprogramHierarchy(final programHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$modules$$Program = strategy.Program$$modules$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getModules().iterator();
		while (iterator$$.hasNext()){
			ModuleAbstract4Public current$$Field = (ModuleAbstract4Public)iterator$$.next();
			T current$$ = current$$Field.strategyprogramHierarchy(strategy);
			result$$modules$$Program = strategy.Program$$modules$$consolidate(getThis(), result$$modules$$Program, current$$);
		}
		T result = strategy.Program$$finalize(getThis() ,result$$modules$$Program);
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addModule(final ModuleAbstract4Public module) 
				throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
    	if(getThis().containsprogramHierarchy(module))
    		throw new AlreadyExistsInParentException(AlreadyExistsInParentMessage);
    	getThis().getModules().add(module);
    }
    public ProgramSGroup4Public copyForStudyGroup() 
				throws PersistenceException{
    	ProgramSGroup4Public newProgram = ProgramSGroup.createProgramSGroup(getThis());
    	try {
			getThis().getModules().applyToAllException(module -> newProgram.addModule(module.copyForStudyGroup()));
		} catch (CycleException e) {
			throw new Error();
		}
    	return newProgram;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return getThis().getModules().aggregate(Fraction.Null, (result, argument) -> result.add(argument.getCreditPoints()));
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    static String AlreadyExistsInParentMessage = "Das ausgewählte Modul ist bereits in dem Programm.";
    
    /* End of protected part that is not overridden by persistence generator */
    
}
