
package model.visitor;

import persistence.*;

public abstract class GradeSystemStandardVisitor implements GradeSystemVisitor {
    
    public void handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGradeSystem) throws PersistenceException{
        this.standardHandling(simpleGradeSystem);
    }
    public void handleThirdGradeSystem(ThirdGradeSystem4Public thirdGradeSystem) throws PersistenceException{
        this.standardHandling(thirdGradeSystem);
    }
    protected abstract void standardHandling(GradeSystem4Public gradeSystem) throws PersistenceException;
}
