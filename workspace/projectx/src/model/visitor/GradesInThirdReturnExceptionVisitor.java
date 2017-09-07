
package model.visitor;
import persistence.*;

public interface GradesInThirdReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleNoGrade(NoGrade4Public noGrade) throws PersistenceException, E;
    public R handleT_1_0(T_1_04Public t_1_0) throws PersistenceException, E;
    public R handleT_1_3(T_1_34Public t_1_3) throws PersistenceException, E;
    public R handleT_1_7(T_1_74Public t_1_7) throws PersistenceException, E;
    public R handleT_2_0(T_2_04Public t_2_0) throws PersistenceException, E;
    public R handleT_2_3(T_2_34Public t_2_3) throws PersistenceException, E;
    public R handleT_2_7(T_2_74Public t_2_7) throws PersistenceException, E;
    public R handleT_3_0(T_3_04Public t_3_0) throws PersistenceException, E;
    public R handleT_3_3(T_3_34Public t_3_3) throws PersistenceException, E;
    public R handleT_3_7(T_3_74Public t_3_7) throws PersistenceException, E;
    public R handleT_4_0(T_4_04Public t_4_0) throws PersistenceException, E;
    public R handleT_5_0(T_5_04Public t_5_0) throws PersistenceException, E;
    
}
