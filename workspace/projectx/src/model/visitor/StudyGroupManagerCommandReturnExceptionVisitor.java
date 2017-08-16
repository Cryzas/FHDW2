
package model.visitor;
import persistence.*;

public interface StudyGroupManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException, E;
    public R handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException, E;
    
}
