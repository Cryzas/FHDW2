
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ProgramSGroup extends PersistentObject implements PersistentProgramSGroup{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ProgramSGroup4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade.getClass(objectId);
        return (ProgramSGroup4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ProgramSGroup4Public createProgramSGroup(Program4Public programCopy) throws PersistenceException{
        return createProgramSGroup(programCopy,false);
    }
    
    public static ProgramSGroup4Public createProgramSGroup(Program4Public programCopy,boolean delayed$Persistence) throws PersistenceException {
        PersistentProgramSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade
                .newDelayedProgramSGroup();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade
                .newProgramSGroup(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("programCopy", programCopy);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ProgramSGroup4Public createProgramSGroup(Program4Public programCopy,boolean delayed$Persistence,ProgramSGroup4Public This) throws PersistenceException {
        PersistentProgramSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade
                .newDelayedProgramSGroup();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade
                .newProgramSGroup(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("programCopy", programCopy);
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
            AbstractPersistentRoot finished = (AbstractPersistentRoot)this.getFinished();
            if (finished != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    finished, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("finished", proxiInformation);
                
            }
        }
        return result;
    }
    
    public ProgramSGroup provideCopy() throws PersistenceException{
        ProgramSGroup result = this;
        result = new ProgramSGroup(this.programCopy, 
                                   this.finished, 
                                   this.This, 
                                   this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ProgramSGroup_ModulesProxi modules;
    protected PersistentProgram programCopy;
    protected PersistentMyBoolean finished;
    protected PersistentProgramSGroup This;
    
    public ProgramSGroup(PersistentProgram programCopy,PersistentMyBoolean finished,PersistentProgramSGroup This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.modules = new ProgramSGroup_ModulesProxi(this);
        this.programCopy = programCopy;
        this.finished = finished;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 177;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 177) ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade
            .newProgramSGroup(this.getId());
        super.store();
        this.getModules().store();
        if(this.getProgramCopy() != null){
            this.getProgramCopy().store();
            ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade.programCopySet(this.getId(), getProgramCopy());
        }
        if(this.getFinished() != null){
            this.getFinished().store();
            ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade.finishedSet(this.getId(), getFinished());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public ProgramSGroup_ModulesProxi getModules() throws PersistenceException {
        return this.modules;
    }
    public Program4Public getProgramCopy() throws PersistenceException {
        return this.programCopy;
    }
    public void setProgramCopy(Program4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.programCopy)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.programCopy = (PersistentProgram)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade.programCopySet(this.getId(), newValue);
        }
    }
    public MyBoolean4Public getFinished() throws PersistenceException {
        return this.finished;
    }
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.finished)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.finished = (PersistentMyBoolean)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade.finishedSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentProgramSGroup newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentProgramSGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramSGroupFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentProgramSGroup getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProgramSGroup result = (PersistentProgramSGroup)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentProgramSGroup)this.This;
    }
    
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleProgramSGroup(this);
    }
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramSGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramSGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProgramSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramSGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramSGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramSGroup(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModules().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<ModuleAbstractSGroup4Public> iterator0 = getThis().getModules().iterator();
		while(iterator0.hasNext())
			if(((programHierarchySGroupHIERARCHY)iterator0.next()).containsprogramHierarchySGroup(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentProgramSGroup)This);
		if(this.isTheSameAs(This)){
			this.setProgramCopy((PersistentProgram)final$$Fields.get("programCopy"));
		}
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$modules$$ProgramSGroup = strategy.ProgramSGroup$$modules$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getModules().iterator();
		while (iterator$$.hasNext()){
			ModuleAbstractSGroup4Public current$$Field = (ModuleAbstractSGroup4Public)iterator$$.next();
			T current$$ = current$$Field.strategyprogramHierarchySGroup(strategy);
			result$$modules$$ProgramSGroup = strategy.ProgramSGroup$$modules$$consolidate(getThis(), result$$modules$$ProgramSGroup, current$$);
		}
		T result = strategy.ProgramSGroup$$finalize(getThis() ,result$$modules$$ProgramSGroup);
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addModule(final ModuleAbstractSGroup4Public module) 
				throws model.CycleException, PersistenceException{
    	getThis().getModules().add(module);
        
    }
    public ProgramStudent4Public copyForStudent() 
				throws model.UserException, PersistenceException{
    	ProgramStudent4Public newProgram = ProgramStudent.createProgramStudent(getThis());
    	getThis().getModules().applyToAllException(module -> newProgram.addModule(module.copyForStudent()));
    	return newProgram;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void endProgram() 
				throws PersistenceException{
        getThis().setFinished(BTrue.getTheBTrue());
        getThis().getModules().applyToAll(module -> module.endModule());
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
    	return getThis().getModules().aggregate(Fraction.Null, (result, argument) -> result.add(argument.getCreditPoints()));
    }
    public String getName() 
				throws PersistenceException{
        return getThis().getProgramCopy().getName();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().setFinished(BFalse.getTheBFalse());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
