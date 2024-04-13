INSERT INTO role (title,code,status) VALUES ('ROOT','ROOT',true);
INSERT INTO role (title,code,status) VALUES ('ADMIN','ADMIN',true);
INSERT INTO role (title,code,status) VALUES ('SUPERVISOR','SUPV',true);
INSERT INTO role (title,code,status) VALUES ('EMPLOYEE','ROOT',true);
INSERT INTO person(first_name,middle_name,last_name,dob,status) VALUES ('ROOT','','USER',NOW(),true);
INSERT INTO user_obj(username,email,status,person_id,role_id,password) VALUES ('root','root@rwizard.com',true,1,1,'$2a$10$092/sl0ZuxymGyBXSKe6W.l17qKbfQaFB2YI3ETOwNgsiSTPjDj2e');
-- password:root