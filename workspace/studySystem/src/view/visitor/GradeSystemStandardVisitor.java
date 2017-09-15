
package view.visitor;

import view.*;

public abstract class GradeSystemStandardVisitor implements GradeSystemVisitor {
    
    public void handleSimpleGradeSystem(SimpleGradeSystemView simpleGradeSystem) throws ModelException{
        this.standardHandling(simpleGradeSystem);
    }
    public void handleThirdGradeSystem(ThirdGradeSystemView thirdGradeSystem) throws ModelException{
        this.standardHandling(thirdGradeSystem);
    }
    protected abstract void standardHandling(GradeSystemView gradeSystem) throws ModelException;
}
