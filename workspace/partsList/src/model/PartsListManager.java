
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class PartsListManager extends PersistentObject implements PersistentPartsListManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PartsListManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.getClass(objectId);
        return (PartsListManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PartsListManager4Public createPartsListManager() throws PersistenceException{
        return createPartsListManager(false);
    }
    
    public static PartsListManager4Public createPartsListManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentPartsListManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade
                .newDelayedPartsListManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade
                .newPartsListManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PartsListManager4Public createPartsListManager(boolean delayed$Persistence,PartsListManager4Public This) throws PersistenceException {
        PersistentPartsListManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade
                .newDelayedPartsListManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade
                .newPartsListManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("currentComponents", this.getCurrentComponents().getValues().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public PartsListManager provideCopy() throws PersistenceException{
        PartsListManager result = this;
        result = new PartsListManager(this.This, 
                                      this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PartsListManager_CurrentComponentsProxi currentComponents;
    protected PersistentPartsListManager This;
    
    public PartsListManager(PersistentPartsListManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.currentComponents = new PartsListManager_CurrentComponentsProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 124;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 124) ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade
            .newPartsListManager(this.getId());
        super.store();
        this.getCurrentComponents().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PartsListManager_CurrentComponentsProxi getCurrentComponents() throws PersistenceException {
        return this.currentComponents;
    }
    protected void setThis(PersistentPartsListManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentPartsListManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentPartsListManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentPartsListManager result = (PersistentPartsListManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentPartsListManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePartsListManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePartsListManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePartsListManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePartsListManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if( this.getCurrentComponents().getValues().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void createMaterial(final String name, final common.Fraction price, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateMaterialCommand4Public command = model.meta.CreateMaterialCommand.createCreateMaterialCommand(name, price, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createProduct(final String name, final common.Fraction price, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateProductCommand4Public command = model.meta.CreateProductCommand.createCreateProductCommand(name, price, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentPartsListManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void clearComponents() 
				throws PersistenceException{
		getThis().getCurrentComponents().getValues().applyToAll(arg -> getThis().getCurrentComponents().remove(arg.getName()));
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void createMaterial(final String name, final common.Fraction price) 
				throws model.PartsListException, PersistenceException{
    	if (Component.getComponentByName(name).iterator().hasNext()) {
			throw new PartsListException("Komponente existiert bereits");
		}
		getThis().getCurrentComponents().put(name, Material.createMaterial(name, price)); 
    }
    public void createProduct(final String name, final common.Fraction price) 
				throws model.PartsListException, PersistenceException{
    	if (Component.getComponentByName(name).iterator().hasNext()) {
			throw new PartsListException("Komponente existiert bereits");
		}
		getThis().getCurrentComponents().put(name, Product.createProduct(name, price));
    }
    public void findComponents(final String name) 
				throws PersistenceException{
    	Component.getComponentByName(name).applyToAll(this::addIfNotExists);
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    private void addIfNotExists(Component4Public toBeAdded) throws PersistenceException {
    	if (getThis().getCurrentComponents().get(toBeAdded.getName()) == null) {
			getThis().getCurrentComponents().put(toBeAdded.getName(), toBeAdded);
		}
    }
    
    /* End of protected part that is not overridden by persistence generator */
    
}
