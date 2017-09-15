
package model.visitor;

import persistence.*;

public abstract class StudyGroupManagerCommandStandardVisitor implements StudyGroupManagerCommandVisitor {
    
    public void handleEndStudyGroupCommand(EndStudyGroupCommand4Public endStudyGroupCommand) throws PersistenceException{
        this.standardHandling(endStudyGroupCommand);
    }
    public void handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException{
        this.standardHandling(swapCPonModuleWithUnitsCommand);
    }
    public void handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException{
        this.standardHandling(startStudyGroupCommand);
    }
    protected abstract void standardHandling(StudyGroupManagerCommand studyGroupManagerCommand) throws PersistenceException;
}
