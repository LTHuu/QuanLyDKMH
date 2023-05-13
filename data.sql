USE QLDKMH;

INSERT INTO TAIKHOAN (MATK, TENDN, MATKHAU, NGLAP, EMAIL) VALUES
    ('SV001', 'user1', 'pass1', '01/01/2023', 'user1@example.com'),
    ('SV002', 'user2', 'pass2', '02/01/2023', 'user2@example.com'),
    ('SV003', 'user3', 'pass3', '03/01/2023', 'user3@example.com'),
    ('SV004', 'user4', 'pass4', '04/01/2023', 'user4@example.com'),
    ('SV005', 'user5', 'pass5', '05/01/2023', 'user5@example.com'),
    ('SV006', 'user6', 'pass6', '06/01/2023', 'user6@example.com'),
    ('SV007', 'user7', 'pass7', '07/01/2023', 'user7@example.com'),
    ('SV008', 'user8', 'pass8', '08/01/2023', 'user8@example.com'),
    ('SV009', 'user9', 'pass9', '09/01/2023', 'user9@example.com'),
    ('SV010', 'user10', 'pass10', '10/01/2023', 'user10@example.com'),
    ('GV001', 'user11', 'pass11', '11/01/2023', 'user11@example.com'),
    ('GV002', 'user12', 'pass12', '12/01/2023', 'user12@example.com'),
    ('GV003', 'user13', 'pass13', '13/01/2023', 'user13@example.com'),
    ('GV004', 'user14', 'pass14', '14/01/2023', 'user14@example.com'),
    ('GV005', 'user15', 'pass15', '15/01/2023', 'user15@example.com'),
    ('GV006', 'user16', 'pass16', '16/01/2023', 'user16@example.com'),
    ('GV007', 'user17', 'pass17', '17/01/2023', 'user17@example.com'),
    ('GV008', 'user18', 'pass18', '18/01/2023', 'user18@example.com'),
    ('GV009', 'user19', 'pass19', '19/01/2023', 'user19@example.com'),
    ('GV010', 'user20', 'pass20', '20/01/2023', 'user20@example.com');

INSERT INTO KHOA (MAKHOA, TENKHOA, NAMTL) VALUES
    ('KHOA001', 'Khoa 1', 2021),
    ('KHOA002', 'Khoa 2', 2022),
    ('KHOA003', 'Khoa 3', 2023),
    ('KHOA004', 'Khoa 4', 2024),
    ('KHOA005', 'Khoa 5', 2025),
    ('KHOA006', 'Khoa 6', 2026),
    ('KHOA007', 'Khoa 7', 2027),
    ('KHOA008', 'Khoa 8', 2028),
    ('KHOA009', 'Khoa 9', 2029),
    ('KHOA010', 'Khoa 10', 2030);

-- Populating SINHVIEN table with sample data
INSERT INTO SINHVIEN (MASV, TENSV, SODT, KHOA, DIACHI) VALUES
    ('SV001', 'Student 1', '123456789', 'KHOA001', 'Address 1'),
    ('SV002', 'Student 2', '234567890', 'KHOA002', 'Address 2'),
    ('SV003', 'Student 3', '345678901', 'KHOA003', 'Address 3'),
    ('SV004', 'Student 4', '456789012', 'KHOA004', 'Address 4'),
    ('SV005', 'Student 5', '567890123', 'KHOA005', 'Address 5'),
    ('SV006', 'Student 6', '678901234', 'KHOA001', 'Address 6'),
    ('SV007', 'Student 7', '789012345', 'KHOA002', 'Address 7'),
    ('SV008', 'Student 8', '890123456', 'KHOA003', 'Address 8'),
    ('SV009', 'Student 9', '901234567', 'KHOA004', 'Address 9'),
    ('SV010', 'Student 10', '012345678', 'KHOA005', 'Address 10');

-- Populating GIANGVIEN table with sample data
INSERT INTO GIANGVIEN (MAGV, TENGV, EMAIL, SODT, KHOA, CHUYEN) VALUES
    ('GV001', 'Teacher 1', 'teacher1@example.com', '123456789', 'KHOA001', 'CHUYEN001'),
    ('GV002', 'Teacher 2', 'teacher2@example.com', '234567890', 'KHOA002', 'CHUYEN002'),
    ('GV003', 'Teacher 3', 'teacher3@example.com', '345678901', 'KHOA003', 'CHUYEN003'),
    ('GV004', 'Teacher 4', 'teacher4@example.com', '456789012', 'KHOA004', 'CHUYEN004'),
    ('GV005', 'Teacher 5', 'teacher5@example.com', '567890123', 'KHOA005', 'CHUYEN005'),
    ('GV006', 'Teacher 6', 'teacher6@example.com', '678901234', 'KHOA001', 'CHUYEN006'),
    ('GV007', 'Teacher 7', 'teacher7@example.com', '789012345', 'KHOA002', 'CHUYEN007'),
    ('GV008', 'Teacher 8', 'teacher8@example.com', '890123456', 'KHOA003', 'CHUYEN008'),
    ('GV009', 'Teacher 9', 'teacher9@example.com', '901234567', 'KHOA004', 'CHUYEN009'),
    ('GV010', 'Teacher 10', 'teacher10@example.com', '012345678', 'KHOA005', 'CHUYEN010');
INSERT INTO LOP (MALOP, TENLOP, NAMHOC, HEDAOTAO, KHOA) VALUES
    ('LOP001', 'Lop 1', 2021, 'HDT001', 'KHOA001'),
    ('LOP002', 'Lop 2', 2022, 'HDT002', 'KHOA002'),
    ('LOP003', 'Lop 3', 2023, 'HDT003', 'KHOA003'),
    ('LOP004', 'Lop 4', 2024, 'HDT004', 'KHOA004'),
    ('LOP005', 'Lop 5', 2025, 'HDT005', 'KHOA005'),
    ('LOP006', 'Lop 6', 2021, 'HDT001', 'KHOA001'),
    ('LOP007', 'Lop 7', 2022, 'HDT002', 'KHOA002'),
    ('LOP008', 'Lop 8', 2023, 'HDT003', 'KHOA003'),
    ('LOP009', 'Lop 9', 2024, 'HDT004', 'KHOA004'),
    ('LOP010', 'Lop 10', 2025, 'HDT005', 'KHOA005');

-- Populating HEDAOTAO table with sample data
INSERT INTO HEDAOTAO (MAHDT, TENHDT) VALUES
    ('HDT001', 'Hệ đào tạo 1'),
    ('HDT002', 'Hệ đào tạo 2'),
    ('HDT003', 'Hệ đào tạo 3'),
    ('HDT004', 'Hệ đào tạo 4'),
    ('HDT005', 'Hệ đào tạo 5'),
    ('HDT006', 'Hệ đào tạo 6'),
    ('HDT007', 'Hệ đào tạo 7'),
    ('HDT008', 'Hệ đào tạo 8'),
    ('HDT009', 'Hệ đào tạo 9'),
    ('HDT010', 'Hệ đào tạo 10');
    
INSERT INTO HOCPHAN (MAHP, TENHP, NGBD, NGKT, MONHOC, HOCKY, SISOTOIDA, SISO)
VALUES
    ('HP001', 'Học phần 1', '01/01/2023', '30/05/2023', 'MH001', 'HK001', 50, 30),
    ('HP002', 'Học phần 2', '01/01/2023', '30/05/2023', 'MH002', 'HK001', 60, 40),
    ('HP003', 'Học phần 3', '01/01/2023', '30/05/2023', 'MH003', 'HK002', 70, 50),
    ('HP004', 'Học phần 4', '01/01/2023', '30/05/2023', 'MH004', 'HK002', 80, 60),
    ('HP005', 'Học phần 5', '01/01/2023', '30/05/2023', 'MH005', 'HK003', 90, 70),
    ('HP006', 'Học phần 6', '01/01/2023', '30/05/2023', 'MH006', 'HK003', 100, 80); 
    
INSERT INTO KETQUA (MASV, MAKT, DIEM) VALUES
    ('SV001', 'KT001', 8.5),
    ('SV002', 'KT002', 7.2),
    ('SV003', 'KT003', 9.0),
    ('SV004', 'KT004', 6.8),
    ('SV005', 'KT005', 8.9),
    ('SV006', 'KT006', 7.5),
    ('SV007', 'KT007', 9.2),
    ('SV008', 'KT008', 6.5),
    ('SV009', 'KT009', 8.7),
    ('SV010', 'KT010', 7.9);

-- Populating CHUYENNGANH table with sample data
INSERT INTO CHUYENNGANH (MACN, TENCN, MAKHOA) VALUES
    ('CHUYEN001', 'Chuyên ngành 1', 'KHOA001'),
    ('CHUYEN002', 'Chuyên ngành 2', 'KHOA002'),
    ('CHUYEN003', 'Chuyên ngành 3', 'KHOA003'),
    ('CHUYEN004', 'Chuyên ngành 4', 'KHOA004'),
    ('CHUYEN005', 'Chuyên ngành 5', 'KHOA005'),
    ('CHUYEN006', 'Chuyên ngành 6', 'KHOA001'),
    ('CHUYEN007', 'Chuyên ngành 7', 'KHOA002'),
    ('CHUYEN008', 'Chuyên ngành 8', 'KHOA003'),
    ('CHUYEN009', 'Chuyên ngành 9', 'KHOA004'),
    ('CHUYEN010', 'Chuyên ngành 10', 'KHOA005');
    