import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { KanbanBoardComponent } from './kanban/kanban-board/kanban-board.component';
import { InscrireComponent } from './inscrire/inscrire.component';

const routes: Routes = [
  { path: '', component: KanbanBoardComponent },
  { path: 'inscrire', component: InscrireComponent }, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
