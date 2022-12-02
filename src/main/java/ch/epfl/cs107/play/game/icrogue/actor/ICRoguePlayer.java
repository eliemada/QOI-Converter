package ch.epfl.cs107.play.game.icrogue.actor;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Animation;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.icrogue.actor.projectiles.Fire;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.RegionOfInterest;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Button;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ICRoguePlayer extends ICRogueActor {


    private static final int ANIMATION_DURATION = 5;
    private final Keyboard keyboard;
    //private final Sprite spriteUp,spriteDown,spriteRight,spriteLeft;
    private static final int MOVE_DURATION = 5;
    private Sprite [][] sprites = Sprite.extractSprites("zelda/player",
            4, 1, 2,
            this , 16, 32, new Orientation [] { Orientation .DOWN ,
                    Orientation .RIGHT , Orientation .UP , Orientation . LEFT });
    // crée un tableau de 4 animation
    private Animation[] animations =
            Animation.createAnimations( ANIMATION_DURATION /2, sprites );
    private Fire fireball;
    public ICRoguePlayer(Area room, Orientation orientation, DiscreteCoordinates position
                         ) {
        super(room, orientation, position);
       /* XXX
            Useful before the implementation of the animations !

          //bas
       spriteDown = new Sprite("zelda/player", .75f, 1.5f, this, new RegionOfInterest(0, 0, 16, 32),
                    new Vector(0,0));
            //haut
        spriteUp = new Sprite("zelda/player", .75f, 1.5f, this, new RegionOfInterest(0, 64, 16, 32),
                    new Vector(0,0));
            //droite
        spriteRight = new Sprite("zelda/player", .75f, 1.5f, this, new RegionOfInterest(0, 32, 16, 32),
                    new Vector(0,0));
        //gauche
        spriteLeft = new Sprite("zelda/player", .75f,1.5f,this,new RegionOfInterest(0,96,16,32),
                new Vector(0,0));
        */


        keyboard = getOwnerArea().getKeyboard();
    }


    @Override
    public void update(float deltaTime){
        super.update(deltaTime);

        moveIfPressed(Orientation.LEFT, keyboard.get(Keyboard.LEFT),deltaTime);
        moveIfPressed(Orientation.UP, keyboard.get(Keyboard.UP),deltaTime);
        moveIfPressed(Orientation.RIGHT, keyboard.get(Keyboard.RIGHT),deltaTime);
        moveIfPressed(Orientation.DOWN, keyboard.get(Keyboard.DOWN),deltaTime);
        if(keyboard.get(Keyboard.X).isPressed()){
            fireball = new Fire(getOwnerArea(), getOrientation(),
                    getCurrentMainCellCoordinates());
            fireball.enterArea(getOwnerArea());
        }

        //TODO next time need to add the fireball when X is pressed
    }

    private void ifKeyIsPressed(Button pressedKey){

    }
    private void moveIfPressed(Orientation orientation, Button pressedKey,float deltatime){
        if(pressedKey.isDown()) {
            if (!isDisplacementOccurs()) {
                orientate(orientation);
                move(MOVE_DURATION);
                animations[getOrientation().ordinal()].update(deltatime);
            }

        }
    }

    @Override
    public void draw(Canvas canvas) {
        switch (getOrientation()) {
            case UP -> animations[Orientation.UP.ordinal()].draw(canvas);
            case DOWN -> animations[Orientation.DOWN.ordinal()].draw(canvas);
            case LEFT ->  animations[Orientation.LEFT.ordinal()].draw(canvas);
            case RIGHT -> animations[Orientation.RIGHT.ordinal()].draw(canvas);
        }
    }



    @Override
    public List<DiscreteCoordinates> getCurrentCells() {
        return Collections.singletonList(getCurrentMainCellCoordinates());
    }

    @Override
    public boolean takeCellSpace() {
        return true;
    }

    @Override
    public boolean isCellInteractable() {
        return true ;
    }

    @Override
    public boolean isViewInteractable() {
        return true;
    }

    @Override
    public void acceptInteraction(AreaInteractionVisitor v, boolean isCellInteraction) {

    }
}
