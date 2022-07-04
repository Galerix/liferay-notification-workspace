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
import com.liferay.cyc.nexo.notification.service.base.NotificationLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the notification local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.cyc.nexo.notification.service.NotificationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author David Galera
 * @see NotificationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.cyc.nexo.notification.model.Notification",
	service = AopService.class
)
public class NotificationLocalServiceImpl
	extends NotificationLocalServiceBaseImpl {
	
	public Notification addNotification(long groupId, long toUserId, boolean read, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,  ServiceContext serviceContext) throws PortalException{
		
		Group group = groupLocalService.getGroup(groupId);
		
		long userId = serviceContext.getUserId();
		
		User user = userLocalService.getUser(userId);
		
		long notificationId =
		         counterLocalService.increment(Notification.class.getName());
		
		//Create notification
		
		Notification notification = createNotification(notificationId);
		
		//Populate fields
		
		notification.setCompanyId(group.getCompanyId());
		notification.setCreateDate(serviceContext.getCreateDate(new Date()));
		notification.setFromUserId(userId);
		notification.setToUserId(toUserId);
		notification.setRead(read);
		notification.setTitleMap(titleMap);
		notification.setDescriptionMap(descriptionMap);
		notification.setGroupId(groupId);
		notification.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		notification.setUserId(userId);
		notification.setUserName(user.getScreenName());
		
		
		
		//persist notification to database
		
		return super.addNotification(notification);
		
		
	}

	public Notification updateNotification(long notificationId, long toUserId, boolean read, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, ServiceContext serviceContext) throws PortalException{

		//Get the Notification by id
		
		Notification notification = getNotification(notificationId);
		
		//set updated fields and modification date
		
		notification.setModifiedDate(new Date());
		notification.setToUserId(toUserId);
		notification.setRead(read);
		notification.setTitleMap(titleMap);
		notification.setDescriptionMap(descriptionMap);
		
		notification = super.updateNotification(notification);
		
		return notification;
		
	}
	
	public List<Notification> getNotificationsByToUserIdRead(long toUserId, boolean read){
		return notificationPersistence.findByToUserIdRead(toUserId, read);
	}
	
	public List<Notification>getNotificationsByToUserIdRead(long toUserId, boolean read, int start, int end){
		return notificationPersistence.findByToUserIdRead(toUserId, read, start, end);
	}
	
	public List<Notification>getNotificationsByToUserIdRead(long toUserId, boolean read, int start, int end,
		     OrderByComparator<Notification> orderByComparator){
		return notificationPersistence.findByToUserIdRead(toUserId, read, start, end, orderByComparator);
	}
	
	public List<Notification>getNotificationsByKeywords(long toUserId,boolean read, String keywords, int start, int end,
		     OrderByComparator<Notification> orderByComparator){
		return notificationLocalService.dynamicQuery(getKeywordSearchDynamicQuery(toUserId, read, keywords), start, end, orderByComparator);
	}
	
	public List<Notification>getNotificationsByKeywords(long toUserId,boolean read, String keywords){
		return notificationLocalService.dynamicQuery(getKeywordSearchDynamicQuery(toUserId,read, keywords));
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(
		     long toUserId, boolean read, String keywords) {

		     DynamicQuery dynamicQuery = dynamicQuery().add(
		         RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("toUserId", toUserId), RestrictionsFactoryUtil.eq("read", read)));

		     if (Validator.isNotNull(keywords)) {
		         Disjunction disjunctionQuery =
		             RestrictionsFactoryUtil.disjunction();

		         disjunctionQuery.add(
		             RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
		         disjunctionQuery.add(
		             RestrictionsFactoryUtil.like(
		                 "description", "%" + keywords + "%"));
		         dynamicQuery.add(disjunctionQuery);
		     }

		     return dynamicQuery;
		 }
	
	@Override
	public Notification addNotification(Notification notification) {
		throw new UnsupportedOperationException("Not supported.");
	}
	
	@Override
	public Notification updateNotification(Notification notification) {
		throw new UnsupportedOperationException("Not supported.");
	}

}