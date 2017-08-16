
package model.visitor;
import persistence.*;

public interface StudyGroupManagerCommandVisitor {
    
    public void handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException;
    public void handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException;
    
}
