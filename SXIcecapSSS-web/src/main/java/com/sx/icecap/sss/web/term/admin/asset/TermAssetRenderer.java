package com.sx.icecap.sss.web.term.admin.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.icecap.sss.constants.IcecapSSSAssetRendererPaths;
import com.sx.icecap.sss.constants.IcecapSSSJsps;
import com.sx.icecap.sss.constants.IcecapSSSWebKeys;
import com.sx.icecap.sss.constants.IcecapSSSWebPortletKeys;
import com.sx.icecap.sss.model.Term;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TermAssetRenderer extends BaseJSPAssetRenderer<Term> {

	private final ModelResourcePermission<Term> _termModelResourcePermission;
    private Term _term;
    
    public TermAssetRenderer( Term term, ModelResourcePermission<Term> modelResoucePermission ) {
    	_term = term;
    	_termModelResourcePermission = modelResoucePermission;
    }

	@Override
	public Term getAssetObject() {
		return _term;
	}

	@Override
	public long getGroupId() {
		return _term.getGroupId();
	}

	@Override
	public long getUserId() {
		return _term.getUserId();
	}

	@Override
	public String getUserName() {
		return _term.getUserName();
	}

	@Override
	public String getUuid() {
		return _term.getUuid();
	}

	@Override
	public String getClassName() {
		return Term.class.getName();
	}

	@Override
	public long getClassPK() {
		return _term.getTermId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();

		return _term.getDefinition(locale);
	}

	@Override
	public String getTitle(Locale locale) {
		return _term.getDisplayTitle(locale);
	}

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest, String template) {
		if( template.equals(TEMPLATE_FULL_CONTENT) || 
			template.equals(TEMPLATE_ABSTRACT )) {
			
			httpServletRequest.setAttribute(IcecapSSSWebKeys.TERM, _term);
			
			return IcecapSSSAssetRendererPaths.ADMIN_TERM_ASSET_RENDERER_PATH + "/" + template + ".jsp";
		}
		return null;
	}

	@Override
	public boolean include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String template) throws Exception {
		httpServletRequest.setAttribute(IcecapSSSWebKeys.TERM, _term);
		httpServletRequest.setAttribute(IcecapSSSWebKeys.HTML_UTIL, HtmlUtil.getHtml());
		httpServletRequest.setAttribute(IcecapSSSWebKeys.STRING_UTIL, new StringUtil());
		return super.include(httpServletRequest, httpServletResponse, template);
	}

	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws Exception {
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
                getControlPanelPlid(liferayPortletRequest), IcecapSSSWebPortletKeys.TERM_ADMIN,
                PortletRequest.RENDER_PHASE);
        portletURL.setParameter(IcecapSSSWebKeys.MVC_PATH, IcecapSSSJsps.ADMIN_EDIT_TERM_JSP);
        portletURL.setParameter(IcecapSSSWebKeys.TERM_ID, String.valueOf(_term.getTermId()));
        portletURL.setParameter(IcecapSSSWebKeys.SHOW_BACK, Boolean.FALSE.toString());

        return portletURL;
	}

	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {
		return super.getURLView(liferayPortletResponse, windowState);
	}

	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
		try {
            long plid = PortalUtil.getPlidFromPortletId(
            		_term.getGroupId(),
                    IcecapSSSWebPortletKeys.TERM_ADMIN);

            PortletURL portletURL;
            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = liferayPortletResponse.createLiferayPortletURL(
                		getControlPanelPlid(liferayPortletRequest),
                		IcecapSSSWebPortletKeys.TERM_ADMIN, 
                		PortletRequest.RENDER_PHASE);
            } else {
                portletURL = PortletURLFactoryUtil.create(
                		liferayPortletRequest,
                		IcecapSSSWebPortletKeys.TERM_ADMIN, 
                		plid, 
                		PortletRequest.RENDER_PHASE);
            }

            portletURL.setParameter(IcecapSSSWebKeys.MVC_PATH, IcecapSSSJsps.ADMIN_VIEW_TERM_JSP);
            portletURL.setParameter(IcecapSSSWebKeys.TERM_ID, String.valueOf(_term.getTermId()));

            String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

            portletURL.setParameter(IcecapSSSWebKeys.REDIRECT, currentUrl);

            return portletURL.toString();

        } catch (PortalException e) {

        } catch (SystemException e) {
        }

        return noSuchEntryRedirect;
    }

	@Override
	public boolean isPrintable() {
		return true;
	}
    
    
}
