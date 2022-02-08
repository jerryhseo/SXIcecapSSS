/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sx.icecap.sss.model.impl;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sx.icecap.sss.constants.IcecapSSSTermAttributes;
import com.sx.icecap.sss.util.IcecapSSSUtil;

import java.util.Locale;

/**
 * The extended model implementation for the Term service. Represents a row in the &quot;sxicecapsss_Term&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.sx.icecap.sss.model.Term</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class TermImpl extends TermBaseImpl {

	public TermImpl() {
	}

	public String getDisplayTitle( Locale locale ) {
		return getDisplayName( locale ) + " ver. " + getTermVersion();
	}
	
	public JSONObject getAttributesJSONObject() throws JSONException {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(getAttributesJSON());
		jsonObject.put(IcecapSSSTermAttributes.toJsonAttr(IcecapSSSTermAttributes.TERM_TYPE), getTermType() );
		jsonObject.put(IcecapSSSTermAttributes.toJsonAttr(IcecapSSSTermAttributes.TERM_NAME), getTermName() );
		jsonObject.put(IcecapSSSTermAttributes.toJsonAttr(IcecapSSSTermAttributes.TERM_VERSION), getTermVersion() );
		jsonObject.put(IcecapSSSTermAttributes.toJsonAttr(IcecapSSSTermAttributes.DISPLAY_NAME), IcecapSSSUtil.mapToJson(getDisplayNameMap()) );
		jsonObject.put(IcecapSSSTermAttributes.toJsonAttr(IcecapSSSTermAttributes.DEFINITION), IcecapSSSUtil.mapToJson(getDefinitionMap()) );
		jsonObject.put(IcecapSSSTermAttributes.toJsonAttr(IcecapSSSTermAttributes.SYNONYMS), getSynonyms() );
		jsonObject.put(IcecapSSSTermAttributes.toJsonAttr(IcecapSSSTermAttributes.TOOLTIP), IcecapSSSUtil.mapToJson(getTooltipMap()) );

		return jsonObject;
	}
}