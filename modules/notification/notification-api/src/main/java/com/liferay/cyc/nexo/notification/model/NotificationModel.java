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

package com.liferay.cyc.nexo.notification.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Notification service. Represents a row in the &quot;Notification_Notification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.cyc.nexo.notification.model.impl.NotificationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.cyc.nexo.notification.model.impl.NotificationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Notification
 * @generated
 */
@ProviderType
public interface NotificationModel
	extends BaseModel<Notification>, GroupedModel, LocalizedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a notification model instance should use the {@link Notification} interface instead.
	 */

	/**
	 * Returns the primary key of this notification.
	 *
	 * @return the primary key of this notification
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this notification.
	 *
	 * @param primaryKey the primary key of this notification
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this notification.
	 *
	 * @return the uuid of this notification
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this notification.
	 *
	 * @param uuid the uuid of this notification
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the notification ID of this notification.
	 *
	 * @return the notification ID of this notification
	 */
	public long getNotificationId();

	/**
	 * Sets the notification ID of this notification.
	 *
	 * @param notificationId the notification ID of this notification
	 */
	public void setNotificationId(long notificationId);

	/**
	 * Returns the group ID of this notification.
	 *
	 * @return the group ID of this notification
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this notification.
	 *
	 * @param groupId the group ID of this notification
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this notification.
	 *
	 * @return the company ID of this notification
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this notification.
	 *
	 * @param companyId the company ID of this notification
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this notification.
	 *
	 * @return the user ID of this notification
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this notification.
	 *
	 * @param userId the user ID of this notification
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this notification.
	 *
	 * @return the user uuid of this notification
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this notification.
	 *
	 * @param userUuid the user uuid of this notification
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this notification.
	 *
	 * @return the user name of this notification
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this notification.
	 *
	 * @param userName the user name of this notification
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this notification.
	 *
	 * @return the create date of this notification
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this notification.
	 *
	 * @param createDate the create date of this notification
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this notification.
	 *
	 * @return the modified date of this notification
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this notification.
	 *
	 * @param modifiedDate the modified date of this notification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the from user ID of this notification.
	 *
	 * @return the from user ID of this notification
	 */
	public long getFromUserId();

	/**
	 * Sets the from user ID of this notification.
	 *
	 * @param fromUserId the from user ID of this notification
	 */
	public void setFromUserId(long fromUserId);

	/**
	 * Returns the from user uuid of this notification.
	 *
	 * @return the from user uuid of this notification
	 */
	public String getFromUserUuid();

	/**
	 * Sets the from user uuid of this notification.
	 *
	 * @param fromUserUuid the from user uuid of this notification
	 */
	public void setFromUserUuid(String fromUserUuid);

	/**
	 * Returns the from app of this notification.
	 *
	 * @return the from app of this notification
	 */
	@AutoEscape
	public String getFromApp();

	/**
	 * Sets the from app of this notification.
	 *
	 * @param fromApp the from app of this notification
	 */
	public void setFromApp(String fromApp);

	/**
	 * Returns the to user ID of this notification.
	 *
	 * @return the to user ID of this notification
	 */
	public long getToUserId();

	/**
	 * Sets the to user ID of this notification.
	 *
	 * @param toUserId the to user ID of this notification
	 */
	public void setToUserId(long toUserId);

	/**
	 * Returns the to user uuid of this notification.
	 *
	 * @return the to user uuid of this notification
	 */
	public String getToUserUuid();

	/**
	 * Sets the to user uuid of this notification.
	 *
	 * @param toUserUuid the to user uuid of this notification
	 */
	public void setToUserUuid(String toUserUuid);

	/**
	 * Returns the read of this notification.
	 *
	 * @return the read of this notification
	 */
	public boolean getRead();

	/**
	 * Returns <code>true</code> if this notification is read.
	 *
	 * @return <code>true</code> if this notification is read; <code>false</code> otherwise
	 */
	public boolean isRead();

	/**
	 * Sets whether this notification is read.
	 *
	 * @param read the read of this notification
	 */
	public void setRead(boolean read);

	/**
	 * Returns the title of this notification.
	 *
	 * @return the title of this notification
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this notification
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this notification. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this notification
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this notification
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this notification.
	 *
	 * @return the locales and localized titles of this notification
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this notification.
	 *
	 * @param title the title of this notification
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this notification in the language.
	 *
	 * @param title the localized title of this notification
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this notification in the language, and sets the default locale.
	 *
	 * @param title the localized title of this notification
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this notification from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this notification
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this notification from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this notification
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description of this notification.
	 *
	 * @return the description of this notification
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this notification
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this notification. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this notification
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this notification
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this notification.
	 *
	 * @return the locales and localized descriptions of this notification
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this notification.
	 *
	 * @param description the description of this notification
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this notification in the language.
	 *
	 * @param description the localized description of this notification
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this notification in the language, and sets the default locale.
	 *
	 * @param description the localized description of this notification
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this notification from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this notification
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this notification from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this notification
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the status of this notification.
	 *
	 * @return the status of this notification
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this notification.
	 *
	 * @param status the status of this notification
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this notification.
	 *
	 * @return the status by user ID of this notification
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this notification.
	 *
	 * @param statusByUserId the status by user ID of this notification
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this notification.
	 *
	 * @return the status by user uuid of this notification
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this notification.
	 *
	 * @param statusByUserUuid the status by user uuid of this notification
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this notification.
	 *
	 * @return the status by user name of this notification
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this notification.
	 *
	 * @param statusByUserName the status by user name of this notification
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this notification.
	 *
	 * @return the status date of this notification
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this notification.
	 *
	 * @param statusDate the status date of this notification
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this notification is approved.
	 *
	 * @return <code>true</code> if this notification is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this notification is denied.
	 *
	 * @return <code>true</code> if this notification is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this notification is a draft.
	 *
	 * @return <code>true</code> if this notification is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this notification is expired.
	 *
	 * @return <code>true</code> if this notification is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this notification is inactive.
	 *
	 * @return <code>true</code> if this notification is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this notification is incomplete.
	 *
	 * @return <code>true</code> if this notification is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this notification is pending.
	 *
	 * @return <code>true</code> if this notification is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this notification is scheduled.
	 *
	 * @return <code>true</code> if this notification is scheduled; <code>false</code> otherwise
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