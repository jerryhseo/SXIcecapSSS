package com.sx.icecap.sss.web.term.admin.command.action;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.sss.constants.IcecapSSSWebKeys;
import com.sx.icecap.sss.constants.IcecapSSSWebPortletKeys;
import com.sx.icecap.sss.constants.IcecapSSSMVCCommands;
import com.sx.icecap.sss.debug.Debug;
import com.sx.icecap.sss.service.TermLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + IcecapSSSWebPortletKeys.TERM_ADMIN,
				"mvc.command.name=" + IcecapSSSMVCCommands.ACTION_ADMIN_TERM_DELETE
		},
		service = MVCActionCommand.class
)
public class DeleteTermsActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		Debug.printHeader("DeleteTermsActionCommand");
		String strTermIds = ParamUtil.getString(actionRequest, IcecapSSSWebKeys.TERM_IDS );
		String CMD = ParamUtil.getString(actionRequest, Constants.CMD);
		String redirect = ParamUtil.getString(actionRequest, IcecapSSSWebKeys.REDIRECT);
		
		System.out.println("-- CMD: "+CMD);
		
		JSONArray jsonTermIds = JSONFactoryUtil.createJSONArray(strTermIds);
		for( int i=0; i<jsonTermIds.length(); i++) {
			_termLocalService.removeTerm(jsonTermIds.getLong(i));
		}
	}

	@Reference
	private TermLocalService _termLocalService;
}
