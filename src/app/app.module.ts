import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { KanbanModule } from './kanban/kanban.module';
import { KanbanBoardComponent } from "./kanban/kanban-board/kanban-board.component";
import { ConnecterComponent } from './connecter/connecter.component';
import { InscrireComponent } from './inscrire/inscrire.component';
import { ListeProjetComponent } from './liste-projet/liste-projet.component';
import { AppRoutingModule } from './app-routing.module';
import { PagePersoComponent } from './page-perso/page-perso.component';

@NgModule({
  declarations: [AppComponent, ConnecterComponent, InscrireComponent, ListeProjetComponent, PagePersoComponent],
  imports: [BrowserModule, KanbanModule, KanbanBoardComponent, AppRoutingModule],
  bootstrap: [AppComponent]
})
export class AppModule {}
