DROP DATABASE QLDKMH;

CREATE DATABASE QLDKMH;

USE QLDKMH;

CREATE TABLE TAIKHOAN(
MATK VARCHAR(15) PRIMARY KEY,
TENDN VARCHAR(20),
MATKHAU VARCHAR(20),
NGLAP VARCHAR(15),
EMAIL VARCHAR(30));

CREATE TABLE SINHVIEN(
MASV VARCHAR(15) PRIMARY KEY,
TENSV VARCHAR(30),
SODT VARCHAR(15),
KHOA VARCHAR(15),
DIACHI VARCHAR(30));

CREATE TABLE KHOA(
MAKHOA VARCHAR(15) PRIMARY KEY,
TENKHOA VARCHAR(30),
NAMTL INT);

CREATE TABLE GIANGVIEN(
MAGV VARCHAR(15) PRIMARY KEY,
TENGV VARCHAR(30),
EMAIL VARCHAR(30),
SODT VARCHAR(15),
KHOA VARCHAR(15),
CHUYEN VARCHAR(15));

CREATE TABLE LOP(
MALOP VARCHAR(15) PRIMARY KEY,
TENLOP VARCHAR(30),
NAMHOC INT,
HEDAOTAO VARCHAR(15),
KHOA VARCHAR(15));

CREATE TABLE HEDAOTAO(
MAHDT VARCHAR(15) PRIMARY KEY,
TENHDT VARCHAR(30));

CREATE TABLE HOCPHI(
MAHP VARCHAR(15) PRIMARY KEY,
NGDONG VARCHAR(15),
SOTIEN FLOAT,
MASV VARCHAR(15),
HOCPHAN VARCHAR(15));

CREATE TABLE HOCPHAN(
MAHP VARCHAR(15) PRIMARY KEY,
TENHP VARCHAR(15),
NGBD VARCHAR(15),
NGKT VARCHAR(15),
MONHOC VARCHAR(15),
HOCKY VARCHAR(15),
SISOTOIDA INT,
SISO INT,
MAGV VARCHAR(15));

CREATE TABLE LICHTHI(
MAKT VARCHAR(15) PRIMARY KEY,
TGBD VARCHAR(15),
NGKT VARCHAR(15),
MAHP VARCHAR(15),
LOAIKT VARCHAR(15));

CREATE TABLE KETQUA(
MASV VARCHAR(15) PRIMARY KEY,
MAKT VARCHAR(15),
DIEM FLOAT);

CREATE TABLE CHUYENNGANH(
MACN VARCHAR(15) PRIMARY KEY,
TENCN VARCHAR(15),
MAKHOA VARCHAR(15));

CREATE TABLE TIETHOC(
MATH VARCHAR(15) PRIMARY KEY,
GIOBD VARCHAR(15),
NGHOC VARCHAR(15),
SOTIET INT,
LOAITIETHOC VARCHAR(30),
LOP VARCHAR(15),
PHONG VARCHAR(15),
MAHP VARCHAR(15));

CREATE TABLE PHONGHOC(
MAPH VARCHAR(15) PRIMARY KEY,
TENPH VARCHAR(30),
KHU VARCHAR(15),
LAU INT,
COSO VARCHAR(15));

CREATE TABLE MONHOC(
MAMH VARCHAR(15) PRIMARY KEY,
TENMH VARCHAR(30),
SOTC INT);

CREATE TABLE HOCKY(
MAHK VARCHAR(15) PRIMARY KEY,
TENHK VARCHAR(20),
NGAYBD VARCHAR(15),
NGAYKT VARCHAR(15),
NAM INT);

CREATE TABLE DANGKY(
MAHP VARCHAR(15),
MASV VARCHAR(15),
NGGAYDK VARCHAR(15));

CREATE TABLE PHANCONG(
MAGV VARCHAR(15),
MAPC VARCHAR(15),
LOAIPC VARCHAR(15));

-- TABLE TAIKHOAN
-- TABLE SINHVIEN
ALTER TABLE SINHVIEN ADD FOREIGN KEY (KHOA) REFERENCES KHOA(MAKHOA);
-- TABLE GIANGVIEN
ALTER TABLE GIANGVIEN ADD FOREIGN KEY (KHOA) REFERENCES KHOA(MAKHOA);
ALTER TABLE GIANGVIEN ADD FOREIGN KEY (CHUYEN) REFERENCES CHUYENNGANH(MACN);
-- TABLE KHOA
-- TABLE LOP
ALTER TABLE LOP ADD FOREIGN KEY (HEDAOTAO) REFERENCES HEDAOTAO(MAHDT);
ALTER TABLE LOP ADD FOREIGN KEY (KHOA) REFERENCES KHOA(MAKHOA);
-- TABLE HEDAOTAO
-- TABLE TIETHOC
ALTER TABLE TIETHOC ADD FOREIGN KEY (LOP) REFERENCES LOP(MALOP);
ALTER TABLE TIETHOC ADD FOREIGN KEY (PHONG) REFERENCES PHONGHOC(MAPH);
ALTER TABLE TIETHOC ADD FOREIGN KEY (MAHP) REFERENCES HOCPHAN(MAHP);
-- TABLE CHUYENNGANH
ALTER TABLE CHUYENNGANH ADD FOREIGN KEY (MAKHOA) REFERENCES KHOA(MAKHOA);
-- TABLE PHONGHOC
-- TABLE HOCPHAN
ALTER TABLE HOCPHAN ADD FOREIGN KEY (MONHOC) REFERENCES MONHOC(MAMH);
ALTER TABLE HOCPHAN ADD FOREIGN KEY (HOCKY) REFERENCES HOCKY(MAHK);
ALTER TABLE HOCPHAN ADD FOREIGN KEY (MAGV) REFERENCES GIANGVIEN(MAGV);
-- TABLE HOCPHI
ALTER TABLE HOCPHI ADD FOREIGN KEY (MASV) REFERENCES SINHVIEN(MASV);
ALTER TABLE HOCPHI ADD FOREIGN KEY (HOCPHAN) REFERENCES HOCPHAN(MAHP);
-- TABLE HOCKY
-- TABLE MONHOC
-- TABLE KIEMTRA
ALTER TABLE LICHTHI ADD FOREIGN KEY (MAHP) REFERENCES HOCPHAN(MAHP);
-- TABLE KETQUA
ALTER TABLE KETQUA ADD FOREIGN KEY (MASV) REFERENCES SINHVIEN(MASV);
ALTER TABLE KETQUA ADD FOREIGN KEY (MAKT) REFERENCES LICHTHI(MAKT);
-- TABLE PHANCONG
ALTER TABLE PHANCONG ADD FOREIGN KEY (MAGV) REFERENCES GIANGVIEN(MAGV);
-- TABLE DANGKY
ALTER TABLE DANGKY ADD FOREIGN KEY (MASV) REFERENCES SINHVIEN(MASV);
ALTER TABLE DANGKY ADD FOREIGN KEY (MAHP) REFERENCES HOCPHAN(MAHP);