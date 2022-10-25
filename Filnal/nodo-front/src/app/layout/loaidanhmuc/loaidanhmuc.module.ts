import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoaidanhmucRoutingModule } from './loaidanhmuc-routing.module';
import { LoaidanhmucComponent } from './loaidanhmuc.component';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    LoaidanhmucComponent
  ],
  imports: [
    CommonModule,
    LoaidanhmucRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ]
})
export class LoaidanhmucModule { }
