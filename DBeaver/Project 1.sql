CREATE TABLE roles (
	role_id serial PRIMARY KEY,
	user_role TEXT
);

INSERT INTO roles
VALUES
(DEFAULT, 'Employee'),
(DEFAULT, 'Admin');

---------------------------------------------

CREATE TABLE employee (
	employee_id serial PRIMARY KEY,
	company_email  TEXT UNIQUE,
	f_name TEXT,
	l_name TEXT,
	employee_username TEXT UNIQUE,
	employee_password TEXT,
	role_id int,
	CONSTRAINT fk_roles_employee FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

---------------------------------------------

CREATE TABLE status (
	status_id serial PRIMARY KEY,
	status_resolution TEXT
);

INSERT INTO status
VALUES
(DEFAULT, 'Approved'),
(DEFAULT, 'Denied');

---------------------------------------------

CREATE TABLE lodging (
	lodging_id serial PRIMARY KEY,
	employee_id int,
	lodging_cost TEXT,
	lodging_info TEXT,
	status int,
	CONSTRAINT fk_employee_lodging FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
	CONSTRAINT fk_status_lodging FOREIGN KEY (status) REFERENCES status(status_id)
);

---------------------------------------------

CREATE TABLE travel (
	travel_id serial PRIMARY KEY,
	employee_id int,
	travel_cost TEXT,
	travel_info TEXT,
	status int,
	CONSTRAINT fk_employee_travel FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
	CONSTRAINT fk_status_travel FOREIGN KEY (status) REFERENCES status(status_id)
);

---------------------------------------------

CREATE TABLE food (
	food_id serial PRIMARY KEY,
	employee_id int,
	food_cost TEXT,
	food_info TEXT,
	status int,
	CONSTRAINT fk_employee_food FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
	CONSTRAINT fk_status_food FOREIGN KEY (status) REFERENCES status(status_id)
);

---------------------------------------------

CREATE TABLE misc (
	misc_id serial PRIMARY KEY,
	employee_id int,
	misc_cost TEXT,
	misc_info TEXT,
	status int,
	CONSTRAINT fk_employee_misc FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
	CONSTRAINT fk_status_misc FOREIGN KEY (status) REFERENCES status(status_id)
);

---------------------------------------------
SELECT * FROM roles;
SELECT * FROM employee;
SELECT * FROM status;
SELECT * FROM lodging;
SELECT * FROM travel;
SELECT * FROM food;
SELECT * FROM misc;


---------------------------------------------

UPDATE lodging SET status = NULL WHERE f_name = 'Bunner' AND l_name ='Fluffer';

UPDATE lodging SET status = NULL WHERE employee_id = 1;

SELECT * FROM lodging WHERE employee_id = 1;

SELECT * FROM lodging WHERE status IS NULL LIMIT 1;

---------------------------------------------

DROP
TABLE IF EXISTS roles;
DROP
TABLE IF EXISTS employee;
DROP
TABLE IF EXISTS status;
DROP
TABLE IF EXISTS lodging;
DROP
TABLE IF EXISTS travel;
DROP
TABLE IF EXISTS food;
DROP
TABLE IF EXISTS misc;

---------------------------------------------


--Creating left join to link reinbursement types and employees
SELECT lodging_info, lodging_cost, employees.f_name , employees.l_name 
FROM lodging LEFT JOIN employees ON lodging.reference_id = employees.employee_id; 

SELECT travel_info, travel_cost, employees.f_name , employees.l_name 
FROM travel LEFT JOIN employees ON travel.reference_id = employees.employee_id; 

SELECT food_info, food_cost, employees.f_name , employees.l_name 
FROM food LEFT JOIN employees ON food.reference_id = employees.employee_id; 

SELECT misc_info, misc_cost, employees.f_name , employees.l_name 
FROM misc LEFT JOIN employees ON misc.reference_id = employees.employee_id; 






