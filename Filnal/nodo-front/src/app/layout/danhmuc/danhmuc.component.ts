import { LoaidanhmucService } from './../../../service/loaidanhmuc.service';
import { DanhmucService } from './../../../service/danhmuc.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-danhmuc',
  templateUrl: './danhmuc.component.html',
  styleUrls: ['./danhmuc.component.css']
})
export class DanhmucComponent implements OnInit {


  page: number = 1;
  count: number = 0;
  tableSize: number = 5;
  tableSizes: any = [3, 6, 9, 12];


  onTableDataChange(event: any) {
    this.page = event;
    this.getList();
  }
  onTableSizeChange(event: any): void {
    this.tableSize = event.target.value;
    this.page = 1;
    this.getList();
  }

  constructor(private service: DanhmucService, private ldmService: LoaidanhmucService, private fb: FormBuilder) { }

  listDanhMuc: any
  listLoaiDanhMuc: any

  ngOnInit(): void {
    this.getList();
  }
  getList() {
    this.service.getListDanhMuc().subscribe(resp => {
      this.listDanhMuc = resp.data;
    });
    this.ldmService.getListLoaiDanhMuc().subscribe(resp => {
      this.listLoaiDanhMuc = resp.data;
    })
  }

  onSubmit() {
    let a = this.getLoaiDanhMuc(this.DanhMucForm.getRawValue().loaiDanhMuc)[0];
    this.DanhMucForm.value.loaiDanhMuc = a;
    a.ngayCapNhat = null;
    a.ngayHetHieuLuc = null;
    a.ngayHieuLuc = null;
    a.ngayTao = null;
    a.listDM = null;
    if (this.DanhMucForm.getRawValue().id == "") {
      console.log(this.DanhMucForm.value)
      this.create(this.DanhMucForm.value);
    } else {
      this.update(this.DanhMucForm.value);
    }
    this.DanhMucForm.reset();

  }

  create(data: any) {
    this.service.insertData(data).subscribe(resp => {
      this.ngOnInit();
      console.log(resp);
    })
  }

  update(data: any) {
    this.service.updateData(data, data.id).subscribe(resp => {
      this.ngOnInit();
      console.log(resp);
    })
  }
  delete(id: number) {
    this.service.deleteData(id).subscribe(resp => {
      this.ngOnInit();
    })
  }

  DanhMucForm = this.fb.group({
    id: [''],
    ten: [''],
    ma: [''],
    nhom: [''],
    thuTu: [''],
    trangThai: [''],
    nguoiCapNhat: [{
      id: 1,
      ten: 'Kiên',
      role: '1'
    }],
    loaiDanhMuc: [''],
    ngayHieuLuc: [''],
    ngayHetHieuLuc: [''],
    ngayTao: new Date(),
    ngayCapNhat: new Date(),
  })


  getLoaiDanhMuc(id: any) {
    return this.listLoaiDanhMuc.filter((x: { id: number; }) => x.id == id)
  }
  edit(item: any) {
    this.DanhMucForm.patchValue(item);
  }

  formFind = this.fb.group({
    ten: [],
    ma: [],
    trangThai: []
  })
  find() {
    console.log(this.formFind.value)
    this.service.findDanhMuc(this.formFind.value).subscribe(resp => {
      this.listDanhMuc = resp.data;
      console.log("find Danh mục", this.listDanhMuc);
    });
  }
}
