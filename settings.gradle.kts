pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

include(":engine:core")
include(":engine:desktop")
include(":engine:web")

include(":editor:core")
include(":editor:desktop")
include(":editor:teavm")

// Features

include(":features:engine:ecs")
include(":features:engine:camera")
include(":features:engine:pool")
include(":features:engine:list")
include(":features:engine:math")
include(":features:engine:lang")
include(":features:engine:shaperenderer")
include(":features:engine:transform")
include(":features:engine:renderer:g3d")
include(":features:engine:renderer:g2d")
include(":features:engine:physics:box2d")
include(":features:engine:physics:jolt")

include(":features:editor:renderer:imgui")

// Demos

include(":demos:g3d:basic:core")
include(":demos:g3d:basic:desktop")
include(":demos:g3d:basic:teavm")


//includeBuild("E:\\Dev\\Projects\\java\\gdx-teavm") {
//    dependencySubstitution {
//        substitute(module("com.github.xpenatan.gdx-teavm:backend-teavm")).using(project(":backends:backend-teavm"))
//        substitute(module("com.github.xpenatan.gdx-teavm:asset-loader")).using(project(":extensions:asset-loader"))
////        substitute(module("com.github.xpenatan.gdx-teavm:gdx-freetype-teavm")).using(project(":extensions:gdx-freetype-teavm"))
//    }
//}

//includeBuild("E:\\Dev\\Projects\\java\\gdx-multi-view") {
//    dependencySubstitution {
//        substitute(module("com.github.xpenatan.gdx-multi-view:core")).using(project(":multiview:core"))
//        substitute(module("com.github.xpenatan.gdx-multi-view:imgui-window")).using(project(":extensions:imgui-window"))
//    }
//}

//includeBuild("E:\\Dev\\Projects\\java\\gdx-gltf") {
//    dependencySubstitution {
//        substitute(module("com.github.mgsx-dev.gdx-gltf:gltf")).using(project(":gltf"))
//    }
//}

//includeBuild("E:\\Dev\\Projects\\java\\gdx-imgui") {
//    dependencySubstitution {
//        substitute(module("com.github.xpenatan.gdx-imgui:imgui-core")).using(project(":imgui:imgui-core"))
//        substitute(module("com.github.xpenatan.gdx-imgui:imgui-desktop")).using(project(":imgui:imgui-desktop"))
//        substitute(module("com.github.xpenatan.gdx-imgui:imgui-teavm")).using(project(":imgui:imgui-teavm"))
//        substitute(module("com.github.xpenatan.gdx-imgui:gdx-impl")).using(project(":gdx:gdx-impl"))
//        substitute(module("com.github.xpenatan.gdx-imgui:imgui-ext-core")).using(project(":imgui-ext:ext-core"))
//        substitute(module("com.github.xpenatan.gdx-imgui:imgui-ext-desktop")).using(project(":imgui-ext:ext-desktop"))
//        substitute(module("com.github.xpenatan.gdx-imgui:imgui-ext-teavm")).using(project(":imgui-ext:ext-teavm"))
//    }
//}

//includeBuild("E:\\Dev\\Projects\\java\\gdx-bullet") {
//    dependencySubstitution {
//        substitute(module("com.github.xpenatan.gdx-bullet:bullet-core")).using(project(":bullet:core"))
//        substitute(module("com.github.xpenatan.gdx-bullet:bullet-teavm")).using(project(":bullet:teavm"))
//        substitute(module("com.github.xpenatan.gdx-bullet:bullet-desktop")).using(project(":bullet:desktop"))
//    }
//}