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

package com.liferay.cyc.nexo.notification.service.impl;

import com.liferay.cyc.nexo.notification.model.Notification;
import com.liferay.cyc.nexo.notification.service.base.NotificationServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the notification remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.cyc.nexo.notification.service.NotificationService</code>
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author David Galera
 * @see NotificationServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=notification",
		"json.web.service.context.path=Notification" }, service = AopService.class)
public class NotificationServiceImpl extends NotificationServiceBaseImpl {

	public Notification addNotification(long groupId, long toUserId, boolean read, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext) throws PortalException {

		return notificationLocalService.addNotification(groupId, toUserId, read, titleMap, descriptionMap,
				serviceContext);

	}
	
	public Notification deleteNotification(long notificationId) throws PortalException {
		Notification notification = notificationLocalService.getNotification(notificationId);
		
		return notificationLocalService.deleteNotification(notification);
	}
	
	public Notification getNotification(long notificationId)throws PortalException {
		
		Notification notification = notificationLocalService.getNotification(notificationId);
		
		return notification;
	}
	
	public List<Notification> getNotificationsByToUserId(long toUserId){
		return notificationPersistence.findByToUserId(toUserId);
	}
	
	public List<Notification> getNotificationsbyKeyWords(long toUserId, boolean read, String keywords, int start, int end,
		     OrderByComparator<Notification> orderByComparator){
		return notificationLocalService.getNotificationsByKeywords(toUserId, read, keywords, start, end, orderByComparator);
	}
	
	public long getNotificationsCountByKeywords(long toUserId,boolean read, String keywords) {
		return notificationLocalService.getNotificationsCountByKeywords(toUserId, read, keywords);
	}
	
	public Notification updateNotification(long notificationId, long toUserId, boolean read, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, ServiceContext serviceContext) throws PortalException{
		return notificationLocalService.updateNotification(notificationId, toUserId, read, titleMap, descriptionMap, serviceContext);
		
	}
	
}