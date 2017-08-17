
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Unit extends PersistentObject implements PersistentUnit{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Unit4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theUnitFacade.getClass(objectId);
        return (Unit4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Unit4Public createUnit(String name,common.Fraction creditPoints) throws PersistenceException{
        return createUnit(name,creditPoints,false);
    }
    
    public static Unit4Public createUnit(String name,common.Fraction creditPoints,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newDelayedUnit(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newUnit(name,creditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("creditPoints", creditPoints);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Unit4Public createUnit(String name,common.Fraction creditPoints,boolean delayed$Persistence,Unit4Public This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newDelayedUnit(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newUnit(name,creditPoints,-1);
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
            AbstractPersistentRoot gradeSystem = (AbstractPersistentRoot)this.getGradeSystem();
            if (gradeSystem != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    gradeSystem, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("gradeSystem", proxiInformation);
                
            }
        }
        return result;
    }
    
    public Unit provideCopy() throws PersistenceException{
        Unit result = this;
        result = new Unit(this.name, 
                          this.creditPoints, 
                          this.gradeSystem, 
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
    protected PersistentGradeSystem gradeSystem;
    protected PersistentUnit This;
    
    public Unit(String name,common.Fraction creditPoints,PersistentGradeSystem gradeSystem,PersistentUnit This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.creditPoints = creditPoints;
        this.gradeSystem = gradeSystem;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 147;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 147) ConnectionHandler.getTheConnectionHandler().theUnitFacade
            .newUnit(name,creditPoints,this.getId());
        super.store();
        if(this.getGradeSystem() != null){
            this.getGradeSystem().store();
            ConnectionHandler.getTheConnectionHandler().theUnitFacade.gradeSystemSet(this.getId(), getGradeSystem());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theUnitFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theUnitFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public common.Fraction getCreditPoints() throws PersistenceException {
        return this.creditPoints;
    }
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theUnitFacade.creditPointsSet(this.getId(), newValue);
        this.creditPoints = newValue;
    }
    public GradeSystem4Public getGradeSystem() throws PersistenceException {
        return this.gradeSystem;
    }
    public void setGradeSystem(GradeSystem4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.gradeSystem)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.gradeSystem = (PersistentGradeSystem)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theUnitFacade.gradeSystemSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theUnitFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentUnit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUnit result = (PersistentUnit)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentUnit)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public void accept(programHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(programHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public boolean containsprogramHierarchy(final programHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentUnit)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setCreditPoints((common.Fraction)final$$Fields.get("creditPoints"));
		}
    }
    public <T> T strategyprogramHierarchy(final programHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result = strategy.Unit$$finalize(getThis() );
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void changeCPOnUnit(final common.Fraction creditPoints) 
				throws PersistenceException{
        getThis().setCreditPoints(creditPoints);
    }
    public UnitSGroup4Public copyForStudyGroup() 
				throws model.UserException, PersistenceException{
        return UnitSGroup.createUnitSGroup(getThis(), getThis().getCreditPoints());
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    	getThis().setGradeSystem(ThirdGrade.getTheThirdGrade());
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
