package io.github.huherto.rbac.controller;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.boot.autoconfigure.mustache.MustacheProperties;
import org.springframework.boot.autoconfigure.mustache.web.MustacheViewResolver;
import org.springframework.core.Ordered;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.Compiler;
import com.samskivert.mustache.Template;

import io.github.huherto.rbac.util.StringUtils;

@Component
public class MustacheLayoutViewResolver extends MustacheViewResolver{
	
	private static final Log logger = LogFactory.getLog(MustacheLayoutViewResolver.class);
	
	public MustacheLayoutViewResolver(Compiler mustacheCompiler, MustacheProperties mustache) {
		logger.info("Creating MustacheLayoutViewResolver");
		mustache.applyToViewResolver(this);
		setCharset(mustache.getCharsetName());
		setCompiler(mustacheCompiler);
		setOrder(Ordered.LOWEST_PRECEDENCE - 10);		
		setExposeSessionAttributes(true);
	}

	@Override
	protected Class<?> requiredViewClass() {
		return MustacheLayoutView.class;
	}
	
	@Override
	protected View loadView(String viewName, Locale locale) throws Exception {
		
		logger.debug("loadView("+viewName+","+locale+")");
		MustacheLayoutView layoutView = (MustacheLayoutView) super.loadView(viewName, locale);
		if (layoutView == null) {
			return null;
		}
		
		if (StringUtils.safeEquals("login", viewName )) {
			return layoutView;
		}
		
		logger.debug("resolveResource()");
		Resource resource = resolveResource("layout", locale);
		if (resource == null) {
			return layoutView;
		}
			
		logger.debug("setLayoutTemplate()");
		layoutView.setLayoutTemplate(createTemplate(resource));
		
		return layoutView;
	}

	/**
	 * All these were copied and pasted from the super class since resolvedResources() and createTemplate() were private.  
	 */
	
	private Compiler compiler = Mustache.compiler();

	private String charset;
		

	public void setCompiler(Compiler compiler) {
		this.compiler = compiler.defaultValue("__MISSING_VALUE__");
		super.setCompiler(this.compiler);
	}

	public void setCharset(String charset) {
		super.setCharset(charset);
		this.charset = charset;
	}
	
	private Resource resolveResource(String viewName, Locale locale) {
		return resolveFromLocale(viewName, getLocale(locale));
	}

	private Resource resolveFromLocale(String viewName, String locale) {
		Resource resource = getApplicationContext()
				.getResource(getPrefix() + viewName + locale + getSuffix());
		if (resource == null || !resource.exists()) {
			if (locale.isEmpty()) {
				return null;
			}
			int index = locale.lastIndexOf("_");
			return resolveFromLocale(viewName, locale.substring(0, index));
		}
		return resource;
	}

	private String getLocale(Locale locale) {
		if (locale == null) {
			return "";
		}
		LocaleEditor localeEditor = new LocaleEditor();
		localeEditor.setValue(locale);
		return "_" + localeEditor.getAsText();
	}

	private Template createTemplate(Resource resource) throws IOException {
		Reader reader = getReader(resource);
		try {
			return this.compiler.compile(reader);
		}
		finally {
			reader.close();
		}
	}

	private Reader getReader(Resource resource) throws IOException {
		if (this.charset != null) {
			return new InputStreamReader(resource.getInputStream(), this.charset);
		}
		return new InputStreamReader(resource.getInputStream());
	}
	
}
