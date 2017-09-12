package persistence;



import model.visitor.*;

public class StudyGroupManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentStudyGroupManager{
    
    public StudyGroupManagerICProxi(long objectId) {
        super(objectId);
    }
    public StudyGroupManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
            .getStudyGroupManager(this.getId());
    }
    
    public long getClassId() {
        return 186;
    }
    
    public StudyGroupManager_GroupsProxi getGroups() throws PersistenceException {
        return ((PersistentStudyGroupManager)this.getTheObject()).getGroups();
    }
    public PersistentStudyGroupManager getThis() throws PersistenceException {
        return ((PersistentStudyGroupManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupManager(this);
    }
    
    
    public void endStudyGroup(final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).endStudyGroup(studyGroup, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void startStudyGroup(final Program4Public program, final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).startStudyGroup(program, name, invoker);
    }
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints, invoker);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void endStudyGroup(final StudyGroup4Public studyGroup) 
				throws model.AlreadyFinishedException, PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).endStudyGroup(studyGroup);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void startStudyGroup(final Program4Public program, final String name) 
				throws model.UserException, PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).startStudyGroup(program, name);
    }
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws model.UnitSwapException, PersistenceException{
        ((PersistentStudyGroupManager)this.getTheObject()).swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints);
    }

    
}
