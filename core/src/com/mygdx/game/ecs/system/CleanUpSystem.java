package com.mygdx.game.ecs.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.mygdx.game.ecs.component.CleanUpComponent;
import com.mygdx.game.ecs.component.DimensionComponent;
import com.mygdx.game.ecs.component.Mappers;
import com.mygdx.game.ecs.component.PositionComponent;

public class CleanUpSystem extends IteratingSystem {

  private static final Family FAMILY = Family.all(
          CleanUpComponent.class,
          PositionComponent.class,
          DimensionComponent.class
  ).get();

  public CleanUpSystem() {
    super(FAMILY);
  }

  @Override
  protected void processEntity(Entity entity, float deltaTime) {
    PositionComponent position = Mappers.POSITION.get(entity);
    DimensionComponent dimensionComponent = Mappers.DIMENSION.get(entity);

    if (position.y < -dimensionComponent.height) {
      getEngine().removeEntity(entity);
    }
  }
}
