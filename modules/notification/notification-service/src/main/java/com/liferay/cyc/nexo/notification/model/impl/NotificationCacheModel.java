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

package com.liferay.cyc.nexo.notification.model.impl;

import com.liferay.cyc.nexo.notification.model.Notification;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Notification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class NotificationCacheModel
	implements CacheModel<Notification>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationCacheModel)) {
			return false;
		}

		NotificationCacheModel notificationCacheModel =
			(NotificationCacheModel)obj;

		if (notificationId == notificationCacheModel.notificationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, notificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", notificationId=");
		sb.append(notificationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", fromUserId=");
		sb.append(fromUserId);
		sb.append(", fromApp=");
		sb.append(fromApp);
		sb.append(", toUserId=");
		sb.append(toUserId);
		sb.append(", read=");
		sb.append(read);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Notification toEntityModel() {
		NotificationImpl notificationImpl = new NotificationImpl();

		if (uuid == null) {
			notificationImpl.setUuid("");
		}
		else {
			notificationImpl.setUuid(uuid);
		}

		notificationImpl.setNotificationId(notificationId);
		notificationImpl.setGroupId(groupId);
		notificationImpl.setCompanyId(companyId);
		notificationImpl.setUserId(userId);

		if (userName == null) {
			notificationImpl.setUserName("");
		}
		else {
			notificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			notificationImpl.setCreateDate(null);
		}
		else {
			notificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			notificationImpl.setModifiedDate(null);
		}
		else {
			notificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		notificationImpl.setFromUserId(fromUserId);

		if (fromApp == null) {
			notificationImpl.setFromApp("");
		}
		else {
			notificationImpl.setFromApp(fromApp);
		}

		notificationImpl.setToUserId(toUserId);
		notificationImpl.setRead(read);

		if (title == null) {
			notificationImpl.setTitle("");
		}
		else {
			notificationImpl.setTitle(title);
		}

		if (description == null) {
			notificationImpl.setDescription("");
		}
		else {
			notificationImpl.setDescription(description);
		}

		notificationImpl.setStatus(status);
		notificationImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			notificationImpl.setStatusByUserName("");
		}
		else {
			notificationImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			notificationImpl.setStatusDate(null);
		}
		else {
			notificationImpl.setStatusDate(new Date(statusDate));
		}

		notificationImpl.resetOriginalValues();

		return notificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		notificationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		fromUserId = objectInput.readLong();
		fromApp = objectInput.readUTF();

		toUserId = objectInput.readLong();

		read = objectInput.readBoolean();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(notificationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(fromUserId);

		if (fromApp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fromApp);
		}

		objectOutput.writeLong(toUserId);

		objectOutput.writeBoolean(read);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long notificationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long fromUserId;
	public String fromApp;
	public long toUserId;
	public boolean read;
	public String title;
	public String description;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}