import { LoaidanhmucService } from './../../../service/loaidanhmuc.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-loaidanhmuc',
  templateUrl: './loaidanhmuc.component.html',
  styleUrls: ['./loaidanhmuc.component.css']
})
export class LoaidanhmucComponent implements OnInit {

  constructor(private service: LoaidanhmucService, private fb: FormBuilder) { }

  listLoaiDM: any;
  listDM: any;
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

  ngOnInit(): void {
    this.getList();
  }

  getList() {
    this.service.getListLoaiDanhMuc().subscribe(resp => {
      this.listLoaiDM = resp.data;
      console.log(this.listLoaiDM);
    });
  }

  loaiDm = this.fb.group({
    id: [],
    ten: [''],
    ma: [],
    ngayHieuLuc: [''],
    ngayHetHieuLuc: [''],
    trangThai: [1],
    ngayTao: new Date,
    ngayCapNhat: new Date,
    nguoiTao: [{
      "id": 1,
      "ten": "Kiên",
      "role": 1
    }],
  })


  onSubmit() {
    if (this.loaiDm.getRawValue().id == null) {
      this.create(this.loaiDm.value);
      this.loaiDm.reset();
      return;
    }
    this.update(this.loaiDm.value)
    this.loaiDm.reset();
  }
  create(data: any) {
    this.service.insertLoaiDanhMuc(data).subscribe(resp => {
      this.ngOnInit();
      console.log(resp);
    })

  }

  edit(item: any) {
    this.loaiDm.patchValue(item);
  }

  update(data: any) {
    this.service.updateDanhMuc(data, data.id).subscribe(resp => {
      this.ngOnInit();
      console.log(resp);
    })
  }

  delete(id: Number) {
    this.service.deleteDanhMuc(id).subscribe(resp => {
      console.log(id)
      this.ngOnInit();
    })
  }

  clickRowTable(item: any) {
    this.listDM = item.listDM;
  }

  formFind = this.fb.group({
    ten: [],
    ma: [],
    trangThai: []
  })
  find() {
    console.log(this.formFind.value)
    this.service.findLoaiDanhMuc(this.formFind.value).subscribe(resp => {
      this.listLoaiDM = resp.data;
    });
  }
}

