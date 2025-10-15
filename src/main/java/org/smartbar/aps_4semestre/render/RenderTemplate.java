package org.smartbar.aps_4semestre.render;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RenderTemplate {

    public ModelAndView getModel (String fileName) {

        return new ModelAndView(fileName);

    }

}
