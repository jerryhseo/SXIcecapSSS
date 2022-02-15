package com.sx.icecap.sss.web.term.admin.command.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.sss.constants.IcecapSSSJsps;
import com.sx.icecap.sss.constants.IcecapSSSWebKeys;
import com.sx.icecap.sss.constants.IcecapSSSWebPortletKeys;
import com.sx.icecap.sss.debug.Debug;
import com.sx.icecap.sss.constants.IcecapSSSMVCCommands;
import com.sx.icecap.sss.model.Term;
import com.sx.icecap.sss.service.TermLocalService;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapSSSWebPortletKeys.TERM_ADMIN,
	        "mvc.command.name="+IcecapSSSMVCCommands.RENDER_ADMIN_TERM_EDIT
	    },
	    service = MVCRenderCommand.class
	)
public class EditTermRenderCommand implements MVCRenderCommand {

	public String render( 
			RenderRequest renderRequest, 
			RenderResponse renderResponse) throws PortletException {
		
		long termId = ParamUtil.getLong(renderRequest, IcecapSSSWebKeys.TERM_ID, 0);
		
		if( termId > 0 ) {
			try {
				Term term = _termLocalService.getTerm(termId);
				renderRequest.setAttribute(IcecapSSSWebKeys.TERM, term);
			}
			catch( PortalException e) {
				e.printStackTrace();
			}
		}
		else {
			String termType = ParamUtil.getString(renderRequest, IcecapSSSWebKeys.TERM_TYPE);
//			System.out.println("In Edit Render: termType - " + termType );
		}
		
		Debug.printAllParameters(renderRequest);
		
		return IcecapSSSJsps.ADMIN_EDIT_TERM_JSP;
	}
	
	@Reference
	private volatile TermLocalService _termLocalService;
}
