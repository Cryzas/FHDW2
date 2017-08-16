
package model.visitor;
import persistence.*;

public interface StudyGroupManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException, E;
    public void handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException, E;
    
}
