
package model.visitor;

import persistence.*;

public abstract class GradesInSimpleOrThirdStandardVisitor implements GradesInSimpleOrThirdVisitor {
    
    public void handlePassed(Passed4Public passed) throws PersistenceException{
        this.standardHandling(passed);
    }
    public void handleNoGradeSimple(NoGradeSimple4Public noGradeSimple) throws PersistenceException{
        this.standardHandling(noGradeSimple);
    }
    public void handleT_3_7(T_3_74Public t_3_7) throws PersistenceException{
        this.standardHandling(t_3_7);
    }
    public void handleT_2_3(T_2_34Public t_2_3) throws PersistenceException{
        this.standardHandling(t_2_3);
    }
    public void handleT_5_0(T_5_04Public t_5_0) throws PersistenceException{
        this.standardHandling(t_5_0);
    }
    public void handleT_4_0(T_4_04Public t_4_0) throws PersistenceException{
        this.standardHandling(t_4_0);
    }
    public void handleT_1_3(T_1_34Public t_1_3) throws PersistenceException{
        this.standardHandling(t_1_3);
    }
    public void handleT_3_0(T_3_04Public t_3_0) throws PersistenceException{
        this.standardHandling(t_3_0);
    }
    public void handleT_2_0(T_2_04Public t_2_0) throws PersistenceException{
        this.standardHandling(t_2_0);
    }
    public void handleT_2_7(T_2_74Public t_2_7) throws PersistenceException{
        this.standardHandling(t_2_7);
    }
    public void handleT_1_7(T_1_74Public t_1_7) throws PersistenceException{
        this.standardHandling(t_1_7);
    }
    public void handleT_3_3(T_3_34Public t_3_3) throws PersistenceException{
        this.standardHandling(t_3_3);
    }
    public void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException{
        this.standardHandling(notPassed);
    }
    public void handleT_1_0(T_1_04Public t_1_0) throws PersistenceException{
        this.standardHandling(t_1_0);
    }
    public void handleNoGradeThird(NoGradeThird4Public noGradeThird) throws PersistenceException{
        this.standardHandling(noGradeThird);
    }
    protected abstract void standardHandling(GradesInSimpleOrThird4Public gradesInSimpleOrThird) throws PersistenceException;
}
