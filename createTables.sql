CREATE TABLE UserRoles (
	ur_id integer primary key,
	ur_role varchar2(40)
);

CREATE TABLE ReimbursementStatus (
	rs_id integer primary key,
	rs_status varchar2(30) not null
);

CREATE TABLE ReimbursementType (
	rt_id integer primary key,
	rt_type varchar2(30) not null
);

CREATE TABLE Users (
	u_id integer primary key,
	u_username varchar2(40) not null,
	u_password varchar2(40) not null,
	u_firstname varchar2(30),
	u_lastname varchar2(30),
	u_email varchar2(100),
	ur_id integer not null,
	CONSTRAINT ERS_USERS_U_USERNAME_UN UNIQUE (u_username),
	CONSTRAINT ERS_USERS_U_EMAIL_UN UNIQUE (u_email),
	FOREIGN KEY (ur_id) REFERENCES UserRoles (ur_id)
);

CREATE TABLE Reimbursements (
	r_id integer primary key,
	r_amount number(22,2) not null,
	r_description varchar2(100),
	r_receipt blob,
	r_submitted timestamp not null,
	r_resolved timestamp,
	u_id_author integer not null,
	u_id_resolver integer,
	rt_type integer not null,
	rt_status integer not null,
	FOREIGN KEY (u_id_author) REFERENCES Users (u_id),
	FOREIGN KEY (u_id_resolver) REFERENCES Users (u_id),
	FOREIGN KEY (rt_type) REFERENCES ReimbursementType (rt_id),
	FOREIGN KEY (rt_status) REFERENCES ReimbursementStatus (rs_id)
);