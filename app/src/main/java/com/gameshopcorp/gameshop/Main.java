package com.gameshopcorp.gameshop;

import com.gameshopcorp.gameshop.gui.MyStartScreen;
import com.gameshopcorp.gameshop.particles.ParticleFactory;
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;

import java.util.logging.Logger;

import de.lessvoid.nifty.Nifty;

/**
 *
 */
public class Main extends SimpleApplication {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    ParticleFactory particleFactory;
    public void simpleInitApp() {

        viewPort.setBackgroundColor(ColorRGBA.fromRGBA255(10,155,223, 255));
        flyCam.setEnabled(false);


//        Box box = new Box(1, 1, 1);
//        Geometry geom = new Geometry("box", box);
//        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setColor("Color", ColorRGBA.Blue);

        // Like normal Android projects, place your texture/models/sounds/etc files in the project
        // "assets" folder (src/main/assets).  jME includes this directory automatically when
        // looking for game assets.
        //Texture texture = assetManager.loadTexture("Textures/Monkey.png");
        //mat.setTexture("ColorMap", texture);

//        geom.setMaterial(mat);
//        rootNode.attachChild(geom);

//        Screen screen = nifty.getCurrentScreen();
//        Element layer = screen.findElementByName("baseLayer");
//
//        // create a 8px height red panel
//        PanelCreator createPanel = new PanelCreator();
//        createPanel.setHeight("8px");
//        createPanel.setBackgroundColor("#f00f");
//        Element newPanel = createPanel.create(nifty, screen, layer);


        MyStartScreen myStartScreen = new MyStartScreen();
        myStartScreen.initialize(this);
        NiftyJmeDisplay niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
                assetManager, inputManager, audioRenderer, guiViewPort);
/** Create a new NiftyGUI object */
        Nifty nifty = niftyDisplay.getNifty();
/** Read your XML and initialize your custom ScreenController */
        nifty.fromXml("Interface/screen.xml", "GScreen0", myStartScreen);
// nifty.fromXml("Interface/helloworld.xml", "start", new MySettingsScreen(data));
// attach the Nifty display to the gui view port as a processor
        guiViewPort.addProcessor(niftyDisplay);

        particleFactory = new ParticleFactory(this);
        particleFactory.addParticle();

    }

    public float elapsedTime = 0f;
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code

        elapsedTime += tpf;
        if (elapsedTime > 1f){

            elapsedTime = 0f;
        }
        //System.out.println("tpf " + tpf);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
