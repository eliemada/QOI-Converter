package ch.epfl.cs107.play.game.icrogue.actor.items;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

public class Staff extends Item{
    public Staff(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position);
        setSprite(new Sprite("zelda/staff_water.icon", .5f, .5f, this));

    }

    public Staff(Area area, Orientation orientation, DiscreteCoordinates position,Sprite givenSprite,
             boolean isCollected) {
        super(area, orientation, position,givenSprite,isCollected);
        sprite.setParent(this);

    }

    @Override
    public boolean isViewInteractable() {
        return false;
    }
}
