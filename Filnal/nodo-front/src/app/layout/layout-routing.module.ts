import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: '',
        redirectTo: 'content',
        pathMatch: 'full'
      },
      {
        path: 'content',
        loadChildren: () => import('../layout/content/content.module').then(m => m.ContentModule),
      },
      { path: 'danhmuc', loadChildren: () => import('./danhmuc/danhmuc.module').then(m => m.DanhmucModule) },
      { path: 'loaidanhmuc', loadChildren: () => import('./loaidanhmuc/loaidanhmuc.module').then(m => m.LoaidanhmucModule) },
    ]
  },



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
