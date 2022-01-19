create table ELL_ImpersonationRegistry (
	uuid_ VARCHAR(75) null,
	impersonationRegistryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	screenName VARCHAR(75) null,
	impersonatedUserId LONG,
	impersonatedScreenName VARCHAR(75) null,
	operationDate DATE null,
	operationResult INTEGER
);