
package model.visitor;

import persistence.*;

public abstract class GradesInThirdStandardVisitor implements GradesInThirdVisitor {
    
    public void handleT_2_3(T_2_34Public t_2_3) throws PersistenceException{
        this.standardHandling(t_2_3);
    }
    public void handleT_1_3(T_1_34Public t_1_3) throws PersistenceException{
        this.standardHandling(t_1_3);
    }
    public void handleT_2_0(T_2_04Public t_2_0) throws PersistenceException{
        this.standardHandling(t_2_0);
    }
    public void handleT_1_7(T_1_74Public t_1_7) throws PersistenceException{
        this.standardHandling(t_1_7);
    }
    public void handleT_1_0(T_1_04Public t_1_0) throws PersistenceException{
        this.standardHandling(t_1_0);
    }
    public void handleNoGradeThird(NoGradeThird4Public noGradeThird) throws PersistenceException{
        this.standardHandling(noGradeThird);
    }
    protected abstract void standardHandling(GradesInThird4Public gradesInThird) throws PersistenceException;
}
