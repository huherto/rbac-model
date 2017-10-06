package io.github.huherto.rbac.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.mustache.web.MustacheView;

import com.samskivert.mustache.Template;

public class MustacheLayoutView extends MustacheView {
	
	private static final Log logger = LogFactory.getLog(MustacheLayoutView.class);	
	
	private Template layoutTemplate;
	
	private Template template;
	
	public MustacheLayoutView() {
	}

	public void setTemplate(Template template) {
		super.setTemplate(template);
		this.template = template;
	}	
	
	public void setLayoutTemplate(Template layoutTemplate) {
		this.layoutTemplate = layoutTemplate;
	}

	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (layoutTemplate == null) {
			logger.debug("layoutTemplate is null. Using vanilla MustacheView");			
			super.renderMergedTemplateModel(model, request, response);
			return;
		}
		
		if (template != null ) {
			
			logger.debug("rendering MustacheLayoutView");			
			
		    StringWriter stringWriter = new StringWriter();
		    PrintWriter printWriter = new PrintWriter(stringWriter);
				
			this.template.execute(model, printWriter);
			model.put("screen_contents", stringWriter.toString());
					
			this.layoutTemplate.execute(model, response.getWriter());
		}
	}

}
