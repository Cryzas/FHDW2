package persistence;



import model.visitor.*;

public class StudyGroupProxi extends PersistentProxi implements PersistentStudyGroup{
    
    public StudyGroupProxi(long objectId) {
        super(objectId);
    }
    public StudyGroupProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 180;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentStudyGroup)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentStudyGroup)this.getTheObject()).setName(newValue);
    }
    public ProgramSGroup4Public getProgram() throws PersistenceException {
        return ((PersistentStudyGroup)this.getTheObject()).getProgram();
    }
    public void setProgram(ProgramSGroup4Public newValue) throws PersistenceException {
        ((PersistentStudyGroup)this.getTheObject()).setProgram(newValue);
    }
    public StudyGroup_StudentsProxi getStudents() throws PersistenceException {
        return ((PersistentStudyGroup)this.getTheObject()).getStudents();
    }
    public MyBoolean4Public getFinished() throws PersistenceException {
        return ((PersistentStudyGroup)this.getTheObject()).getFinished();
    }
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException {
        ((PersistentStudyGroup)this.getTheObject()).setFinished(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentStudyGroup)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentStudyGroup)this.getTheObject()).setSubService(newValue);
    }
    public PersistentStudyGroup getThis() throws PersistenceException {
        return ((PersistentStudyGroup)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroup(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroup(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroup(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroup(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroup(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).updateObservers(event);
    }
    public void addStudent(final Student4Public student) 
				throws model.AlreadyExistsInParentException, PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).addStudent(student);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void endStudyGroup() 
				throws model.AlreadyFinishedException, PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).endStudyGroup();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).initializeOnInstantiation();
    }

    
}
