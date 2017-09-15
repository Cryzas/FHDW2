package view.objects;

/* Additional import section end */

public class OldProgramsStudentWrapper extends AssociationInTreeWrapper {

	public OldProgramsStudentWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
    	return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
    	return "[Abgeschlossen] " + this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
