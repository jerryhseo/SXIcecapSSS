create index IX_D519B8C6 on sxicecapsss_Term (groupId, status);
create index IX_18D85700 on sxicecapsss_Term (groupId, userId, status);
create index IX_CC13DAF0 on sxicecapsss_Term (status);
create index IX_8B0D0FD5 on sxicecapsss_Term (termName[$COLUMN_LENGTH:75$]);
create index IX_DFCAAF2A on sxicecapsss_Term (userId, status);
create index IX_6BEC197E on sxicecapsss_Term (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_8408E780 on sxicecapsss_Term (uuid_[$COLUMN_LENGTH:75$], groupId);