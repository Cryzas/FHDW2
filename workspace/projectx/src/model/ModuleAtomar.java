
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ModuleAtomar extends model.ModuleAbstract implements PersistentModuleAtomar{
    
    
    public static ModuleAtomar4Public createModuleAtomar(String name) throws PersistenceException{
        return createModuleAtomar(name,false);
    }
    
    public static ModuleAtomar4Public createModuleAtomar(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleAtomar result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade
                .newDelayedModuleAtomar(name,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade
                .newModuleAtomar(name,common.Fraction.Null,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleAtomar4Public createModuleAtomar(String name,boolean delayed$Persistence,ModuleAtomar4Public This) throws PersistenceException {
        PersistentModuleAtomar result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade
                .newDelayedModuleAtomar(name,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade
                .newModuleAtomar(name,common.Fraction.Null,-1);
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
            result.put("ownCreditPoints", this.getOwnCreditPoints().toString());
        }
        return result;
    }
    
    public ModuleAtomar provideCopy() throws PersistenceException{
        ModuleAtomar result = this;
        result = new ModuleAtomar(this.name, 
                                  this.subService, 
                                  this.This, 
                                  this.ownCreditPoints, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected common.Fraction ownCreditPoints;
    
    public ModuleAtomar(String name,SubjInterface subService,PersistentModuleAbstract This,common.Fraction ownCreditPoints,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(SubjInterface)subService,(PersistentModuleAbstract)This,id);
        this.ownCreditPoints = ownCreditPoints;        
    }
    
    static public long getTypeId() {
        return 153;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 153) ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade
            .newModuleAtomar(name,ownCreditPoints,this.getId());
        super.store();
        
    }
    
    public common.Fraction getOwnCreditPoints() throws PersistenceException {
        return this.ownCreditPoints;
    }
    public void setOwnCreditPoints(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade.ownCreditPointsSet(this.getId(), newValue);
        this.ownCreditPoints = newValue;
    }
    public PersistentModuleAtomar getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleAtomar result = (PersistentModuleAtomar)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleAtomar)this.This;
    }
    
    public void accept(ModuleAbstractVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomar(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomar(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomar(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void changeCPOnModule(final common.Fraction creditPoints) 
				throws PersistenceException{
        model.meta.ModuleAtomarChangeCPOnModuleFractionMssg event = new model.meta.ModuleAtomarChangeCPOnModuleFractionMssg(creditPoints, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleAtomar)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void changeCPOnModuleImplementation(final common.Fraction creditPoints) 
				throws PersistenceException{
        getThis().setOwnCreditPoints(creditPoints);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }

	@Override
	public Fraction getCreditPoints() throws PersistenceException {
		return getThis().getOwnCreditPoints();
	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
