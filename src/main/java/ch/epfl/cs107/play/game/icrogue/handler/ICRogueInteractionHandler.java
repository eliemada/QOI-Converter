package ch.epfl.cs107.play.game.icrogue.handler;

import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.icrogue.ICRogueBehavior;
import ch.epfl.cs107.play.game.icrogue.actor.Connector;
import ch.epfl.cs107.play.game.icrogue.actor.ICRoguePlayer;
import ch.epfl.cs107.play.game.icrogue.actor.enemies.Turret;
import ch.epfl.cs107.play.game.icrogue.actor.items.*;
import ch.epfl.cs107.play.game.icrogue.actor.projectiles.Arrow;
import ch.epfl.cs107.play.game.icrogue.actor.projectiles.Fire;

public interface ICRogueInteractionHandler extends AreaInteractionVisitor {
    default void interactWith(ICRogueBehavior.ICRogueCell cell, boolean isCellInteraction) {
    }

    default void interactWith(ICRoguePlayer player, boolean isCellInteraction) {
    }

    default void interactWith(Heart heart, boolean isCellInteraction) {
    }
    default void interactWith(Cherry cherry, boolean isCellInteraction) {
    }
    default void interactWith(Arrow arrow, boolean isCellInteraction) {
    }
    default void interactWith(Turret turret, boolean isCellInteraction) {
    }

    default void interactWith(Staff staff, boolean isCellInteraction) {
    }

    default void interactWith(Key key, boolean isCellInteraction) {
    }

    default void interactWith(Fire fireBall, boolean isCellInteraction) {
    }

    default void interactWith(Connector connector, boolean isCellInteraction) {
    }

    default void interactWith(HellFire hellfire, boolean isCellInteraction) {
    }


}