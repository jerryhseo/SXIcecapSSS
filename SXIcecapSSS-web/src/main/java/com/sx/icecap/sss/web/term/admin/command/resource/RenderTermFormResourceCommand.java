package com.sx.icecap.sss.web.term.admin.command.resource;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.icecap.sss.constants.IcecapSSSWebPortletKeys;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.sx.icecap.sss.constants.IcecapSSSMVCCommands;
import com.sx.icecap.sss.constants.IcecapSSSWebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapSSSWebPortletKeys.TERM_ADMIN,
	        "mvc.command.name="+IcecapSSSMVCCommands.RESOURCE_ADMIN_RENDER_TERM
	    },
	    service = MVCResourceCommand.class
	)
public class RenderTermFormResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		System.out.println("Render Term with FTL");
		
		return false;
	}
	
	private Template renderTermEditTemplate( ResourceRequest resourceRequest ) throws IOException {
		String template = "";
		
		/* ------------------------------------------------------------------------ */
        /* The followings should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String templateFolder = resourceRequest.getContextPath() + "/templates";
		
		cfg.setDirectoryForTemplateLoading(new File(templateFolder));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		// cfg.setWrapUncheckedExceptions(true); - cfg.setWrapUncheckedExceptions(true);
		// cfg.setFallbackOnNullLoopVariable(false); - FreeMarker v. 2.3.23 may not support this function
		
		 /* ------------------------------------------------------------------------ */
		
		long termId = ParamUtil.getLong(resourceRequest, IcecapSSSWebKeys.TERM_ID);
		String termType = ParamUtil.getString(resourceRequest, IcecapSSSWebKeys.TERM_TYPE);
		
		/* Create Data Model for Template */
		Map<String, String> root = new HashMap<>();
		
		
		return cfg.getTemplate(template);
		
	}
}
