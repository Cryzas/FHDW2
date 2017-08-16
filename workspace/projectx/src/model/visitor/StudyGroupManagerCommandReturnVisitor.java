
package model.visitor;
import persistence.*;

public interface StudyGroupManagerCommandReturnVisitor<R> {
    
    public R handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException;
    public R handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException;
    
}
