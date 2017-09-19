
package model;

import persistence.*;

import model.visitor.*;


/* Additional import section end */

public class Student extends PersistentObject implements PersistentStudent{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Student4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theStudentFacade.getClass(objectId);
        return (Student4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Student4Public createStudent(String firstName,String lastName,java.sql.Date birthDate) throws PersistenceException{
        return createStudent(firstName,lastName,birthDate,false);
    }
    
    public static Student4Public createStudent(String firstName,String lastName,java.sql.Date birthDate,boolean delayed$Persistence) throws PersistenceException {
        if (firstName == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (lastName == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudentFacade
                .newDelayedStudent(firstName,lastName,birthDate);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudentFacade
                .newStudent(firstName,lastName,birthDate,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("firstName", firstName);
        final$$Fields.put("lastName", lastName);
        final$$Fields.put("birthDate", birthDate);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Student4Public createStudent(String firstName,String lastName,java.sql.Date birthDate,boolean delayed$Persistence,Student4Public This) throws PersistenceException {
        if (firstName == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (lastName == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudentFacade
                .newDelayedStudent(firstName,lastName,birthDate);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudentFacade
                .newStudent(firstName,lastName,birthDate,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("firstName", firstName);
        final$$Fields.put("lastName", lastName);
        final$$Fields.put("birthDate", birthDate);
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
            result.put("firstName", this.getFirstName());
            result.put("lastName", this.getLastName());
            result.put("birthDate", this.getBirthDate());
            result.put("matrNr", new Long(this.getMatrNr()).toString());
            AbstractPersistentRoot program = (AbstractPersistentRoot)this.getProgram();
            if (program != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    program, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("program", proxiInformation);
                
            }
            result.put("oldPrograms", this.getOldPrograms().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
            result.put("parentGroup", this.getParentGroup().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public Student provideCopy() throws PersistenceException{
        Student result = this;
        result = new Student(this.firstName, 
                             this.lastName, 
                             this.birthDate, 
                             this.program, 
                             this.subService, 
                             this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String firstName;
    protected String lastName;
    protected java.sql.Date birthDate;
    protected PersistentProgramStudent program;
    protected Student_OldProgramsProxi oldPrograms;
    protected SubjInterface subService;
    protected PersistentStudent This;
    
    public Student(String firstName,String lastName,java.sql.Date birthDate,PersistentProgramStudent program,SubjInterface subService,PersistentStudent This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.program = program;
        this.oldPrograms = new Student_OldProgramsProxi(this);
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 195;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 195) ConnectionHandler.getTheConnectionHandler().theStudentFacade
            .newStudent(firstName,lastName,birthDate,this.getId());
        super.store();
        if(this.getProgram() != null){
            this.getProgram().store();
            ConnectionHandler.getTheConnectionHandler().theStudentFacade.programSet(this.getId(), getProgram());
        }
        this.getOldPrograms().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theStudentFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theStudentFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getFirstName() throws PersistenceException {
        return this.firstName;
    }
    public void setFirstName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theStudentFacade.firstNameSet(this.getId(), newValue);
        this.firstName = newValue;
    }
    public String getLastName() throws PersistenceException {
        return this.lastName;
    }
    public void setLastName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theStudentFacade.lastNameSet(this.getId(), newValue);
        this.lastName = newValue;
    }
    public java.sql.Date getBirthDate() throws PersistenceException {
        return this.birthDate;
    }
    public void setBirthDate(java.sql.Date newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theStudentFacade.birthDateSet(this.getId(), newValue);
        this.birthDate = newValue;
    }
    public ProgramStudent4Public getProgram() throws PersistenceException {
        return this.program;
    }
    public void setProgram(ProgramStudent4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.program)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.program = (PersistentProgramStudent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudentFacade.programSet(this.getId(), newValue);
        }
    }
    public Student_OldProgramsProxi getOldPrograms() throws PersistenceException {
        return this.oldPrograms;
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudentFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentStudent newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentStudent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudentFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentStudent getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudent result = (PersistentStudent)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudent)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudent(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleStudent(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudent(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudent(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudent(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getProgram() != null) return 1;
        if (this.getOldPrograms().getLength() > 0) return 1;
        return 0;
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
    public StudyGroupSearchList getParentGroup() 
				throws PersistenceException{
        StudyGroupSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
										.inverseGetStudents(getThis().getId(), getThis().getClassId());
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentStudent)This);
		if(this.isTheSameAs(This)){
			this.setFirstName((String)final$$Fields.get("firstName"));
			this.setLastName((String)final$$Fields.get("lastName"));
			this.setBirthDate((java.sql.Date)final$$Fields.get("birthDate"));
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
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public long getMatrNr() 
				throws PersistenceException{
        return getThis().getId();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setProgram(NoProgram.getTheNoProgram());
    	int year = getThis().getBirthDate().toLocalDate().getYear();
    	int month = getThis().getBirthDate().toLocalDate().getMonthValue();
    	int day = getThis().getBirthDate().toLocalDate().getDayOfMonth();
    	String yearS = String.valueOf(year);
    	String monthS = String.valueOf(month);
    	String dayS = String.valueOf(day);
    	if (month < 10) monthS = "0" + monthS;
    	if (day < 10) dayS = "0" + dayS;
    	String pw = yearS + monthS + dayS;
    	Server.createServer(pw, String.valueOf(getThis().getMatrNr()), 0, new java.sql.Timestamp(0));
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
