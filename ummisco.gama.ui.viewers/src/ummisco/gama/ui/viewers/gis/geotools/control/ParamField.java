/*********************************************************************************************
 *
 * 'ParamField.java, in plugin ummisco.gama.ui.viewers, is part of the source code of the
 * GAMA modeling and simulation platform.
 * (c) 2007-2016 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 * 
 *
 **********************************************************************************************/
package ummisco.gama.ui.viewers.gis.geotools.control;

import java.io.File;
import java.net.URL;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.geotools.data.Parameter;

import com.vividsolutions.jts.geom.Geometry;

/**
 * Super class that provides additional helper methods useful when implementing your own
 * ParamWidget.
 * 
 * @author gdavis
 *
 *
 *
 *
 * @source $URL$
 */
public abstract class ParamField {

    protected Parameter< ? > parameter;
    protected Composite parent;

    /**
     * Holds on to the parameter so implementations can consult the type and metadata information.
     * 
     * @param parameter
     */
    ParamField( Composite parent, Parameter< ? > parameter ) {
        this.parent = parent;
        this.parameter = parameter;
    }

    /**
     * Called to build the widget, initialize it (setting defaults or whatever) and setup any
     * listeners needed for validation of the widget value. The returned JComponent will contain the
     * widget for editing.
     * 
     * @return JComponent or null if error
     */
    abstract public Control doLayout();

    /**
     * Validates the current value of the widget, returns false if not valid, true otherwise
     * 
     * @return boolean if validated
     */
    abstract public boolean validate();

    /**
     * Sets the value of the widget.
     * 
     * @param Object
     *            an object containing the value to set for the widget
     */
    abstract public void setValue( Object value );

    /**
     * Returns the current value of the widget.
     * 
     * @return Object representing the current value of the widget
     */
    abstract public Object getValue();

    /**
     * Factory method creating the appropriate ParamField for the supplied Param.
     * 
     * @param param
     * @return
     */
    public static ParamField create( Composite parent, Parameter< ? > parameter ) {
        if (Double.class.isAssignableFrom(parameter.type)) {
            return new JDoubleField(parent, parameter);
        } else if (URL.class.isAssignableFrom(parameter.type)) {
            if (parameter.metadata != null && parameter.metadata.get(Parameter.EXT) != null) {
                return new JURLField(parent, parameter);
            } else {
                JField field = new JField(parent, parameter);
                field.setSingleLine(true);
                return field;
            }
        } else if (Boolean.class.isAssignableFrom(parameter.type)) {
            JField field = new JField(parent, parameter);
            field.setSingleLine(true);
            return field;
        } else if (Number.class.isAssignableFrom(parameter.type)) {
            JField field = new JField(parent, parameter);
            field.setSingleLine(true);
            return field;
        } else if (File.class.isAssignableFrom(parameter.type)) {
            return new JFileField(parent, parameter);
        } else if (Geometry.class.isAssignableFrom(parameter.type)) {
            return new JGeometryField(parent, parameter);
        } else {
            // We got nothing special hope the converter api can deal
            return new JField(parent, parameter);
        }
    }

}
