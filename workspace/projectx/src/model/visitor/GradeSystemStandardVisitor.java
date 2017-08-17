
package model.visitor;

import persistence.*;

public abstract class GradeSystemStandardVisitor implements GradeSystemVisitor {
    
    public void handleSimpleGrade(SimpleGrade4Public simpleGrade) throws PersistenceException{
        this.standardHandling(simpleGrade);
    }
    public void handleTenthGrade(TenthGrade4Public tenthGrade) throws PersistenceException{
        this.standardHandling(tenthGrade);
    }
    public void handleThirdGrade(ThirdGrade4Public thirdGrade) throws PersistenceException{
        this.standardHandling(thirdGrade);
    }
    protected abstract void standardHandling(GradeSystem4Public gradeSystem) throws PersistenceException;
}
