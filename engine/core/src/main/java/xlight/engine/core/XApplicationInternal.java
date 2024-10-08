package xlight.engine.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import xlight.engine.ecs.event.XEvent;
import xlight.engine.ecs.event.XEventService;
import xlight.engine.scene.ecs.manager.XSceneManager;

class XApplicationInternal implements ApplicationListener {

    protected XEngine engine;
    private XApplication applicationListener;

    public XApplicationInternal(XEngine engine, XApplication applicationListener) {
        this.applicationListener = applicationListener;
        this.engine = engine;
    }

    @Override
    public void create() {
        engine.update(1); // Do a single update so default manager/services are initialized
        applicationListener.onSetup(engine);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1, true);
        float deltaTime = Gdx.graphics.getDeltaTime();
        engine.update(deltaTime);
        engine.render();
    }

    @Override
    public void resize(int width, int height) {
        engine.getWorld().getWorldService().getEventService().sendEvent(XEngineEvent.EVENT_RESIZE);
    }

    @Override
    public void pause() {
        engine.getWorld().getWorldService().getEventService().sendEvent(XEngineEvent.EVENT_PAUSE);
    }

    @Override
    public void resume() {
        engine.getWorld().getWorldService().getEventService().sendEvent(XEngineEvent.EVENT_RESUME);
    }

    @Override
    public void dispose() {
        engine.dispose();
    }
}