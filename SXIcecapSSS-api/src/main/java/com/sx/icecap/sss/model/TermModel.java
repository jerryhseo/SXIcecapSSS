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

package com.sx.icecap.sss.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Term service. Represents a row in the &quot;sxicecapsss_Term&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.sx.icecap.sss.model.impl.TermModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.sx.icecap.sss.model.impl.TermImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Term
 * @generated
 */
@ProviderType
public interface TermModel
	extends BaseModel<Term>, LocalizedModel, ShardedModel, StagedGroupedModel,
			WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a term model instance should use the {@link Term} interface instead.
	 */

	/**
	 * Returns the primary key of this term.
	 *
	 * @return the primary key of this term
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this term.
	 *
	 * @param primaryKey the primary key of this term
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this term.
	 *
	 * @return the uuid of this term
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this term.
	 *
	 * @param uuid the uuid of this term
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the term ID of this term.
	 *
	 * @return the term ID of this term
	 */
	public long getTermId();

	/**
	 * Sets the term ID of this term.
	 *
	 * @param termId the term ID of this term
	 */
	public void setTermId(long termId);

	/**
	 * Returns the group ID of this term.
	 *
	 * @return the group ID of this term
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this term.
	 *
	 * @param groupId the group ID of this term
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this term.
	 *
	 * @return the company ID of this term
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this term.
	 *
	 * @param companyId the company ID of this term
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this term.
	 *
	 * @return the user ID of this term
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this term.
	 *
	 * @param userId the user ID of this term
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this term.
	 *
	 * @return the user uuid of this term
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this term.
	 *
	 * @param userUuid the user uuid of this term
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this term.
	 *
	 * @return the user name of this term
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this term.
	 *
	 * @param userName the user name of this term
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this term.
	 *
	 * @return the create date of this term
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this term.
	 *
	 * @param createDate the create date of this term
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this term.
	 *
	 * @return the modified date of this term
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this term.
	 *
	 * @param modifiedDate the modified date of this term
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this term.
	 *
	 * @return the status of this term
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this term.
	 *
	 * @param status the status of this term
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this term.
	 *
	 * @return the status by user ID of this term
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this term.
	 *
	 * @param statusByUserId the status by user ID of this term
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this term.
	 *
	 * @return the status by user uuid of this term
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this term.
	 *
	 * @param statusByUserUuid the status by user uuid of this term
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this term.
	 *
	 * @return the status by user name of this term
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this term.
	 *
	 * @param statusByUserName the status by user name of this term
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this term.
	 *
	 * @return the status date of this term
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this term.
	 *
	 * @param statusDate the status date of this term
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the last publish date of this term.
	 *
	 * @return the last publish date of this term
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this term.
	 *
	 * @param lastPublishDate the last publish date of this term
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the term name of this term.
	 *
	 * @return the term name of this term
	 */
	@AutoEscape
	public String getTermName();

	/**
	 * Sets the term name of this term.
	 *
	 * @param termName the term name of this term
	 */
	public void setTermName(String termName);

	/**
	 * Returns the term version of this term.
	 *
	 * @return the term version of this term
	 */
	@AutoEscape
	public String getTermVersion();

	/**
	 * Sets the term version of this term.
	 *
	 * @param termVersion the term version of this term
	 */
	public void setTermVersion(String termVersion);

	/**
	 * Returns the term type of this term.
	 *
	 * @return the term type of this term
	 */
	@AutoEscape
	public String getTermType();

	/**
	 * Sets the term type of this term.
	 *
	 * @param termType the term type of this term
	 */
	public void setTermType(String termType);

	/**
	 * Returns the display name of this term.
	 *
	 * @return the display name of this term
	 */
	public String getDisplayName();

	/**
	 * Returns the localized display name of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized display name of this term
	 */
	@AutoEscape
	public String getDisplayName(Locale locale);

	/**
	 * Returns the localized display name of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this term. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDisplayName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized display name of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized display name of this term
	 */
	@AutoEscape
	public String getDisplayName(String languageId);

	/**
	 * Returns the localized display name of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this term
	 */
	@AutoEscape
	public String getDisplayName(String languageId, boolean useDefault);

	@AutoEscape
	public String getDisplayNameCurrentLanguageId();

	@AutoEscape
	public String getDisplayNameCurrentValue();

	/**
	 * Returns a map of the locales and localized display names of this term.
	 *
	 * @return the locales and localized display names of this term
	 */
	public Map<Locale, String> getDisplayNameMap();

	/**
	 * Sets the display name of this term.
	 *
	 * @param displayName the display name of this term
	 */
	public void setDisplayName(String displayName);

	/**
	 * Sets the localized display name of this term in the language.
	 *
	 * @param displayName the localized display name of this term
	 * @param locale the locale of the language
	 */
	public void setDisplayName(String displayName, Locale locale);

	/**
	 * Sets the localized display name of this term in the language, and sets the default locale.
	 *
	 * @param displayName the localized display name of this term
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDisplayName(
		String displayName, Locale locale, Locale defaultLocale);

	public void setDisplayNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized display names of this term from the map of locales and localized display names.
	 *
	 * @param displayNameMap the locales and localized display names of this term
	 */
	public void setDisplayNameMap(Map<Locale, String> displayNameMap);

	/**
	 * Sets the localized display names of this term from the map of locales and localized display names, and sets the default locale.
	 *
	 * @param displayNameMap the locales and localized display names of this term
	 * @param defaultLocale the default locale
	 */
	public void setDisplayNameMap(
		Map<Locale, String> displayNameMap, Locale defaultLocale);

	/**
	 * Returns the definition of this term.
	 *
	 * @return the definition of this term
	 */
	public String getDefinition();

	/**
	 * Returns the localized definition of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized definition of this term
	 */
	@AutoEscape
	public String getDefinition(Locale locale);

	/**
	 * Returns the localized definition of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized definition of this term. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDefinition(Locale locale, boolean useDefault);

	/**
	 * Returns the localized definition of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized definition of this term
	 */
	@AutoEscape
	public String getDefinition(String languageId);

	/**
	 * Returns the localized definition of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized definition of this term
	 */
	@AutoEscape
	public String getDefinition(String languageId, boolean useDefault);

	@AutoEscape
	public String getDefinitionCurrentLanguageId();

	@AutoEscape
	public String getDefinitionCurrentValue();

	/**
	 * Returns a map of the locales and localized definitions of this term.
	 *
	 * @return the locales and localized definitions of this term
	 */
	public Map<Locale, String> getDefinitionMap();

	/**
	 * Sets the definition of this term.
	 *
	 * @param definition the definition of this term
	 */
	public void setDefinition(String definition);

	/**
	 * Sets the localized definition of this term in the language.
	 *
	 * @param definition the localized definition of this term
	 * @param locale the locale of the language
	 */
	public void setDefinition(String definition, Locale locale);

	/**
	 * Sets the localized definition of this term in the language, and sets the default locale.
	 *
	 * @param definition the localized definition of this term
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDefinition(
		String definition, Locale locale, Locale defaultLocale);

	public void setDefinitionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized definitions of this term from the map of locales and localized definitions.
	 *
	 * @param definitionMap the locales and localized definitions of this term
	 */
	public void setDefinitionMap(Map<Locale, String> definitionMap);

	/**
	 * Sets the localized definitions of this term from the map of locales and localized definitions, and sets the default locale.
	 *
	 * @param definitionMap the locales and localized definitions of this term
	 * @param defaultLocale the default locale
	 */
	public void setDefinitionMap(
		Map<Locale, String> definitionMap, Locale defaultLocale);

	/**
	 * Returns the tooltip of this term.
	 *
	 * @return the tooltip of this term
	 */
	public String getTooltip();

	/**
	 * Returns the localized tooltip of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized tooltip of this term
	 */
	@AutoEscape
	public String getTooltip(Locale locale);

	/**
	 * Returns the localized tooltip of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized tooltip of this term. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTooltip(Locale locale, boolean useDefault);

	/**
	 * Returns the localized tooltip of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized tooltip of this term
	 */
	@AutoEscape
	public String getTooltip(String languageId);

	/**
	 * Returns the localized tooltip of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized tooltip of this term
	 */
	@AutoEscape
	public String getTooltip(String languageId, boolean useDefault);

	@AutoEscape
	public String getTooltipCurrentLanguageId();

	@AutoEscape
	public String getTooltipCurrentValue();

	/**
	 * Returns a map of the locales and localized tooltips of this term.
	 *
	 * @return the locales and localized tooltips of this term
	 */
	public Map<Locale, String> getTooltipMap();

	/**
	 * Sets the tooltip of this term.
	 *
	 * @param tooltip the tooltip of this term
	 */
	public void setTooltip(String tooltip);

	/**
	 * Sets the localized tooltip of this term in the language.
	 *
	 * @param tooltip the localized tooltip of this term
	 * @param locale the locale of the language
	 */
	public void setTooltip(String tooltip, Locale locale);

	/**
	 * Sets the localized tooltip of this term in the language, and sets the default locale.
	 *
	 * @param tooltip the localized tooltip of this term
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTooltip(String tooltip, Locale locale, Locale defaultLocale);

	public void setTooltipCurrentLanguageId(String languageId);

	/**
	 * Sets the localized tooltips of this term from the map of locales and localized tooltips.
	 *
	 * @param tooltipMap the locales and localized tooltips of this term
	 */
	public void setTooltipMap(Map<Locale, String> tooltipMap);

	/**
	 * Sets the localized tooltips of this term from the map of locales and localized tooltips, and sets the default locale.
	 *
	 * @param tooltipMap the locales and localized tooltips of this term
	 * @param defaultLocale the default locale
	 */
	public void setTooltipMap(
		Map<Locale, String> tooltipMap, Locale defaultLocale);

	/**
	 * Returns the synonyms of this term.
	 *
	 * @return the synonyms of this term
	 */
	@AutoEscape
	public String getSynonyms();

	/**
	 * Sets the synonyms of this term.
	 *
	 * @param synonyms the synonyms of this term
	 */
	public void setSynonyms(String synonyms);

	/**
	 * Returns the attributes json of this term.
	 *
	 * @return the attributes json of this term
	 */
	@AutoEscape
	public String getAttributesJSON();

	/**
	 * Sets the attributes json of this term.
	 *
	 * @param attributesJSON the attributes json of this term
	 */
	public void setAttributesJSON(String attributesJSON);

	/**
	 * Returns <code>true</code> if this term is approved.
	 *
	 * @return <code>true</code> if this term is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this term is denied.
	 *
	 * @return <code>true</code> if this term is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this term is a draft.
	 *
	 * @return <code>true</code> if this term is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this term is expired.
	 *
	 * @return <code>true</code> if this term is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this term is inactive.
	 *
	 * @return <code>true</code> if this term is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this term is incomplete.
	 *
	 * @return <code>true</code> if this term is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this term is pending.
	 *
	 * @return <code>true</code> if this term is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this term is scheduled.
	 *
	 * @return <code>true</code> if this term is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

}