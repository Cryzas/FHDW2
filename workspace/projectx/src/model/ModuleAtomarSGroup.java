
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ModuleAtomarSGroup extends model.ModuleAbstractSGroup implements PersistentModuleAtomarSGroup{
    
    
    public static ModuleAtomarSGroup4Public createModuleAtomarSGroup(String name) throws PersistenceException{
        return createModuleAtomarSGroup(name,false);
    }
    
    public static ModuleAtomarSGroup4Public createModuleAtomarSGroup(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleAtomarSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade
                .newDelayedModuleAtomarSGroup(name,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade
                .newModuleAtomarSGroup(name,common.Fraction.Null,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleAtomarSGroup4Public createModuleAtomarSGroup(String name,boolean delayed$Persistence,ModuleAtomarSGroup4Public This) throws PersistenceException {
        PersistentModuleAtomarSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade
                .newDelayedModuleAtomarSGroup(name,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade
                .newModuleAtomarSGroup(name,common.Fraction.Null,-1);
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
        }
        return result;
    }
    
    public ModuleAtomarSGroup provideCopy() throws PersistenceException{
        ModuleAtomarSGroup result = this;
        result = new ModuleAtomarSGroup(this.name, 
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
    
    public ModuleAtomarSGroup(String name,PersistentModuleAbstractSGroup This,common.Fraction ownCreditPoints,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentModuleAbstractSGroup)This,id);
        this.ownCreditPoints = ownCreditPoints;        
    }
    
    static public long getTypeId() {
        return 179;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 179) ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade
            .newModuleAtomarSGroup(name,ownCreditPoints,this.getId());
        super.store();
        
    }
    
    public common.Fraction getOwnCreditPoints() throws PersistenceException {
        return this.ownCreditPoints;
    }
    public void setOwnCreditPoints(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade.ownCreditPointsSet(this.getId(), newValue);
        this.ownCreditPoints = newValue;
    }
    public PersistentModuleAtomarSGroup getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleAtomarSGroup result = (PersistentModuleAtomarSGroup)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleAtomarSGroup)this.This;
    }
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleAtomarSGroup)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result = strategy.ModuleAtomarSGroup$$finalize(getThis() );
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void changeCPOnModule(final common.Fraction creditPoints) 
				throws PersistenceException{
        //TODO: implement method: changeCPOnModule
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        //TODO: implement method: getCreditPoints
        try{
            throw new java.lang.UnsupportedOperationException("Method \"getCreditPoints\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
		//TODO: implement method: initializeOnCreation
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
		//TODO: implement method: initializeOnInstantiation
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
