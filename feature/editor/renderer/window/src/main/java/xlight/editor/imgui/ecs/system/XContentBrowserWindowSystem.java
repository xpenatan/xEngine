package xlight.editor.imgui.ecs.system;

import imgui.ImGui;
import imgui.ImGuiWindowClass;
import xlight.editor.imgui.ecs.manager.XImGuiManager;
import xlight.editor.imgui.ui.filebrowser.XContentBrowser;
import xlight.editor.imgui.window.XImGuiWindowContext;
import xlight.editor.imgui.window.XMainWindow;
import xlight.engine.ecs.XWorld;
import xlight.engine.ecs.system.XSystem;
import xlight.engine.ecs.system.XSystemData;
import xlight.engine.ecs.system.XSystemType;

public class XContentBrowserWindowSystem implements XSystem {

    public final static String name = "Content Browser";

    private ImGuiWindowClass windowClass;

    private XContentBrowser contentBrowser;

    @Override
    public void onAttach(XWorld world, XSystemData systemData) {
        XImGuiManager imguiManager = world.getManager(XImGuiManager.class);
        XImGuiWindowContext windowContext = imguiManager.getWindowContext(XMainWindow.CLASS_ID);
        windowClass = windowContext.getWindowClass();
        contentBrowser = new XContentBrowser();
        contentBrowser.init(world);
    }

    @Override
    public void onTick(XWorld world) {
        ImGui.SetNextWindowClass(windowClass);
        ImGui.Begin(name);
        {
            contentBrowser.render();
        }
        ImGui.End();
    }

    @Override
    public XSystemType getType() {
        return XSystemType.UI;
    }
}