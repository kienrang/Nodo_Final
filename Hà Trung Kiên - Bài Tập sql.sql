-- 1, T?o c?u tr�c b?ng 
create table loai_sach_hkien
    (
        hk_id_ls number primary key,
        hk_code varchar2(30),
        hk_name varchar2(100)
    )
    create table sach_hkien(
        hk_id_s number primary key,
        hk_loai_sach_id number,
        hk_code varchar2(30),
        hk_name varchar2(100),
        hk_status varchar2(1)
    );
    
    create table nhan_vien_hkien
    (
        hk_id_nv number primary key,
        hk_phong_ban_id number,
        hk_code varchar2(30),
        hk_name varchar2(100),
        hk_status varchar2(1)
    );

    create table phong_ban_hkien
    (
        hk_id_pb number primary key,
        hk_code varchar2(30),
        hk_name varchar2(100),
        hk_status varchar2(1)
    );
    create table muon_sach_hkien
    (
        hk_id_ms number primary key,
        hk_sach_id number,
        hk_nhan_vien_id number,
        hk_ngay_muon date,
        hk_status varchar2(1),
        hk_ngay_tra date
    );
    
    
--2 T?o kh�a ngo?i

Alter Table sach_hkien add  constraint fk_loaisach foreign key (hk_loai_sach_id) references loai_sach_hkien(hk_id_pb)
Alter Table nhan_vien_hkien add  constraint fk_nhanvien foreign key (hk_phong_ban_id) references phong_ban_hkien(hk_id_ls)
Alter Table muon_sach_hkien add  constraint fk_msach_s foreign key (hk_sach_id) references sach_hkien(hk_id_s)
Alter Table muon_sach_hkien add  constraint fk_msach_nv foreign key (hk_nhan_vien_id) references nhan_vien_hkien(hk_id_nv)

-- 3 insert d? li?u
insert into loai_sach_hkien values(1,'LS001','S�ch v?n h?c');
insert into loai_sach_hkien values(2,'LS002','S�ch kinh t?');
insert into loai_sach_hkien values(3,'LS003','S�ch k? n?ng');
insert into loai_sach_hkien values(4,'LS004','S�ch thi?u nhi');
insert into loai_sach_hkien values(5,'LS005','S�ch gi�o khoa');
insert into loai_sach_hkien values(6,'LS006','S�ch tham kh?o');
insert into loai_sach_hkien values(7,'LS007','S�ch ngo?i ng?');
insert into loai_sach_hkien values(8,'LS008','S�ch t? nhi�n');
insert into loai_sach_hkien values(9,'LS009','S�ch l?ch s?');
insert into loai_sach_hkien values(10,'LS010','S�ch v?n h�a');

insert into sach_hkien values(1,1,'S001','Ng? V?n ','A');
insert into sach_hkien values(2,3,'S002','K? n?ng s?ng ','A');
insert into sach_hkien values(3,2,'S003','Kinh t? h?c ','A');
insert into sach_hkien values(4,1,'S004','S�ch v?n h?c 4','A');
insert into sach_hkien values(5,1,'S005','S�ch v?n h?c 5','A');
insert into sach_hkien values(6,1,'S006','S�ch v?n h?c 6','A');
insert into sach_hkien values(7,1,'S007','S�ch v?n h?c 7','A');
insert into sach_hkien values(8,1,'S008','S�ch v?n h?c 8','A');
insert into sach_hkien values(9,1,'S009','S�ch v?n h?c 9','A');
insert into sach_hkien values(10,1,'S010','S�ch v?n h?c 10','A');

insert into phong_ban_hkien values(1,'PB001','Ph�ng k? to�n','0');
insert into phong_ban_hkien values(2,'PB002','Ph�ng nh�n s?','1');
insert into phong_ban_hkien values(3,'PB003','Ph�ng k? thu?t','0');
insert into phong_ban_hkien values(4,'PB004','Ph�ng h�nh ch�nh','0');
insert into phong_ban_hkien values(5,'PB005','Ph�ng kinh doanh','0');

insert into nhan_vien_hkien values(1,1,'NV001','Nguy?n V?n A','A');
insert into nhan_vien_hkien values(2,2,'NV002','Nguy?n V?n B','A');
insert into nhan_vien_hkien values(3,3,'NV003','Nguy?n V?n C','A');
insert into nhan_vien_hkien values(4,4,'NV004','Nguy?n V?n D','A');
insert into nhan_vien_hkien values(5,5,'NV005','Nguy?n V?n E','A');
insert into nhan_vien_hkien values(6,1,'NV006','Nguy?n V?n F','A');
insert into nhan_vien_hkien values(7,2,'NV007','Nguy?n V?n G','A');
insert into nhan_vien_hkien values(8,3,'NV008','Nguy?n V?n H','A');
insert into nhan_vien_hkien values(9,4,'NV009','Nguy?n V?n I','A');
insert into nhan_vien_hkien values(10,5,'NV010','Nguy?n V?n J','A');


insert into muon_sach_hkien values(1,1,1,sysdate,'A',sysdate);
insert into muon_sach_hkien values(2,2,2,sysdate,'A',sysdate);
insert into muon_sach_hkien values(3,3,3,sysdate,'A',sysdate);
insert into muon_sach_hkien values(4,4,4,sysdate,'A',sysdate);
insert into muon_sach_hkien values(5,5,5,sysdate,'A',sysdate);
insert into muon_sach_hkien values(6,6,6,sysdate,'A',sysdate);
insert into muon_sach_hkien values(7,7,7,sysdate,'A',sysdate);
insert into muon_sach_hkien values(8,2,4,sysdate,'A',sysdate);
insert into muon_sach_hkien values(9,3,5,sysdate,'A',to_date('2022/10/17','yyyy-MM-dd'));
insert into muon_sach_hkien values(10,3,5,to_date('2022/10/17','yyyy-MM-dd'),'A',to_date('2022/10/19','yyyy-MM-dd'));


select * from muon_sach_hkien;
select * from sach_hkien;
select * from loai_sach_hkien;
select * from nhan_vien_hkien;

--1: Th?ng k� t?ng s? l??t m??n s�ch, m?i l?n m??n s�ch ???c t�nh l� m?t l??t(m?t b?n ghi trong b?ng muon sach) trong m?t kho?ng th?i gian fromDate, toDate
--
select count(hk_nhan_vien_id) as so_luot_muon  from muon_sach_hkien  where hk_ngay_muon >= to_date('12-10-2022','dd-MM-yyyy') and  hk_ngay_muon <  to_date('15-10-2022','dd-MM-yyyy');



--   2: Th?ng k� s? l??t m??n s�ch theo lo?i s�ch ??u ra v� d? nh?,c�ch t�nh l??t m??n nh? BT1, trong kho?ng th?i gian t? FromDate, ToDate
--        Lo?i s�ch, L??t m??n, t? l?
--        S�ch Java, 15, 30%
--        S�ch SQL 35, 70%  
select ls.hk_name, count(ms.hk_id_ms) as luot_muon, count(ms.hk_id_ms)*100/(select count(*) from muon_sach_hkien)||'%'  as ty_le
from muon_sach_hkien ms, sach_hkien s, loai_sach_hkien ls
where ms.hk_sach_id = s.hk_id_s and s.hk_loai_sach_id = ls.hk_id_ls
group by ls.hk_name;


--    3: Th?ng k� s? l??ng nh�n vi�n m??n s�ch trong kho?ng th?i gian t? formDate, ToDate(Trong kho?ng th?i gian m?t nh�n vi�n m??n 100 cu?n c?ng t�nh l� m?t)
--        ??u ra : Ch? hi?n th� s? l??ng v� d? 100(t?c l� trong kho?ng th?i gian ?� c� 100 nh�n vi�n m??n)
--

select count(distinct hk_nhan_vien_id) as so_luong_nhan_vien_muon from muon_sach_hkien
    where hk_ngay_muon between to_date('10-06-2022','dd-MM-yyyy') and to_date('25-10-2022','dd-MM-yyyy');

--    4: Th?ng k� 10 ph�ng ban c� l??t m??n nhi?u nh?t trong m?t kho?ng th?i gian FromDate, ToDate
--        ??u ra : Ph�ng ban 1, 100
--                 Ph�ng ban 2, 50

select pb.hk_name, count(ms.hk_id_ms) as luot_muon
from muon_sach_hkien ms, nhan_vien_hkien nv, phong_ban_hkien pb
where ms.hk_nhan_vien_id = nv.hk_id_nv and nv.hk_phong_ban_id = pb.hk_id_pb
group by pb.hk_name;
--    5 : Th�ng k� 10 nh�n vi�n c� l??t m??n nhi?u nh?t trong m?t kho?ng th?i gian fromDate, toDate
--        ??u ra : M� nh�n vi�n, T�n nh�n vi�n, t�n phong ban, l??t m??n, t? l? %
--                 NH01, Nguy?n V?n A, Ph�ng ban 1, 50, 20%
--                 NH02, Nguy?n V?n B, Ph�ng ban 2, 25, 10%
--             
--        (L?u �:  l??t m??n ???c t�nh b?ng m?t b?n ghi trong b?ng muon_sach, trong kho?ng th?i gian ???c x�c ??nh theo ngay_muon trong b?ng m??n s�ch)
select nv.hk_code, nv.hk_name, pb.hk_name, count(ms.hk_id_ms) as luot_muon, count(ms.hk_id_ms)*100/(select count(*) from muon_sach_hkien) ||'%' as ty_le
from muon_sach_hkien ms, nhan_vien_hkien nv, phong_ban_hkien pb
where ms.hk_nhan_vien_id = nv.hk_id_nv and nv.hk_phong_ban_id = pb.hk_id_pb and rownum <= 10 
group by nv.hk_code, nv.hk_name, pb.hk_name  order by luot_muon desc;




    