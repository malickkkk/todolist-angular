import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { KanbanModule } from './kanban/kanban.module';
import { KanbanBoardComponent } from "./kanban/kanban-board/kanban-board.component";

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, KanbanModule, KanbanBoardComponent],
  bootstrap: [AppComponent]
})
export class AppModule {}
