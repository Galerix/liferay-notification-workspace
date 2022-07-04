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

package com.liferay.cyc.nexo.notification.service;

import com.liferay.cyc.nexo.notification.model.Notification;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Notification. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface NotificationService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificationServiceUtil} to access the notification remote service. Add custom service methods to <code>com.liferay.cyc.nexo.notification.service.impl.NotificationServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Notification addNotification(
			long groupId, long toUserId, boolean read,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			ServiceContext serviceContext)
		throws PortalException;

	public Notification deleteNotification(long notificationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Notification getNotification(long notificationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Notification> getNotificationsbyKeyWords(
		long toUserId, boolean read, String keywords, int start, int end,
		OrderByComparator<Notification> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Notification> getNotificationsByToUserId(long toUserId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getNotificationsCountByKeywords(
		long toUserId, boolean read, String keywords);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Notification updateNotification(
			long notificationId, long toUserId, boolean read,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			ServiceContext serviceContext)
		throws PortalException;

}