
package model.visitor;
import persistence.*;

public interface GradesInThirdReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleNoGradeThird(NoGradeThird4Public noGradeThird) throws PersistenceException, E;
    public R handleT_1_0(T_1_04Public t_1_0) throws PersistenceException, E;
    public R handleT_1_3(T_1_34Public t_1_3) throws PersistenceException, E;
    public R handleT_1_7(T_1_74Public t_1_7) throws PersistenceException, E;
    public R handleT_2_0(T_2_04Public t_2_0) throws PersistenceException, E;
    public R handleT_2_3(T_2_34Public t_2_3) throws PersistenceException, E;
    
}
