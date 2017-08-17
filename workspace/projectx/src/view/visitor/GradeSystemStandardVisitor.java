
package view.visitor;

import view.*;

public abstract class GradeSystemStandardVisitor implements GradeSystemVisitor {
    
    public void handleSimpleGrade(SimpleGradeView simpleGrade) throws ModelException{
        this.standardHandling(simpleGrade);
    }
    public void handleTenthGrade(TenthGradeView tenthGrade) throws ModelException{
        this.standardHandling(tenthGrade);
    }
    public void handleThirdGrade(ThirdGradeView thirdGrade) throws ModelException{
        this.standardHandling(thirdGrade);
    }
    protected abstract void standardHandling(GradeSystemView gradeSystem) throws ModelException;
}
