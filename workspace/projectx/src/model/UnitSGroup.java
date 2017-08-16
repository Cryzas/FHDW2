
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class UnitSGroup extends PersistentObject implements PersistentUnitSGroup{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static UnitSGroup4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade.getClass(objectId);
        return (UnitSGroup4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static UnitSGroup4Public createUnitSGroup(String name,common.Fraction creditPoints) throws PersistenceException{
        return createUnitSGroup(name,creditPoints,false);
    }
    
    public static UnitSGroup4Public createUnitSGroup(String name,common.Fraction creditPoints,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentUnitSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade
                .newDelayedUnitSGroup(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade
                .newUnitSGroup(name,creditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("creditPoints", creditPoints);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static UnitSGroup4Public createUnitSGroup(String name,common.Fraction creditPoints,boolean delayed$Persistence,UnitSGroup4Public This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentUnitSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade
                .newDelayedUnitSGroup(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade
                .newUnitSGroup(name,creditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("creditPoints", creditPoints);
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
            result.put("name", this.getName());
            result.put("creditPoints", this.getCreditPoints().toString());
        }
        return result;
    }
    
    public UnitSGroup provideCopy() throws PersistenceException{
        UnitSGroup result = this;
        result = new UnitSGroup(this.name, 
                                this.creditPoints, 
                                this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected common.Fraction creditPoints;
    protected PersistentUnitSGroup This;
    
    public UnitSGroup(String name,common.Fraction creditPoints,PersistentUnitSGroup This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.creditPoints = creditPoints;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 181;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 181) ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade
            .newUnitSGroup(name,creditPoints,this.getId());
        super.store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public common.Fraction getCreditPoints() throws PersistenceException {
        return this.creditPoints;
    }
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade.creditPointsSet(this.getId(), newValue);
        this.creditPoints = newValue;
    }
    protected void setThis(PersistentUnitSGroup newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentUnitSGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theUnitSGroupFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentUnitSGroup getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUnitSGroup result = (PersistentUnitSGroup)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentUnitSGroup)this.This;
    }
    
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleUnitSGroup(this);
    }
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitSGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitSGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitSGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitSGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitSGroup(this);
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
        this.setThis((PersistentUnitSGroup)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setCreditPoints((common.Fraction)final$$Fields.get("creditPoints"));
		}
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result = strategy.UnitSGroup$$finalize(getThis() );
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addCP(final common.Fraction creditPoints) 
				throws PersistenceException{
    	getThis().setCreditPoints(getThis().getCreditPoints().add(creditPoints));
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void subCP(final common.Fraction creditPoints) 
				throws model.StudyProgramException, PersistenceException{
    	if(getThis().getCreditPoints().add(creditPoints.mul(Fraction.parse("-1"))).lessOrEquals(Fraction.Null))
    		throw new StudyProgramException(CreditPointsUnderNullMessage);
    	getThis().setCreditPoints(getThis().getCreditPoints().add(creditPoints.mul(Fraction.parse("-1"))));
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    static String CreditPointsUnderNullMessage = "Units müssen mehr als Null Creditpoints haben.";
    /* End of protected part that is not overridden by persistence generator */
    
}
