package com.sx.icecap.sss.web.term.admin.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownGroupItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.trash.TrashHelper;
import com.sx.icecap.sss.constants.IcecapSSSActionKeys;
import com.sx.icecap.sss.constants.IcecapSSSConstants;
import com.sx.icecap.sss.constants.IcecapSSSWebKeys;
import com.sx.icecap.sss.constants.IcecapSSSMVCCommands;
import com.sx.icecap.sss.constants.IcecapSSSTermAttributes;
import com.sx.icecap.sss.debug.Debug;
import com.sx.icecap.sss.model.Term;
import com.sx.icecap.sss.web.term.admin.security.permission.resource.TermModelPermissionHelper;
import com.sx.icecap.sss.web.term.admin.security.permission.resource.TermResourcePermissionHelper;
import com.sx.icecap.sss.web.term.admin.taglib.clay.TermVerticalCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.servlet.http.HttpServletRequest;

public class TermAdminManagementToolbarDisplayContext 
						extends SearchContainerManagementToolbarDisplayContext{

	private final ThemeDisplay _themeDisplay;
	private final String _displayStyle;
	private final String _keywords;
	private final String _orderByCol;
	private final String _orderByType;
	private final long _groupId;
	private final boolean _showAddButton;
	private final Integer _status;
	private final String _navigation;
	private final Boolean _multipleSelection;
	private final String _eventName;
	private final Boolean _showScheduled;

	
	private final String _namespace;
	private final HttpServletRequest _httpServletRequest;
	private final PermissionChecker _permissionChecker;
	private final TrashHelper _trashHelper;
	
	private final Locale _locale;

	public TermAdminManagementToolbarDisplayContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			HttpServletRequest httpServletRequest,
			SearchContainer<Term> searchContainer,
			TrashHelper trashHelper) {

		super(
				liferayPortletRequest, 
				liferayPortletResponse, 
				httpServletRequest,
				searchContainer);
		
		/* For the scope to search. mine, group, all. It's set in the management toolbar. */
		_navigation = ParamUtil.getString(httpServletRequest, IcecapSSSWebKeys.NAVIGATION, IcecapSSSConstants.NAVIGATION_MINE);
		/* For the display style. card, list, table.  It's set in the management toolbar. */
		_displayStyle = ParamUtil.getString(
				httpServletRequest, IcecapSSSWebKeys.DISPLAY_STYLE, IcecapSSSConstants.VIEW_TYPE_TABLE);
		/* For sorting by column.  It's set in the management toolbar. */
		_orderByCol = searchContainer.getOrderByCol();
		/* For sorting by ascending or descending.  It's set in the management toolbar. */
		_orderByType = searchContainer.getOrderByType();
		
		/* Keywords for searched.  It's set in the management toolbar. */
		DisplayTerms displayTerms = searchContainer.getSearchTerms();
		_keywords = Validator.isNotNull(displayTerms) ? displayTerms.getKeywords() : "";
		
		/* Status to be displayed.  It's set in the management toolbar.  */
		_status = ParamUtil.getInteger(httpServletRequest, IcecapSSSTermAttributes.STATUS, WorkflowConstants.STATUS_ANY);
		
		/* Show add button or not */
		_showAddButton = ParamUtil.getBoolean(httpServletRequest, IcecapSSSWebKeys.SHOW_ADD_BUTTON, true);
		_multipleSelection = ParamUtil.getBoolean( httpServletRequest, IcecapSSSWebKeys.MULTIPLE_SELECTION, true);
		_showScheduled = ParamUtil.getBoolean(httpServletRequest, IcecapSSSWebKeys.SHOW_SCHEDULED, false);
		
		_themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		_namespace = _themeDisplay.getPortletDisplay().getNamespace();
		_eventName = ParamUtil.getString(
				httpServletRequest, IcecapSSSWebKeys.EVENT_NAME,
				_namespace + IcecapSSSWebKeys.SELECT_TERM);
		
		_httpServletRequest = httpServletRequest;
		_locale = _themeDisplay.getLocale();
		_groupId = _themeDisplay.getScopeGroupId();
		
		_permissionChecker = _themeDisplay.getPermissionChecker();
		_trashHelper = trashHelper;
		
	}
	
	@Override
	protected PortletURL getPortletURL() {
		PortletURL portletURL = super.liferayPortletResponse.createRenderURL();
		
		portletURL.setParameter(IcecapSSSWebKeys.GROUP_ID, String.valueOf(_groupId));

		if (_getListable() != null) {
			portletURL.setParameter(IcecapSSSWebKeys.LISTABLE, String.valueOf(_getListable()));
		}

		portletURL.setParameter( 
				IcecapSSSWebKeys.MULTIPLE_SELECTION, 
				String.valueOf(_multipleSelection));

		portletURL.setParameter(IcecapSSSWebKeys.SHOW_ADD_BUTTON, String.valueOf(_showAddButton));

		portletURL.setParameter(
				IcecapSSSWebKeys.SHOW_SCHEDULED, String.valueOf(_showScheduled));

		portletURL.setParameter(IcecapSSSWebKeys.EVENT_NAME, _eventName);
		
		portletURL.setParameter(IcecapSSSWebKeys.DISPLAY_STYLE, _displayStyle);
		portletURL.setParameter(IcecapSSSWebKeys.ORDER_BY_COL, _orderByCol);
		portletURL.setParameter(IcecapSSSWebKeys.ORDER_BY_TYPE, _orderByType);
		portletURL.setParameter(IcecapSSSWebKeys.NAVIGATION, _navigation);
		portletURL.setParameter(IcecapSSSWebKeys.KEYWORDS, _keywords);
		
		return portletURL;
	}

	@Override
	public String getClearResultsURL() {
//		Debug.printHeader("TermAdminManagementToolbarDisplayContext.getClearResultsURL()");
		PortletURL clearResultsURL = getPortletURL();
		clearResultsURL.setParameter(IcecapSSSWebKeys.KEYWORDS, StringPool.BLANK);
//		Debug.printFooter("TermAdminManagementToolbarDisplayContext.getClearResultsURL()");
		return clearResultsURL.toString();
	}
	
	@Override
	public String getSearchContainerId() {
//		Debug.printHeader("TermAdminManagementToolbarDisplayContext.getSearchContainerId()");
//		String searchContainerId = _termAdminDisplayContext.getSearchContainerId();
		String searchContainerId = super.searchContainer.getId( _httpServletRequest, _namespace);
		
//		Debug.printFooter("TermAdminManagementToolbarDisplayContext.getSearchContainerId()");
		return searchContainerId;
	}
	
	public SearchContainer<Term> getSearchContainer(){
		return super.searchContainer;
	}
	
	@Override
	public String getSearchActionURL() {
//		Debug.printHeader("TermAdminManagementToolbarDisplayContext.getSearchActionURL()");
		PortletURL searchURL =  getPortletURL();
		
		searchURL.setParameter(
				IcecapSSSWebKeys.MVC_RENDER_COMMAND_NAME, 
				IcecapSSSMVCCommands.RENDER_ADMIN_TERM_LIST);
		
//		System.out.println("Order By Type: "+ _orderByType);
		
		
//		Debug.printFooter("TermAdminManagementToolbarDisplayContext.getSearchActionURL()");

		return searchURL.toString();
	}
	
	public PortletURL getFilterURL() {
		PortletURL filterURL =  getPortletURL();
		filterURL.setParameter(
				IcecapSSSWebKeys.MVC_RENDER_COMMAND_NAME,
				IcecapSSSMVCCommands.RENDER_ADMIN_TERM_LIST);

		return filterURL;
	}
	
	@Override
	protected String[] getDisplayViews() {
//		Debug.printHeader("TermAdminManagementToolbarDisplayContext.getDisplayViews()");
		String[] viewTypes = new String[] { 
				IcecapSSSConstants.VIEW_TYPE_CARDS, 
				IcecapSSSConstants.VIEW_TYPE_LIST,
				IcecapSSSConstants.VIEW_TYPE_TABLE};
//		Debug.printFooter("TermAdminManagementToolbarDisplayContext.getDisplayViews()");
		return viewTypes;
	}
	
	@Override
	protected String[] getNavigationKeys() {
//		Debug.printHeader("TermAdminManagementToolbarDisplayContext.getNavigationKeys()");
//		System.out.println("Default NavigationKeys are define in IcecapSSSConstants");
//		Debug.printFooter("TermAdminManagementToolbarDisplayContext.getNavigationKeys()");
		return IcecapSSSConstants.NAVIGATION_KEYS();
	}
	
	protected Map<String, Integer> getStatusMap(){

		Map<String, Integer> statusMap = new LinkedHashMap<>();

		statusMap.put("Any", Integer.valueOf(WorkflowConstants.STATUS_ANY));
		statusMap.put("Pending", Integer.valueOf(WorkflowConstants.STATUS_PENDING));
		statusMap.put("Approved", Integer.valueOf(WorkflowConstants.STATUS_APPROVED));
//		statusMap.put("Draft", Integer.valueOf(WorkflowConstants.STATUS_DRAFT));
//		statusMap.put("Denied", Integer.valueOf(WorkflowConstants.STATUS_DENIED));
//		statusMap.put("Scheduled", Integer.valueOf(WorkflowConstants.STATUS_SCHEDULED));
//		statusMap.put("Expired", Integer.valueOf(WorkflowConstants.STATUS_EXPIRED));

		return statusMap;
	}
	
	protected List<DropdownItem> getFilterByStatusDropdownItems() {
		return getStatusDropdownItems(
						getStatusMap(), 
						getFilterURL(), 
						getStatusParam(),
						getFilterStatus());
	}
	
	protected List<DropdownItem> getStatusDropdownItems(
			Map<String, Integer> statusMap, 
			PortletURL filterURL,
			String parameterName, 
			int parameterValue){
		return new DropdownItemList() {
			{
				for (Map.Entry<String, Integer> entry : statusMap.entrySet()) {
					add(
						dropdownItem -> {
							dropdownItem.setActive(parameterValue == entry.getValue());
							dropdownItem.setHref(
									filterURL, parameterName, entry.getValue());
							dropdownItem.setLabel(
								LanguageUtil.get(request, entry.getKey()));
						});
				}
			}
		};
	}
	
	protected int getFilterStatus() {
		return ParamUtil.getInteger(
			liferayPortletRequest, getStatusParam(), WorkflowConstants.STATUS_ANY);
	}
	
	protected String getStatusParam() {
		return "status";
	}
	
	// Dropdown Items for management toolbar. multi selection.
	// These items appear on the management toolbar.
	@Override
	public List<DropdownItem> getActionDropdownItems() {
//		Debug.printHeader("TermAdminManagementToolbarDisplayContext.getActionDropdownItems()");
		List<DropdownItem> itemList = 
					new DropdownItemList() {
						{
							boolean stagedActions = false;
							
							add(
								dropdownItem -> {
									dropdownItem.setIcon("trash");
									dropdownItem.setLabel(LanguageUtil.get(request, "delete"));
									dropdownItem.setQuickAction(true);
									dropdownItem.putData("cmd", IcecapSSSActionKeys.DELETE_TERMS);
								});
						}
					};
					
//		Debug.printFooter("TermAdminManagementToolbarDisplayContext.getActionDropdownItems()");
		return itemList;
	}
	
	public List<String> getAvailableActions( Term term ) throws PortalException{
		List<String> availableActions = new ArrayList<>();

		PermissionChecker permissionChecker =
			_themeDisplay.getPermissionChecker();

		if (TermModelPermissionHelper.contains(
				permissionChecker, term, IcecapSSSActionKeys.DELETE_TERM)) {

			availableActions.add(IcecapSSSActionKeys.DELETE_TERM);
		}
		
		if (TermModelPermissionHelper.contains(
				permissionChecker, term, IcecapSSSActionKeys.UPDATE_TERM)) {

			availableActions.add(IcecapSSSActionKeys.UPDATE_TERM);
		}
		
		if (TermModelPermissionHelper.contains(
				permissionChecker, term, IcecapSSSActionKeys.ADD_TERM)) {

			availableActions.add(IcecapSSSActionKeys.ADD_TERM);
		}

		if (TermModelPermissionHelper.contains(
				permissionChecker, term, IcecapSSSActionKeys.REVIEW_TERM)) {

			availableActions.add(IcecapSSSActionKeys.REVIEW_TERM);
		}

		if (TermModelPermissionHelper.contains(
				permissionChecker, term, IcecapSSSActionKeys.APPROVE_TERM)) {

			availableActions.add(IcecapSSSActionKeys.APPROVE_TERM);
		}
		
		return availableActions;
	}
	
	public String getBulkActionURL() {
		PortletURL actionURL = liferayPortletResponse.createActionURL();
		actionURL.setParameter("actionName", IcecapSSSMVCCommands.ACTION_ADMIN_BULK_ACTIONS);
		
		return actionURL.toString();
	}
	
	public List<DropdownItem> getTermActionDropdownItems( long termId){
//		Debug.printHeader("TermAdminManagementToolbarDisplayContext.getTermActionDropdownItems()");
		List<DropdownItem> itemList = 
				new DropdownItemList() {
					{
						if (_hasUpdatePermission( termId )) {
							add(dropdownItem -> {
								dropdownItem.setHref(
										getPortletURL(), 
										IcecapSSSWebKeys.MVC_RENDER_COMMAND_NAME, IcecapSSSMVCCommands.RENDER_ADMIN_TERM_EDIT, 
										Constants.CMD, Constants.UPDATE,
										IcecapSSSWebKeys.TERM_ID, termId);

									dropdownItem.setIcon("edit");
									dropdownItem.setLabel(LanguageUtil.get(_locale, "edit"));
							});
						}

						if (_hasDeletePermission( termId )) {
							PortletURL deleteURL = liferayPortletResponse.createActionURL();
							
							long[] termIds = { termId};
							deleteURL.setParameter(ActionRequest.ACTION_NAME, IcecapSSSMVCCommands.ACTION_ADMIN_TERM_DELETE);
							deleteURL.setParameter(Constants.CMD, Constants.DELETE);
							deleteURL.setParameter(IcecapSSSWebKeys.REDIRECT, _getRedirectURL());
							deleteURL.setParameter(IcecapSSSWebKeys.TERM_IDS, Arrays.toString(termIds) );
							
							add( dropdownItem -> {
								dropdownItem.setHref(deleteURL);
								dropdownItem.setIcon("delete");
								dropdownItem.setLabel(
									LanguageUtil.get(request, "delete"));
							});		
						}
					}
				};
				
//		Debug.printFooter("TermAdminManagementToolbarDisplayContext.getTermActionDropdownItems()");
		return itemList;
	}

	@Override
	public CreationMenu getCreationMenu() {
		if( !TermResourcePermissionHelper.contains(
				_permissionChecker, 
				_themeDisplay.getScopeGroupId(), 
				IcecapSSSActionKeys.ADD_TERM)) {
			return null;
		}
		
		CreationMenu menu = 
				new CreationMenu() {
					{
						addDropdownItem(
								dropdownItem -> {
									dropdownItem.setHref(
											getPortletURL(),
											IcecapSSSWebKeys.MVC_RENDER_COMMAND_NAME, IcecapSSSMVCCommands.RENDER_ADMIN_TERM_EDIT,
											IcecapSSSWebKeys.REDIRECT, getPortletURL().toString(),
											Constants.CMD, Constants.ADD);
									dropdownItem.setLabel(
											LanguageUtil.get(request, "add-term"));
								});
					}
				};
		
		return menu;
	}
	
	public TermVerticalCard getVerticalCard( 
			Term term, 
			RenderRequest renderRequest,
			RenderResponse renderResponse,
			RowChecker rowChecker,
			String termViewURL) {
		
		return new TermVerticalCard(
				term, 
				renderRequest, 
				renderResponse, 
				rowChecker, 
				termViewURL, 
				getTermActionDropdownItems(term.getTermId()));
	}

	private boolean _hasDeletePermission( long termId ) {
		boolean hasPermission = false;
		try {
			hasPermission = TermModelPermissionHelper.contains(
						_permissionChecker, termId, ActionKeys.DELETE);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Delete Permission: "+hasPermission);
		return hasPermission;
	}
	
	private boolean _hasUpdatePermission( long termId ) {
		boolean hasPermission = false;
		try {
			hasPermission = TermModelPermissionHelper.contains(
				_permissionChecker, termId, ActionKeys.UPDATE);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("Update Permission: "+hasPermission);
		return hasPermission;
	}
	
	private String _getRedirectURL() {
		PortletURL redirectURL = getPortletURL();

		return redirectURL.toString();
	}

	@Override
	public int getItemsTotal() {
		return searchContainer.getTotal();
	}

	@Override
	public List<ViewTypeItem> getViewTypeItems() {
		if (ArrayUtil.isEmpty(getDisplayViews())) {
			return null;
		}

		List<ViewTypeItem> viewTypeItemList = new ArrayList<ViewTypeItem>();

		String[] displayViews = getDisplayViews();
		
		RenderURL renderURL = liferayPortletResponse.createRenderURL();
		
		String renderCommand = IcecapSSSMVCCommands.RENDER_ADMIN_TERM_LIST;
		if( Validator.isNotNull(_keywords) && !_keywords.isEmpty() ) {
			renderCommand = IcecapSSSMVCCommands.RENDER_ADMIN_SEARCH_TERMS;
		}
		
		if (ArrayUtil.contains(displayViews, IcecapSSSConstants.VIEW_TYPE_CARDS)) {
			ViewTypeItem viewType = new ViewTypeItem();
			
			viewType.setActive( _displayStyle.equals(IcecapSSSConstants.VIEW_TYPE_CARDS) );
			viewType.setHref(renderURL,
						IcecapSSSWebKeys.MVC_RENDER_COMMAND_NAME, renderCommand,
						IcecapSSSWebKeys.DISPLAY_STYLE, IcecapSSSConstants.VIEW_TYPE_CARDS,
						IcecapSSSWebKeys.KEYWORDS, _keywords);
			viewType.setIcon("cards2");
			viewType.setLabel(LanguageUtil.get(LocaleUtil.getMostRelevantLocale(), "cards"));
			viewTypeItemList.add(viewType);
		}

		if (ArrayUtil.contains(displayViews, IcecapSSSConstants.VIEW_TYPE_LIST)) {
			ViewTypeItem viewType = new ViewTypeItem();
			
			viewType.setActive( _displayStyle.equals(IcecapSSSConstants.VIEW_TYPE_LIST) );
			viewType.setHref(renderURL,
						IcecapSSSWebKeys.MVC_RENDER_COMMAND_NAME, renderCommand,
						IcecapSSSWebKeys.DISPLAY_STYLE, IcecapSSSConstants.VIEW_TYPE_LIST,
						IcecapSSSWebKeys.KEYWORDS, _keywords);
			viewType.setIcon("list");
			viewType.setLabel(LanguageUtil.get(LocaleUtil.getMostRelevantLocale(), "list"));
			viewTypeItemList.add(viewType);
		}

		if (ArrayUtil.contains(displayViews, IcecapSSSConstants.VIEW_TYPE_TABLE)) {
			ViewTypeItem viewType = new ViewTypeItem();
			
			viewType.setActive( _displayStyle.equals(IcecapSSSConstants.VIEW_TYPE_TABLE) );
			viewType.setHref(renderURL,
						IcecapSSSWebKeys.MVC_RENDER_COMMAND_NAME, renderCommand,
						IcecapSSSWebKeys.DISPLAY_STYLE, IcecapSSSConstants.VIEW_TYPE_TABLE,
						IcecapSSSWebKeys.KEYWORDS, _keywords);
			viewType.setIcon("table");
			viewType.setLabel(LanguageUtil.get(LocaleUtil.getMostRelevantLocale(), "table"));
			viewTypeItemList.add(viewType);
		}
		
		return viewTypeItemList;
	}

	@Override
	protected String getDefaultDisplayStyle() {
		return IcecapSSSConstants.VIEW_TYPE_TABLE;
	}

	@Override
	protected String getDisplayStyle() {
		return _displayStyle;
	}

	@Override
	public String getSortingURL() {
		Debug.printHeader("getSortingURL");
		
		PortletURL portletURL = getPortletURL();
		if( _orderByType.equals(IcecapSSSConstants.ASC) ) {
			portletURL.setParameter(IcecapSSSWebKeys.ORDER_BY_TYPE, IcecapSSSConstants.DSC);
		}
		else {
			portletURL.setParameter(IcecapSSSWebKeys.ORDER_BY_TYPE, IcecapSSSConstants.ASC);
		}
		
		Debug.printFooter("getSortingURL");
		return portletURL.toString();
	}

	@Override
	protected List<DropdownItem> getFilterNavigationDropdownItems() {

		DropdownItemList filterNavigationDropdownItems = new DropdownItemList();
		
		List<DropdownItem> filterByScopeDropdownItemList = super.getFilterNavigationDropdownItems();
		DropdownGroupItem filterByScopeGroup = new DropdownGroupItem();
//		filterByScopeGroup.setLabel("Filter By Scope");
		filterByScopeGroup.setDropdownItems(filterByScopeDropdownItemList);
		filterNavigationDropdownItems.add(filterByScopeGroup);
		
		List<DropdownItem> filterByStatusDropdownItemList = getFilterByStatusDropdownItems();
		DropdownGroupItem filterByStatusGroup = new DropdownGroupItem();
		filterByStatusGroup.setLabel("Filter By Status");
		filterByStatusGroup.setDropdownItems(filterByStatusDropdownItemList);
		filterNavigationDropdownItems.add(filterByStatusGroup);
		
		return filterNavigationDropdownItems;
	}
	
	@Override
	protected String getFilterNavigationDropdownItemsLabel() {
		return LanguageUtil.get(request, "filter-by-scope");
	}

	@Override
	protected String[] getOrderByKeys() {
		return new String[] {LanguageUtil.get(_locale, "parameter-name"), LanguageUtil.get(_locale, "modified-date")};
	}

	@Override
	public Boolean isSelectable() {
		return true;
	}

	@Override
	public Boolean getSupportsBulkActions() {
		return true;
	}

	@Override
	public Boolean isShowAdvancedSearch() {
		return false;
	}

	@Override
	public String getComponentId() {
		return "termAdminManagementToolbar";
	}

	@Override
	public String getSearchFormMethod() {
//		System.out.println("----- Search Form Method: "+super.getSearchFormMethod());
		return super.getSearchFormMethod();
	}

	@Override
	public String getSearchFormName() {
//		System.out.println("----- Search Form Name: "+super.getSearchFormName());
		return "searchForm";
	}

	@Override
	public String getSearchInputName() {
//		System.out.println("----- Search Input Name: "+super.getSearchInputName());
		return super.getSearchInputName();
	}

	@Override
	public String getSearchValue() {
//		System.out.println("----- Search Value: "+super.getSearchValue());
		return super.getSearchValue();
	}

	@Override
	public int getSelectedItems() {
//		System.out.println("----- Selected Items: "+super.getSelectedItems());
		return super.getSelectedItems();
	}

	@Override
	public String getDefaultEventHandler() {
		if( Validator.isNull(super.getDefaultEventHandler())) {
//			System.out.println("Default Event Handler is null.");
			return null;
		}
		else {
//			System.out.println("Default Event Handler: "+super.getDefaultEventHandler());
		}
		return super.getDefaultEventHandler();
	}
	
	private Boolean _getListable() {
		Boolean listable = null;

		String listableValue = ParamUtil.getString(
			super.liferayPortletRequest, IcecapSSSWebKeys.LISTABLE, null);

		if (Validator.isNotNull(listableValue)) {
			listable = ParamUtil.getBoolean(
					super.liferayPortletRequest, IcecapSSSWebKeys.LISTABLE, true);
		}

		return listable;
	}

}
