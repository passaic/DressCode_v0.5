package com.pixelmaid.dresscode.antlr.types.tree.functions.transforms;

import java.util.List;

import com.pixelmaid.dresscode.antlr.types.VarType;
import com.pixelmaid.dresscode.antlr.types.tree.DCNode;
import com.pixelmaid.dresscode.app.Manager;
import com.pixelmaid.dresscode.drawing.primitive2d.Color;
import com.pixelmaid.dresscode.drawing.primitive2d.Drawable;
import com.pixelmaid.dresscode.drawing.primitive2d.PrimitiveInterface;


public class NoStrokeNode implements DCNode {

	protected DCNode param;

    protected int line;


    
    public NoStrokeNode(DCNode p, int l) {
        param = p;
        line = l;
       
    }

    @Override
    public VarType evaluate() {
    	Drawable d;
    	
    	try{
    		
    	d= (param.evaluate().asDrawable());
    	d.doStroke(false);
    	return new VarType(d);
    	}
    	catch (ClassCastException e){
    		throw new RuntimeException("Illegal noStroke function call at line:"+ line+" : " + this);
    	}
    }

   
}