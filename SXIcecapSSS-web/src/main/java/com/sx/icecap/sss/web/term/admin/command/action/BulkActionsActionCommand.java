package com.sx.icecap.sss.web.term.admin.command.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.sss.constants.IcecapSSSActionKeys;
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
				"mvc.command.name=" + IcecapSSSMVCCommands.ACTION_ADMIN_BULK_ACTIONS
		},
		service = MVCActionCommand.class
)
public class BulkActionsActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		Debug.printHeader("BulkActionsActionCommand");
		
		long[] termIds = ParamUtil.getLongValues(actionRequest, IcecapSSSWebKeys.ROW_IDS);
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		String redirect = ParamUtil.getString(actionRequest, IcecapSSSWebKeys.REDIRECT);

		if( cmd.equals(IcecapSSSActionKeys.DELETE_TERMS) ) {
			_termLocalService.removeTerms(termIds);
		}
		
		actionResponse.sendRedirect(redirect);
		
		Debug.printFooter("BulkActionsActionCommand");
	}

	@Reference
	private TermLocalService _termLocalService;
}
