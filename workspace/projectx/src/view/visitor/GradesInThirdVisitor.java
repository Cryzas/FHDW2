
package view.visitor;
import view.*;

public interface GradesInThirdVisitor {
    
    public void handleNoGradeThird(NoGradeThirdView noGradeThird) throws ModelException;
    public void handleT_1_0(T_1_0View t_1_0) throws ModelException;
    public void handleT_1_3(T_1_3View t_1_3) throws ModelException;
    public void handleT_1_7(T_1_7View t_1_7) throws ModelException;
    public void handleT_2_0(T_2_0View t_2_0) throws ModelException;
    public void handleT_2_3(T_2_3View t_2_3) throws ModelException;
    
}
