CREATE TABLE LPGStock(
AvQty NUMBER(4),
ReceivedDate Date,
UpdatedBy VARCHAR(50) PRIMARY KEY,
Location VARCHAR(30));



INSERT INTO LPGStock VALUES(50,'27-Sep-16','Bharat Gas','Pune');
INSERT INTO LPGStock VALUES(40,'28-Sep-16','HP Gas','Mumbai');
INSERT INTO LPGStock VALUES(45,'29-Sep-16','Super Gas','Mumbai');
INSERT INTO LPGStock VALUES(23,'25-Sep-16','Seva Gas Service','Bangalore');
INSERT INTO LPGStock VALUES(34,'24-Sep-16','Khalsa Gas','Pune');
INSERT INTO LPGStock VALUES(0,'27-Sep-16','Krishna Gas','Bangalore');

COMMIT;
