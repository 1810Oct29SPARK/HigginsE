import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MemberRoutingModule } from './member-routing.module';
import { MemberHomeComponent } from './member-home/member-home.component';

import { MaterialModule } from '../material.module';

@NgModule({
  declarations: [MemberHomeComponent],
  imports: [
    CommonModule,
    MaterialModule,
    MemberRoutingModule
  ]
})
export class MemberModule { }
