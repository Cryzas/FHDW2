
package view.visitor;

import view.*;

public abstract class GradesInSimpleOrThirdStandardVisitor implements GradesInSimpleOrThirdVisitor {
    
    public void handlePassed(PassedView passed) throws ModelException{
        this.standardHandling(passed);
    }
    public void handleT_3_7(T_3_7View t_3_7) throws ModelException{
        this.standardHandling(t_3_7);
    }
    public void handleT_2_3(T_2_3View t_2_3) throws ModelException{
        this.standardHandling(t_2_3);
    }
    public void handleT_5_0(T_5_0View t_5_0) throws ModelException{
        this.standardHandling(t_5_0);
    }
    public void handleT_4_0(T_4_0View t_4_0) throws ModelException{
        this.standardHandling(t_4_0);
    }
    public void handleT_1_3(T_1_3View t_1_3) throws ModelException{
        this.standardHandling(t_1_3);
    }
    public void handleT_3_0(T_3_0View t_3_0) throws ModelException{
        this.standardHandling(t_3_0);
    }
    public void handleT_2_0(T_2_0View t_2_0) throws ModelException{
        this.standardHandling(t_2_0);
    }
    public void handleT_2_7(T_2_7View t_2_7) throws ModelException{
        this.standardHandling(t_2_7);
    }
    public void handleT_1_7(T_1_7View t_1_7) throws ModelException{
        this.standardHandling(t_1_7);
    }
    public void handleT_3_3(T_3_3View t_3_3) throws ModelException{
        this.standardHandling(t_3_3);
    }
    public void handleNoGrade(NoGradeView noGrade) throws ModelException{
        this.standardHandling(noGrade);
    }
    public void handleNotPassed(NotPassedView notPassed) throws ModelException{
        this.standardHandling(notPassed);
    }
    public void handleT_1_0(T_1_0View t_1_0) throws ModelException{
        this.standardHandling(t_1_0);
    }
    protected abstract void standardHandling(GradesInSimpleOrThirdView gradesInSimpleOrThird) throws ModelException;
}
