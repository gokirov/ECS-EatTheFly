package com.mygdx.game.ecs.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.mygdx.game.ecs.component.BoundsComponent;
import com.mygdx.game.ecs.component.DimensionComponent;
import com.mygdx.game.ecs.component.Mappers;
import com.mygdx.game.ecs.component.PositionComponent;

public class BoundsSystem extends IteratingSystem {

  private static final Family FAMILY = Family.all(
          BoundsComponent.class,
          PositionComponent.class,
          DimensionComponent.class
  ).get();

  public BoundsSystem() {
    super(FAMILY);
  }

  @Override
  protected void processEntity(Entity entity, float deltaTime) {
    BoundsComponent bounds = Mappers.BOUNDS.get(entity);
    PositionComponent position = Mappers.POSITION.get(entity);
    DimensionComponent dimension = Mappers.DIMENSION.get(entity);

    bounds.rectangle.x = position.x;
    bounds.rectangle.y = position.y;
    bounds.rectangle.width = dimension.width;
    bounds.rectangle.height = dimension.height;
    //TODO Upgrade from rectangle to  poligon?
    //https://stackoverflow.com/questions/30554629/how-can-i-rotate-rectangles-in-libgdx
  }
}
