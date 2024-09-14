package xlight.engine.ecs.system;

import com.badlogic.gdx.utils.IntArray;
import xlight.engine.ecs.XECSWorld;
import xlight.engine.ecs.component.XComponentMatcher;
import xlight.engine.ecs.component.XComponentMatcherBuilder;
import xlight.engine.ecs.component.XComponentService;
import xlight.engine.ecs.entity.XEntity;
import xlight.engine.ecs.entity.XEntityService;

/**
 * XEntitySystem is a higher class that already do all the component matching for you.
 * For every frame it calls onEntityTick passing each entity.
 */
public abstract class XEntitySystem implements XSystem {

    private XEntityService entityService;
    private XComponentService componentService;
    protected IntArray entities;

    @Override
    public final void onAttach(XECSWorld world) {
        entityService = world.getEntityService();
        componentService = world.getComponentService();
        XComponentMatcherBuilder matcherBuilder = componentService.getMatcherBuilder();
        XComponentMatcher matcher = getMatcher(matcherBuilder);
        entities = matcher.getEntities();
        onAttachSystem(world);
    }

    @Override
    public final void onDetach(XECSWorld world) {
        onDetachSystem(world);
    }

    @Override
    public final void onTick(XECSWorld world) {
        if(entities == null) {
            return;
        }
        if(onBeginTick()) {
            return;
        }
        for(int i = 0; i < entities.size; i++) {
            int entityId = entities.get(i);
            XEntity entity = entityService.getEntity(entityId);
            onEntityTick(componentService, entity);
        }
        onEndTick();
    }

    /**
     * Returning true will skip processing all entities.
     */
    protected boolean onBeginTick() { return false; }
    protected void onEndTick() {}

    public abstract XComponentMatcher getMatcher(XComponentMatcherBuilder builder);
    public void onAttachSystem(XECSWorld world) {}
    public void onDetachSystem(XECSWorld world) {}
    public abstract void onEntityTick(XComponentService cs, XEntity e);
}