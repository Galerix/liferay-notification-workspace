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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Notification. This utility wraps
 * <code>com.liferay.cyc.nexo.notification.service.impl.NotificationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationService
 * @generated
 */
@ProviderType
public class NotificationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.cyc.nexo.notification.service.impl.NotificationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.cyc.nexo.notification.model.Notification
			addNotification(
				long groupId, long toUserId, boolean read,
				java.util.Map<java.util.Locale, String> titleMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addNotification(
			groupId, toUserId, read, titleMap, descriptionMap, serviceContext);
	}

	public static com.liferay.cyc.nexo.notification.model.Notification
			deleteNotification(long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteNotification(notificationId);
	}

	public static com.liferay.cyc.nexo.notification.model.Notification
			getNotification(long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNotification(notificationId);
	}

	public static java.util.List
		<com.liferay.cyc.nexo.notification.model.Notification>
			getNotificationsbyKeyWords(
				long toUserId, boolean read, String keywords, int start,
				int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.cyc.nexo.notification.model.Notification>
						orderByComparator) {

		return getService().getNotificationsbyKeyWords(
			toUserId, read, keywords, start, end, orderByComparator);
	}

	public static java.util.List
		<com.liferay.cyc.nexo.notification.model.Notification>
			getNotificationsByToUserId(long toUserId) {

		return getService().getNotificationsByToUserId(toUserId);
	}

	public static long getNotificationsCountByKeywords(
		long toUserId, boolean read, String keywords) {

		return getService().getNotificationsCountByKeywords(
			toUserId, read, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.cyc.nexo.notification.model.Notification
			updateNotification(
				long notificationId, long toUserId, boolean read,
				java.util.Map<java.util.Locale, String> titleMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateNotification(
			notificationId, toUserId, read, titleMap, descriptionMap,
			serviceContext);
	}

	public static NotificationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NotificationService, NotificationService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NotificationService.class);

		ServiceTracker<NotificationService, NotificationService>
			serviceTracker =
				new ServiceTracker<NotificationService, NotificationService>(
					bundle.getBundleContext(), NotificationService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}