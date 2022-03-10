package com.sx.icecap.sss.web.term.admin.command.resource;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.sx.icecap.sss.constants.IcecapSSSWebPortletKeys;
import com.sx.icecap.sss.constants.IcecapSSSMVCCommands;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

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
}
