package com.sx.icecap.sss.web.term.admin.command.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.trash.TrashHelper;
import com.sx.icecap.sss.constants.IcecapSSSJsps;
import com.sx.icecap.sss.constants.IcecapSSSWebPortletKeys;
import com.sx.icecap.sss.constants.IcecapSSSMVCCommands;
import com.sx.icecap.sss.service.TermLocalService;
import com.sx.icecap.sss.web.term.admin.display.context.TermAdminDisplayContext;
import com.sx.icecap.sss.web.term.admin.display.context.TermAdminManagementToolbarDisplayContext;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapSSSWebPortletKeys.TERM_ADMIN,
	        "mvc.command.name="+IcecapSSSMVCCommands.RENDER_ROOT,
	        "mvc.command.name="+IcecapSSSMVCCommands.RENDER_ADMIN_TERM_LIST
	    },
	    service = MVCRenderCommand.class
	)
public class TermListViewRenderCommand implements MVCRenderCommand {

	@Reference(unbind = "-")
	protected void setPortal(Portal portal) {
		  this._portal = portal;
	}
	protected Portal _portal;
	
	@Reference(unbind = "-")
	protected void setTrashHelper(TrashHelper trashHelper) {
	  _trashHelper = trashHelper;
	}
	protected TrashHelper _trashHelper;
	
	@Reference
	private TermLocalService _termLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
//		System.out.println("TermListViewRenderCommand.render()");
		TermAdminDisplayContext termAdminDisplayContext = 
//				(TermAdminDisplayContext)renderRequest.getAttribute(TermAdminDisplayContext.class.getName());
		
					new TermAdminDisplayContext(
												PortalUtil.getLiferayPortletRequest(renderRequest),
												PortalUtil.getLiferayPortletResponse(renderResponse),
												PortalUtil.getHttpServletRequest(renderRequest),
												_termLocalService,
												_trashHelper);
		
		TermAdminManagementToolbarDisplayContext termAdminManagementToolbarDisplayContext =
				new TermAdminManagementToolbarDisplayContext(
							renderRequest, 
							renderResponse, 
							termAdminDisplayContext
				);
		renderRequest.setAttribute(
				TermAdminManagementToolbarDisplayContext.class.getName(), 
				termAdminManagementToolbarDisplayContext );
		
		return IcecapSSSJsps.ADMIN_TERM_LIST_JSP;
	}

}
