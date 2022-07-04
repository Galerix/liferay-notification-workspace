create index IX_390C9E85 on Notification_Notification (groupId);
create index IX_622BBFDF on Notification_Notification (toUserId, read_);
create index IX_8FC53E79 on Notification_Notification (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A84D0F3B on Notification_Notification (uuid_[$COLUMN_LENGTH:75$], groupId);