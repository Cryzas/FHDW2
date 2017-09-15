
package model.visitor;

import persistence.*;

public abstract class GradeDirectVisitor implements GradeVisitor {
    
    public abstract void handleGradesInSimpleOrThird(GradesInSimpleOrThird4Public gradesInSimpleOrThird) throws PersistenceException;
    
    public void handlePassed(Passed4Public passed) throws PersistenceException{
        this.handleGradesInSimpleOrThird(passed);
    }
    public void handleT_3_7(T_3_74Public t_3_7) throws PersistenceException{
        this.handleGradesInSimpleOrThird(t_3_7);
    }
    public void handleT_2_3(T_2_34Public t_2_3) throws PersistenceException{
        this.handleGradesInSimpleOrThird(t_2_3);
    }
    public void handleT_5_0(T_5_04Public t_5_0) throws PersistenceException{
        this.handleGradesInSimpleOrThird(t_5_0);
    }
    public void handleT_4_0(T_4_04Public t_4_0) throws PersistenceException{
        this.handleGradesInSimpleOrThird(t_4_0);
    }
    public void handleT_1_3(T_1_34Public t_1_3) throws PersistenceException{
        this.handleGradesInSimpleOrThird(t_1_3);
    }
    public void handleT_3_0(T_3_04Public t_3_0) throws PersistenceException{
        this.handleGradesInSimpleOrThird(t_3_0);
    }
    public void handleT_2_0(T_2_04Public t_2_0) throws PersistenceException{
        this.handleGradesInSimpleOrThird(t_2_0);
    }
    public void handleT_2_7(T_2_74Public t_2_7) throws PersistenceException{
        this.handleGradesInSimpleOrThird(t_2_7);
    }
    public void handleT_1_7(T_1_74Public t_1_7) throws PersistenceException{
        this.handleGradesInSimpleOrThird(t_1_7);
    }
    public void handleT_3_3(T_3_34Public t_3_3) throws PersistenceException{
        this.handleGradesInSimpleOrThird(t_3_3);
    }
    public void handleNoGrade(NoGrade4Public noGrade) throws PersistenceException{
        this.handleGradesInSimpleOrThird(noGrade);
    }
    public void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException{
        this.handleGradesInSimpleOrThird(notPassed);
    }
    public void handleT_1_0(T_1_04Public t_1_0) throws PersistenceException{
        this.handleGradesInSimpleOrThird(t_1_0);
    }
    public abstract void handleGradesInTenth(GradesInTenth4Public gradesInTenth) throws PersistenceException;
    
    public void handleZ_1_0(Z_1_04Public z_1_0) throws PersistenceException{
        this.handleGradesInTenth(z_1_0);
    }
    public void handleZ_1_1(Z_1_14Public z_1_1) throws PersistenceException{
        this.handleGradesInTenth(z_1_1);
    }
    public void handleZ_2_0(Z_2_04Public z_2_0) throws PersistenceException{
        this.handleGradesInTenth(z_2_0);
    }
    public void handleZ_3_0(Z_3_04Public z_3_0) throws PersistenceException{
        this.handleGradesInTenth(z_3_0);
    }
    public void handleZ_1_2(Z_1_24Public z_1_2) throws PersistenceException{
        this.handleGradesInTenth(z_1_2);
    }
    public void handleZ_2_1(Z_2_14Public z_2_1) throws PersistenceException{
        this.handleGradesInTenth(z_2_1);
    }
    public void handleZ_4_0(Z_4_04Public z_4_0) throws PersistenceException{
        this.handleGradesInTenth(z_4_0);
    }
    public void handleZ_2_2(Z_2_24Public z_2_2) throws PersistenceException{
        this.handleGradesInTenth(z_2_2);
    }
    public void handleZ_3_1(Z_3_14Public z_3_1) throws PersistenceException{
        this.handleGradesInTenth(z_3_1);
    }
    public void handleZ_1_3(Z_1_34Public z_1_3) throws PersistenceException{
        this.handleGradesInTenth(z_1_3);
    }
    public void handleZ_2_3(Z_2_34Public z_2_3) throws PersistenceException{
        this.handleGradesInTenth(z_2_3);
    }
    public void handleZ_5_0(Z_5_04Public z_5_0) throws PersistenceException{
        this.handleGradesInTenth(z_5_0);
    }
    public void handleZ_3_2(Z_3_24Public z_3_2) throws PersistenceException{
        this.handleGradesInTenth(z_3_2);
    }
    public void handleZ_1_4(Z_1_44Public z_1_4) throws PersistenceException{
        this.handleGradesInTenth(z_1_4);
    }
    public void handleZ_2_4(Z_2_44Public z_2_4) throws PersistenceException{
        this.handleGradesInTenth(z_2_4);
    }
    public void handleZ_3_3(Z_3_34Public z_3_3) throws PersistenceException{
        this.handleGradesInTenth(z_3_3);
    }
    public void handleZ_1_5(Z_1_54Public z_1_5) throws PersistenceException{
        this.handleGradesInTenth(z_1_5);
    }
    public void handleZ_2_5(Z_2_54Public z_2_5) throws PersistenceException{
        this.handleGradesInTenth(z_2_5);
    }
    public void handleZ_3_4(Z_3_44Public z_3_4) throws PersistenceException{
        this.handleGradesInTenth(z_3_4);
    }
    public void handleZ_1_6(Z_1_64Public z_1_6) throws PersistenceException{
        this.handleGradesInTenth(z_1_6);
    }
    public void handleZ_2_6(Z_2_64Public z_2_6) throws PersistenceException{
        this.handleGradesInTenth(z_2_6);
    }
    public void handleZ_3_5(Z_3_54Public z_3_5) throws PersistenceException{
        this.handleGradesInTenth(z_3_5);
    }
    public void handleZ_1_7(Z_1_74Public z_1_7) throws PersistenceException{
        this.handleGradesInTenth(z_1_7);
    }
    public void handleZ_2_7(Z_2_74Public z_2_7) throws PersistenceException{
        this.handleGradesInTenth(z_2_7);
    }
    public void handleZ_3_6(Z_3_64Public z_3_6) throws PersistenceException{
        this.handleGradesInTenth(z_3_6);
    }
    public void handleZ_1_8(Z_1_84Public z_1_8) throws PersistenceException{
        this.handleGradesInTenth(z_1_8);
    }
    public void handleZ_2_8(Z_2_84Public z_2_8) throws PersistenceException{
        this.handleGradesInTenth(z_2_8);
    }
    public void handleZ_3_7(Z_3_74Public z_3_7) throws PersistenceException{
        this.handleGradesInTenth(z_3_7);
    }
    public void handleZ_1_9(Z_1_94Public z_1_9) throws PersistenceException{
        this.handleGradesInTenth(z_1_9);
    }
    public void handleZ_2_9(Z_2_94Public z_2_9) throws PersistenceException{
        this.handleGradesInTenth(z_2_9);
    }
    public void handleZ_3_8(Z_3_84Public z_3_8) throws PersistenceException{
        this.handleGradesInTenth(z_3_8);
    }
    public void handleZ_3_9(Z_3_94Public z_3_9) throws PersistenceException{
        this.handleGradesInTenth(z_3_9);
    }
    
}
