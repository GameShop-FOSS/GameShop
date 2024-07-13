package com.gameshopcorp.gameshop.particles;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;

import java.util.ArrayList;

public class ParticleFactory {

    ArrayList<Geometry> particles;
    SimpleApplication app;

    Node node;
    public ParticleFactory(SimpleApplication app){

        this.app = app;
        particles = new ArrayList<>();
        node = new Node();
    }

    public void addParticle(){
        Quad quad = new Quad(.25f, .25f, false);
        Geometry geom = new Geometry("quad", quad);
        Material mat = new Material(this.app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);
        node.attachChild(geom);
       node.setLocalTranslation(-1.5f,-2.5f,0f);
        this.app.getRootNode().attachChild(node);
    }
}
