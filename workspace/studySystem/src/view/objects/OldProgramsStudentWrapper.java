package view.objects;

import common.Fraction;
import view.ModelException;

/* Additional import section end */

public class OldProgramsStudentWrapper extends AssociationInTreeWrapper {

	public OldProgramsStudentWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
		try {
			ProgramStudent program = (ProgramStudent)this.getWrappedObject().getTheObject();
			if(program.getPassedCP().equals(Fraction.Null)){
				this.getWrappedObject().setIconInfo(5);
			} else if (program.getPassedCP().equals(program.getCreditPoints())) {
				this.getWrappedObject().setIconInfo(3);
			} else {
				this.getWrappedObject().setIconInfo(4);
			}
		} catch (ModelException e) {
			e.printStackTrace();
		}
    	 return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
    	return "[Abgeschlossen] " + this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
