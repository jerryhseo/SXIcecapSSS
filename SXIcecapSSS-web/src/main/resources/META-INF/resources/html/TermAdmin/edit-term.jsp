<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.sx.icecap.sss.debug.Debug"%>
<%@page import="com.sx.icecap.sss.util.term.IcecapSSSTermAttributeUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sx.icecap.sss.constants.IcecapSSSMVCCommands"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sx.icecap.sss.constants.IcecapSSSActionKeys"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Set"%>
<%@page import="com.sx.icecap.sss.constants.IcecapSSSClassNames"%>
<%@page import="com.sx.icecap.sss.constants.IcecapSSSTermTypes"%>
<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.SelectOption"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sx.icecap.sss.constants.IcecapSSSWebKeys"%>
<%@page import="com.sx.icecap.sss.model.Term"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp" %>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css">

<%
	
	Term term = (Term)renderRequest.getAttribute(IcecapSSSWebKeys.TERM);

	String cmd = ParamUtil.getString(renderRequest, Constants.CMD, Constants.ADD);
	
	String defaultTermType = ParamUtil.getString(renderRequest, IcecapSSSWebKeys.TERM_TYPE, IcecapSSSTermTypes.STRING);

	String submitButtonLabel = "";
	
//	System.out.println("CMD: "+cmd);
	if( cmd.equals(Constants.ADD) ){
		submitButtonLabel = LanguageUtil.get(locale, "add-term", "Add Term");
	}
	else{
		submitButtonLabel = LanguageUtil.get(locale, "update-term", "Update Term");
		defaultTermType = term.getTermType();
	}
	
	Locale defaultLocale = PortalUtil.getSiteDefaultLocale(themeDisplay.getScopeGroupId());
	
	Set<Locale> availableLocales = LanguageUtil.getAvailableLocales();
	
	JSONArray jsonLocales = JSONFactoryUtil.createJSONArray();
	availableLocales.forEach( jsonLocales::put );

%>

<div class="SXIcecapSSS-web">
<liferay-portlet:actionURL name="<%=IcecapSSSMVCCommands.ACTION_ADMIN_TERM_ADD%>" var="addTermURL">
</liferay-portlet:actionURL>

<portlet:renderURL var="termListURL">
	<portlet:param
			name="<%=IcecapSSSWebKeys.MVC_RENDER_COMMAND_NAME%>" 
    		value="<%=IcecapSSSMVCCommands.RENDER_ADMIN_TERM_LIST%>" />
    <portlet:param
    		name="<%=  IcecapSSSWebKeys.NAVIGATION %>"
    		value="<%= ParamUtil.getString(renderRequest, IcecapSSSWebKeys.NAVIGATION) %>" />
    <portlet:param
    		name="<%=  IcecapSSSWebKeys.DISPLAY_STYLE %>"
    		value="<%= ParamUtil.getString(renderRequest, IcecapSSSWebKeys.DISPLAY_STYLE) %>" />
    <portlet:param
    		name="<%=  IcecapSSSWebKeys.KEYWORDS %>"
    		value="<%= ParamUtil.getString(renderRequest, IcecapSSSWebKeys.KEYWORDS) %>" />
    <portlet:param
    		name="<%=  IcecapSSSWebKeys.ORDER_BY_COL %>"
    		value="<%= ParamUtil.getString(renderRequest, IcecapSSSWebKeys.ORDER_BY_COL) %>" />
    <portlet:param
    		name="<%=  IcecapSSSWebKeys.ORDER_BY_TYPE %>"
    		value="<%= ParamUtil.getString(renderRequest, IcecapSSSWebKeys.ORDER_BY_TYPE) %>" />
    <portlet:param
    		name="<%=  IcecapSSSWebKeys.SHOW_SCHEDULED %>"
    		value="<%= ParamUtil.getString(renderRequest, IcecapSSSWebKeys.SHOW_SCHEDULED) %>" />
    <portlet:param
    		name="<%=  IcecapSSSWebKeys.MULTIPLE_SELECTION %>"
    		value="<%= ParamUtil.getString(renderRequest, IcecapSSSWebKeys.MULTIPLE_SELECTION) %>" />
    <portlet:param
    		name="<%=  IcecapSSSWebKeys.STATUS %>"
    		value="<%= ParamUtil.getString(renderRequest, IcecapSSSWebKeys.STATUS, String.valueOf(WorkflowConstants.STATUS_ANY)) %>" />
</portlet:renderURL>

<portlet:actionURL name="<%=IcecapSSSMVCCommands.ACTION_ADMIN_TERM_UPDATE%>" var="updateTermURL">
</portlet:actionURL>

<portlet:actionURL name="<%=IcecapSSSMVCCommands.ACTION_ADMIN_LOAD_TERM_ATTRIBURES%>" var="loadTermAttributesURL"/>

<portlet:resourceURL id="<%= IcecapSSSMVCCommands.RESOURCE_ADMIN_RENDER_TERM %>" var="renderTermURL"></portlet:resourceURL>


<liferay-asset:asset-categories-error />
<liferay-asset:asset-tags-error />

<aui:container>
	<aui:row>
		<aui:col md="3" cssClass="card card-horizontal">
			<aui:form name="termTypeForm" method="POST" action="<%=loadTermAttributesURL%>" markupView="lexicon">
						<aui:select name="termType" label="term-type" helpMessage="term-type-select-help">
							<%
								final String[] parameterTypes = IcecapSSSTermTypes.getTypes();
											for( String parameterType : parameterTypes ){
												if( parameterType.equals(IcecapSSSTermTypes.GROUP) || parameterType.equals(IcecapSSSTermTypes.COMMENT) ){
													continue;
												}
												if( parameterType.equals( defaultTermType )){
							%>
								<aui:option label="<%=parameterType%>" value="<%=parameterType%>" selected="<%=true%>"/>
							<%
								}
												else {
							%>
									<aui:option label="<%=parameterType%>" value="<%=parameterType%>"/>
							<%
								}
											}
							%>
						</aui:select>
						
						<input type="hidden" name="<portlet:namespace/>mvcRenderCommandName" value="<%=IcecapSSSMVCCommands.RENDER_ADMIN_TERM_EDIT%>" >
						<input type="hidden" name="<portlet:namespace/>termListViewURL" value="<%= backURL %>" >
			</aui:form>
		</aui:col>
		<aui:col md="7">
		</aui:col>
		<aui:col md="2" >
			<clay:link href="<%= termListURL.toString() %>" icon="list" label="view-term-list" />
		</aui:col>
	</aui:row>
</aui:container>

<%
	String actionURL;
	
	if( cmd.equals(Constants.ADD) ){
		actionURL = addTermURL.toString();
	}
	else{
		actionURL = updateTermURL.toString();
	}
	
	JSONObject jsonDedicatedAttrs = null;
	if( Validator.isNotNull(term) ){
		jsonDedicatedAttrs = IcecapSSSTermAttributeUtil.toJsonObject(term.getAttributesJSON());
	}
%>
<aui:container>
<aui:form name="termDefForm" method="POST" action="<%= actionURL %>">
	<aui:row>
		<aui:col>
			<aui:input type="hidden" name="termId" value="<%= Validator.isNotNull(term)?term.getTermId():StringPool.BLANK %>"></aui:input>
			
			<%@include file="jspf/term-definition.jspf" %>
			
			<hr class="content-horizontal-line">
		
			<%@include file="../templates/type-specific-attributes.jspf" %>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col>
			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset collapsed="<%= false %>" collapsible="<%= true %>" label="categorization" helpMessage="term-categories-help">
					<liferay-asset:asset-categories-selector 
								className="<%=Term.class.getName()%>" 
								classPK="<%= Validator.isNotNull(term)?term.getTermId():0 %>"/>
				</aui:fieldset>
			</aui:fieldset-group>
		</aui:col>
	</aui:row>
	<aui:button-row>
		<aui:button name="submit" type="submit" value="<%= submitButtonLabel %>"></aui:button>
		<aui:button name="clear" type="reset" value="clear"></aui:button>
		<c:if test="<%= Validator.isNotNull(term) %>">
			<portlet:actionURL name="<%=IcecapSSSMVCCommands.ACTION_ADMIN_TERM_DELETE%>" var="deleteTermURL">
				<portlet:param name="termId" value="<%= String.valueOf(term.getTermId()) %>"/>
			</portlet:actionURL>
			<aui:button name="delete" type="delete" value="delete" href="<%= deleteTermURL.toString() %>"></aui:button>
		</c:if>
		<aui:button name="cancel" value="cancel" href="<%= termListURL %>"></aui:button>
	</aui:button-row>
</aui:form>
</aui:container>

<script>
$(document).ready(function(){
	let SX = StationX(  '<portlet:namespace/>', 
								'<%= defaultLocale.toString() %>',
								'<%= locale.toString() %>',
								<%= jsonLocales.toJSONString() %> );

	
	var hasDedicatedAttributes = function( termType ){
		if( termType === '<%= IcecapSSSTermTypes.EMAIL%>' ||
			 termType === '<%= IcecapSSSTermTypes.DATE %>' )
			return false;
		
		return true;
	};
	
	SX.Term.$TERM_TYPE_FORM_CTRL.change(function(eventObj){
		let selectedTermType = currentTerm.getTermTypeFormValue();
		
		if( selectedTermType === currentTerm.termType ){
			// Do nothing
			return;
		}
		
		if( currentTerm.isRendered() ){
			$.alert({
				title: '<liferay-ui:message key="term-type-change-alert"/>',
				content: 'how-to-term-type-change'
			});
			
			setCurrentTerm( currentTerm );
		}
		else{
			setCurrentTerm( dataStructure.createTerm( selectedTermType ) );
		}
	});
	
	SX.Term.$TERM_NAME_FORM_CTRL.change(function(eventObj){
		if( currentTerm.$rendered ){
			// It means the current term is one of the data structure and previewed on the preview panel.
			// Therefore, we must confirm that the term's name be changed before the preview changed.
			$.confirm({
				title: '<liferay-ui:message key="select-term-type" />',
				content: '<liferay-ui:message key="this-term-is-previewed-are-you-sure-to-change-the-name-of-the-term" />',
				type: 'orange',
				typeAnimated: true,
				buttons:{
					ok: {
						text: 'OK',
						btnClass: 'btn-blue',
						action: function(){
							let changedName = currentTerm.getTermNameFormValue();
							if( dataStructure.exist( changedName ) ){
								$.alert( changedName + 'already exist. Should be changed another name.' );
								currentTerm.setTermNameFormValue();
							}
							else{
								if( currentTerm.validateNameExpression( changedName ) === true ){
									currentTerm.termName = changedName;
									
									dataStructure.refreshTerm( currentTerm );
								}
								else{
									$.alert( 'Term Name[' + changedName +'] is unvalid. Try another one.');
									currentTerm.setTermNameFormValue();
								}
							} 
						}
					},
					cancel: function(){
						currentTerm.setTermNameFormValue();
					}
				},
				draggable: true
			}); 
		}
		else{
			currentTerm.getTermNameFormValue( true );
		}
	});

	SX.Term.$TERM_VERSION_FORM_CTRL.change(function(eventObj){
		const changedVersion = currentTerm.getTermVersionFormValue();
		
		let validated;
		if( currentTerm.$rendered ){
			validated = SX.Term.validateTermVersion( changedVersion, currentTerm.termVersion );
		}
		else{
			validated = SX.Term.validateTermVersion( changedVersion );
		}
		
		if( validated === true ){
			currentTerm.termVersion = changedVersion;
		}
		else{
			$.alert( changedVersion + ' ' + validated );
			currentTerm.setTermVersionFormValue();
		} 
	});

	SX.Term.$TERM_DISPLAY_NAME_FORM_CTRL.change(function(eventObj){
		currentTerm.getDisplayNameFormValue(true);
	
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>termDefinition').change(function(eventObj){
		currentTerm.getDefinitionFormValue(true);
	});

	$('#<portlet:namespace/>termTooltip').change(function(eventObj){
		currentTerm.getTooltipFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>placeHolder').change(function(eventObj){
		currentTerm.getPlaceHolderFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>synonyms').change(function(eventObj){
		currentTerm.getSynonymsFormValue(true);
	});
	
	$('#<portlet:namespace/>mandatory').change(function(eventObj){
		currentTerm.getMandatoryFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>value').change(function(eventObj){
		currentTerm.getValueFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});

	$('#<portlet:namespace/>minLength').change(function(eventObj){
		const changedValue = Number( currentTerm.getMinLengthFormValue() );
		console.log( 'Changed number: '+changedValue );
		if( isNaN( changedValue ) || changedValue <= 0){
			$.alert('Minimum length should be an interger larger than 0.');
			currentTerm.setMinLengthFormValue()
		}
		else{
			currentTerm.minLength = changedValue;
			dataStructure.refreshTerm( currentTerm );
		}
	});
	
	$('#<portlet:namespace/>maxLength').change(function(eventObj){
		const minLength = currentTerm.getMinLengthFormValue();
		const maxLength = currentTerm.getMaxLengthFormValue();
		if( maxLength < minLength ){
			$.alert('Maximum length should be larger than minimum length.');
			currentTerm.setMaxLengthFormValue();
		}
		else{
			currentTerm.getMaxLengthFormValue(true);
			dataStructure.refreshTerm( currentTerm );
		}
	});

	$('#<portlet:namespace/>multipleLine').change(function(eventObj){
		currentTerm.getMultipleLineFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});

	$('#<portlet:namespace/>validationRule').change(function(eventObj){
		currentTerm.getValidationRuleFormValue(true);
	});
	
	$('#<portlet:namespace/>minValue').change(function(eventObj){
		const preValue = currentTerm.minValue;
	
		currentTerm.getMinValueFormValue(true);
		
		if( !currentTerm.minValue ){
			currentTerm.setMinBoundaryFormValue();
			dataStructure.disable(['minBoundary'], true);
			//$('#<portlet:namespace/>minBoundary').prop('disabled', true);
		}
		else{
			dataStructure.disable(['minBoundary'], false);
			//$('#<portlet:namespace/>minBoundary').prop('disabled', false);
		}
		
		if( preValue !== currentTerm.minValue ){
			dataStructure.refreshTerm( currentTerm );
		}
	});

	$('#<portlet:namespace/>minBoundary').change(function(eventObj){
		currentTerm.getMinBoundaryFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>maxValue').change(function(eventObj){
		const preValue = currentTerm.maxValue;
		
		currentTerm.getMaxValueFormValue(true);
		
		if( !currentTerm.maxValue ){
			currentTerm.setMaxBoundaryFormValue();
			dataStructure.disable(['maxBoundary'], true);
//			$('#<portlet:namespace/>maxBoundary').prop('disabled', true);
		}
		else{
			dataStructure.disable(['maxBoundary'], false);
//			$('#<portlet:namespace/>maxBoundary').prop('disabled', false);
		}
		
		if( preValue !== currentTerm.maxValue ){
			dataStructure.refreshTerm( currentTerm );
		}
	});

	$('#<portlet:namespace/>maxBoundary').change(function(eventObj){
		currentTerm.getMaxBoundaryFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});

	$('#<portlet:namespace/>unit').change(function(eventObj){
		currentTerm.getUnitFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>uncertainty').change(function(eventObj){
		currentTerm.getUncertaintyFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});

	$('#<portlet:namespace/>sweepable').change(function(eventObj){
		currentTerm.getSweepableFormValue(true);
	});
	
	$('input[name="<portlet:namespace/>listDisplayStyle"]').change(function(eventObj){
		currentTerm.getDisplayStyleFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	SX.ListTerm.$OPTION_LABEL.change(function(event){
		let labelMap = currentTerm.getOptionLabelFormValue();
		if( Object.keys(labelMap).length === 0 ){
			$.alert('<liferay-ui:message key="option-label-required"/>');
			currentTerm.setOptionLabelFormValue();
			SX.ListTerm.$OPTION_LABEL.focus();
			
			return;
		}
		
		currentTerm.setOptionLabelMap( labelMap );
		
		dataStructure.refreshTerm( currentTerm );
	});
	
	SX.ListTerm.$OPTION_VALUE.change(function(event){
		let value = currentTerm.getOptionValueFormValue();
		if( !value ){
			$.alert('<liferay-ui:message key="option-label-required"/>');
			currentTerm.setOptionValueFormValue();
			SX.ListTerm.$OPTION_VALUE.focus();
			
			return;
		}
		
		currentTerm.setOptionValue( value );
		
		dataStructure.refreshTerm( currentTerm );
	});
	
	SX.ListTerm.$OPTION_SELECTED.change(function(event){
		let value = currentTerm.getOptionSelectedFormValue();
		
		currentTerm.setOptionSelected( value );
		
		dataStructure.refreshTerm( currentTerm );
	});
	
	SX.ListTerm.$OPTION_ACTIVE_TERMS.change(function(event){
		let activeTermNames = currentTerm.getActiveTermsFormValue();
		
		currentTerm.setActiveTerms( activeTermNames );
		
		console.log('active terms: ', activeTermNames);
	});
	
	$('input[name="<portlet:namespace/>booleanDisplayStyle"]').change(function(event){
		console.log( 'Boolean display style changed: ', currentTerm.getDisplayStyleFormValue( true ) );
		
		dataStructure.refreshTerm( currentTerm );
	});
	
});



</script>
