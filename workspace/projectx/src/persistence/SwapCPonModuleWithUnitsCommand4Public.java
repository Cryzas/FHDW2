package persistence;


import model.visitor.*;

public interface SwapCPonModuleWithUnitsCommand4Public extends StudyGroupManagerCommand, Anything, CommonDate4Public, AbstractPersistentProxi {
    
    public ModuleWithUnitsSGroup4Public getModule() throws PersistenceException ;
    public void setModule(ModuleWithUnitsSGroup4Public newValue) throws PersistenceException ;
    public UnitSGroup4Public getFromUnit() throws PersistenceException ;
    public void setFromUnit(UnitSGroup4Public newValue) throws PersistenceException ;
    public UnitSGroup4Public getToUnit() throws PersistenceException ;
    public void setToUnit(UnitSGroup4Public newValue) throws PersistenceException ;
    public common.Fraction getCreditPoints() throws PersistenceException ;
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException ;
    public Invoker getInvoker() throws PersistenceException ;
    public void setInvoker(Invoker newValue) throws PersistenceException ;
    public StudyGroupManager4Public getCommandReceiver() throws PersistenceException ;
    public void setCommandReceiver(StudyGroupManager4Public newValue) throws PersistenceException ;
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException;
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(StudyGroupManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(StudyGroupManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(StudyGroupManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(StudyGroupManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(CommandVisitor visitor) throws PersistenceException;
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void checkException() 
				throws model.UserException, PersistenceException;
    public void execute() 
				throws PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;
    public void sendResult() 
				throws PersistenceException;

}

