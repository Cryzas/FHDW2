
package model.visitor;
import persistence.*;

public interface StudyGroupManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleEndStudyGroupCommand(EndStudyGroupCommand4Public endStudyGroupCommand) throws PersistenceException, E;
    public R handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException, E;
    public R handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException, E;
    
}
