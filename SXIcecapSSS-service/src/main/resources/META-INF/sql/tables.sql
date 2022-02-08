create table sxicecapsss_Term (
	uuid_ VARCHAR(75) null,
	termId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	lastPublishDate DATE null,
	termName VARCHAR(75) null,
	termVersion VARCHAR(75) null,
	termType VARCHAR(75) null,
	displayName STRING null,
	definition STRING null,
	tooltip STRING null,
	synonyms VARCHAR(75) null,
	attributesJSON VARCHAR(75) null
);