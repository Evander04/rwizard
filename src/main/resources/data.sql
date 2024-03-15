INSERT INTO role (title,code,status) VALUES ('Root User','ROOT',true);
INSERT INTO person(first_name,middle_name,last_name,dob,status) VALUES ('ROOT','','USER',NOW(),true);
INSERT INTO user_obj(username,email,status,person_id,role_id,password) VALUES ('root','root@rwizard.com',true,1,1,'$2a$10$092/sl0ZuxymGyBXSKe6W.l17qKbfQaFB2YI3ETOwNgsiSTPjDj2e');
-- password:root