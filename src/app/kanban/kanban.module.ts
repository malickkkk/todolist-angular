import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
// Assurez-vous que le chemin est correct
import { KanbanBoardComponent } from './kanban-board/kanban-board.component';

@NgModule({
  imports: [CommonModule],
  declarations: [], // Pas de déclaration si le composant est standalone
})
export class KanbanModule {}
