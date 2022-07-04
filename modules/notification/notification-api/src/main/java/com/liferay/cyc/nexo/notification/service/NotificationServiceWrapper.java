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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link NotificationService}.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationService
 * @generated
 */
@ProviderType
public class NotificationServiceWrapper
	implements NotificationService, ServiceWrapper<NotificationService> {

	public NotificationServiceWrapper(NotificationService notificationService) {
		_notificationService = notificationService;
	}

	@Override
	public com.liferay.cyc.nexo.notification.model.Notification addNotification(
			long groupId, long toUserId, boolean read,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationService.addNotification(
			groupId, toUserId, read, titleMap, descriptionMap, serviceContext);
	}

	@Override
	public com.liferay.cyc.nexo.notification.model.Notification
			deleteNotification(long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationService.deleteNotification(notificationId);
	}

	@Override
	public com.liferay.cyc.nexo.notification.model.Notification getNotification(
			long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationService.getNotification(notificationId);
	}

	@Override
	public java.util.List<com.liferay.cyc.nexo.notification.model.Notification>
		getNotificationsbyKeyWords(
			long toUserId, boolean read, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.cyc.nexo.notification.model.Notification>
					orderByComparator) {

		return _notificationService.getNotificationsbyKeyWords(
			toUserId, read, keywords, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.cyc.nexo.notification.model.Notification>
		getNotificationsByToUserId(long toUserId) {

		return _notificationService.getNotificationsByToUserId(toUserId);
	}

	@Override
	public long getNotificationsCountByKeywords(
		long toUserId, boolean read, String keywords) {

		return _notificationService.getNotificationsCountByKeywords(
			toUserId, read, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _notificationService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.cyc.nexo.notification.model.Notification
			updateNotification(
				long notificationId, long toUserId, boolean read,
				java.util.Map<java.util.Locale, String> titleMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationService.updateNotification(
			notificationId, toUserId, read, titleMap, descriptionMap,
			serviceContext);
	}

	@Override
	public NotificationService getWrappedService() {
		return _notificationService;
	}

	@Override
	public void setWrappedService(NotificationService notificationService) {
		_notificationService = notificationService;
	}

	private NotificationService _notificationService;

}