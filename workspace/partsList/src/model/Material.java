
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Material extends model.Component implements PersistentMaterial{
    
    
    public static Material4Public createMaterial(String name,common.Fraction price) throws PersistenceException{
        return createMaterial(name,price,false);
    }
    
    public static Material4Public createMaterial(String name,common.Fraction price,boolean delayed$Persistence) throws PersistenceException {
        PersistentMaterial result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMaterialFacade
                .newDelayedMaterial(name,price);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMaterialFacade
                .newMaterial(name,price,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("price", price);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Material4Public createMaterial(String name,common.Fraction price,boolean delayed$Persistence,Material4Public This) throws PersistenceException {
        PersistentMaterial result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMaterialFacade
                .newDelayedMaterial(name,price);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMaterialFacade
                .newMaterial(name,price,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("price", price);
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
    
    public Material provideCopy() throws PersistenceException{
        Material result = this;
        result = new Material(this.name, 
                              this.price, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Material(String name,common.Fraction price,PersistentComponent This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(common.Fraction)price,(PersistentComponent)This,id);        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 116) ConnectionHandler.getTheConnectionHandler().theMaterialFacade
            .newMaterial(name,price,this.getId());
        super.store();
        
    }
    
    public PersistentMaterial getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMaterial result = (PersistentMaterial)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentMaterial)this.This;
    }
    
    public void accept(ComponentVisitor visitor) throws PersistenceException {
        visitor.handleMaterial(this);
    }
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMaterial(this);
    }
    public <E extends model.UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMaterial(this);
    }
    public <R, E extends model.UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMaterial(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMaterial(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMaterial(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMaterial(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMaterial(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMaterial)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setPrice((common.Fraction)final$$Fields.get("price"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public boolean contains(final Component4Public component) 
				throws PersistenceException{
        if (getThis().equals(component)) {
			return true;
		}
        return false;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public ComponentLst4Public fetchMaterials() 
				throws PersistenceException{
    	ComponentLst4Public list = ComponentLst.createComponentLst(true);
    	list.addPart(getThis(), 1);
    	return list;
    }
    public common.Fraction fetchOverallPrice() 
				throws PersistenceException{
        return getThis().getPrice();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
