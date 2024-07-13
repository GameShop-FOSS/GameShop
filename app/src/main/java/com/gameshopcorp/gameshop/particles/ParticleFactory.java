package com.gameshopcorp.gameshop.particles;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;

import java.util.ArrayList;
import java.util.Random;

public class ParticleFactory {

    ArrayList<Geometry> particles;
    SimpleApplication app;

    //Node node;
    Random rand = new Random(System.currentTimeMillis());
    public ParticleFactory(SimpleApplication app){

        this.app = app;
        particles = new ArrayList<>();
       // node = new Node();
    }

    public void addParticle(){
        Quad quad = new Quad(.25f, .25f, false);
        Geometry geom = new Geometry("quad", quad);
        Material mat = new Material(this.app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.fromRGBA255(10,155,223, 255));
        geom.setMaterial(mat);
       // node.attachChild(geom);

        int randX = rand.nextInt(14);
        //x = -1.75f + (randX * .25f);
        float x = 0f;
        switch (randX){

            case 0:
                x = -1.75f;
                break;
            case 1:
                x = -1.50f;
                break;
            case 2:
                x = -1.25f;
                break;
            case 3:
                x = -1.00f;
                break;
            case 4:
                x = -.75f;
                break;
            case 5:
                x = -.5f;
                break;
            case 6:
                x = -.25f;
                break;
            case 7:
                x = 0f;
                break;
            case 8:
                x = .25f;
                break;
            case 9:
                x = .5f;
                break;
            case 10:
                x = .75f;
                break;
            case 11:
                x = 1f;
                break;
            case 12:
                x = 1.25f;
                break;
            case 13:
                x = 1.5f;
                break;
            case 14:
                x = 1.75f;
                break;
        }

        //float x = -1.75f + (randX * .25f);
       geom.setLocalTranslation(x ,-3.75f,0f);
        this.app.getRootNode().attachChild(geom);
        particles.add(geom);
    }

    public void animateParticles(){

        for (Geometry g: particles){
            g.move(0f,.1f,0f);
        }
    }

    public void deleteExtraParticles(){

        for (Geometry g: particles){
            if (g.getWorldTranslation().y > 3.75f){
//                this.app.getRootNode().detachChild(g);
//                g = null;
                g.removeFromParent();
                g = null;
            }
        }

    }
}
