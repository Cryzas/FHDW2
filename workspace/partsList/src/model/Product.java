
package model;

import persistence.*;

import model.visitor.*;


/* Additional import section end */

public class Product extends model.Component implements PersistentProduct{
    
    
    public static Product4Public createProduct(String name,common.Fraction price) throws PersistenceException{
        return createProduct(name,price,false);
    }
    
    public static Product4Public createProduct(String name,common.Fraction price,boolean delayed$Persistence) throws PersistenceException {
        PersistentProduct result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProductFacade
                .newDelayedProduct(name,price);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProductFacade
                .newProduct(name,price,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("price", price);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Product4Public createProduct(String name,common.Fraction price,boolean delayed$Persistence,Product4Public This) throws PersistenceException {
        PersistentProduct result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProductFacade
                .newDelayedProduct(name,price);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProductFacade
                .newProduct(name,price,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("price", price);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot components = (AbstractPersistentRoot)this.getComponents();
            if (components != null) {
                result.put("components", components.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    components.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && components.hasEssentialFields())components.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Product provideCopy() throws PersistenceException{
        Product result = this;
        result = new Product(this.name, 
                             this.price, 
                             this.This, 
                             this.components, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentComponentLst components;
    
    public Product(String name,common.Fraction price,PersistentComponent This,PersistentComponentLst components,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(common.Fraction)price,(PersistentComponent)This,id);
        this.components = components;        
    }
    
    static public long getTypeId() {
        return 115;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 115) ConnectionHandler.getTheConnectionHandler().theProductFacade
            .newProduct(name,price,this.getId());
        super.store();
        if(this.getComponents() != null){
            this.getComponents().store();
            ConnectionHandler.getTheConnectionHandler().theProductFacade.componentsSet(this.getId(), getComponents());
        }
        
    }
    
    public ComponentLst4Public getComponents() throws PersistenceException {
        return this.components;
    }
    public void setComponents(ComponentLst4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.components)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.components = (PersistentComponentLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProductFacade.componentsSet(this.getId(), newValue);
        }
    }
    public PersistentProduct getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProduct result = (PersistentProduct)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentProduct)this.This;
    }
    
    public void accept(ComponentVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends model.UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends model.UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getComponents() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentProduct)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setPrice((common.Fraction)final$$Fields.get("price"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addPart(final Component4Public component, final long quantity) 
				throws model.PartsListException, PersistenceException{
    	if (component.contains(getThis())) {
    		throw new PartsListException("GEHT NICHT WEIL ZYKLISCH!!!");
		}
    	getThis().getComponents().addPart(component, quantity);        
    }
    public boolean contains(final Component4Public component) 
				throws PersistenceException{
    	if (getThis().equals(component)) {
			return true;
		}
        return getThis().getComponents().contains(component);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{        
    }
    public ComponentLst4Public fetchMaterials() 
				throws PersistenceException{
        return getThis().getComponents().fetchMaterials();
    }
    public common.Fraction fetchOverallPrice() 
				throws PersistenceException{
        return getThis().getComponents().fetchOverallPrice().add(getThis().getPrice());
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
		getThis().setComponents(ComponentLst.createComponentLst());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
