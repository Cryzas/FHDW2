
package model.visitor;
import persistence.*;

public interface StudyGroupManagerCommandReturnVisitor<R> {
    
    public R handleEndStudyGroupCommand(EndStudyGroupCommand4Public endStudyGroupCommand) throws PersistenceException;
    public R handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException;
    public R handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException;
    
}
