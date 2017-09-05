
package view.visitor;

import view.*;

public abstract class GradesInThirdStandardVisitor implements GradesInThirdVisitor {
    
    public void handleT_2_3(T_2_3View t_2_3) throws ModelException{
        this.standardHandling(t_2_3);
    }
    public void handleT_1_3(T_1_3View t_1_3) throws ModelException{
        this.standardHandling(t_1_3);
    }
    public void handleT_2_0(T_2_0View t_2_0) throws ModelException{
        this.standardHandling(t_2_0);
    }
    public void handleT_1_7(T_1_7View t_1_7) throws ModelException{
        this.standardHandling(t_1_7);
    }
    public void handleT_1_0(T_1_0View t_1_0) throws ModelException{
        this.standardHandling(t_1_0);
    }
    public void handleNoGradeThird(NoGradeThirdView noGradeThird) throws ModelException{
        this.standardHandling(noGradeThird);
    }
    protected abstract void standardHandling(GradesInThirdView gradesInThird) throws ModelException;
}
