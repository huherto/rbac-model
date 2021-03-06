

CREATE TABLE MY_USER (
   USER_ID integer identity NOT Null primary key,
   LOGIN_NAME varchar(40) NOT NULL,
   PASSWORD_VALUE varchar(60) NOT NULL,
   FIRST_NAME varchar(30) NOT NULL,
   LAST_NAME varchar(30) NOT  NULL,
   EMAIL varchar(40) NOT NULL,
   CONFIRM_VALUE varchar(20) NOT NULL,
   MODIFED TIMESTAMP,
   CREATED TIMESTAMP,
   LAST_LOGIN TIMESTAMP,
);

CREATE TABLE ROLE (
   ROLE_ID INTEGER identity NOT NULL primary key,
   ROLE_NAME varchar(60) NOT NULL,
);

CREATE TABLE PERMISSION (
   PERMISSION_ID INTEGER identity PRIMARY KEY,
   PERMISSION_NAME varchar(60) NOT NULL,
);

CREATE TABLE ROLE_PERM (
   ROLE_ID integer references ROLE, 
   PERMISSION_ID integer references PERMISSION,
   primary key(ROLE_ID,PERMISSION_ID)
);

CREATE TABLE USER_ROLE_REALM (
   USER_ROLE_REALM_ID integer identity not null primary key,
   USER_ID integer NOT NULL references MY_USER(USER_ID),
   ROLE_ID integer NOT NULL references ROLE(ROLE_ID),
   REALM varchar(60) NOT NULL,
);
