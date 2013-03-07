package com.pixelmaid.dresscode.antlr.types.tree.properties;

import com.pixelmaid.dresscode.antlr.types.VarType;
import com.pixelmaid.dresscode.antlr.types.tree.PropertyNode;
import com.pixelmaid.dresscode.drawing.primitive2d.Drawable;



public class RotationPropertyNode extends PropertyNode {


    
    public RotationPropertyNode(){
    
    }

    @Override
    public VarType evaluate() {
    	if(!(value.isDrawable())){
    		  throw new RuntimeException("Illegal width property access: " + this);
    	}
    	
    	Drawable d = value.asDrawable();
    	Double x = d.getRotation();
    	return new VarType(x);	
      
    }

   
}
