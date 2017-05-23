package view.objects;


/* Additional import section end */

public class ReceiversMailWrapper extends AssociationInTreeWrapper {

	public ReceiversMailWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
    	 return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
    	return "Receiver: " + this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
